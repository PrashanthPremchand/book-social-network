Good catch 👍 — this is an **important real-world detail**, and updating the README to reflect it actually **makes your project more professional**, not weaker.

Below is an **updated README version** that clearly explains:

* ❌ Why the project **cannot run fully locally**
* ✅ How it **runs via GitHub Actions + self-hosted runner**
* ✅ How environment variables & secrets are handled
* ✅ What reviewers/interviewers should understand

You can **replace your README with this version** (or copy the relevant sections).

---

# 📚 Book Social Network – Backend API

A **production-style Spring Boot backend** demonstrating **JWT authentication, email verification, Dockerized deployment, and CI/CD using GitHub Actions**.

⚠️ **Important Note**:
This project is **designed to run via CI/CD pipelines** and **self-hosted runners**, not as a simple `mvn spring-boot:run` local setup.

---

## 🚀 Key Highlights

* JWT-based authentication & authorization
* Email-based account activation (Thymeleaf templates)
* Book borrowing & return workflow
* Feedback and rating system
* PostgreSQL persistence
* Docker & Docker Compose
* GitHub Actions CI/CD pipeline
* Self-hosted runner deployment
* Production-style configuration using secrets

---

## ⚠️ Local Execution Disclaimer (Important)

### ❌ This project **cannot run fully locally out-of-the-box**

Reasons:

1. **Critical environment variables are injected via GitHub Secrets**
2. Docker image is pulled dynamically using:

   ```yaml
   image: ${DOCKER_USERNAME}/bsn-api:${APP_VERSION}
   ```
3. Email credentials, database passwords, and Docker credentials are **never hardcoded**
4. CI/CD pipeline controls:

   * Image version
   * Deployment
   * Environment variables

➡️ This setup **intentionally mirrors real production environments**

---

## 🔐 Environment Variables & Secrets

The application depends on **external secrets** injected at runtime.

### Required Secrets (GitHub)

```text
DOCKER_USERNAME
DOCKERHUB_TOKEN
POSTGRES_PASSWORD

EMAIL_HOST_NAME
EMAIL_USER_NAME
EMAIL_PASSWORD
```

These are provided **only during pipeline execution** or via a **self-hosted GitHub runner**.

---

## 🐳 Docker Architecture

### docker-compose.yml (Production-style)

```yaml
bsn-api:
  container_name: bsn-api
  image: ${DOCKER_USERNAME}/bsn-api:${APP_VERSION}
  environment:
    SPRING_DATASOURCE_URL: jdbc:postgresql://postgres:5432/book_social_network_db
    EMAIL_HOST_NAME: ${EMAIL_HOST_NAME}
    EMAIL_USER_NAME: ${EMAIL_USER_NAME}
    EMAIL_PASSWORD: ${EMAIL_PASSWORD}
```

### Why this matters

* Image version is controlled by CI/CD
* Same compose file works across environments
* No environment-specific code changes

---

## 🔄 CI/CD Pipeline Overview

### Pipeline Stages

1. **Compile**

   * Maven compile
2. **Unit Tests**

   * JUnit tests
3. **Build & Push**

   * Docker image built
   * Tagged with project version
   * Pushed to Docker Hub
4. **Deploy**

   * Runs on **self-hosted GitHub runner**
   * Pulls Docker image
   * Runs `docker compose up -d`

---

## 🧪 Testing Strategy

### ✔ Manual Testing

* Fully tested using **Postman**
* Covers:

  * Authentication
  * JWT authorization
  * Book lifecycle
  * Borrow/return flow
  * Feedback APIs

### ✔ Automated Testing

* JUnit 5
* Spring Boot context load test
* Executed in CI pipeline

---

## 📖 API Documentation

Swagger UI (available when deployed):

```
http://<server-ip>:8088/swagger-ui.html
```

---

## 🧠 Design Decision (Why Not Local?)

This project intentionally prioritizes:

* Security
* Secret management
* CI/CD correctness
* Production realism

> **In real companies, applications do not run with hardcoded credentials or local configs.**

This backend reflects:

* How services are deployed
* How secrets are managed
* How environments are separated

---

## 👨‍💻 Author

**Prashanth P**
Java Backend Developer
📧 [prashanthpremchand@gmail.com](mailto:prashanthpremchand@gmail.com)

---

## ⭐ Project Status

* ✅ Production-style backend
* ✅ CI/CD enabled
* ✅ Dockerized
* ✅ Secure configuration
* ⚠️ Not intended for direct local execution

---
