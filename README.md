## Chat App (Java Swing & Socket)

A simple real‑time desktop chat application built using Java Swing, Socket Programming, and Multithreading.

# Features
Username login

Real‑time messaging

Multiple clients supported

Sender messages aligned right

Other users’ messages aligned left

Simple, clean chat UI

Basic error handling

# Project Structure
ChatApp/
│
├── server/
│   ├── ChatServer.java
│   └── ClientHandler.java
│
├── client/
│   ├── ChatClient.java
│   ├── ChatUI.java
│   ├── LoginUI.java
│   ├── MessageBubble.java
│   ├── RoundedPanel.java
│   └── UIError.java
│
└── README.md

# How to Run
# 1️⃣ Start the Server
cd server
javac *.java
java server.ChatServer

# 2️⃣ Start the Client
cd client
javac *.java
java client.ChatClient
