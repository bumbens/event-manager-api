# Event Manager API

## Description
Spring Boot REST API for managing events and user registrations.
It utilises JPA/Hibernate to establish a connection with a PostgreSQL database, allowing users to create events, register participants, and track payment statuses.

## Tech Stack

**Backend**
- Java 17
- Spring Boot
- PostgreSQL
- JPA / Hibernate
- JUnit 5 / Mockito

**Frontend**
- React
- Vite

## How to Run

### Prerequisites
- Java 17+
- PostgreSQL
- Gradle

### Setup

1. Clone the repository
   ```bash
   git clone https://github.com/bumbens/event-manager-api.git
   cd event-manager-api
   ```

2. Create a PostgreSQL database
   ```sql
   CREATE DATABASE eventmanager;
   ```

3. Configure the application
   ```bash
   cp src/main/resources/application.properties.example src/main/resources/application.properties
   ```
   Edit `application.properties` and fill in your PostgreSQL credentials.

4. Run the application
   ```bash
   ./gradlew bootRun
   ```

The API will be available at `http://localhost:8080`.

## Frontend

A React frontend is available at [https://github.com/bumbens/event-manager-frontend](https://github.com/bumbens/event-manager-api/tree/main/eventmanager-frontend).

Built with React + Vite. Allows users to:
- View all registrations
- Register a user for an event

The frontend is currently under active development. More features coming soon. 

## API Endpoints

### Users

| Method | URL | Description |
|--------|-----|-------------|
| GET | /users | Get all users |
| POST | /users | Create a new user |
| PUT | /users/{id} | Update a user |
| DELETE | /users/{id} | Delete a user |

#### Example POST /users body
```json
{
    "name": "John Doe",
    "email": "john@doe.com"
}
```

---

### Events

| Method | URL | Description |
|--------|-----|-------------|
| GET | /events | Get all events |
| POST | /events | Create a new event |
| PUT | /events/{id} | Update an event |
| DELETE | /events/{id} | Delete an event |

#### Example POST /events body
```json
{
    "name": "Spring Boot Conference",
    "description": "Annual Spring Boot developers conference",
    "date": "2026-09-15",
    "price": "99.99",
    "location": "Copenhagen, Denmark"
}
```

---

### Registrations

| Method | URL | Description |
|--------|-----|-------------|
| GET | /registrations | Get all registrations |
| POST | /registrations | Register a user for an event |
| PUT | /registrations/{id} | Update a registration |
| DELETE | /registrations/{id} | Delete a registration |

#### Example POST /registrations body
```json
{
    "userId": 1,
    "eventId": 1
}
```

Payment status is set automatically to `NEW` on creation.

---

## Payment Status

| Status | Description |
|--------|-------------|
| `NEW` | Registration created, awaiting payment |
| `PAYMENT_IN_PROGRESS` | Payment is being processed |
| `PAID` | Payment completed successfully |
| `FREE` | Event is free, no payment required |
| `NO_PAYMENT` | Payment deadline passed without payment |
| `CANCELED` | Registration canceled by user |
| `FAILED` | Payment or registration failed |

## Data Model

```
User ──< Registration >── Event
```

A user can register for many events, and an event can have many registered users. Each registration tracks its own payment status independently.

This project is currently under active development.
