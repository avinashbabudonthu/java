package global.exception.handling.controller;

import global.exception.handling.model.Student;
import global.exception.handling.util.ErrorsEnum;
import global.exception.handling.util.Utils;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;

@Slf4j
@RestController
@RequestMapping("/api/v1")
public class AppController {

    @Autowired
    private Utils utils;

    @SneakyThrows
    @GetMapping(value = "/students/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Student findStudentById(@PathVariable("id") Long id){
        if(id == 0L){
            throw utils.buildAppException(ErrorsEnum.BAD_REQUEST_EXCEPTION.getCode(), ErrorsEnum.BAD_REQUEST_EXCEPTION.getMessage(), id, "Pathvariable", "id").get();
        }

        return Student.builder().id(id).name("jill").joiningDate(new Date()).build();
    }

    @PostMapping(value = "/students", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Student saveStudent(@Valid @RequestBody Student student){
           log.info("student={}", student );
           student.setJoiningDate(new Date());
           return student;
    }
}
