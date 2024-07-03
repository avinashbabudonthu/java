package com.java.controller;

import com.java.model.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.TEXT_PLAIN_VALUE;

@RequestMapping(value = "/api")
public interface GetController {

    /**
     * API to return Simple Text
     * @return {@link String}
     */
    @GetMapping(value = "/v1/hello-world", produces = TEXT_PLAIN_VALUE)
    String helloWorld();

    /**
     * Return student
     * @return {@link Student}
     */
    @GetMapping(value = "/v1/students", produces = APPLICATION_JSON_VALUE)
    Student studentsV1();

    /**
     * Return student
     * @return {@link ResponseEntity}&lt;{@link Student}&gt;
     */
    @GetMapping(value = "/v2/students", produces = APPLICATION_JSON_VALUE)
    ResponseEntity<Student> studentsV2();

    /**
     * Get all students
     * @return {@link List}&lt;{@link Student}&gt;
     */
    @GetMapping(value = "/v3/students", produces = APPLICATION_JSON_VALUE)
    List<Student> studentsV3();

    /**
     * Get student with name and book passed as request headers
     * @param name Student name header
     * @param book Book name header
     * @return {@link Student}
     */
    @GetMapping(value = "/v4/students", produces = APPLICATION_JSON_VALUE)
    Student studentsV4(@RequestHeader("name") String name, @RequestHeader("book") String book);

    /**
     * Get student with name and book passed as request headers
     * @param name Student name request parameter
     * @param book Book name request parameter
     * @return {@link Student}
     */
    @GetMapping(value = "/v5/students", produces = APPLICATION_JSON_VALUE)
    Student studentsV5(@RequestParam("name") String name, @RequestParam("book") String book);

    /**
     * Get student with name and book passed as request headers
     * @param name Student name path variable
     * @param book Book name path variable
     * @return {@link Student}
     */
    @GetMapping(value = "/v6/students/{name}/{book}", produces = APPLICATION_JSON_VALUE)
    Student studentsV6(@PathVariable("name") String name, @PathVariable("book") String book);

}