package com.spring.integration.controller;

import com.spring.integration.model.Student;
import com.spring.integration.service.IntegrationGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @Autowired
    private IntegrationGateway integrationGateway;

    @PostMapping(value = "/api/v1/student", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.TEXT_PLAIN_VALUE)
    public String processStudent(@RequestBody Student student){
        return integrationGateway.processStudent(student);
    }

}