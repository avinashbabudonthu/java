package com.rest.api.controller;

import com.rest.api.model.Student;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping(value = "/gets")
public class GetController {

    @GetMapping(value = "/return-string", produces = MediaType.TEXT_PLAIN_VALUE)
    public String returnString(){
        return "Hello Spring Boot 2";
    }

    @GetMapping(value = "/return-map-as-json", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, String> mapAsJson(){
        Map<String, String> map = new HashMap<>();
        map.put("name", "jack");
        map.put("course", "spring boot 2");

        return map;
    }

        @GetMapping(value = "/student-object-as-json", produces = MediaType.APPLICATION_JSON_VALUE)
    public Student studentObjectAsJson(){
        Student student = Student.builder().name("jim").cource("spring boot 2").joiningDate(new Date()).build();
        return student;
    }

    @GetMapping(value = "/list-of-students-as-json", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Student> listOfStudentsAsJson(){
        Student student1 = Student.builder().name("jim").cource("spring boot 2").joiningDate(new Date()).build();
        Student student2 = Student.builder().name("jill").cource("spring boot 2").joiningDate(new Date()).build();
        Student student3 = Student.builder().name("john").cource("spring boot 2").joiningDate(new Date()).build();

        List<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);
        students.add(student3);

        return students;
    }
}
