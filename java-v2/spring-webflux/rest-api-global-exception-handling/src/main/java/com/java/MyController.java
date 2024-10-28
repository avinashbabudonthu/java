package com.java;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.TEXT_PLAIN_VALUE;

@RestController
public class MyController {

    private record Student(int id, String name) {}

    @GetMapping(value = "/api1", produces = APPLICATION_JSON_VALUE)
    public Mono<Student> resourceNotFound(@RequestParam("id") Integer id) {
        if(id == 0) {
            return Mono.error(new ResourceNotFoundException("Resource not found"));
        }
        return Mono.just(new Student(id, "a"));
    }

    @GetMapping(value = "/api2", produces = APPLICATION_JSON_VALUE)
    public Mono<Student> badRequest(@RequestParam("id") Integer id) {
        if(id < 0) {
            return Mono.error(new BadRequestException("Bad request"));
        }
        return Mono.just(new Student(id, "a"));
    }

    @GetMapping(value = "/api3", produces = APPLICATION_JSON_VALUE)
    public Mono<Student> genericException(@RequestParam("id")Integer id) {
        if(id == null) {
            return Mono.error(new RuntimeException("Runtime exception"));
        }
        return Mono.just(new Student(id, "a"));
    }

}