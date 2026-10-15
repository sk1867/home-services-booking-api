# Home Services Booking API

A REST API built using Spring Boot, Spring Data JPA, Hibernate, and MySQL to manage home services and customer bookings.

## Technologies Used
- Java 21
- Spring Boot 3.5.7
- Spring Data JPA and Hibernate
- MySQL
- Maven
- Swagger UI

## Prerequisites
- JDK 21
- MySQL Server
- Maven (or use the Maven Wrapper if included)

## Database Configuration

1. Start your MySQL server.
2. Create the database:

```sql
CREATE DATABASE home_services_db;
```

3. Open `src/main/resources/application.properties` and configure your database credentials:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/home_services_db
spring.datasource.username=${DB_USERNAME:root}
spring.datasource.password=${DB_PASSWORD}
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
spring.jackson.serialization.write-dates-as-timestamps=false
springdoc.swagger-ui.path=/swagger-ui.html
```

Set the `DB_PASSWORD` environment variable to your MySQL password before running the application. Do not commit passwords or other secrets to GitHub.

## How to Run

1. Clone the repository:

```bash
git clone https://github.com/sk1867/home-services-booking-api.git
cd home-services-booking-api
```

2. Configure your MySQL credentials as described above.
3. Run the application using Maven:

```bash
mvn spring-boot:run
```

The API runs at `http://localhost:8080`.

## API Endpoints

| Method | Endpoint | Description |
|---|---|---|
| GET | `/api/services` | Get all services |
| GET | `/api/services/{id}` | Get a service by ID |
| GET | `/api/services/search?name=cleaning` | Search services by name |
| POST | `/api/bookings` | Create a booking |
| GET | `/api/bookings` | Get all bookings |
| GET | `/api/bookings/{id}` | Get a booking by ID |

## Swagger UI

Open `http://localhost:8080/swagger-ui.html` to explore and test the API.

## Repository

https://github.com/sk1867/home-services-booking-api
