package com.java.resolver;

import com.java.model.Student4;
import com.java.model.Subject;
import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Student4Resolver implements GraphQLResolver<Student4> {

    public List<Subject> subjects(Student4 student4, DataFetchingEnvironment dfe){
        Subject subject1 = Subject.builder()
                .id(1)
                .name("Java")
                .marks(4.99D)
                .build();
        Subject subject2 = Subject.builder()
                .id(1)
                .name("GraphQL")
                .marks(4.98D)
                .build();
        List<Subject> subjects = new ArrayList<>();
        subjects.add(subject1);
        subjects.add(subject2);

        return subjects;
    }

}