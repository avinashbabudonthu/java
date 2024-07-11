package com.java.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import com.java.model.Student;
import com.java.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.converters.models.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
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
    public List<Student> getStudents(Pageable pageable) {
        log.info("page={}, size={}, sort={}", pageable.getPage(), pageable.getSize(), pageable.getSort());
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

    @Override
    public Student studentV1(String studentJsonAsText) throws JsonProcessingException {
        Student student = new ObjectMapper().readValue(studentJsonAsText, Student.class);
        student.setId(FAKER.idNumber().valid());
        return student;
    }

    @Override
    public Student studentV2(Student student) {
        student.setId(FAKER.idNumber().valid());
        return student;
    }

    @Override
    public Student studentV3(Student student, String name, String book) {
        student.setId(FAKER.idNumber().valid());
        student.setName(name);
        student.setBook(book);
        return student;
    }

    @Override
    public Student studentV4(Student student, String name, String book) {
        student.setId(FAKER.idNumber().valid());
        student.setName(name);
        student.setBook(book);
        return student;
    }

    @Override
    public Student studentV5(Student student, String name, String book) {
        student.setId(FAKER.idNumber().valid());
        student.setName(name);
        student.setBook(book);
        return student;
    }

    @Override
    public Student studentV6(Student student, String id, String name, String book) {
        student.setId(id);
        student.setName(name);
        student.setBook(book);
        return student;
    }

}