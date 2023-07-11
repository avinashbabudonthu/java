package com.java.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Slf4j
@RestController
public class AppController {

    @GetMapping(value = "/api/v1/username", produces = APPLICATION_JSON_VALUE)
    public Record loggedInUsername() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        log.info("username={}", username); // username=admin
        Object credentials = authentication.getCredentials();
        log.info("credentials={}", credentials); // credentials=null
        User principal = (User) authentication.getPrincipal();

        // principal=org.springframework.security.core.userdetails.User [Username=admin, Password=[PROTECTED], Enabled=true,
        // AccountNonExpired=true, credentialsNonExpired=true, AccountNonLocked=true, Granted Authorities=[ROLE_ADMIN, ROLE_USER]]
        log.info("principal={}", principal);

        record UserModel(String username){};

        return new UserModel(username);
    }

}