package docker.maven.plugin.controller;

import docker.maven.plugin.model.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class AppController {

    @GetMapping("/students")
    public List<Student> findAllStudents(){
        Student student1 = Student.builder().id(1L).name("jill").course("java").build();
        Student student2 = Student.builder().id(1L).name("jill").course("spring").build();
        Student student3 = Student.builder().id(1L).name("jill").course("spring boot").build();
        Student student4 = Student.builder().id(1L).name("jill").course("maven").build();

        return Arrays.asList(student1, student2, student3, student4);
    }
}
