# 🌍 GreenLearn — Eco Education Platform

> **A full-stack gamified eco-education platform built with Spring Boot, MySQL, and Thymeleaf. Users learn about climate change, sustainability, and environmental awareness through interactive games, simulations, and daily missions.**

---

## 🖼 Project Overview

GreenLearn is a web-based platform that makes learning about the environment fun and engaging. Users earn points by playing eco-themed games, completing daily missions, and making smart choices in climate simulations — all tracked in a live leaderboard. Admins can manage users and quiz questions through a dedicated admin dashboard.

---

## ✨ Features

### 👤 User Side
- 🔐 **Register & Login** — Secure authentication with duplicate email check and role-based redirect
- 🏠 **Home Dashboard** — Personalized welcome with points, badge, and navigation to all games
- 🧠 **Eco Quiz** — 60 questions across 6 categories pulled live from the database
- 🃏 **Memory Match** — Eco-themed card flip game with 3 difficulty levels and timer
- ♻️ **Waste Sorter** — Drag and sort waste into correct bins under 60 seconds
- 🔤 **Word Scramble** — Unscramble 50 eco terms with streak system and hints
- 🎯 **Eco Trivia Battle** — Fast-paced trivia with 3 lives and 15-second timer per question
- 🌡️ **Climate Simulator** — Choose actions that help or harm the planet. Bad choices trigger a real eco-fact warning popup before proceeding
- 🏙️ **Eco City Builder** — Build a city, manage pollution, and survive random disasters
- 📋 **Daily Missions** — 5 eco missions that reset every midnight, earn points on completion
- 🏆 **Leaderboard** — Live rankings pulled from DB, animated podium for top 3, highlights current user

### 👑 Admin Side
- 📊 **Admin Dashboard** — Platform stats (users, questions, total points, top player)
- 👥 **Manage Users** — View, search, and delete users. Admin rows are protected
- ❓ **Manage Questions** — Edit questions inline (saves to DB instantly), delete, filter by category
- ➕ **Add Question** — Add new quiz questions to the database with category selection

---

## 🛠 Tech Stack

| Layer | Technology |
|---|---|
| Backend | Java 21, Spring Boot |
| Database | MySQL 8.0 |
| ORM | Spring Data JPA / Hibernate |
| Frontend | Thymeleaf, HTML, CSS, Vanilla JavaScript |
| Fonts | Fraunces (serif) + Plus Jakarta Sans |
| Build Tool | Maven |

---

## 📁 Project Structure

```
greenlearn/
│
├── src/main/java/com/dhanavarshini/greenlearn/
│   ├── GreelearnApplication.java        ← App entry point + auto admin seeder
│   ├── entity/
│   │   ├── User.java                    ← user table
│   │   ├── Question.java                ← question table
│   │   ├── DailyMission.java            ← daily_mission table
│   │   └── QuizResult.java              ← quiz_result table
│   ├── repository/
│   │   ├── UserRepository.java
│   │   ├── QuestionRepository.java
│   │   ├── MissionRepository.java
│   │   └── QuizResultRepository.java
│   └── controller/
│       ├── PageController.java          ← serves all HTML pages
│       ├── UserController.java          ← register, login, leaderboard
│       ├── AdminController.java         ← admin APIs
│       ├── QuestionController.java      ← quiz question APIs
│       └── MissionController.java       ← daily mission APIs
│
├── src/main/resources/
│   ├── templates/
│   │   ├── login.html
│   │   ├── home.html
│   │   ├── quiz.html
│   │   ├── leaderboard.html
│   │   ├── missions.html
│   │   ├── memory.html
│   │   ├── waste.html
│   │   ├── scramble.html
│   │   ├── trivia.html
│   │   ├── result.html
│   │   ├── climate-simulator.html
│   │   ├── eco-city-builder.html
│   │   └── admin/
│   │       ├── admin-dashboard.html
│   │       ├── manage-users.html
│   │       ├── manage-questions.html
│   │       └── add-question.html
│   └── application.properties           ← DB connection config
│
└── pom.xml                              ← Maven dependencies
```

---

## ⚙️ Prerequisites

Make sure you have the following installed:

