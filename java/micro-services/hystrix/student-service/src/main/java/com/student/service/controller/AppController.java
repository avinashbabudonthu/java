package com.student.service.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.Arrays;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.student.service.model.Student;
import com.student.service.model.StudentList;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class AppController {

	@GetMapping(value = "/students", produces = APPLICATION_JSON_VALUE)
	@HystrixCommand(fallbackMethod = "fallbackFindAllStudents")
	public StudentList findAllStudents() {
		log.info("findAllStudents  method");
		throw new RuntimeException("exception thrown");
	}

	public StudentList fallbackFindAllStudents() {
		log.info("fallbackFindAllStudents method");
		Student student = Student.builder().id(1).name("Aria").course("hystrix").build();
		return StudentList.builder().studentList(Arrays.asList(student)).build();
	}
}
