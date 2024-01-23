package com.ab.repository;

import com.ab.model.Student;
import com.ab.model.StudentResponse;
import com.ab.util.Util;
import com.github.javafaker.Address;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class QueryRepository {

    public String findName() {
        return Util.FAKER.name().fullName();
    }

    public String fullName(String firstName, String lastName) {
        return firstName + " " + lastName;
    }

    public String fullName(Student student) {
        return student.getId() + " " + student.getFirstName() + " " + student.getLastName();
    }

    public StudentResponse findStudentResponse() {
        Address address = Util.FAKER.address();
        return StudentResponse.builder()
                .id(Util.FAKER.number().randomNumber())
                .firstName(address.firstName())
                .lastName(address.lastName())
                .email(address.firstName() + "@graphql.com")
                .street(address.streetAddress())
                .city(address.city())
                .build();
    }

    public List<StudentResponse> findAllStudents() {
        List<StudentResponse> studentResponseList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Address address = Util.FAKER.address();
            studentResponseList.add(
                    StudentResponse.builder()
                            .id(Util.FAKER.number().randomNumber())
                            .firstName(address.firstName())
                            .lastName(address.lastName())
                            .email(address.firstName() + "@graphql.com")
                            .street(address.streetAddress())
                            .city(address.city())
                            .build()
            );
        }
        return studentResponseList;
    }

}