package spring.boot2.lombok.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.boot2.lombok.model.Student;

import java.util.Date;

@RestController
public class AppController {

    @GetMapping(value = "/students", produces = MediaType.APPLICATION_JSON_VALUE)
    public Student getStudent(){
        return Student.builder().name("jim").joiningDate(new Date())
                .grade(3.56).build();
    }
}
