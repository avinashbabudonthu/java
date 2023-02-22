package com.app.service;

import com.app.entity.Student;
import com.app.model.PaginatedResponse;
import com.app.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student findStudentById(String id) {
        return studentRepository.findById(id).get();
    }

    public List<Student> findAllStudents() {
        return studentRepository.findAll();
    }

    public String deleteStudentById(String id) {
        studentRepository.deleteById(id);
        return "student deleted";
    }

    public List<Student> findStudentsByName(String name) {
        return studentRepository.findByName(name);
    }

    public List<Student> findStudentsByNameAndEmail(String name, String email) {
        return studentRepository.findByNameAndEmail(name, email);
    }

    public List<Student> findStudentsByNameOrEmail(String name, String email) {
        return studentRepository.findByNameOrEmail(name, email);
    }

    public String deleteAllStudents() {
        studentRepository.deleteAll();
        return "all students deleted";
    }

    /**
     * @param pageNumber - starts with 0
     * @param pageSize   - number of records
     */
    public PaginatedResponse<Student> findStudentsByPagination(Integer pageNumber, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        Page<Student> studentPage = studentRepository.findAll(pageable);
        Long totalElements = studentPage.getTotalElements();
        Integer resultSize = studentPage.getNumberOfElements();

        List<Student> studentList = studentPage.getContent();
        PaginatedResponse<Student> paginatedResponse = PaginatedResponse.<Student>builder()
                .pageNumber(pageNumber)
                .pageSize(pageSize)
                .list(studentList)
                .totalSize(totalElements)
                .resultSize(resultSize)
                .build();

        return paginatedResponse;
    }

    /**
     * @param sortProperty
     * @param sortOrder    - applicable values ASC, DESC
     * @return
     */
    public List<Student> findAllStudentsWithSorting(String sortProperty, String sortOrder) {
        Sort sort = Sort.by(Sort.Direction.fromString(sortOrder), sortProperty);
        // like below we can pass multiple properties for sorting
//        Sort sort = Sort.by(Sort.Direction.fromString(sortOrder), sortProperty, "anotherProperty");
        return studentRepository.findAll(sort);
    }

    public List<Student> findStudentsByDepartmentName(String departmentName){
        return studentRepository.findByDepartmentName(departmentName);
    }

    public List<Student> findStudentsByEmailLike(String email){
        return studentRepository.findByEmailLike(email);
    }

    public List<Student> findStudentsByNameStartsWith(String name){
        return studentRepository.findByNameStartsWith(name);
    }

}