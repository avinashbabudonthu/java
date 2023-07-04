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
        studentList.add(new Student("name1", 101L, "java", 4.0));
        studentList.add(new Student("name2", 102L, "spring", 3.9));
        studentList.add(new Student("name3", 103L, "spring boot", 4.1));
        studentList.add(new Student("name4", 104L, "kafka", 3.8));
        return studentList;
    }
}