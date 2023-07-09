package com.java.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class AppController {

    @GetMapping(value = "/api/v1/students", produces = APPLICATION_JSON_VALUE)
    public Record method1() {
        record Student(Integer id, String name, String course){};
        Student student = new Student(100, "Ram", "AI");
        return student;
    }

}