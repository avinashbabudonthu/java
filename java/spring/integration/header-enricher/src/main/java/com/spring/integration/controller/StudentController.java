package com.spring.integration.controller;

import com.spring.integration.config.gateway.IntegrationGateway;
import com.spring.integration.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class StudentController {

    @Autowired
    private IntegrationGateway integrationGateway;

    @PostMapping(value = "/api/v1/students", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public Student saveStudent(@RequestBody Student student){
        return integrationGateway.saveStudent(student);
    }

}