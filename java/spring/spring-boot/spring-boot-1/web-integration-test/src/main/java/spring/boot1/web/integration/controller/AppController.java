package spring.boot1.web.integration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.boot1.web.integration.model.Student;
import spring.boot1.web.integration.service.AppService;

import java.util.List;

@RestController
public class AppController {

    @Autowired
    private AppService appService;

    @GetMapping(value = "/students", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Student> findAllStudents(){
        return appService.findAllStudents();
    }
}
