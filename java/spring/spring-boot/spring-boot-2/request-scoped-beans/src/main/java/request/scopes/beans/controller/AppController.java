package request.scopes.beans.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import request.scopes.beans.model.Student;
import request.scopes.beans.service.AppServiceOne;
import request.scopes.beans.service.AppServiceTwo;

@RestController
public class AppController {

	@Autowired
	private AppServiceOne appServiceOne;

	@Autowired
	private AppServiceTwo appServiceTwo;

	@Autowired
	private Student student;

	@GetMapping(value = "/students", produces = APPLICATION_JSON_VALUE)
	public Student getStudent() {
		appServiceOne.setId();
		appServiceTwo.setName();
		student.setCourse("spring-" + student.getId());

		Student resultStudent = Student.builder().id(student.getId()).name(student.getName())
				.course(student.getCourse()).build();

		return resultStudent;
	}
}