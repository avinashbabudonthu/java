package com.student.service.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.service.model.StudentList;

@RestController
public class AppController {

	@Autowired
	private StudentList studentList;

	@GetMapping(value = "/students", produces = APPLICATION_JSON_VALUE)
	public StudentList findAllStudents() {
		return studentList;
	}
}
