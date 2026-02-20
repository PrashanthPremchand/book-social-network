![Java](https://img.shields.io/badge/Java-17-orange)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3-green)
![Docker](https://img.shields.io/badge/Docker-Enabled-blue)
![CI/CD](https://img.shields.io/badge/CI%2FCD-GitHub%20Actions-success)
![PostgreSQL](https://img.shields.io/badge/Database-PostgreSQL-blue)

# 📚 Book Social Network – Backend API

A **production-grade Spring Boot backend** for a Book Social Network platform featuring **JWT authentication**, **email verification**, **book borrowing workflows**, **feedback system**, **Dockerized deployment**, and a **fully automated CI/CD pipeline using GitHub Actions**.

> ⚠️ **Important**: This project is designed to run via **CI/CD pipelines and Docker**, not via simple `mvn spring-boot:run`.

---

## 🎯 Why This Project?

This project was built to demonstrate how real-world backend systems are designed and deployed in production environments, including:

- Secure authentication using JWT
- Email-based account activation
- Clean layered architecture
- Dockerized deployment
- CI/CD-driven delivery using GitHub Actions

It intentionally avoids hardcoded secrets and local shortcuts to reflect enterprise-grade practices.

---

## 🚀 Tech Stack (ATS Optimized)

**Backend**

* Java 17
* Spring Boot 3
* Spring Security (JWT)
* Spring Data JPA
* Hibernate
* Validation (Jakarta)
* Thymeleaf (Email Templates)

**Database**

* PostgreSQL (Production)
* H2 (Testing)

**DevOps & Infrastructure**

* Docker & Docker Compose
* GitHub Actions (CI/CD)
* Self-hosted GitHub Runner
* MailDev (Local Email Testing)

**Tools**

* Swagger / OpenAPI
* Maven
* Postman

---

## ✨ Core Features

* 🔐 JWT-based Authentication & Authorization
* 📧 Email Account Activation (Token-based)
* 📚 Book Management (CRUD, Shareable, Archive)
* 🔄 Book Borrow & Return Workflow
* ⭐ Feedback & Rating System
* 📄 Pagination & Filtering
* 🧾 Global Exception Handling
* 🐳 Fully Dockerized Setup
* ⚙️ Automated CI/CD Pipeline

---

## 🧱 Clean Architecture Overview

This project follows **Clean Architecture + Layered Architecture** principles.

```
Controller → Service → Repository → Database
           ↓
         Mapper / DTO
```

### 📦 Package Structure

```
com.prashanth.book
├── auth          # Authentication & JWT logic
├── book          # Book domain (entity, service, repo)
├── feedback      # Feedback & ratings
├── history       # Book transaction history
├── user          # User & roles
├── security      # JWT filter & security config
├── email         # Email service & templates
├── file          # File storage utilities
├── common        # BaseEntity, PageResponse
├── handler       # Global exception handling
└── config        # Beans, OpenAPI, auditing
```

✔ Separation of concerns
✔ Testable services
✔ Maintainable structure
✔ Production-ready design

---

## 🏗️ Architecture Diagrams

### 1️⃣ Monolithic Architecture (Current)

```
graph TD
    subgraph Client_Layer [Client Layer]
        A[Postman / Frontend]
    end

    subgraph Spring_Boot_App [Spring Boot Application]
        B[Security Filter / JWT]
        C[Auth Module]
        D[Book Module]
        E[Feedback Module]
        F[Email Module]
    end

    subgraph Data_Layer [Data Layer]
        G[(PostgreSQL)]
    end

    A --> B
    B --> C
    B --> D
    B --> E
    C --> F
    C & D & E --> G
```

**Why Monolith?**

* Faster development
* Easier debugging
* Ideal for early-stage systems
* Clean separation allows future migration

---

### 2️⃣ Microservices (Future Scope)

```
API Gateway
    ↓
Auth Service  → JWT
Book Service  → Books
Feedback Service → Reviews
Notification Service → Emails
    ↓
PostgreSQL (per service)
```

> The current design intentionally supports **easy migration to microservices**.

---

## 🗃️ ER Diagram (High-Level)

```
erDiagram
    USER ||--o{ BOOK : owns
    USER ||--o{ BOOK_TRANSACTION_HISTORY : borrows
    BOOK ||--o{ FEEDBACK : receives
    BOOK ||--o{ BOOK_TRANSACTION_HISTORY : tracked_in
    USER ||--o{ FEEDBACK : writes

    USER {
        string email
        string password
        boolean accountLocked
        boolean enabled
    }
    BOOK {
        string title
        string authorName
        boolean archieved
        boolean shareable
    }
    FEEDBACK {
        double note
        string comment
    }
```

**Key Relationships**

* User ↔ Book (Owner)
* User ↔ BookTransactionHistory (Borrower)
* Book ↔ Feedback (Ratings & Reviews)

---

## 📘 API Documentation (Swagger)

Once deployed, Swagger UI is available at:

```
http://<HOST>:8088/swagger-ui/index.html
```

**Includes**

* Auth endpoints
* Book APIs
* Feedback APIs
* JWT security scheme
* Request/response schemas

---

## 🔄 CI/CD Pipeline (GitHub Actions)

### Pipeline Stages

1. **Compile**
2. **Unit Tests**
3. **Build JAR**
4. **Build & Push Docker Image**
5. **Deploy via Docker Compose (Self-hosted Runner)**

### Docker Image Versioning

* Tagged using Maven project version
* Also pushes `latest`

---

## 🐳 Docker & Deployment

### Services Used

* PostgreSQL
* MailDev
* Spring Boot API (Docker Image)

### ⚠️ Local Execution Disclaimer (Important)

❌ This project **cannot run fully locally out-of-the-box**

**Reasons:**

* Environment variables are injected via **GitHub Secrets**
* Docker image is pulled dynamically:

  ```
  image: ${DOCKER_USERNAME}/bsn-api:${APP_VERSION}
  ```
* Email credentials, DB passwords, Docker credentials are never hardcoded
* CI/CD pipeline controls:

  * Image version
  * Deployment
  * Environment variables

✅ This is **intentional** and follows **production best practices**.

---

## 🧪 Testing Strategy

* ✅ Manual API testing via Postman
* ✅ Context load test
* 🧩 Unit tests (service-level – extensible)
* 🔐 JWT-protected endpoint testing

> Test coverage can be expanded with MockMvc & Testcontainers.

---

## 📌 Project Status

**Status:** ✅ Stable & Functional

The project is:

* Fully implemented
* Tested via Postman
* CI/CD automated
* Dockerized and deployable

### 🔮 Future Improvements

* Integration tests (Testcontainers)
* Observability (Prometheus + Grafana)
* Cloud deployment (ECS / GCP / Azure)
* Rate limiting & caching

---

## 👨‍💻 Author

**Prashanth P**
Java Backend Developer
Spring Boot | Microservices | Docker | CI/CD

📧 Email: `prashanthpremchand@gmail.com`

---
