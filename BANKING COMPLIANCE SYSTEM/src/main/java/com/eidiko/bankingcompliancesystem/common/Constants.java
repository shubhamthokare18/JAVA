package com.eidiko.bankingcompliancesystem.common;

/**
 * Application constants
 */
public class Constants {
    
    public static final String API_PREFIX = "/api";
    
    // API Endpoints
    public static final String AUTH_BASE_URL = "/auth";
    public static final String CUSTOMER_BASE_URL = "/customer";
    public static final String FRAUD_BASE_URL = "/fraud";
    
    // JWT
    public static final String AUTHORIZATION_HEADER = "Authorization";
    public static final String BEARER_PREFIX = "Bearer ";
    public static final long JWT_EXPIRATION = 3600000; // 1 hour
    public static final String JWT_SECRET = "mysecretmysecretmysecretmysecret";
    
    // Default Values
    public static final String DEFAULT_FRAUD_STATUS = "PENDING";
    public static final String DEFAULT_ADMIN_ROLE = "ADMIN";
    public static final String DEFAULT_USER_ROLE = "USER";
    
    // Error Messages
    public static final String INVALID_TOKEN = "Invalid or expired token";
    public static final String UNAUTHORIZED = "Unauthorized access";
    public static final String RESOURCE_NOT_FOUND = "Resource not found";
    public static final String VALIDATION_FAILED = "Validation failed";
    public static final String INTERNAL_SERVER_ERROR = "An internal server error occurred";
    
    // Success Messages
    public static final String LOGIN_SUCCESS = "Login successful";
    public static final String RESOURCE_CREATED = "Resource created successfully";
    public static final String RESOURCE_UPDATED = "Resource updated successfully";
    public static final String RESOURCE_DELETED = "Resource deleted successfully";
    
    private Constants() {
        // Private constructor to prevent instantiation
    }
}

