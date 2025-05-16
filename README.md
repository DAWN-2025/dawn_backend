# DAWN - Dark Tourism with AI Navigation

[![Demo Video](https://img.shields.io/badge/-Demo%20Video-red)](https://youtu.be/qjlmdKrCPaI)

> *"Those who do not remember the past are condemned to repeat it."*
> — George Santayana

---

# 🌌 Overview

DAWN is an immersive AI-powered dark tourism platform that allows users to explore and emotionally engage with historically significant yet tragic events.
Users interact with AI-generated personas, experience site-based reconstructions, and collect digital memorials.

---

# 📂 Table of Contents

* [Solution Challenge Theme](#Solution-Challenge-Theme)
* [Architecture](#-Architecture)
* [Core Concept](#-Core-Concept)
* [Tech Stack](#-Tech-Stack)
* [How to Run](#-How-to-Run)
* [Team](#-team-dawn)

---
# Solution Challenge Theme

<table>
  <tr>
    <th> Tourism</th>
  </tr>
  <tr>
    <td>
      <img src="https://github.com/user-attachments/assets/c608a183-87c4-4b9f-98cd-7b3126399b9b"/>
    </td>
  </tr>
  <tr>
    <td>Explore innovation: Craft digital experiences to enhance travel, promote local cultures, and boost sustainable tourism.</td>
  </tr>
</table>

---
# 🏗️ Architecture

The DAWN platform is designed to provide an immersive dark tourism experience powered by AI, integrating various services using modern cloud-native technologies. Below is a breakdown of the architecture:

<table>
  <tr>
    <th> Tourism</th>
  </tr>
  <tr>
    <td>
      <img src="https://github.com/user-attachments/assets/327e38e1-1de9-4d4f-b758-64e001f913df"/>
    </td>
  </tr>
  <tr>
    <td>Explore innovation: Craft digital experiences to enhance travel, promote local cultures, and boost sustainable tourism.</td>
  </tr>
</table>

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
./gradlew clean build -x test

# 2. Build and run Docker containers
sudo docker compose up --build
```

### Mobile App (Flutter)

* Flutter SDK required
* Firebase project configured
* Run on Android emulator or real device (Android 8.0+)



---

# 🌑 TEAM DAWN

| Role            | Member                                                   |
| --------------- | -------------------------------------------------------- |
| Frontend, Team Leader   | [@yb0x00](https://github.com/yb0x00)                   |
| Frontend, UI Design | [@LBB](https://github.com/202780) |
| Backend, AI   | [@ji-mim](https://github.com/ji-mim)                     |
| Backend, AI | [@KwanjoonPark](https://github.com/KwanjoonPark)                                        |
<table>
  <tr>
    <th>Frontend, Team Leader</th>
    <th>Frontend, UI Design</th>
    <th>Backend, AI</th>
    <th>Backend, AI</th>
  </tr>
  <tr>
    <td><img src="images/hyuna.png" width="150"/></td>
    <td><img src="images/ganghee.png" width="150"/></td>
    <td><img src="images/yensoo.png" width="150"/></td>
    <td><img src="images/sohyun.png" width="150"/></td>
  </tr>
  <tr>
    <td><a href="https://github.com/yb0x00" target="_blank">@yb0x00</a></td>
    <td><a href="https://github.com/202780" target="_blank">@LBB</a></td>
    <td><a href="https://github.com/ji-mim" target="_blank">@ji-mim</a></td>
    <td><a href="https://github.com/KwanjoonPark" target="_blank">@KwanjoonParkm</a></td>
  </tr>
</table>