package com.spring.integration.controller;

import com.spring.integration.service.IntegrationGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

    @Autowired
    private IntegrationGateway integrationGateway;

    @GetMapping(value = "/api/v1/greet/{name}", produces = MediaType.TEXT_PLAIN_VALUE)
    public String sendMessage(@PathVariable("name")String name){
        return integrationGateway.sendMessage(name);
    }

}