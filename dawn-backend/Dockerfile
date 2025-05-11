FROM openjdk:21-jdk-slim

WORKDIR /app

COPY build/libs/*.jar app.jar

COPY src/main/resources/dawn-a6a20-firebase-adminsdk-fbsvc-387b42759f.json ./dawn-firebase.json


EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]