package com.java.service.impl;

import com.github.javafaker.Faker;
import com.java.model.Student;
import com.java.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private static final Faker FAKER = Faker.instance();

    private Student buildStudent() {
        return Student.builder()
                .id(FAKER.idNumber().valid())
                .name(FAKER.name().fullName())
                .book(FAKER.harryPotter().book())
                .build();
    }

    private List<Student> buildStudents() {
        return List.of(
                Student.builder().id(FAKER.idNumber().valid()).name(FAKER.name().fullName()).book(FAKER.harryPotter().book()).build(),
                Student.builder().id(FAKER.idNumber().valid()).name(FAKER.name().fullName()).book(FAKER.harryPotter().book()).build(),
                Student.builder().id(FAKER.idNumber().valid()).name(FAKER.name().fullName()).book(FAKER.harryPotter().book()).build(),
                Student.builder().id(FAKER.idNumber().valid()).name(FAKER.name().fullName()).book(FAKER.harryPotter().book()).build(),
                Student.builder().id(FAKER.idNumber().valid()).name(FAKER.name().fullName()).book(FAKER.harryPotter().book()).build()
        );
    }

    @Override
    public List<Student> getStudents() {
        return buildStudents();
    }

    @Override
    public Student getStudent() {
        return buildStudent();
    }

    @Override
    public Student buildStudent(String name, String book) {
        return Student.builder().id(FAKER.idNumber().valid()).name(name).book(book).build();
    }

}