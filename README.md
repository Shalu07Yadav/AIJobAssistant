# 🚀 AI Job Assistant

An AI-powered career preparation platform that helps job seekers improve their resumes, analyze ATS compatibility, generate personalized interview questions, and receive AI-driven resume optimization suggestions.

Built using **React**, **Spring Boot**, **PostgreSQL**, and **Google Gemini AI**.

---

## ✨ Features

### 📄 Resume Upload
- Upload resume in PDF format
- Resume stored securely
- Extracts resume text using Apache PDFBox
- Stores extracted text in PostgreSQL

---

### 📊 ATS Resume Analyzer
Compare your resume against any Job Description.

Features:
- ATS Match Score
- Matched Skills
- Missing Skills
- Strong Points
- Personalized Recommendations

---

### 🤖 AI Interview Question Generator

Generate personalized interview questions based on your uploaded resume.

Question Categories:
- Project Questions
- Technical Questions
- Experience Questions
- Behavioral Questions

Each question includes:
- Difficulty Level
- Related Skill

Powered by **Google Gemini AI**.

---

### ✨ AI Resume Optimizer

Receive AI-powered suggestions to improve your resume.

Suggestions include:

- Overall Resume Feedback
- Professional Summary Suggestions
- Experience Improvements
- Project Improvements
- Technical Skill Recommendations
- Missing ATS Keywords
- Optimized Resume Bullet Points

---

## 🛠 Tech Stack

### Frontend
- React
- React Router
- Axios
- Tailwind CSS
- React Icons

### Backend
- Spring Boot
- Spring Web
- Spring Data JPA
- Lombok
- Apache PDFBox
- Google Gemini AI API

### Database
- PostgreSQL

---

## 📂 Project Structure

```
AIJobAssistant
│
├── frontend
│   ├── src
│   │   ├── api
│   │   ├── components
│   │   ├── context
│   │   ├── pages
│   │   ├── services
│   │   └── App.jsx
│
├── backend
│   ├── ats
│   ├── auth
│   ├── interview
│   ├── optimizer
│   ├── resume
│   ├── common
│   └── config
```

---

## ⚙️ Installation

### Clone Repository

```bash
git clone https://github.com/yourusername/AIJobAssistant.git
```

---

### Backend Setup

```bash
cd backend
```

Configure your `application.properties`

```properties
spring.datasource.url=YOUR_DATABASE_URL
spring.datasource.username=YOUR_USERNAME
spring.datasource.password=YOUR_PASSWORD

spring.ai.openai.api-key=YOUR_GEMINI_API_KEY
```

Run

```bash
mvn spring-boot:run
```

Backend runs on

```
http://localhost:8080
```

---

### Frontend Setup

```bash
cd frontend

npm install

npm run dev
```

Runs on

```
http://localhost:5173
```

---

## 📌 API Endpoints

### Resume Upload

```
POST /api/resumes/upload
```

---

### ATS Analysis

```
POST /analyze
```

Request

```json
{
  "resumeId": 1,
  "jobDescription": "Java, Spring Boot, AWS..."
}
```

---

### Interview Question Generator

```
POST /api/interview/generate
```

Request

```json
{
  "resumeId": 1
}
```

---

### Resume Optimizer

```
POST /api/optimizer/optimize
```

Request

```json
{
  "resumeId": 1,
  "jobDescription": "Java Spring Boot Developer..."
}
```

---

## 🎯 Future Improvements

- User Authentication
- Resume History
- Multiple Resume Management
- AI Chat Career Assistant
- Resume Version Comparison
- Cover Letter Generator
- Job Recommendation System
- Export Optimized Resume as PDF
- Interview Practice Mode
- Dashboard Analytics

---

## 📸 Screenshots

Add screenshots of:

- Home Page
- Dashboard
- ATS Analyzer
- Interview Generator
- Resume Optimizer

---

## 🌟 Why This Project?

AI Job Assistant combines modern web development with Generative AI to help candidates prepare for software engineering interviews and improve their resumes using intelligent insights.

It demonstrates:

- Full Stack Development
- REST API Design
- React + Spring Boot Integration
- PostgreSQL
- AI API Integration
- State Management
- Responsive UI
- Clean Architecture

---

## 👩‍💻 Author

**Shalu Yadav**

GitHub: https://github.com/yourusername

LinkedIn: https://linkedin.com/in/yourprofile
