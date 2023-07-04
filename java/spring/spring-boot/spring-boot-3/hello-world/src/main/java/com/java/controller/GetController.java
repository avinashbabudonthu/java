package com.java.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class GetController {

    @GetMapping(value = "/students", produces = APPLICATION_JSON_VALUE)
    public List<Record> findStudents() {
        record Student(String name, long id, String course, double grade){}
        List<Record> studentList = new ArrayList<>();
        studentList.add(new Student("name1", 100L, "java", 4.0));
        studentList.add(new Student("name2", 101L, "spring", 3.9));
        studentList.add(new Student("name3", 102L, "spring boot", 4.1));
        return studentList;
    }
}