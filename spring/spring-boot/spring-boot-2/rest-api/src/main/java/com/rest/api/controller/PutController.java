package com.rest.api.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rest.api.model.Student;

@RestController
public class PutController {

	@PutMapping(value = "/student1", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Student method1(@RequestBody Student student) {
		return student;
	}
}