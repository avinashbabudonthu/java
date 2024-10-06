package com.java.controller.impl;


import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.github.javafaker.Faker;
import com.java.controller.GetController;
import com.java.model.Student;
import com.java.model.User;
import com.java.service.StudentService;
import com.java.service.UserService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.converters.models.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class GetControllerImpl implements GetController {

    private final StudentService studentService;
    private final UserService userService;

    private static final Faker FAKER = Faker.instance();

    @Override
    public String helloWorld() {
        return FAKER.harryPotter().character();
    }

    @Override
    public Student studentsV1() {
        return studentService.getStudent();
    }

    @Override
    public ResponseEntity<Student> studentsV2() {
        return ResponseEntity.ok(studentService.getStudent());
    }

    @Override
    public List<Student> studentsV3() {
        return studentService.getStudents();
    }

    @Override
    public Student studentsV4(String name, String book) {
        return studentService.buildStudent(name, book);
    }

    @Override
    public Student studentsV5(String name, String book) {
        return studentService.buildStudent(name, book);
    }

    @Override
    public Student studentsV6(String name, String book) {
        return studentService.buildStudent(name, book);
    }

    @Override
    public List<Student> studentsV7(Pageable pageable) {
        return studentService.getStudents(pageable);
    }

    @Override
    public MappingJacksonValue users1() {
        final String jsonFilterName = "StudentPropertyFilter";

        List<User> users = userService.findAllUsers();
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(users);
        SimpleBeanPropertyFilter simpleBeanPropertyFilter = SimpleBeanPropertyFilter.filterOutAllExcept("username", "firstName", "lastName");
        FilterProvider filterProvider = new SimpleFilterProvider().addFilter(jsonFilterName, simpleBeanPropertyFilter);
        mappingJacksonValue.setFilters(filterProvider);

        return mappingJacksonValue;
    }

}
