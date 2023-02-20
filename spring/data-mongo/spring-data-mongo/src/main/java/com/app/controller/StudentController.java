package com.app.controller;

import com.app.entity.Student;
import com.app.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.TEXT_PLAIN_VALUE;

@RestController
@RequestMapping(value = "/api/v1")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping(value = "/save-student", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public Student saveStudent(@RequestBody Student student){
        return studentService.saveStudent(student);
    }

    @GetMapping(value = "/student-by-id/{id}", produces = APPLICATION_JSON_VALUE)
    public Student findStudentById(@PathVariable("id") String id){
        return studentService.findStudentById(id);
    }

    @GetMapping(value = "/all-students", produces = APPLICATION_JSON_VALUE)
    public List<Student> findAllStudents(){
        return studentService.findAllStudents();
    }

    @DeleteMapping(value = "/delete-student-by-id/{id}", produces = TEXT_PLAIN_VALUE)
    public String deleteStudentById(@PathVariable("id")String id){
        return studentService.deleteStudentById(id);
    }

}