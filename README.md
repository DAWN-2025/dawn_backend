# DAWN - Dark Tourism with AI Navigation

[![Demo Video](https://img.shields.io/badge/-Demo%20Video-red)](https://youtu.be/xGadBd0Dcfg)

> *"Those who do not remember the past are condemned to repeat it."*
> — George Santayana

---

> ⚠️ **Note on Repository Visibility & Sensitive File Removal**

We are currently in contact with the GitHub team regarding the removal of a mistakenly committed `.json` file that was included in a previous pull request.  
The file does not contain any critical credentials, but it was not intended for publication and we have requested its removal from the repository's commit history.

We plan to make this repository **public** in the near future once the cleanup process is complete.  
Thank you for your understanding and patience!
---

# 🌌 Overview

DAWN is an immersive AI-powered dark tourism platform that allows users to explore and emotionally engage with historically significant yet tragic events.
Users interact with AI-generated personas, experience site-based reconstructions, and collect digital memorials.

![DawnBanner](https://private-user-images.githubusercontent.com/138632648/444613401-dff12b35-ba56-4187-8927-6236142ce533.png?jwt=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTUiLCJleHAiOjE3NDc0MTA5NzIsIm5iZiI6MTc0NzQxMDY3MiwicGF0aCI6Ii8xMzg2MzI2NDgvNDQ0NjEzNDAxLWRmZjEyYjM1LWJhNTYtNDE4Ny04OTI3LTYyMzYxNDJjZTUzMy5wbmc_WC1BbXotQWxnb3JpdGhtPUFXUzQtSE1BQy1TSEEyNTYmWC1BbXotQ3JlZGVudGlhbD1BS0lBVkNPRFlMU0E1M1BRSzRaQSUyRjIwMjUwNTE2JTJGdXMtZWFzdC0xJTJGczMlMkZhd3M0X3JlcXVlc3QmWC1BbXotRGF0ZT0yMDI1MDUxNlQxNTUxMTJaJlgtQW16LUV4cGlyZXM9MzAwJlgtQW16LVNpZ25hdHVyZT1iM2VhNmM5ZTE1ZWU4OGIxM2ZkNDQ3ZGFjN2EzMDdjMjk4Nzk1MTk1MWRhZDJmZTMyZTMxZjk1YmZiYTYwOWRlJlgtQW16LVNpZ25lZEhlYWRlcnM9aG9zdCJ9.LEC4fcpLjjrGjjeZW0ZgyqE_3iZoSGWl_IhGgTPPzaA)---

# 📂 Table of Contents

* [Solution Challenge Theme](#solution-challenge-theme)
* [Architecture](#architecture)
* [Core Concept](#core-concept)
* [Tech Stack](#tech-stack)
* [How to Run](#how-to-run)
* [Team](#team-dawn)

---
# Solution Challenge Theme

<table>
  <tr>
    <th>Tourism</th>
  </tr>
  <tr>
    <td>
      <img src="https://private-user-images.githubusercontent.com/138632648/444619629-1b02477f-8cf8-459a-9f57-71c0405f67fa.png?jwt=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTUiLCJleHAiOjE3NDc0MTE2MjAsIm5iZiI6MTc0NzQxMTMyMCwicGF0aCI6Ii8xMzg2MzI2NDgvNDQ0NjE5NjI5LTFiMDI0NzdmLThjZjgtNDU5YS05ZjU3LTcxYzA0MDVmNjdmYS5wbmc_WC1BbXotQWxnb3JpdGhtPUFXUzQtSE1BQy1TSEEyNTYmWC1BbXotQ3JlZGVudGlhbD1BS0lBVkNPRFlMU0E1M1BRSzRaQSUyRjIwMjUwNTE2JTJGdXMtZWFzdC0xJTJGczMlMkZhd3M0X3JlcXVlc3QmWC1BbXotRGF0ZT0yMDI1MDUxNlQxNjAyMDBaJlgtQW16LUV4cGlyZXM9MzAwJlgtQW16LVNpZ25hdHVyZT1jMDZjNTNmNjBjZjYxZTlmZWZiZDk4MWU3MTU2MzU3NGZiMDdkMzU1MzE4ZjZmYmQwNzlmYzA5NmQxYWQ5NjQ0JlgtQW16LVNpZ25lZEhlYWRlcnM9aG9zdCJ9.oRXzB0UZhCudGMPTR8Gc969HIkWg7jFZoiqK-SZAEtg" width="600"/>
    </td>
  </tr>
</table>

---
# 🏗️ Architecture

The DAWN platform is designed to provide an immersive dark tourism experience powered by AI, integrating various services using modern cloud-native technologies. Below is a breakdown of the architecture:


<p align="center">
  <img src="https://private-user-images.githubusercontent.com/138632648/444619482-acb1b657-c0de-4c5a-a89e-625a3e5c2bc5.png?jwt=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTUiLCJleHAiOjE3NDc0MTE1OTMsIm5iZiI6MTc0NzQxMTI5MywicGF0aCI6Ii8xMzg2MzI2NDgvNDQ0NjE5NDgyLWFjYjFiNjU3LWMwZGUtNGM1YS1hODllLTYyNWEzZTVjMmJjNS5wbmc_WC1BbXotQWxnb3JpdGhtPUFXUzQtSE1BQy1TSEEyNTYmWC1BbXotQ3JlZGVudGlhbD1BS0lBVkNPRFlMU0E1M1BRSzRaQSUyRjIwMjUwNTE2JTJGdXMtZWFzdC0xJTJGczMlMkZhd3M0X3JlcXVlc3QmWC1BbXotRGF0ZT0yMDI1MDUxNlQxNjAxMzNaJlgtQW16LUV4cGlyZXM9MzAwJlgtQW16LVNpZ25hdHVyZT00YzA4YTEwM2EyYjhhYjJiZmMzNzg4YjhiODcxZTA2MDYyMjQxZjRhYjZhODE2ZmZkMDRmY2M2ZjNjMzU0MjMxJlgtQW16LVNpZ25lZEhlYWRlcnM9aG9zdCJ9.-M8Pz0iY-ohMZMNUHw4jFaU22hB-WpLZXF6AkIGmgrE" width="700"/>
</p>

* `Spring Boot` Web Server with `JWT + Redis` authentication
* `FastAPI` RAG backend for AI persona response generation
* `MySQL (Cloud SQL)` as primary DB
* `GCP Storage` for image, letter, and event assets
* `LangChain + Vertex AI + Pinecone` for RAG pipeline
* `Flutter` mobile app client
* `Docker` deployment on GCP VM (Compute Engine)
---

### 🧭 Client Layer
- **Flutter**: Cross-platform mobile application framework.
- **Google Maps API**: Enables location-based features.
- **Google Design**: Ensures UI/UX consistency across devices.

The client communicates with the backend using RESTful APIs and receives both structured content and AI-generated responses.


### 🔐 Firebase Platform
- **Firebase Authentication**: Handles secure user login and identity verification.
- **Cloud Storage for Firebase**: Stores user-uploaded content such as images or letters.

Firebase communicates directly with both the client and server for authentication and media access.


### ⚙️ Server Layer (GCP Compute Engine)
- **Spring Boot**: Java-based backend that manages user data, historical content, and API endpoints.
- **FastAPI**: Python-based service for handling AI interactions.
- **Docker**: Containerization of backend services for portability and scalability.


### 🧠 AI Integration
- **LangChain**: Orchestrates communication with the AI model.
- **Vertex AI + Gemini**: Google’s powerful LLM platform for generating historical personas and contextual responses.


### 🗄️ Database
- **Cloud SQL (MySQL)**: Stores all persistent data including users, locations, events, and AI-generated content.


## 🔁 Communication Flow

- The **Flutter client** sends user requests to the **Spring Boot** backend.
- If AI content is needed, Spring Boot relays the request to **FastAPI**, which processes it via **LangChain** & **RAG** and **Vertex AI (Gemini)**.
- **Firebase Authentication** verifies users, and **Cloud Storage** manages uploaded files.
- **Cloud SQL** stores and retrieves all application data.


___

# ✨ Core Concept

* AI-generated persona interactions based on historical events
* Guestbook and memory sharing for visited locations
* Digital stamp collection to track historical journeys
* Firebase-based authentication and user data management
* Support for multi-language and immersive content rendering

---

# 🔧 Tech Stack

| Layer    | Tech Choices                             |
| -------- | ---------------------------------------- |
| Backend  | Java Spring Boot, MySQL                 |
| AI Model | Python, FastAPI, LangChain, VertexAI     |
| Frontend | Flutter (Dart), Google Maps API        |
| Storage  | GCP Cloud SQL, Firebase storage         |
| Auth     | Firebase Authentication                  |
| Deploy   | Docker, GCP VM                           |
| ML Infra | Pinecon                                 |

---

# 🛫 How to Run

### Backend Server

```bash
# 1. Build backend
./gradlew build

# 2. Build and run Docker containers
sudo docker compose up --build
```

### Mobile App (Flutter)
```
# 1. Install dependencies
flutter pub get

# 2. Run the app on the desired platform (make sure a device/emulator is connected)
flutter run -d <device>
```


---

# 🌑 TEAM DAWN

We are a four-member team from GDG on Campus CNU, combining strengths across frontend, backend, AI, and UI design.


<table>
  <tr>
    <th>Frontend, Team Leader</th>
    <th>Frontend, UI Design</th>
    <th>Backend, AI</th>
    <th>Backend, AI</th>
  </tr>
  <tr>
    <td><img src="https://avatars.githubusercontent.com/u/169421565?v=4" width="150"/></td>
    <td><img src="https://avatars.githubusercontent.com/u/163499519?v=4" width="150"/></td>
    <td><img src="https://avatars.githubusercontent.com/u/138632648?v=4" width="150"/></td>
    <td><img src="https://avatars.githubusercontent.com/u/96593737?v=4" width="150"/></td>
  </tr>
  <tr>
    <td><a href="https://github.com/yb0x00" target="_blank">@yb0x00</a></td>
    <td><a href="https://github.com/202780" target="_blank">@LBB</a></td>
    <td><a href="https://github.com/ji-mim" target="_blank">@ji-mim</a></td>
    <td><a href="https://github.com/KwanjoonPark" target="_blank">@KwanjoonParkm</a></td>
  </tr>
</table>