package com.java.service.impl;

import com.github.javafaker.Faker;
import com.java.model.Student;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class HateoasService {

    private static final List<Student> students = new ArrayList<>();
    private static final Faker FAKER = Faker.instance();

    static {
        students.add(Student.builder().id("1").name(FAKER.name().fullName()).book(FAKER.harryPotter().book()).build());
        students.add(Student.builder().id("2").name(FAKER.name().fullName()).book(FAKER.harryPotter().book()).build());
        students.add(Student.builder().id("3").name(FAKER.name().fullName()).book(FAKER.harryPotter().book()).build());
    }

    public List<Student> findAllStudents(){
        return students;
    }

    public Student findStudentById(String id) {
        return students.stream().filter(student -> StringUtils.equalsAnyIgnoreCase(student.getId(), id)).findFirst().get();
    }

    public Student saveStudent(Student student) {
        Student savedStudent = Student.builder().id(UUID.randomUUID().toString()).name(student.getName()).book(student.getBook()).build();
        students.add(savedStudent);
        return savedStudent;
    }

}