- **Java 21** — [Download here](https://www.oracle.com/java/technologies/downloads/)
- **MySQL 8.0** — [Download here](https://dev.mysql.com/downloads/)
- **Spring Tool Suite 4 (STS)** *(recommended IDE)* — [Download here](https://spring.io/tools)

---

## 🚀 Getting Started

### Step 1 — Clone the Repository

```bash
git clone https://github.com/yourusername/greenlearn.git
cd greenlearn
```

### Step 2 — Create the Database

Open MySQL Workbench or MySQL terminal and run:

```sql
CREATE DATABASE greenlearn;
```

### Step 3 — Configure Database Connection

Open `src/main/resources/application.properties` and update if needed:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/greenlearn
spring.datasource.username=root
spring.datasource.password=root
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

> ⚠️ If your MySQL password is not `root`, change `spring.datasource.password` to your actual password.

### Step 4 — Run the Project

**Option A — Using Spring Tool Suite (STS):**
1. Open STS → File → Import → Existing Maven Project → select the project folder
2. Wait for Maven to download all dependencies automatically
3. Right-click the project → Run As → Spring Boot App

**Option B — Using Terminal:**
```bash
mvn spring-boot:run
```

### Step 5 — Open in Browser

```
http://localhost:8080
```

---

## 🌱 Seed Quiz Questions (Optional but Recommended)

To populate the database with 60 questions across 6 categories, run the SQL seed file:

```bash
mysql -u root -p greenlearn < insert_questions.sql
```

> This inserts 10 questions each for: **Climate, Energy, Ecosystem, Ocean, Waste, Wildlife**

---

## 👑 Default Admin Credentials

When the project starts for the **first time**, an admin account is automatically created:

```
Email    : admin@greenlearn.com
Password : admin123
```

> This is handled by `GreelearnApplication.java` using `CommandLineRunner`. It only creates the admin if the email doesn't already exist — so restarting the project will never create duplicates.

---

## 🗺 All Pages & Routes

| URL | Page | Access |
|---|---|---|
| `localhost:8080/` | Login / Register | Everyone |
| `localhost:8080/home` | Home Dashboard | Users |
| `localhost:8080/quiz` | Eco Quiz | Users |
| `localhost:8080/missions` | Daily Missions | Users |
| `localhost:8080/leaderboard` | Leaderboard | Users |
| `localhost:8080/memory` | Memory Match | Users |
| `localhost:8080/waste` | Waste Sorter | Users |
| `localhost:8080/scramble` | Word Scramble | Users |
| `localhost:8080/trivia` | Eco Trivia | Users |
| `localhost:8080/climate-simulator` | Climate Simulator | Users |
| `localhost:8080/eco-city-builder` | Eco City Builder | Users |
| `localhost:8080/admin` | Admin Dashboard | Admin only |
| `localhost:8080/admin/manage-users` | Manage Users | Admin only |
| `localhost:8080/admin/manage-questions` | Manage Questions | Admin only |
| `localhost:8080/admin/add-question` | Add Question | Admin only |

---

## 🔌 API Endpoints

### User APIs
| Method | URL | Description |
|---|---|---|
| POST | `/users/register` | Register new user |
| POST | `/users/login` | Login user |
| GET | `/users/leaderboard` | Get all users sorted by points |
| GET | `/users/{id}` | Get user by ID |

### Question APIs
| Method | URL | Description |
|---|---|---|
| GET | `/api/questions` | Get all questions |
| GET | `/api/questions/category/{category}` | Get by category |
| GET | `/api/questions/categories` | Get distinct categories |
| POST | `/api/questions` | Add new question |
| DELETE | `/api/questions/{id}` | Delete question |

### Mission APIs
| Method | URL | Description |
|---|---|---|
| GET | `/api/missions` | Get all missions |
| POST | `/api/missions/complete/{missionId}/{userId}` | Complete a mission |

### Admin APIs
| Method | URL | Description |
|---|---|---|
| GET | `/admin/stats` | Platform statistics |
| GET | `/admin/users` | All users |
| DELETE | `/admin/users/{id}` | Delete user |
| GET | `/admin/questions` | All questions |
| PUT | `/admin/questions/{id}` | Update question |
| DELETE | `/admin/questions/{id}` | Delete question |

---

## 🏅 Badge System

Users earn badges based on total points:

| Badge | Points Required |
|---|---|
| 🌾 Beginner | 0 pts |
| 🌱 Green Starter | 50+ pts |
| 🌿 Eco Warrior | 150+ pts |
| 🌟 Green Champion | 300+ pts |
| 🏆 Eco Legend | 500+ pts |

---

## 🗄 Database Tables

| Table | Description |
|---|---|
| `user` | id, name, email, password, points, badge, role |
| `question` | id, question, optiona, optionb, optionc, optiond, correct_answer, category |
| `daily_mission` | id, title, description, points |
| `quiz_result` | id, user_id, score |

> Tables are **auto-created** by Hibernate on first run. No manual SQL setup needed.

---

## 🧩 How It Works — Quick Flow

```
Browser (HTML + JS)
    ↓  fetch('/api/...') — sends request
Spring Boot Controller
    ↓  calls repository method
Spring Data JPA Repository
    ↓  auto-generates SQL query
MySQL Database
    ↓  returns data
Back up the chain → displayed in browser
```

---

## 🐛 Common Issues & Fixes

**❌ "Access denied for user 'root'"**
→ Your MySQL password is wrong. Update `spring.datasource.password` in `application.properties`.

**❌ "Unknown database 'greenlearn'"**
→ You haven't created the database yet. Run `CREATE DATABASE greenlearn;` in MySQL.

**❌ Port 8080 already in use**
→ Add this to `application.properties`: `server.port=9090` and visit `localhost:9090` instead.

**❌ Tables not created**
→ Make sure `spring.jpa.hibernate.ddl-auto=update` is in `application.properties`.

**❌ Admin login not working**
→ The admin is auto-created on first run. Check the console for: `✅ Default admin created`. If not shown, the admin already exists in DB.

---

## 👩‍💻 Built By

**Dhanavarshini** — Full Stack Developer

> GreenLearn was built as an eco-education platform to raise awareness about climate change through gamification. Every game, simulation, and mission is designed to teach real environmental facts while keeping users engaged.

---

## 📄 License

This project is built for educational purposes.

---

## 🌱 "Every choice you make either helps or harms the planet. GreenLearn helps you make the right ones."
