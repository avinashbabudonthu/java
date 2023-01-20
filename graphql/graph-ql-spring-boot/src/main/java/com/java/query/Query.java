package com.java.query;

import com.java.model.*;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Query implements GraphQLQueryResolver {

    public String firstQuery(){
        return "Hello world";
    }

    public String fullName(String firstName, String lastName){
        return firstName + " " + lastName;
    }

    /**
     * Query with student object as request body
     *
     * @param student
     * @return
     */
    public String studentRequest(Student student){
        return student.getId() + " " + student.getFirstName() + " " + student.getLastName();
    }

    public String mandatoryField(Student2 student){
        return student.getId() + " " + student.getFirstName() + " " + student.getLastName();
    }

    public StudentResponse studentAsResponse(Long id, String firstName, String lastName){
        return StudentResponse.builder().id(Integer.parseInt(id.toString()))
                .firstName(firstName)
                .lastName(lastName)
                .build();
    }

    public Student3 responseWithList(Integer id){
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

        Student3 student3 = Student3.builder()
                .id(id)
                .firstName("jim")
                .lastName("john")
                .subjects(subjects)
                .build();

        return student3;
    }

    public Student4 student4SubjectsWithResolver(Integer id){
        return Student4.builder()
                .id(id)
                .firstName("jim")
                .lastName("john")
                .build();
    }

    public Student5 student5SubjectsWithResolvedAndFilter(Integer id){
        return Student5.builder()
                .id(id)
                .firstName("jim")
                .lastName("john")
                .build();
    }

}