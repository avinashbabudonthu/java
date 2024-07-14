package com.spring.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.TEXT_PLAIN_VALUE;

@RestController
public class AccountController {

    @GetMapping(value = "/my-account", produces = TEXT_PLAIN_VALUE)
    public String getContacts() {
        return "My Account";
    }
}