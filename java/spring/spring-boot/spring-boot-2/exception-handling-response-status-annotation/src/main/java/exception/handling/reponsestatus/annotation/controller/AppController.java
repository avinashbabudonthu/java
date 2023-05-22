package exception.handling.reponsestatus.annotation.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import exception.handling.reponsestatus.annotation.model.Student;
import exception.handling.reponsestatus.annotation.utils.Utils;

@RestController
public class AppController {

	private static List<Student> studentList = new ArrayList<>();

	static {
		studentList.add(Student.builder().id("1").name("jim").build());
		studentList.add(Student.builder().id("2").name("jill").build());
		studentList.add(Student.builder().id("3").name("jane").build());
	}

	@Autowired
	private Utils utils;

	@GetMapping(value = "/students/{id}", produces = APPLICATION_JSON_VALUE)
	public Student findStudentById(@PathVariable("id") String id) {
		Student resultStudent = null;
		for (Student student : studentList) {
			if (id.equalsIgnoreCase(student.getId())) {
				resultStudent = student;
				break;
			}
		}

		return Optional.ofNullable(resultStudent).orElseThrow(utils.throwObjectNotFound());
	}

	/**
	 * Location response header will have url to get student object
	 * 
	 * @param student
	 * @return
	 */
	@PostMapping(value = "/students", produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
	public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
		String name = student.getName();
		Optional.ofNullable(name).orElseThrow(utils.throwInvalidObjectException());
		studentList.add(student);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(student.getId())
				.toUri();
		return ResponseEntity.created(uri).body(student);
	}

}