package com.internal.methods.transactional.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.internal.methods.transactional.model.StudentModel;
import com.internal.methods.transactional.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	private StudentService studentService;

	@PostMapping(value = "/save-and-commit-each-student-model", produces = APPLICATION_JSON_VALUE)
	public List<StudentModel> saveAndCommitEachStudentModel() {
		return studentService.saveAndCommitEachStudentModel();
	}

	@PostMapping(value = "/save-and-commit-all-student-models", produces = APPLICATION_JSON_VALUE)
	public List<StudentModel> saveAndCommitAllStudentModels() {
		return studentService.saveAndCommitAllStudentModels();
	}
}
