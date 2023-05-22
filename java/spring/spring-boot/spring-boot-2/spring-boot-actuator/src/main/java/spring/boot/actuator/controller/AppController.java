package spring.boot.actuator.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

    @GetMapping(value = "/hello", produces = MediaType.TEXT_PLAIN_VALUE)
    public String hello(){
        return "Hello Spring boot 2 actuator";
    }
}
