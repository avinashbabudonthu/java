package com.rest.api.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.api.model.Student;

import java.util.Date;

@RestController
@RequestMapping(value = "/puts")
public class PutController {

	@PutMapping(value = "/student1", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Student method1(@RequestBody Student student) {
		System.out.println("id: " + student.getId() +", name: " + student.getName() +", course: " + student.getCourse());
		student.setJoiningDate(new Date());
		return student;
	}

}