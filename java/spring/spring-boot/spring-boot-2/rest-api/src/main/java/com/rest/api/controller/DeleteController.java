package com.rest.api.controller;

import com.rest.api.model.Student;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/deletes")
public class DeleteController {

    @DeleteMapping(value = "/delete-1/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Student method1(@PathVariable("id")String id, @RequestHeader("name")String name,
                           @RequestParam("course")String course){
        return Student.builder().id(id).name(name).course(course).build();
    }

}