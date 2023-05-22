package async.controller.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.Arrays;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import async.controller.model.Student;
import async.controller.model.Students;

@RestController
public class StudentController {

	@GetMapping(value = "/students", produces = APPLICATION_JSON_VALUE)
	public Students findAllStudents() {
		Student student1 = Student.builder().id(1).name("ana").course("java").build();
		Student student2 = Student.builder().id(2).name("jamy").course("spring").build();
		Student student3 = Student.builder().id(3).name("john").course("docker").build();

		return Students.builder().students(Arrays.asList(student1, student2, student3)).build();
	}
}
