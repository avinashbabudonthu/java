package com.java.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.java.model.Student;
import org.springdoc.core.converters.models.Pageable;

import java.util.List;

public interface StudentService {
    List<Student> getStudents();

    List<Student> getStudents(Pageable pageable);

    Student getStudent();

    Student buildStudent(String name, String book);

    Student studentV1(String studentJsonAsText) throws JsonProcessingException;

    Student studentV2(Student student);

    Student studentV3(Student student, String name, String book);

    Student studentV4(Student student, String name, String book);

    Student studentV5(Student student, String name, String book);

    Student studentV6(Student student, String id, String name, String book);
}
