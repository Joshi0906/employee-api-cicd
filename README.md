# Employee API - GitHub Actions + Azure CI/CD Practice

A small Spring Boot CRUD application designed for learning:

- Java 17
- Spring Boot
- Maven
- REST API
- JPA + H2
- JUnit + Mockito
- Docker
- GitHub Actions
- Azure Container Registry
- Azure Container Apps

## 1. Run locally

Requirements:
- Java 17+
- Maven 3.9+
- Docker Desktop (for Docker practice)
- Git

Run tests:

```bash
mvn clean test
```

Run application:

```bash
mvn spring-boot:run
```

Health:

```text
http://localhost:8080/actuator/health
```

API:

```text
http://localhost:8080/api/employees
```

## 2. Test the API

Create:

```bash
curl -X POST http://localhost:8080/api/employees ^
  -H "Content-Type: application/json" ^
  -d "{"name":"Gaurav","department":"IT","salary":60000}"
```

Get all:

```bash
curl http://localhost:8080/api/employees
```

Get one:

```bash
curl http://localhost:8080/api/employees/1
```

Update:

```bash
curl -X PUT http://localhost:8080/api/employees/1 ^
  -H "Content-Type: application/json" ^
  -d "{"name":"Gaurav","department":"Engineering","salary":70000}"
```

Delete:

```bash
curl -X DELETE http://localhost:8080/api/employees/1
```

## 3. GitHub

```bash
git init
git add .
git commit -m "Initial employee API"
git branch -M main
git remote add origin YOUR_GITHUB_REPOSITORY_URL
git push -u origin main
```

Then open GitHub -> Actions.

The included workflow runs:

1. Checkout
2. Setup Java 17
3. Maven test
4. Maven package
5. Docker build

## 4. Docker locally

First:

```bash
mvn clean package
```

Build:

```bash
docker build -t employee-api:local .
```

Run:

```bash
docker run --rm -p 8080:8080 employee-api:local
```

Test:

```text
http://localhost:8080/actuator/health
```

## 5. Azure phase

After CI works, create an Azure Resource Group, Azure Container Registry (ACR), and Azure Container App.

The recommended learning sequence is:

GitHub
 -> GitHub Actions CI
 -> Docker image
 -> Azure Container Registry
 -> Azure Container Apps
 -> GitHub Actions CD

Do not add Azure credentials to source code.

For the CD stage, use GitHub Actions secrets/variables and Azure's recommended workload identity/OIDC authentication rather than hard-coding passwords.

## 6. Practice plan

Stage 1: Run Spring Boot locally.
Stage 2: Push to GitHub.
Stage 3: Understand ci.yml.
Stage 4: Break a unit test and observe CI failure.
Stage 5: Dockerize locally.
Stage 6: Create ACR and Container App in Azure.
Stage 7: Add CD to GitHub Actions.
Stage 8: Make a code change and watch GitHub deploy it automatically.
Stage 9: Practice logs and rollback.

The database is intentionally H2 at first. Add Azure PostgreSQL only after the application-to-Azure deployment is working.
