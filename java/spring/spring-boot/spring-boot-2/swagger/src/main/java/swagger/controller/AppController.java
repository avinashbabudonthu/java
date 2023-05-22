package swagger.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import swagger.model.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
public class AppController {

    private static final List<Student> studentList = new ArrayList<>();

    static {
        studentList.add(Student.builder().id(UUID.randomUUID().toString()).name("jim").build());
    }

    @GetMapping(value = "/students", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Student> findAllStudents(){
        return studentList;
    }
}
