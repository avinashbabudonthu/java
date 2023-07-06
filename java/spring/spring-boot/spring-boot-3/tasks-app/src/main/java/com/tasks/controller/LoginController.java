package com.tasks.controller;

import com.tasks.service.AuthenticationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Slf4j
@Controller
@SessionAttributes("name")
public class LoginController {

    @Autowired
    private AuthenticationService authenticationService;

    @GetMapping(value = "/login")
    public String login() {
        return "login";
    }

    @GetMapping(value = "/login2")
    public String login2(@RequestParam("name") String name, ModelMap modelMap) {
        log.info("name={}", name);
        modelMap.put("name", name);
        return "login2"; // view name
    }

    @GetMapping(value = "/login3")
    public String login3() {
        return "login3";
    }

    @PostMapping(value = "/login3")
    public String gotToWelcome(@RequestParam("name") String name, @RequestParam("password")String password, ModelMap modelMap) {
        log.info("name={}, password={}", name, password);
        boolean isValidCreds = authenticationService.authenticate(name, password);
        if(isValidCreds) {
            modelMap.put("name", name);
            return "welcome";
        }else {
            modelMap.put("errorMessage", "Invalid credentials, try again");
            return "login3";
        }
    }
}