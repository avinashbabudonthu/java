package com.ab.example0006;

import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Query0006 implements GraphQLQueryResolver {

    public List<Student0006> findAllStudents() {
        Student0006 student1 = Student0006.builder().id(1L).name("Jim").build();
        Student0006 student2 = Student0006.builder().id(2L).name("Jill").build();

        List<Student0006> studentList = new ArrayList<>();
        studentList.add(student1);
        studentList.add(student2);

        return studentList;
    }

}