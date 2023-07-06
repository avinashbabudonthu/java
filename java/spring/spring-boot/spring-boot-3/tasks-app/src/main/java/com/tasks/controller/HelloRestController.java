package com.tasks.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.TEXT_PLAIN_VALUE;

@RestController
public class HelloRestController {

    @GetMapping(value = "/hello", produces = TEXT_PLAIN_VALUE)
    public String hello() {
        return "Hello World";
    }

}