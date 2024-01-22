package com.ab.repository;

import com.ab.model.Student;
import com.ab.util.Util;
import org.springframework.stereotype.Repository;

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
        return student.getFirstName() + " " + student.getLastName();
    }

}