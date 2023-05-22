package mockito.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import mockito.model.Student;
import mockito.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	private StudentService studentService;

	@GetMapping(value = "/students", produces = APPLICATION_JSON_VALUE)
	public Student findStudent() {
		return studentService.findStudent();
	}
}
