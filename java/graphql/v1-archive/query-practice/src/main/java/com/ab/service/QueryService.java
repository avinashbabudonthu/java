package com.ab.service;

import com.ab.model.Student;
import com.ab.model.StudentResponse;
import com.ab.model.SubjectResponse;
import com.ab.repository.QueryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QueryService {

    @Autowired
    private QueryRepository queryRepository;

    public String findName() {
        return queryRepository.findName();
    }

    public String fullName(String firstName, String lastName) {
        return queryRepository.fullName(firstName, lastName);
    }

    public List<String> findAllNames() {
        List<String> names = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            names.add(queryRepository.findName());
        }

        return names;
    }

    public String fullName(Student student) {
        return queryRepository.fullName(student);
    }

    public StudentResponse findStudentResponse() {
        return queryRepository.findStudentResponse();
    }

    public List<StudentResponse> findAllStudents() {
        return queryRepository.findAllStudents();
    }

    public List<StudentResponse> findStudentById() {
        return queryRepository.findAllStudentsV2();
    }

    public List<SubjectResponse> findSubjects() {
        return queryRepository.findSubjects();
    }

}