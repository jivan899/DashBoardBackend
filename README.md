Test Dashboard Project Setup Guide
Here's a comprehensive version and setup document for your test dashboard project:
1. Backend (Spring Boot)
Technical Stack & Version Details
Component	Version	Installation Command
Java JDK	17	sdk install java 17.0.11-tem
Spring Boot	3.2.4	Inherited from parent POM
PostgreSQL	15	docker run --name pg-testdb -e POSTGRES_PASSWORD=pass -p 5432:5432 -d postgres:15
Hibernate	6.4.1	Inherited via Spring Data JPA
Maven	3.9.6	sdk install maven 3.9.6
Backend Setup:

# Clone project
git clone <backend-repo-url>
cd spring-boot-backend

# Start PostgreSQL (Docker)
docker run --name pg-testdb -e POSTGRES_PASSWORD=pass -p 5432:5432 -d postgres:15

# Build and run
mvn clean install
mvn spring-boot:run

2. Frontend (Angular)
Component	Version	Installation Command
Node.js	18.20.2	nvm install 18.20.2
Angular CLI	16.2.16	npm install -g @angular/cli@16.2.16
Angular Core	16.2.12	Auto-installed by CLI
ng2-charts	4.1.1	npm install ng2-charts@4.1.1
Chart.js	3.9.1	npm install chart.js@3.9.1
Angular Material	16.2.12	npm install @angular/material@16.2.12
Frontend Setup:

# Clone project
git clone <frontend-repo-url>
cd angular-frontend

# Install dependencies
npm install

# Start dev server
ng serve

3. Development Environment

| Tool                | Version  | Installation Guide                            |
|---------------------|----------|-----------------------------------------------|
| Git                 | 2.40+    | `brew install git`                            |
| Docker              | 24.0+    | Docker Desktop                                |
| IDE (Recommended)   |          | VS Code / IntelliJ IDEA                       |

4. Project Structure

test-dashboard/
├── backend/
│   ├── src/main/java/
│   │   └── com/example/testdashboard/
│   │       ├── controller/TestResultController.java
│   │       ├── model/TestResult.java
│   │       └── repository/TestResultRepository.java
│   └── application.properties
├── frontend/
│   ├── src/app/
│   │   ├── services/test-result.service.ts
│   │   ├── models/test-result.model.ts
│   │   └── components/
│   └── angular.json
└── README.md

5. Critical Configuration Files
Backend: application.properties

spring.datasource.url=jdbc:postgresql://localhost:5432/testdb
spring.datasource.username=postgres
spring.datasource.password=pass
spring.jpa.hibernate.ddl-auto=update
server.port=8080

Frontend: environment.ts

export const environment = {
  production: false,
  apiUrl: 'http://localhost:8080/api'
};

6. Post-Setup Verification

Backend Checks:
1. Access http://localhost:8080/api/test-results → Should return JSON
2. Check logs for: Started TestDashboardApplication in X seconds

Frontend Checks:
1. Browser console should show: Angular is running in development mode
2. Network tab shows successful API calls (status 200)

7. Troubleshooting Guide

| Issue                          | Solution                                                                 |
|--------------------------------|--------------------------------------------------------------------------|
| CORS errors                    | 1. Verify @CrossOrigin in Spring Boot<br>2. Check proxy.conf.json in Angular |
| Chart not rendering            | Confirm ng2-charts@4.1.1 and chart.js@3.9.1 are installed           |
| Database connection failed     | 1. Verify PostgreSQL is running<br>2. Check credentials in application.properties |

8. Version Locking (For Production)

# Backend (pom.xml)
<maven.compiler.source>17</maven.compiler.source>
<spring-boot.version>3.2.4</spring-boot.version>

# Frontend (package.json)
"dependencies": {
  "@angular/core": "16.2.12",
  "ng2-charts": "4.1.1",
  "chart.js": "3.9.1"
}

Final Notes

1. Always run mvn clean install after changing backend dependencies  
2. Use npm ci (instead of npm install) in CI/CD pipelines  
3. For new team members: Share this document + run ./setup-env.sh (if available)

