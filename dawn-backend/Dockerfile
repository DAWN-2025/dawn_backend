FROM openjdk:21-jdk-slim

WORKDIR /app

# 앱 JAR 파일 복사
COPY build/libs/*.jar app.jar

# Firebase admin JSON 복사 (파일명과 경로 수정됨)
COPY src/main/resources/firebase-admin.json /app/dawn-firebase.json

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]