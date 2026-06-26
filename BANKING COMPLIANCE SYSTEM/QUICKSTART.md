# Quick Start Guide

## 🚀 Get the Application Running in 5 Minutes

### Step 1: Prerequisites
Ensure you have:
- Java 21+ installed: `java -version`
- Maven 3.8+: `mvn -version`

### Step 2: Build the Project
```bash
cd banking-compliance-system
mvn clean install
```

### Step 3: Run the Application
```bash
mvn spring-boot:run
```

Or run the JAR directly:
```bash
java -jar target/banking-compliance-system-0.0.1-SNAPSHOT.jar
```

### Step 4: Verify It's Running
Open your browser and go to:
- **Swagger UI**: http://localhost:8082/swagger-ui.html
- **H2 Console**: http://localhost:8082/h2-console

## 🔑 Login & Test Endpoints

### 1. Get Authentication Token
```bash
curl -X POST http://localhost:8082/auth/login \
  -H "Content-Type: application/json" \
  -d '{
    "username": "admin",
    "password": "admin123"
  }'
```

**Response:**
```json
{
  "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...",
  "message": "Login successful"
}
```

### 2. Use the Token for Subsequent Requests
Replace `YOUR_TOKEN` with the token from login response.

## 📋 Common API Operations

### Create a Customer
```bash
curl -X POST http://localhost:8082/customer/create \
  -H "Content-Type: application/json" \
  -H "Authorization: Bearer YOUR_TOKEN" \
  -d '{
    "name": "John Doe",
    "country": "USA"
  }'
```

### Get All Customers
```bash
curl -X GET http://localhost:8082/customer/all \
  -H "Authorization: Bearer YOUR_TOKEN"
```

### Get Customer by ID
```bash
curl -X GET http://localhost:8082/customer/1 \
  -H "Authorization: Bearer YOUR_TOKEN"
```

### Update Customer
```bash
curl -X PUT http://localhost:8082/customer/1 \
  -H "Content-Type: application/json" \
  -H "Authorization: Bearer YOUR_TOKEN" \
  -d '{
    "name": "Jane Doe",
    "country": "UK"
  }'
```

### Delete Customer
```bash
curl -X DELETE http://localhost:8082/customer/1 \
  -H "Authorization: Bearer YOUR_TOKEN"
```

### Create Fraud Case
```bash
curl -X POST http://localhost:8082/fraud/create \
  -H "Content-Type: application/json" \
  -H "Authorization: Bearer YOUR_TOKEN" \
  -d '{
    "status": "PENDING",
    "description": "Suspicious transaction detected"
  }'
```

### Get All Fraud Cases
```bash
curl -X GET http://localhost:8082/fraud/all \
  -H "Authorization: Bearer YOUR_TOKEN"
```

## 🗄️ Database Access

### H2 Console
1. Go to: http://localhost:8082/h2-console
2. Connection settings:
   - **JDBC URL**: `jdbc:h2:mem:testdb`
   - **User Name**: `sa`
   - **Password**: (leave empty)
3. Click Connect

### View Tables
```sql
-- List all tables
SELECT TABLE_NAME FROM INFORMATION_SCHEMA.TABLES;

-- View users
SELECT * FROM USERS;

-- View customers
SELECT * FROM CUSTOMER;

-- View fraud cases
SELECT * FROM FRAUD_CASE;
```

## 📊 Swagger UI Tips

1. **Access Swagger**: http://localhost:8082/swagger-ui.html
2. **Authentication**:
   - Click "Try it out" on any endpoint
   - Perform login first
   - Copy the token from response
   - Click "Authorize" button (top right)
   - Paste: `Bearer YOUR_TOKEN`
   - Click "Authorize"
3. **Test Endpoints**: Now test other endpoints directly from Swagger

## 🔍 Logs

View application logs in console:
```
2026-05-06T16:07:36.395+05:30  INFO ... Started BankingComplianceSystemApplication
```

## 🛠️ Troubleshooting

### Port 8082 Already in Use
```bash
# Find process using port 8082
netstat -ano | findstr :8082

# Kill the process (Windows)
taskkill /PID <PID> /F
```

### Build Fails
```bash
# Clean cache
mvn clean

# Update dependencies
mvn dependency:resolve

# Rebuild
mvn install
```

### Database Issues
- H2 is in-memory, data resets on restart
- Check `application.yaml` for database settings
- Verify `ddl-auto: create-drop` in yaml

## 📚 Documentation

- **Full README**: See `README.md`
- **API Documentation**: See `API_DOCUMENTATION.md`
- **Changes Made**: See `CHANGELOG.md`
- **Fixes Applied**: See `FIXES_SUMMARY.md`

## 🎯 Next Steps

1. ✅ Run the application
2. ✅ Login with admin/admin123
3. ✅ Test API endpoints
4. ✅ View Swagger documentation
5. ✅ Check database via H2 console
6. ✅ Read comprehensive documentation

## 📞 Support

- Check Swagger UI for endpoint documentation
- Review logs for error details
- See `FAQ` section in README.md

---

**Happy Testing!** 🎉

