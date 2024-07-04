package com.java.controller.impl;

import com.java.controller.PostController;
import com.java.model.Student;
import com.java.service.StudentService;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class PostControllerImpl implements PostController {

    private StudentService studentService;

    @SneakyThrows
    @Override
    public Student studentV1(String studentJsonAsText) {
        return studentService.studentV1(studentJsonAsText);
    }

    @Override
    public Student studentV2(Student student) {
        return studentService.studentV2(student);
    }

    @Override
    public Student studentV3(Student student, String name, String book) {
        return studentService.buildStudent(name, book);
    }

    @Override
    public Student studentV4(Student student, String name, String book) {
        return studentService.studentV4(student, name, book);
    }

    @Override
    public Student studentV5(Student student, String name, String book) {
        return studentService.studentV5(student, name, book);
    }

    @Override
    public Student studentV6(Student student, String id, String name, String book) {
        return studentService.studentV6(student, id, name, book);
    }

}