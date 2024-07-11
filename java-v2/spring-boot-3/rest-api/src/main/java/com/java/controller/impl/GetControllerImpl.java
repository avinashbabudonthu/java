package com.java.controller.impl;


import com.github.javafaker.Faker;
import com.java.controller.GetController;
import com.java.model.Student;
import com.java.service.StudentService;
import lombok.AllArgsConstructor;
import org.springdoc.core.converters.models.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
public class GetControllerImpl implements GetController {

    private StudentService studentService;

    private static final Faker FAKER = Faker.instance();

    @Override
    public String helloWorld() {
        return FAKER.book().title();
    }

    @Override
    public Student studentsV1() {
        return studentService.getStudent();
    }

    @Override
    public ResponseEntity<Student> studentsV2() {
        return ResponseEntity.ok(studentService.getStudent());
    }

    @Override
    public List<Student> studentsV3() {
        return studentService.getStudents();
    }

    @Override
    public Student studentsV4(String name, String book) {
        return studentService.buildStudent(name, book);
    }

    @Override
    public Student studentsV5(String name, String book) {
        return studentService.buildStudent(name, book);
    }

    @Override
    public Student studentsV6(String name, String book) {
        return studentService.buildStudent(name, book);
    }

    @Override
    public List<Student> studentsV7(Pageable pageable) {
        return studentService.getStudents(pageable);
    }

}
