package com.java.controller.impl;

import com.java.config.StudentConfiguration;
import com.java.controller.StudentController;
import com.java.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentControllerImpl implements StudentController {

    @Autowired
    private StudentConfiguration studentConfiguration;

    @Override
    public Student findStudent() {
        return Student.builder()
                .id(studentConfiguration.getId())
                .name(studentConfiguration.getName())
                .course(studentConfiguration.getCourse())
                .build();
    }
}