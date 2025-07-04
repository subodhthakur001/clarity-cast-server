# ClarityCast Server (Spring Boot) 🌐

The **ClarityCast Server** is a scalable, WebSocket-based signaling backend built with **Spring Boot** for managing peer connections in a modern, high-quality video communication platform — similar to **Riverside.fm**.

Unlike basic peer-to-peer WebRTC demos, this server is designed for **production**, with a modular architecture to support **multi-user rooms**, **recording orchestration**, **session persistence**, and eventually **media pipeline integration**.

---

## 🎯 Project Vision

To build a Riverside.fm-style remote studio system with:

- 🎥 Studio-quality audio/video recording
- 🧠 Session-aware WebRTC signaling
- 🔒 Secure, authenticated communication
- 📂 Cloud-based media asset management
- 🔁 Post-processing and export support

---

## 🚀 Current Features

- ✅ WebSocket server for WebRTC signaling
- ✅ Role assignment (`sender`, `receiver`)
- ✅ Routing of SDP (offer/answer) and ICE candidates
- ✅ Configurable WebSocket endpoints
- ✅ Modular Spring Boot project structure

---

## 🧱 Tech Stack

- Java 17+  
- Spring Boot 3.x  
- Spring WebSocket  
- STOMP (optional for future features)  
- Jackson for JSON serialization

---

## 🗂️ Project Structure (as of now)

```bash
clarity-cast-server/
├── src/
│   └── main/
│       ├── java/
│       │   └── com/claritycast/
│       │       ├── config/
│       │       │   └── WebSocketConfig.java         # WebSocket setup
│       │       ├── handler/
│       │       │   └── SignalingWebSocketHandler.java # Custom handler for signaling
│       │       └── ClarityCastServerApplication.java
│       └── resources/
│           └── application.properties
├── pom.xml
└── README.md
