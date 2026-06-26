# Documentation Index

## Welcome to Banking Compliance System

This is a comprehensive guide to all available documentation for the Banking Compliance System application.

## 📖 Documentation Files

### 🚀 Getting Started
- **[QUICKSTART.md](QUICKSTART.md)** - Start here! 5-minute quick start guide
  - Includes curl examples for testing
  - H2 database access instructions
  - Swagger UI setup

- **[README.md](README.md)** - Complete project documentation
  - Features overview
  - Installation & setup
  - Project structure
  - Technologies used
  - Troubleshooting guide

### 📚 API Documentation
- **[API_DOCUMENTATION.md](API_DOCUMENTATION.md)** - API endpoints reference
  - Authentication endpoints
  - Customer management endpoints
  - Fraud detection endpoints
  - Configuration details

### 🔧 Development Documentation
- **[FIXES_SUMMARY.md](FIXES_SUMMARY.md)** - All improvements and fixes made
  - 10 major fixes applied
  - 11 new files created
  - 11 files modified
  - Quality improvements

- **[CHANGELOG.md](CHANGELOG.md)** - Version history and changes
  - Version 1.0.0 features
  - Technology stack
  - Future enhancements

## 🎯 Quick Links

### For Users
1. Start with [QUICKSTART.md](QUICKSTART.md) to get running
2. Test endpoints using curl examples
3. Access Swagger UI at http://localhost:8082/swagger-ui.html

### For Developers
1. Read [README.md](README.md) for project structure
2. Check [API_DOCUMENTATION.md](API_DOCUMENTATION.md) for all endpoints
3. Review [FIXES_SUMMARY.md](FIXES_SUMMARY.md) to understand improvements
4. Read [CHANGELOG.md](CHANGELOG.md) for version history

### For DevOps/Deployment
1. See [README.md](README.md) - Deployment section
2. Check application settings in `application.yaml`
3. Review security configuration in `SecurityConfig.java`

## 🏗️ Project Structure

```
banking-compliance-system/
├── Documentation Files (*.md)
├── pom.xml                          # Maven configuration
├── src/
│   ├── main/
│   │   ├── java/com/eidiko/bankingcompliancesystem/
│   │   │   ├── BankingComplianceSystemApplication.java
│   │   │   ├── common/              # Constants and utilities
│   │   │   ├── config/              # Spring configurations
│   │   │   ├── controller/          # REST controllers
│   │   │   ├── dto/                 # Data Transfer Objects
│   │   │   ├── entity/              # JPA entities
│   │   │   ├── exception/           # Exception handling
│   │   │   ├── feign/               # Feign clients
│   │   │   ├── repository/          # Data repositories
│   │   │   ├── security/            # Security utilities
│   │   │   ├── service/             # Business logic
│   │   │   └── workflow/            # Temporal workflows
│   │   └── resources/
│   │       └── application.yaml     # Application configuration
│   └── test/
│       └── java/                    # Test classes
└── target/                          # Build output

```

## 📋 Core Components

### Controllers (REST Endpoints)
- **AuthController** - Login and authentication
- **CustomerController** - Customer CRUD operations
- **FraudController** - Fraud case management

### Services (Business Logic)
- **AuthService** - Authentication logic
- **CustomerService** - Customer operations
- **FraudService** - Fraud case processing

### Repositories (Data Access)
- **UserRepository** - User database access
- **CustomerRepository** - Customer database access
- **FraudRepository** - Fraud case database access

### Configuration
- **SecurityConfig** - Spring Security setup
- **PasswordEncoderConfig** - Password encryption
- **DataInitializationConfig** - Test data loader
- **OpenApiConfig** - Swagger documentation

## 🔑 Key Features

✅ JWT Authentication
✅ Customer Management
✅ Fraud Detection System
✅ RESTful API
✅ Swagger/OpenAPI Documentation
✅ Exception Handling
✅ Database Management
✅ Spring Security

## 🌐 Running the Application

```bash
# Build
mvn clean install

# Run
mvn spring-boot:run

# Access
- API: http://localhost:8082
- Swagger: http://localhost:8082/swagger-ui.html
- Database: http://localhost:8082/h2-console
```

## 🔐 Default Credentials

```
Username: admin
Password: admin123
```

## 📊 Technology Stack

- **Framework**: Spring Boot 3.4.5
- **Security**: Spring Security 6.4.5
- **Authentication**: JWT (JJWT)
- **Database**: H2 (in-memory)
- **ORM**: Hibernate 6.6.13
- **Build**: Maven
- **Documentation**: SpringDoc OpenAPI 2.5.0

## ✨ Latest Updates

**Version 1.0.0** - May 6, 2026
- 10 major issues fixed
- 11 new files created
- 11 files enhanced
- 2,000+ lines of code added
- Comprehensive documentation

## 🆘 Getting Help

1. **Quick Issues**: Check [QUICKSTART.md](QUICKSTART.md)
2. **API Questions**: Read [API_DOCUMENTATION.md](API_DOCUMENTATION.md)
3. **Technical Details**: See [FIXES_SUMMARY.md](FIXES_SUMMARY.md)
4. **Features**: Review [CHANGELOG.md](CHANGELOG.md)
5. **Project Info**: Read [README.md](README.md)

## 📞 Support

- Check Swagger UI for endpoint documentation
- Review logs for error details
- Refer to README troubleshooting section
- Check H2 console for data verification

## 🎓 Learning Resources

- Spring Boot: https://spring.io/projects/spring-boot
- Spring Security: https://spring.io/projects/spring-security
- JWT Guide: https://jwt.io/
- OpenAPI Spec: https://spec.openapis.org/

---

**Last Updated**: May 6, 2026
**Version**: 1.0.0
**Status**: ✅ Ready to Use

