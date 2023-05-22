package com.api.response.header.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.response.header.model.Student;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class AppController {

	@GetMapping(value = "/1", produces = APPLICATION_JSON_VALUE)
	public Student apiOne(HttpServletResponse httpServletResponse) {
		httpServletResponse.addHeader("response-header", "response-header-value");
		httpServletResponse.addHeader("transaction-id", String.valueOf(UUID.randomUUID()));

		return Student.builder().id(1L).name("jack").build();
	}

	@GetMapping(value = "/2", produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<Student> apiTwo() {
		Student student = Student.builder().id(1L).name("jack").build();

		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.set("response-header", "response-header-value");
		httpHeaders.set("transaction-id", String.valueOf(UUID.randomUUID()));

		return ResponseEntity.ok().headers(httpHeaders).body(student);
	}

	@GetMapping(value = "/3", produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<Student> apiThree() {
		log.info("Inside api /3");
		Student student = Student.builder().id(1L).name("jack").build();

		return ResponseEntity.ok().body(student);
	}
}