package com.java.controller;

import com.java.config.MailConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class AppController {

    @Autowired
    private MailConfig mailConfig;

    @GetMapping(value = "/api/v1/properties", produces = APPLICATION_JSON_VALUE)
    public Map<String, Object> getProperties(){
        Map<String, Object> map = new HashMap<>();
        map.put("emailId", mailConfig.getEmailId());
        map.put("username", mailConfig.getUserName());
        map.put("password", mailConfig.getPassWord());
        map.put("smtpHost", mailConfig.getSmtpHost());
        map.put("port", mailConfig.getPort());
        map.put("smtpUrl", mailConfig.getSmtpUrl());
        return map;
    }

}