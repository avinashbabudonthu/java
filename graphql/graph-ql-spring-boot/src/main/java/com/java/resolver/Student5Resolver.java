package com.java.resolver;

import com.java.model.Student5;
import com.java.model.Subject;
import com.java.util.SubjectEnum;
import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Student5Resolver implements GraphQLResolver<Student5> {

    public List<Subject> subjects(Student5 student5, SubjectEnum subjectEnum, DataFetchingEnvironment dfe){
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

        System.out.println("filter subject-name="+subjectEnum.name());

        if(subjectEnum.name().equals(subject1.getName())){
            subjects.add(subject1);
        }

        if(subjectEnum.name().equals(subject2.getName())){
            subjects.add(subject2);
        }


        return subjects;
    }

}