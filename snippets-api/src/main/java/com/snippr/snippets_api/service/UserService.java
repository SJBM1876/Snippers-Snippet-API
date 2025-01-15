package com.snippr.snippets_api.service;

import com.snippr.snippets_api.model.User;
import com.snippr.snippets_api.util.PasswordUtil;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {
    private final Map<String, User> users = new HashMap<>();

    public User registerUser(String email, String password) {
        if (users.containsKey(email)) {
            throw new IllegalArgumentException("Email already exists");
        }
        String hashedPassword = PasswordUtil.hashPassword(password);
        User user = new User(email, hashedPassword);
        users.put(email, user);
        return user;
    }

    public User authenticateUser(String email, String password) {
        User user = users.get(email);
        if (user != null && PasswordUtil.verifyPassword(password, user.getPasswordHash())) {
            return user;
        }
        throw new IllegalArgumentException("Invalid email or password");
    }
}
