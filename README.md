# Smart-Email-Replier
Smart Email Replier is a Chrome extension that integrates with Gmail to help users generate AI-powered email replies with the click of a button. Built using JavaScript (Content Script) and powered by a Spring Boot backend, it leverages tone-based customization to craft replies in various styles: Professional, Friendly, Casual, or Persuasive.

# 📧 Smart Email Replier – Chrome Extension

**Smart Email Replier** is an AI-powered Chrome extension that integrates with Gmail and helps you generate intelligent email replies instantly. It adds an **"AI Reply"** button inside the Gmail compose window. You can also choose the tone of the reply — such as **Professional**, **Friendly**, **Casual**, or **Persuasive** — using the extension popup.

---

## 🚀 Features

- ✨ Adds an **AI Reply** button inside Gmail’s compose window
- 🎯 Supports tone customization via popup (Professional, Friendly, Casual, Persuasive)
- 🧠 Uses an AI model (via backend API) to generate email replies
- 💾 Saves tone preference using Chrome storage
- ⚙️ Built to work with a local Spring Boot backend at `http://localhost:8080`

---

---

## 🛠 Tech Stack

- **Chrome Extension APIs**
- **JavaScript**, **HTML**, **CSS**
- **Spring Boot Backend API** for reply generation
- **LocalStorage API** (via Chrome storage)

---

## 🧩 How It Works

1. **Popup Tone Selector**  
   - Users choose a reply tone using the extension popup.
   - The tone is saved using `chrome.storage.local`.

2. **Gmail Compose Detection**  
   - When a Gmail compose window appears, a **mutation observer** detects it.
   - An **"AI Reply"** button is injected into the Gmail compose toolbar.

3. **AI Reply Button Action**  
   - When clicked, it fetches the email thread content.
   - Sends a POST request to `http://localhost:8080/api/email/generate` with `emailContent` and `tone`.
   - Inserts the AI-generated reply into the compose box.

---

## 🔧 Backend API

You’ll need a Spring Boot backend running locally.  
Make sure the following API is implemented:

**Endpoint:**


