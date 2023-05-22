package com.app.controller;

import com.app.entity.Student;
import com.app.model.PaginatedResponse;
import com.app.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @DeleteMapping(value = "/delete-all-students", produces = TEXT_PLAIN_VALUE)
    public String deleteAllStudents(){
        return studentService.deleteAllStudents();
    }

    @GetMapping(value = "/students-by-name/{name}", produces = APPLICATION_JSON_VALUE)
    public List<Student> findStudentsByName(@PathVariable("name") String name){
        return studentService.findStudentsByName(name);
    }

    @GetMapping(value = "/students-by-name-native-query/{name}", produces = APPLICATION_JSON_VALUE)
    public List<Student> findStudentsByNameByNativeQuery(@PathVariable("name") String name){
        return studentService.findStudentsByNameByNativeQuery(name);
    }

    @GetMapping(value = "/students-by-name-email", produces = APPLICATION_JSON_VALUE)
    public List<Student> findStudentsByNameAndEmail(@RequestParam("name") String name,@RequestParam("email") String email){
        return studentService.findStudentsByNameAndEmail(name, email);
    }

    @GetMapping(value = "/students-by-name-or-email", produces = APPLICATION_JSON_VALUE)
    public List<Student> findStudentsByNameOrEmail(@RequestParam("name") String name,@RequestParam("email") String email){
        return studentService.findStudentsByNameOrEmail(name, email);
    }

    @GetMapping(value = "/all-students-pagination", produces = APPLICATION_JSON_VALUE)
    public PaginatedResponse<Student> findStudentsByPagination(@RequestParam("pageNumber") Integer pageNumber,
                                                               @RequestParam("pageSize")Integer pageSize){
        return studentService.findStudentsByPagination(pageNumber, pageSize);
    }

    @GetMapping(value = "/all-students-with-sorting", produces = APPLICATION_JSON_VALUE)
    public List<Student> findAllStudentsWithSorting(@RequestParam("sortProperty") String sortProperty, @RequestParam("sortOrder") String sortOrder){
        return studentService.findAllStudentsWithSorting(sortProperty, sortOrder);
    }

    @GetMapping(value = "/all-students-by-department-name", produces = APPLICATION_JSON_VALUE)
    public List<Student> findStudentsByDepartmentName(@RequestParam("departmentName") String departmentName){
        return studentService.findStudentsByDepartmentName(departmentName);
    }

    @GetMapping(value = "/all-students-by-email-like", produces = APPLICATION_JSON_VALUE)
    public List<Student> findStudentsByEmailLike(@RequestParam("email") String email){
        return studentService.findStudentsByEmailLike(email);
    }

    @GetMapping(value = "/all-students-name-starting-with", produces = APPLICATION_JSON_VALUE)
    public List<Student> findStudentsByNameStartsWith(@RequestParam("name")String name){
        return studentService.findStudentsByNameStartsWith(name);
    }

}