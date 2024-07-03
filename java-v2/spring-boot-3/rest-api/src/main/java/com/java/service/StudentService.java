package com.java.service;

import com.java.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> getStudents();

    Student getStudent();

    Student buildStudent(String name, String book);
}
