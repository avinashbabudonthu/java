package com.ab.component;

import com.ab.model.Student;
import com.ab.model.StudentResponse;
import com.ab.service.QueryService;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Query implements GraphQLQueryResolver {

    @Autowired
    private QueryService queryService;

    public String findName() {
        return queryService.findName();
    }

    public String fullName(String firstName, String lastName) {
        return queryService.fullName(firstName, lastName);
    }

    public List<String> findAllNames() {
        return queryService.findAllNames();
    }

    public String fullName2(Student student) {
        return queryService.fullName(student);
    }

    public StudentResponse student() {
        return queryService.findStudentResponse();
    }

    public List<StudentResponse> allStudents() {
        return queryService.findAllStudents();
    }

}