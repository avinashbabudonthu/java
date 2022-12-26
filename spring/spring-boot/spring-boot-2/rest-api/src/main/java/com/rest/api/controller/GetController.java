package com.rest.api.controller;

import com.rest.api.model.Student;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(value = "/gets")
public class GetController {

    @GetMapping(value = "/return-string", produces = MediaType.TEXT_PLAIN_VALUE)
    public String returnString(){
        return "Hello Spring Boot 2";
    }

    @GetMapping(value = "/return-map-as-json", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, String> mapAsJson(){
        Map<String, String> map = new HashMap<>();
        map.put("name", "jack");
        map.put("course", "spring boot 2");

        return map;
    }

        @GetMapping(value = "/student-object-as-json", produces = MediaType.APPLICATION_JSON_VALUE)
    public Student studentObjectAsJson(){
        Student student = Student.builder().name("jim").course("spring boot 2").joiningDate(new Date()).build();
        return student;
    }

    @GetMapping(value = "/list-of-students-as-json", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Student> listOfStudentsAsJson(){
        Student student1 = Student.builder().name("jim").course("spring boot 2").joiningDate(new Date()).build();
        Student student2 = Student.builder().name("jill").course("spring boot 2").joiningDate(new Date()).build();
        Student student3 = Student.builder().name("john").course("spring boot 2").joiningDate(new Date()).build();

        List<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);
        students.add(student3);

        return students;
    }

    @GetMapping(value = "/with-mandatory-request-headers", produces = MediaType.APPLICATION_JSON_VALUE)
    public Student withMandatoryRequestHeaders(@RequestHeader("id")String id,
                                               @RequestHeader("name")String name,
                                               @RequestHeader("course")String course){
        return Student.builder().id(id).name(name).course(course).joiningDate(new Date()).build();
    }

    @GetMapping(value = "/with-optional-request-headers", produces = MediaType.APPLICATION_JSON_VALUE)
    public Student withOptionalRequestHeaders(@RequestHeader(value = "id", required = false)String id,
                                              @RequestHeader(value = "name", required = false)String name,
                                               @RequestHeader(value = "course", required = false)String course){
        return Student.builder().id(id).name(name).course(course).joiningDate(new Date()).build();
    }

    @GetMapping(value = "/with-optional-default-value-request-headers", produces = MediaType.APPLICATION_JSON_VALUE)
    public Student withOptionalDefaultValueRequestHeaders(@RequestHeader(value = "id", required = false, defaultValue = "000")String id,
                                                          @RequestHeader(value = "name", required = false, defaultValue = "no-name")String name,
                                              @RequestHeader(value = "course", required = false, defaultValue = "no course")String course){
        return Student.builder().id(id).name(name).course(course).joiningDate(new Date()).build();
    }

    @GetMapping(value = "/with-mandatory-request-params", produces = MediaType.APPLICATION_JSON_VALUE)
    public Student withMandatoryRequestParams(@RequestParam("id") String id, @RequestParam("name")String name,
                                               @RequestParam("course")String course){
        return Student.builder().id(id).name(name).course(course).joiningDate(new Date()).build();
    }

    @GetMapping(value = "/with-optional-request-params", produces = MediaType.APPLICATION_JSON_VALUE)
    public Student withOptionalRequestParams(@RequestParam(value = "id", required = false)String id, @RequestParam(value = "name", required = false)String name,
                                              @RequestParam(value = "course", required = false)String course){
        return Student.builder().id(id).name(name).course(course).joiningDate(new Date()).build();
    }

    @GetMapping(value = "/with-optional-default-value-request-params", produces = MediaType.APPLICATION_JSON_VALUE)
    public Student withOptionalDefaultValueRequestParams(@RequestParam(value = "id", required = false, defaultValue = "000")String id,
                                                          @RequestParam(value = "name", required = false, defaultValue = "no-name")String name,
                                                          @RequestParam(value = "course", required = false, defaultValue = "no course")String course){
        return Student.builder().id(id).name(name).course(course).joiningDate(new Date()).build();
    }

    @GetMapping(value = "/with-request-headers-as-list", produces = MediaType.APPLICATION_JSON_VALUE)
    public Student requestHeaderList(@RequestHeader("ids")List<String> idList,
                                     @RequestHeader(value = "name", required = false, defaultValue = "no-name")String name,
                                     @RequestHeader(value = "course", required = false, defaultValue = "no course")String course){
        idList.forEach(System.out::println);
        return Student.builder().idList(idList).name(name).course(course).joiningDate(new Date()).build();
    }

    @GetMapping(value = "/with-request-params-as-list", produces = MediaType.APPLICATION_JSON_VALUE)
    public Student requestParamList(@RequestParam("ids")List<String> idList,
                                     @RequestParam(value = "name", required = false, defaultValue = "no-name")String name,
                                     @RequestParam(value = "course", required = false, defaultValue = "no course")String course){
        return Student.builder().idList(idList).name(name).course(course).joiningDate(new Date()).build();
    }

    @GetMapping(value = "/with-path-variables/{id}/{name}/{course}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Student pathVariables(@PathVariable("id")String id,
                                    @PathVariable("name")String name,
                                    @PathVariable("course")String course){
        return Student.builder().id(id).name(name).course(course).joiningDate(new Date()).build();
    }

}
