package com.docker.image.dockerfile.controller;

import com.docker.image.dockerfile.model.Student;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/docker")
public class AppController {

    @GetMapping(value = "/students", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Student> getStudent(){
        List<Student> studentsList = new ArrayList<>();
        studentsList.add(Student.builder().name("john").grade(3.0).joiningDate(new Date()).build());
        studentsList.add(Student.builder().name("jill").grade(3.1).joiningDate(new Date()).build());
        studentsList.add(Student.builder().name("jim").grade(3.2).joiningDate(new Date()).build());
        studentsList.add(Student.builder().name("jack").grade(3.3).joiningDate(new Date()).build());

        return studentsList;
    }
}
