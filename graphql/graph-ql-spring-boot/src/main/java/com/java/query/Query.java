package com.java.query;

import com.java.model.Student;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

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

}