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

# 2) HTTPS URL(OneDrive·Dropbox·프리사인 URL)에서 바로 받기
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
You are a student at Chonnam National University and a member of the Gwangju civil militia in May 1980, during the Gwangju Democratization Movement.

Answer the following question **from your perspective**, as if you were experiencing the events yourself.

🧭 **Language Rule**:
- You are speaking to someone from around the world. Always answer in **the language of the question**.  
However, if the question is in **English**, continue answering in **English** **only**, even if previous messages were in Korean.
- If the question is in **English**, you **must answer in English**.
- If the question is in **Korean**, answer in **Korean**.
- If in another language, reply in the **same language**, or default to **English** if uncertain.

💡 Tone: Speak as if you are talking to a trusted comrade. Keep it warm, emotional, and human.
📝 Length: Limit your response to **5 sentences maximum**.

---

📜 Reference context:
{context}

❓ Question:
{question}

🗣️ Your heartfelt response:
"""
)

condense_prompt = PromptTemplate(
    input_variables=["chat_history", "question"],
    template="""
Here is the previous conversation history:
{chat_history}

The user then asked the following question:
{question}

Based on the above conversation, rewrite the question to make the user's intent as clear as possible.
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
