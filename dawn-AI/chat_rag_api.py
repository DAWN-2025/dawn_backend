from fastapi import FastAPI
from pydantic import BaseModel
from rag_pipeline import conversational_chain  # rag_pipeline.py에서 conversational_chain을 가져옴
from letter_generator import generate_letter

app = FastAPI()

# 요청 모델 정의
class ChatRequest(BaseModel):
    session_id: str
    question: str

# 응답 모델 정의
class ChatResponse(BaseModel):
    answer: str

@app.post("/chat", response_model=ChatResponse)
def chat_endpoint(request: ChatRequest):
    answer = conversational_chain.invoke(
        {"question": request.question},
        config={"configurable": {"session_id": request.session_id}}
    )
    return {"answer": answer}

# 💌 편지 요청/응답 모델
class LetterRequest(BaseModel):
    session_id: str

class LetterResponse(BaseModel):
    letter: str

@app.post("/generate-letter", response_model=LetterResponse)
def generate_letter_endpoint(request: LetterRequest):
    letter = generate_letter(request.session_id)
    return {"letter": letter}