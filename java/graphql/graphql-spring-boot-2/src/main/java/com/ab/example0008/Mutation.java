package com.ab.example0008;

import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.stereotype.Component;

@Component
public class Mutation implements GraphQLMutationResolver {

    public StudentResponse0008 createStudent(Student0008 student) {
        System.out.println("Creating student record");
        return StudentResponse0008.builder().id(student.getId()).name(student.getName()).build();
    }

}