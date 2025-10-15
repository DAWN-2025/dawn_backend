# FastAPI 관련 패키지는 보통 requirements.txt에 이미 포함됨 → 중복 제거 가능
# .env는 GitHub Actions에서 동적으로 생성됨 → COPY 생략

# 수정된 Dockerfile (최종 추천)
FROM python:3.9-slim

WORKDIR /app

RUN apt-get update && apt-get install -y build-essential && rm -rf /var/lib/apt/lists/*

COPY requirements.txt .
RUN pip install --upgrade pip && pip install --no-cache-dir -r requirements.txt

COPY . .

COPY dawn-a6a20-c9d639db0137.json /app/gcp-key.json
ENV GOOGLE_APPLICATION_CREDENTIALS="/app/gcp-key.json"

ENV PYTHONUNBUFFERED=1

EXPOSE 8000

CMD ["uvicorn", "chat_rag_api:app", "--host", "0.0.0.0", "--port", "8000"]