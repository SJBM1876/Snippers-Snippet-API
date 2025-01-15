package com.snippr.snippets_api.controller;

import com.snippr.snippets_api.model.User;
import com.snippr.snippets_api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public User registerUser(@RequestBody User user) {
        return userService.registerUser(user.getEmail(), user.getPasswordHash());
    }

    @GetMapping
    public User authenticateUser(@RequestParam String email, @RequestParam String password) {
        return userService.authenticateUser(email, password);
    }
}
