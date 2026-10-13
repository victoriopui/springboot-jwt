# Spring Boot JWT

A Spring Boot REST API demonstrating JWT-based authentication, backed by SQLite with Flyway migrations.

## Tech Stack

- Java 8, Spring Boot 2.1.1 (Spring Web, Spring Security, Spring Data JPA)
- SQLite (via `sqlite-jdbc`) for storage
- Flyway for database schema migrations
- `jjwt` for JWT generation/validation

## Prerequisites

- JDK 8+
- Maven

## Running the application

```bash
./mvnw spring-boot:run
```

The app starts on the default port `8080`. On first run, Flyway applies the migration in `src/main/resources/db/migration`, creating `springboot_jwt.db` in the project root.

## Configuration

Key settings live in `src/main/resources/application.properties`:

- `jwt.secret` — signing key used to generate/validate tokens
- `spring.datasource.url` — SQLite database file location

## API Endpoints

### `POST /login`

Authenticate a user and receive a JWT.

```json
{
  "username": "user@example.com",
  "password": "secret",
  "time": 60
}
```

Returns a JWT valid for `time` minutes.

### `POST /verifytoken`

Validate a previously issued token.

```json
{
  "username": "user@example.com",
  "token": "<jwt>"
}
```

### `POST /api/users/`

Create a new user. `pin` is required and is hashed before being stored as the user's password.

```json
{
  "firstname": "Jane",
  "lastname": "Doe",
  "email": "user@example.com",
  "pin": "1234",
  ...
}
```

### `GET /api/users/{email}`

Fetch a user by email.

## Project Structure

```
src/main/java/com/test/
├── config/      # Security config, JWT utilities, filters
├── controller/  # REST controllers
├── model/       # JPA entities and request/response DTOs
├── repository/  # Spring Data repositories
└── service/     # Business logic
```
