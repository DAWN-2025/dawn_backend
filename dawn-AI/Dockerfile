# ---- Builder Stage ----
# 빌드 의존성을 설치하고 Python 패키지를 설치하는 단계
FROM python:3.9-slim as builder

WORKDIR /app

# 빌드에 필요한 패키지 설치
RUN apt-get update && apt-get install -y build-essential && rm -rf /var/lib/apt/lists/*

# 가상 환경 생성
RUN python -m venv /opt/venv
# 가상 환경을 활성화하도록 PATH 설정
ENV PATH="/opt/venv/bin:$PATH"

# requirements.txt를 복사하고 패키지 설치
COPY requirements.txt .
RUN pip install --upgrade pip && pip install --no-cache-dir -r requirements.txt


# ---- Final Stage ----
# 최종 이미지를 만드는 단계
FROM python:3.9-slim

WORKDIR /app

# Builder stage에서 생성한 가상 환경 복사
COPY --from=builder /opt/venv /opt/venv

# 소스 코드 복사 (.dockerignore에 의해 불필요한 파일은 제외됨)
COPY . .

# 가상 환경 PATH 설정 및 환경 변수 설정
ENV PATH="/opt/venv/bin:$PATH"
ENV PYTHONUNBUFFERED=1

EXPOSE 8000

# 애플리케이션 실행
CMD ["uvicorn", "chat_rag_api:app", "--host", "0.0.0.0", "--port", "8000"]
