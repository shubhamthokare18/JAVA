# Banking Compliance System - API Documentation

## Overview
This is a Spring Boot application for banking compliance and fraud detection system with JWT authentication, Temporal workflow integration, and OpenFeign client support.

## Features
- **Authentication**: JWT-based authentication with login endpoint
- **Customer Management**: Full CRUD operations for customers
- **Fraud Detection**: Fraud case management with workflow integration
- **Security**: Spring Security with role-based access control
- **API Documentation**: Swagger/OpenAPI integration
- **Database**: H2 in-memory database (configurable for production)

## API Endpoints

### Authentication
- `POST /auth/login` - Login endpoint (Public)
  - Request: `{"username": "string", "password": "string"}`
  - Response: `{"token": "JWT_TOKEN", "message": "Login successful"}`

### Customer Management
- `POST /customer/create` - Create a new customer
- `GET /customer/{id}` - Get customer by ID
- `GET /customer/all` - Get all customers
- `PUT /customer/{id}` - Update customer
- `DELETE /customer/{id}` - Delete customer

### Fraud Cases
- `POST /fraud/create` - Create a new fraud case
- `GET /fraud/{id}` - Get fraud case by ID
- `GET /fraud/all` - Get all fraud cases
- `PUT /fraud/{id}` - Update fraud case
- `DELETE /fraud/{id}` - Delete fraud case

## Configuration

### Database
- URL: `jdbc:h2:mem:testdb`
- Username: `sa`
- Password: (empty)
- Driver: `org.h2.Driver`

### Security
- Default user: `admin`
- Default password: `admin123`
- Public endpoints: `/auth/**`, `/swagger-ui/**`, `/v3/api-docs/**`

### Server
- Port: 8082
- Context Path: `/`

## Running the Application

```bash
# Build the project
mvn clean install

# Run the application
mvn spring-boot:run

# Or run the JAR directly
java -jar target/banking-compliance-system-0.0.1-SNAPSHOT.jar
```

## Accessing Swagger UI
Navigate to: `http://localhost:8082/swagger-ui.html`

## Key Components

### Controllers
- **AuthController**: Handles authentication and login
- **CustomerController**: Manages customer CRUD operations
- **FraudController**: Manages fraud case operations

### Services
- **AuthService**: Authentication logic
- **CustomerService**: Customer business logic
- **FraudService**: Fraud case processing with workflow integration

### Repositories
- **UserRepository**: Database access for users
- **CustomerRepository**: Database access for customers
- **FraudRepository**: Database access for fraud cases

### Security
- **JwtUtil**: JWT token generation and validation
- **SecurityConfig**: Security configuration

### Workflows
- **FraudWorkflow**: Temporal workflow interface
- **FraudWorkflowImpl**: Fraud case processing workflow

## Error Handling
Global exception handler returns standardized error responses with:
- HTTP status code
- Error message
- Error class name
- Timestamp

## Technologies Used
- Spring Boot 3.4.5
- Spring Security 6.4.5
- Spring Cloud OpenFeign 4.2.1
- JWT (JJWT 0.11.5)
- Hibernate 6.6.13
- H2 Database
- Temporal SDK 1.22.3
- Swagger/SpringDoc 2.5.0
- Lombok

