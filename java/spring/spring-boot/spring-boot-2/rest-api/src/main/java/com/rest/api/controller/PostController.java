package com.rest.api.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.rest.api.model.Student2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.rest.api.model.Student;

@Slf4j
@RestController
@RequestMapping(value = "/posts")
public class PostController {

	private static List<Student> students = new ArrayList<>();

	/**
	 * Status  - 201 Created
	 * Check Location header in response headers
	 * 
	 * @param student
	 * @return
	 */
	@PostMapping(value = "/students", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
		UUID randomUUID = UUID.randomUUID();
		String id = randomUUID.toString();
		student.setId(id);
		students.add(student);

		// build path to get student by id
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();

		return ResponseEntity.created(uri).body(student);
	}

	@GetMapping(value = "/students/{id}", produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<Student> findStudent(@PathVariable("id") String id) {
		for (Student student : students) {
			if (id.equals(student.getId())) {
				return ResponseEntity.ok(student);
			}
		}

		return ResponseEntity.noContent().build();
	}

	@PostMapping(value = "/request-body-with-enum-name", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	public Student2 studentWithEnum(@RequestBody Student2 student2){
		log.info("student2={}", student2);

		return student2;
	}


}
