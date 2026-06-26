# Banking Compliance System

A Spring Boot application for banking compliance and fraud detection with JWT authentication, Temporal workflow integration, and micro-service capabilities.

## 🚀 Quick Start

### Prerequisites
- Java 21 or higher
- Maven 3.8+
- Git

### Installation & Running

```bash
# Clone the repository
git clone <repository-url>
cd banking-compliance-system

# Build the project
mvn clean install

# Run the application
mvn spring-boot:run

# Or run the JAR directly
java -jar target/banking-compliance-system-0.0.1-SNAPSHOT.jar
```

The application will start on `http://localhost:8082`

## 📚 API Documentation

### Swagger UI
Access the interactive API documentation at: `http://localhost:8082/swagger-ui.html`

### H2 Console
Access the H2 database console at: `http://localhost:8082/h2-console`
- URL: `jdbc:h2:mem:testdb`
- Username: `sa`
- Password: (leave blank)

## 🔑 Default Credentials

```
Username: admin
Password: admin123
```

## 📋 Main Features

### 1. Authentication Service
- JWT token-based authentication
- Login endpoint: `POST /auth/login`
- Token validation and authorization

### 2. Customer Management
- Create, Read, Update, Delete customers
- Endpoints:
  - `POST /customer/create` - Create customer
  - `GET /customer/{id}` - Get customer
  - `GET /customer/all` - List all customers
  - `PUT /customer/{id}` - Update customer
  - `DELETE /customer/{id}` - Delete customer

### 3. Fraud Detection
- Manage fraud cases with workflow integration
- Endpoints:
  - `POST /fraud/create` - Report fraud case
  - `GET /fraud/{id}` - Get fraud case details
  - `GET /fraud/all` - List all fraud cases
  - `PUT /fraud/{id}` - Update fraud case
  - `DELETE /fraud/{id}` - Delete fraud case

## 🏗️ Project Structure

```
src/main/java/com/eidiko/bankingcompliancesystem/
├── config/              # Configuration classes
├── controller/          # REST controllers
├── dto/                 # Data Transfer Objects
├── entity/              # JPA entities
├── exception/           # Exception handling
├── feign/               # Feign clients
├── repository/          # Data repositories
├── security/            # Security utilities
├── service/             # Business logic
└── workflow/            # Temporal workflows
```

## 🔒 Security Configuration

- **Public Endpoints**: `/auth/**`, `/swagger-ui/**`, `/v3/api-docs/**`
- **Protected Endpoints**: All other endpoints require authentication
- **Password Encoding**: BCrypt
- **Token Expiration**: 1 hour (configurable)

## 📊 Technologies

- **Framework**: Spring Boot 3.4.5
- **Security**: Spring Security 6.4.5
- **Authentication**: JWT (JJWT 0.11.5)
- **Database**: H2 (in-memory for development)
- **ORM**: Hibernate 6.6.13 with JPA
- **Microservices**: Spring Cloud OpenFeign 4.2.1
- **Workflow**: Temporal SDK 1.22.3
- **API Documentation**: SpringDoc OpenAPI 2.5.0
- **Build Tool**: Maven
- **Dependency Injection**: Lombok

## 🧪 Testing

```bash
# Run tests
mvn test

# Run specific test class
mvn test -Dtest=YourTestClass

# Generate test coverage report
mvn clean test jacoco:report
```

## 📝 Configuration Files

### application.yaml
Main application configuration including:
- Server port (8082)
- Database settings
- Logging levels
- Security configuration
- JWT settings

## 🐛 Troubleshooting

### Application won't start
```bash
# Check Java version
java -version  # Should be 21+

# Clear Maven cache
mvn clean
mvn install
```

### Database connection issues
- Ensure H2 database is properly configured
- Check `application.yaml` database settings
- Verify JDBC URL and credentials

### Security/Authentication issues
- Verify JWT token format in Authorization header: `Bearer <token>`
- Check token expiration (default 1 hour)
- Ensure user has proper roles

## 🚢 Deployment

### Docker (if Dockerfile available)
```bash
docker build -t banking-compliance-system:1.0 .
docker run -p 8082:8082 banking-compliance-system:1.0
```

### Cloud Platform
Update `application.yaml` for your environment:
- Database connection strings
- Server port
- Security settings
- External service URLs

## 📞 Support

For issues or questions:
- Check the API documentation at `/swagger-ui.html`
- Review logs in `console` or `log files`
- Contact: support@eidiko.com

## 📄 License

This project is licensed under Apache 2.0 - see LICENSE file for details.

## 👥 Contributors

- Banking Compliance Team (Eidiko)

---

**Last Updated**: May 6, 2026
**Version**: 1.0.0

