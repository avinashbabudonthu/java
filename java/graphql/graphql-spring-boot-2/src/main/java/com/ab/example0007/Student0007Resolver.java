package com.ab.example0007;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class Student0007Resolver implements GraphQLResolver<Student0007> {

    @Autowired
    private Service0007 service;

    public List<Subject0007> subjects(Student0007 student0007, String subjectName, DataFetchingEnvironment dataFetchingEnvironment) {
        Long studentId = student0007.getId();
        List<Subject0007> subjects = service.findSubjectByStudentId(studentId);
        if(!"All".equalsIgnoreCase(subjectName)) {
            subjects = subjects.stream().filter(subject0007 -> subject0007.getName().equalsIgnoreCase(subjectName)).collect(Collectors.toList());
        }
        return subjects;
    }

}