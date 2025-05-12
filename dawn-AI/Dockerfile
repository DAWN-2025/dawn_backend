# Python 3.9 이미지를 기반으로 사용
FROM python:3.9-slim

# 작업 디렉토리 설정
WORKDIR /app

# 필요한 시스템 패키지 설치
RUN apt-get update && apt-get install -y \
    build-essential \
    && rm -rf /var/lib/apt/lists/*

# requirements.txt 복사 및 의존성 설치
COPY requirements.txt .
RUN pip install --upgrade pip
RUN pip install --no-cache-dir -r requirements.txt

# FastAPI 관련 패키지 추가 설치
RUN pip install fastapi uvicorn

# .env 파일 복사
COPY .env .

# 소스 코드 복사
COPY . .

# 환경 변수 설정
ENV PYTHONUNBUFFERED=1

# 포트 노출
EXPOSE 8000

# 서버 실행
CMD ["uvicorn", "chat_rag_api:app", "--host", "0.0.0.0", "--port", "8000"] 