package com.tasks.service;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    public boolean authenticate(String username, String password) {
        boolean isValidUsername = "admin".equalsIgnoreCase(username);
        boolean isValidPassword = "dummy".equalsIgnoreCase(password);
        return isValidUsername && isValidPassword;
    }

}