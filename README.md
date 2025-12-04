# Dev Activity Tracker

A proof of concept application built with **Spring Boot (Java 21)** and **Angular**, used to track development projects and their related activities. 
The backend provides a REST API for creating projects and logging activity sessions, while the frontend offers a clean UI for viewing and managing that data.

### Backend
- Java 21  
- Spring Boot 3.3  
- Spring Web, Spring Data JPA, H2  
- Maven  

### Frontend
- Angular  
- Standalone components  
- TypeScript  

---

## Getting Started

### Clone the repository

```

mvn clean spring-boot:run
Backend runs at:
http://localhost:8080
H2 Console:
http://localhost:8080/h2-console

Frontend Setup
cd frontend/activity-tracker-ui
npm install
npm start
Frontend runs at:

http://localhost:4200
Project Structure

backend/        → Spring Boot REST API
frontend/       → Angular application

Endpoints 
GET /api/projects
GET /api/projects/{id}
POST /api/projects
PUT /api/projects/{id}
DELETE /api/projects/{id}

GET /api/projects/{projectId}/activities
GET /api/projects/{projectId}/activities/{activityId}
POST /api/projects/{projectId}/activities
PUT /api/projects/{projectId}/activities/{activityId}
DELETE /api/projects/{projectId}/activities/{activityId}
