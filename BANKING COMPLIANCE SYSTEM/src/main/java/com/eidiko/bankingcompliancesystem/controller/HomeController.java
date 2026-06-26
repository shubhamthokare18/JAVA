package com.eidiko.bankingcompliancesystem.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class HomeController {

    @GetMapping("/")
    public Map<String, Object> home() {
        return Map.of(
                "status", "UP",
                "message", "Banking Compliance System is running",
                "swagger", "http://localhost:8082/swagger-ui/index.html",
                "apiDocs", "http://localhost:8082/v3/api-docs",
                "h2Console", "http://localhost:8082/h2-console"
        );
    }

    @GetMapping("/favicon.ico")
    public void favicon() {
        // avoid favicon 500 error
    }
}
