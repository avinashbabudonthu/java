package com.java.query;

import com.java.model.StudentRequest1;
import com.java.model.StudentResponse;
import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.stereotype.Component;

@Component
public class Mutation implements GraphQLMutationResolver {

    public StudentResponse createStudent(StudentRequest1 studentRequest1, DataFetchingEnvironment dfe){
        System.out.println("Inside createStudent method");
        return StudentResponse
                .builder()
                .id(Integer.valueOf(studentRequest1.getId().toString()))
                .firstName(studentRequest1.getFirstName())
                .lastName(studentRequest1.getLastName())
                .build();
    }

}