package spring.boot.hateoas.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.net.URI;
import java.util.*;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import spring.boot.hateoas.exceptions.StudentNotFoundException;
import spring.boot.hateoas.model.Student;

@RestController
public class AppController {

	private static List<Student> studentList = new ArrayList<>();

	static {
		studentList.add(Student.builder().id("1").name("jim").joiningDate(new Date()).build());
		studentList.add(Student.builder().id("2").name("jill").joiningDate(new Date()).build());
		studentList.add(Student.builder().id("3").name("jane").joiningDate(new Date()).build());
	}

	/**
	 * Status  - 201 Created
	 * Check Location header in response headers
	 */
	@PostMapping(value = "/students", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
		String id = UUID.randomUUID().toString();
		student.setId(id);
		studentList.add(student);

		// build path to get student by id
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
		return ResponseEntity.created(uri).body(student);
	}

	@GetMapping(value = "/students", produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Student>> findAllStudent() {
		return ResponseEntity.ok(studentList);
	}

	/**
	 * Return url to /students API using HATEOAS
	 *
	 */
	@GetMapping(value = "/students/{id}", produces = APPLICATION_JSON_VALUE)
	public Resource<Student> findStudent(@PathVariable("id") String id) {
		Student resultStudent = null;
		for (Student student : studentList) {
			if (id.equals(student.getId())) {
				resultStudent = student;
				break;
			}
		}

		Optional.ofNullable(resultStudent).orElseThrow(StudentNotFoundException::new);

		Resource<Student> resource = new Resource<>(resultStudent);
		ControllerLinkBuilder linkTo = ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(this.getClass()).findAllStudent());
		resource.add(linkTo.withRel("find-all-students"));

		return resource;
	}

}