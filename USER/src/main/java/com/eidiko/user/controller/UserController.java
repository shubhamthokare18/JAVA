package com.eidiko.user.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/get/{id}")
    public String getUserById(@PathVariable Integer id) {

        return "USER: " + id;
    }

    @PostMapping("/create")
    public String createUser(@RequestBody String name) {

        return "USER CREATED: " + name;
    }
}
