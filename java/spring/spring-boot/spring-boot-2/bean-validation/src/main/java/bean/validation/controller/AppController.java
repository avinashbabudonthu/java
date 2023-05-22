package bean.validation.controller;

import bean.validation.model.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@RestController
public class AppController {

    @PostMapping(value = "/students", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Student saveStudent(@Valid @RequestBody Student student){
        log.info("student={}", student);

        return student;
    }
}
