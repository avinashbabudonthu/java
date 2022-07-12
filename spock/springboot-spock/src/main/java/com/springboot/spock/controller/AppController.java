package com.springboot.spock.controller;

import com.springboot.spock.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AppController {

    @Autowired
    private AppService appService;

    @GetMapping(value = "/numbers", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Integer> findNumbers(){
        return appService.findNumbers();
    }
}
