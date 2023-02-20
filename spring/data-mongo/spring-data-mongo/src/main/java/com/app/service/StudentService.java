package com.app.service;

import com.app.entity.Student;
import com.app.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student saveStudent(Student student){
        return studentRepository.save(student);
    }

    public Student findStudentById(String id){
        return studentRepository.findById(id).get();
    }

    public List<Student> findAllStudents(){
        return studentRepository.findAll();
    }

    public String deleteStudentById(String id){
        studentRepository.deleteById(id);
        return "student deleted";
    }
}