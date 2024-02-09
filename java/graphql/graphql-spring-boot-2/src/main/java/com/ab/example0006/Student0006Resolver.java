package com.ab.example0006;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Student0006Resolver implements GraphQLResolver<Student0006> {

    @Autowired
    private Service0006 service;

    public List<Subject0006> subjects(Student0006 student0006, DataFetchingEnvironment dataFetchingEnvironment) {
        Long studentId = student0006.getId();
        return service.findSubjectByStudentId(studentId);
    }

}