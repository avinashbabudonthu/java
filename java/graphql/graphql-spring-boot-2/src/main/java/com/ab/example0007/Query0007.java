package com.ab.example0007;

import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Query0007 implements GraphQLQueryResolver {

    public List<Student0007> findAllStudents2() {
        Student0007 student1 = Student0007.builder().id(1L).name("Jim").build();
        Student0007 student2 = Student0007.builder().id(2L).name("Jill").build();

        List<Student0007> studentList = new ArrayList<>();
        studentList.add(student1);
        studentList.add(student2);

        return studentList;
    }

}