package com.java.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.TEXT_PLAIN_VALUE;

@RestController
public class AppController {

    @GetMapping(value = "/api/v1/api1", produces = TEXT_PLAIN_VALUE)
    public String method1() {
        return "Hello World";
    }

}