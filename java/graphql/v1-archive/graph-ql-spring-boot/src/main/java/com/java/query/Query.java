package com.java.query;

import com.java.model.*;
import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
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

    public Student5 student5SubjectsWithResolverAndFilter(Integer id){
        return Student5.builder()
                .id(id)
                .firstName("jim")
                .lastName("john")
                .build();
    }

    public List<Student6> dataLoadersProblem(DataFetchingEnvironment environment){
        Student6 student6_1 = Student6.builder()
                .id(1L)
                .name("jack")
                .course("java")
                .build();
        Student6 student6_2 = Student6.builder()
                .id(2L)
                .name("jill")
                .course("rest")
                .build();
        Student6 student6_3 = Student6.builder()
                .id(3L)
                .name("jim")
                .course("graphql")
                .build();
        Student6 student6_4 = Student6.builder()
                .id(4L)
                .name("john")
                .course("aws")
                .build();

        List<Student6> student6List = new ArrayList<>();
        student6List.add(student6_1);
        student6List.add(student6_2);
        student6List.add(student6_3);
        student6List.add(student6_4);

        return student6List;
    }

    public List<Student7> dataLoadersSolution(DataFetchingEnvironment environment){
        Student7 student1 = Student7.builder()
                .id(1L)
                .name("jack")
                .course("java")
                .build();
        Student7 student2 = Student7.builder()
                .id(2L)
                .name("jill")
                .course("rest")
                .build();
        Student7 student3 = Student7.builder()
                .id(3L)
                .name("jim")
                .course("graphql")
                .build();
        Student7 student4 = Student7.builder()
                .id(4L)
                .name("john")
                .course("aws")
                .build();

        List<Student7> list = new ArrayList<>();
        list.add(student1);
        list.add(student2);
        list.add(student3);
        list.add(student4);

        return list;
    }

}