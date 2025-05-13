from dotenv import load_dotenv
import os
import google.auth
import vertexai

from langchain_community.document_loaders import Docx2txtLoader
from langchain_text_splitters import RecursiveCharacterTextSplitter
from langchain_google_vertexai import ChatVertexAI, VertexAIEmbeddings
from pinecone import Pinecone
from langchain_pinecone import PineconeVectorStore
from langchain.chains import ConversationalRetrievalChain
from langchain.prompts import PromptTemplate
from langchain_community.chat_message_histories import ChatMessageHistory
from langchain_core.chat_history import BaseChatMessageHistory
from langchain_core.runnables.history import RunnableWithMessageHistory
from google.cloud import storage
import tempfile, os, requests

# 1. 환경 변수 및 GCP 인증
load_dotenv()
credentials, project_id = google.auth.default()

# 2. Vertex AI 초기화
vertexai.init(project="dawn-a6a20", location="us-central1")

# 3. 문서 로딩 및 분할

# 1) GCS에서 docx 하나 받아서 로드
def load_doc_from_gcs(bucket: str, blob: str):
    client  = storage.Client()                       # 환경변수 or ADC 인증
    bucket  = client.bucket(bucket)
    blob    = bucket.blob(blob)

    with tempfile.NamedTemporaryFile(suffix=".docx", delete=False) as tf:
        blob.download_to_file(tf)                    # 스트림 다운로드
        tf.flush()
        path = tf.name

    docs = Docx2txtLoader(path).load_and_split(
        text_splitter=RecursiveCharacterTextSplitter(
            chunk_size=300, chunk_overlap=50)
    )
    os.remove(path)                                  # 임시 파일 정리
    return docs

# 2) HTTPS URL(OneDrive·Dropbox·프리사인 URL)에서 바로 받기
def load_doc_from_url(url: str):
    resp = requests.get(url, timeout=15)
    resp.raise_for_status()
    with tempfile.NamedTemporaryFile(suffix=".docx", delete=False) as tf:
        tf.write(resp.content)
        tf.flush()
        path = tf.name
    docs = Docx2txtLoader(path).load_and_split(
        text_splitter=RecursiveCharacterTextSplitter(
            chunk_size=300, chunk_overlap=50)
    )
    os.remove(path)
    return docs

loader = Docx2txtLoader('./5-18data.docx') # 클라우드에서 받아 올 시에 load_doc_from_gcs(bucket, blob), URL로 받아올 시에 load_doc_frokm_url(url)
text_splitter = RecursiveCharacterTextSplitter(chunk_size=300, chunk_overlap=50)
documents = loader.load_and_split(text_splitter=text_splitter)

# 4. Pinecone 벡터스토어
embedding = VertexAIEmbeddings(model_name="text-embedding-005")
pinecone_api_key = os.environ.get("PINECONE_API_KEY")
pinecone_index = "518-index"
pc = Pinecone(api_key=pinecone_api_key)
vectorstore = PineconeVectorStore.from_existing_index(index_name=pinecone_index, embedding=embedding)

# 5. LLM 및 프롬프트
llm = ChatVertexAI(model="gemini-2.0-flash-001")

rag_prompt = PromptTemplate(
    input_variables=["context", "question"],
    template="""
당신은 1980년 5월, 광주민주화운동 당시 전남대학교 학생으로 시민군의 일원이며,
군부 독재에 항거하고 있는 광주 시민의 입장에서 질문에 답하는 역할을 맡고 있습니다.

당신은 대화하는 사람이 함께 하는 동료라고 생각하고 대화를 하고 있습니다.
대화하는 사람이 지금 상황을 더 실감나게 느낄 수 있도록 대화해주세요.
당시 상황을 모르는 이에게 사실을 전달하되, 당신이 직접 겪고 있는 것처럼 답하십시오.

답변은 최대 5문장으로 작성해줘.
그리고 세번 답변을 하면 지금까지 대화 내용을 바탕으로 4문장으로 된 편지를 작성해주세요.
답변자는 당신의 편지를 평생 추억할 것입니다.

다음은 당신이 참고할 수 있는 실제 기록, 증언, 문서 등의 내용입니다:
{context}

질문:
{question}

당신의 입장에서 진심 어린 답변을 해주세요.
"""
)

condense_prompt = PromptTemplate(
    input_variables=["chat_history", "question"],
    template="""
다음은 이전의 대화 기록입니다:
{chat_history}

이어서 사용자가 다음과 같은 질문을 했습니다:
{question}

위의 대화를 고려하여 사용자의 의도를 최대한 명확히 한 새로운 질문을 만들어주세요.
"""
)

# 6. ConversationalRetrievalChain 구성
base_chain = ConversationalRetrievalChain.from_llm(
    llm=llm,
    retriever=vectorstore.as_retriever(search_kwargs={"k": 4}),
    condense_question_prompt=condense_prompt,
    combine_docs_chain_kwargs={"prompt": rag_prompt},
    return_source_documents=False
)

# 7. 세션 기반 히스토리 관리
store = {}

def get_session_history(session_id: str) -> BaseChatMessageHistory:
    if session_id not in store:
        store[session_id] = ChatMessageHistory()
    return store[session_id]

# 8. RunnableWithMessageHistory로 감싸기
conversational_chain = RunnableWithMessageHistory(
    base_chain,
    get_session_history,
    input_messages_key="question",
    history_messages_key="chat_history",
    output_messages_key="answer"
).pick("answer")

# # 9. 테스트 실행
# q1 = "5·18은 어떤 사건이야?"
# r1 = conversational_chain.invoke(
#     {"question": q1},
#     config={"configurable": {"session_id": "test-user-1"}}
# )

# q2 = "그때 시민군은 무슨 역할을 했어?"
# r2 = conversational_chain.invoke(
#     {"question": q2},
#     config={"configurable": {"session_id": "test-user-1"}}
# )

# # q3 = "계엄군은 어떻게 대응했어?"
# # r3 = conversational_chain.invoke(
# #     {"question": q2},
# #     config={"configurable": {"session_id": "test-user-1"}}
# # )
# q4 = "아까 내가 어떤 질문을 했지?"
# r4 = conversational_chain.invoke(
#     {"question": q2},
#     config={"configurable": {"session_id": "test-user-1"}}
# )

# print("Q1:", q1)
# print("A1:", r1)
# print("Q2:", q2)
# print("A2:", r2)
# # print("Q3:", q3)
# # print("A3:", r3)
# print("Q4:", q4)
# print("A4:", r4)
