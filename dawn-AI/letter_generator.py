from rag_pipeline import store, llm
from langchain.prompts import PromptTemplate
from langchain_core.chat_history import BaseMessage

def generate_letter(session_id: str) -> str:
    """
    주어진 세션 ID를 기반으로 대화 기록을 불러와,
    그 내용을 바탕으로 시민군 시점의 편지를 작성하는 함수.
    """
    history = store.get(session_id)
    if history is None:
        return "해당 세션에 대한 대화 기록이 없습니다."

    messages = history.messages  # List[BaseMessage]

    formatted_history = ""
    for msg in messages:
        role = "사용자" if msg.type == "human" else "시민군"
        formatted_history += f"{role}: {msg.content}\n"

    letter_prompt = PromptTemplate(
        input_variables=["chat_history"],
        template="""
다음은 지금까지의 대화 기록입니다:

{chat_history}

이 대화를 기반으로 사용자에게 보내는 진심 어린 편지를 작성해주세요.
편지는 시민군의 시점에서 쓰이며, 당시의 감정, 연대감, 위로의 메시지를 담고 있어야 합니다.
형식은 다음과 같아야 합니다:

---

친애하는 친구에게,

(여기에 편지 본문)

시민군 일동 드림.
"""
    )

    prompt = letter_prompt.format(chat_history=formatted_history)
    letter = llm.invoke(prompt)
    return letter.content
