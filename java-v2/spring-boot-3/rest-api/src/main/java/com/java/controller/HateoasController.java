package com.java.controller;

import com.java.model.Student;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Tag(name = "Hateoas APIs")
@RequestMapping("/hateoas/api")
public interface HateoasController {

    @Operation(summary = "Get all students")
    @GetMapping(value = "/v1/students", produces = APPLICATION_JSON_VALUE)
    List<Student> findAllStudents();

    @Operation(summary = "Get student by id")
    @GetMapping(value = "/v1/students/{id}", produces = APPLICATION_JSON_VALUE)
    Student findStudentById(@PathVariable("id") String id);

    @Operation(summary = "Save new student")
    @PostMapping(value = "/v1/students", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    ResponseEntity<Student> saveStudent(@RequestBody Student student);

    @Operation(summary = "Save new student 2")
    @PostMapping(value = "/v2/students", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    EntityModel<Student> saveStudents2(@RequestBody Student student);
}
