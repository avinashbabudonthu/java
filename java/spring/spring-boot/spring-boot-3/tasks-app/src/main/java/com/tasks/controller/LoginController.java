package com.tasks.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Controller
public class LoginController {

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

}