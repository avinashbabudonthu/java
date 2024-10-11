package com.java.controller;

import com.java.model.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RequestMapping(value = "/v1/apis")
public interface StudentController {

    @GetMapping(value = "/students", produces = APPLICATION_JSON_VALUE)
    Student findStudent();

}
