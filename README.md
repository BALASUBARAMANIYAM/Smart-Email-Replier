
# 📧 Smart Email Replier – Chrome Extension

**Smart Email Replier** is an AI-powered Chrome extension that integrates directly into Gmail and helps users instantly generate smart email replies. With a single click, you can generate responses in various tones like **Professional**, **Friendly**, **Casual**, or **Persuasive** — powered by a Spring Boot backend.

---

## ✨ Features

- 🧠 AI-generated email replies using backend API
- 📌 Adds an "AI Reply" button directly inside Gmail's compose window
- 🎯 Tone selection via popup UI (Professional, Friendly, Casual, Persuasive)
- 💾 Saves your tone preference using Chrome Storage
- 🔍 Automatically detects new compose windows in Gmail
- ⚙️ Spring Boot backend integration via `http://localhost:8080/api/email/generate`

---

## 🛠 Tech Stack

- **Frontend:** Chrome Extension (JavaScript, HTML, CSS)
- **Backend:** Spring Boot (Java, REST API)
- **AI Integration:** Gemini / OpenAI / LLM via Spring Boot
- **Storage:** Chrome local storage

---

## 📁 Folder Structure

```
email-writer-extension/
├── content.js          # Injected into Gmail to add the AI Reply button
├── popup.html          # Tone selection UI
├── popup.js            # Handles tone saving/loading
├── manifest.json       # Chrome extension config
└── README.md           # You're here
```

---

## ⚙️ How It Works

1. **Popup UI for Tone Selection**  
   - Click the extension icon in Chrome.
   - Select one of the tones: Professional, Friendly, Casual, or Persuasive.

2. **Compose Email Detection**  
   - The extension observes the DOM.
   - When a Gmail compose window appears, it injects the **AI Reply** button.

3. **Generate Reply on Click**  
   - When clicked, the extension extracts email content.
   - Sends it to the backend API with the selected tone.
   - The AI-generated reply is injected into the message box.

---

## 🔌 Backend API Specification

Your Spring Boot backend should have this endpoint:

**Endpoint:**
```
POST http://localhost:8080/api/email/generate
```

**Request:**
```json
{
  "emailContent": "Hey, can you send me the project report by today evening?",
  "tone": "professional"
}
```

**Response:**
```text
Dear [Name], I will ensure the report is sent by this evening. Best regards, [Your Name].
```

---

## 💬 Tone Examples

**Dummy Email:**  
> "Hey, can you send me the project report by today evening? We need it for the review meeting tomorrow."

### 🟦 Professional
> Dear [Name],  
> I will ensure the project report is finalized and sent to you by this evening.  
> Best regards,  
> [Your Name]

### 🟩 Friendly
> Hi [Name],  
> Sure thing! I’ll wrap up the project report and send it later today. Let me know if there's anything else.  
> Cheers,  
> [Your Name]

### 🟨 Casual
> Hey,  
> Yup, I’ll send the report by evening. Let me know if you need anything added.  
> Thanks!  
> [Your Name]

### 🟥 Persuasive
> Hi [Name],  
> I’m already working on the report and will send it this evening. This gives us more time to refine it for the review.  
> Let’s make it count!  
> [Your Name]

---

## 🧩 Installation Instructions

### 📥 Load the Extension in Chrome

1. Download or clone this repository.
2. Open Chrome and go to `chrome://extensions/`.
3. Enable **Developer mode** (top right).
4. Click **Load unpacked**.
5. Select the extension folder (where `manifest.json` is located).
6. Open Gmail and click **Compose**.
7. You'll see the **"AI Reply"** button.
8. Click the extension icon → choose your tone → click AI Reply!

---

## 🔐 Permissions (from `manifest.json`)

```json
"permissions": ["activeTab", "scripting", "storage"]
"host_permissions": [
  "http://localhost:8080/*",
  "*://mail.google.com/*"
]
```

These allow access to Gmail UI, backend API, and storing user tone preference.

---

## 🧪 Testing Checklist

- ✅ Gmail is opened and logged in
- ✅ Spring Boot backend is running at `http://localhost:8080`
- ✅ Tone is selected from popup
- ✅ "AI Reply" button appears in Gmail compose window
- ✅ Response is injected properly into email body

---

## ❗ Troubleshooting

| Issue | Fix |
|------|-----|
| ❌ Button not showing | Reload Gmail or re-open Compose |
| ❌ API failed | Ensure Spring Boot backend is running on correct port |
| ❌ Reply not injected | Check Gmail changed selector, update `content.js` |
| ❌ CORS error | Allow CORS in Spring Boot config |

---

## 📃 License

This project is licensed under the **MIT License**.

---

## 👨‍💻 Author

Developed by **Balasubaramaniyam TS**  
Feel free to use, customize, or extend the project. Contributions welcome!

---

## 🏷️ Tags

`#ChromeExtension` `#Gmail` `#SpringBoot` `#AI` `#LLM` `#EmailAutomation` `#JavaScript` `#Gemini` `#OpenAI`
