package com.spring.security.controller;


import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.TEXT_PLAIN_VALUE;

@RestController
public class HelloWorldController {

    @GetMapping(value = "/status", produces = TEXT_PLAIN_VALUE)
    public String helloWorld() {
        return "Hello World";
    }

}