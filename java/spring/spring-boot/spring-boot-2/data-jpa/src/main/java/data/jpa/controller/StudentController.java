package data.jpa.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import data.jpa.model.StudentModel;
import data.jpa.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	private StudentService studentService;

	@PutMapping(value = "/delete/students", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	public List<StudentModel> deleteStudentEntityListByIdList(@RequestBody List<Long> studentIdList) {
		return studentService.deleteStudentEntityListByIdList(studentIdList);
	}
}
