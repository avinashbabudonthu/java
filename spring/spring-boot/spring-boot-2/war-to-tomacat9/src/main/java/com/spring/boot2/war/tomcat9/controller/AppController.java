package com.spring.boot2.war.tomcat9.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.TEXT_PLAIN_VALUE;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot2.war.tomcat9.entity.EmployeeEntity;
import com.spring.boot2.war.tomcat9.repository.EmployeeRepository;

@RestController
public class AppController {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Value("${first.name}")
	private String firstName;

	@GetMapping(value = "/hello", produces = TEXT_PLAIN_VALUE)
	public String hello() {
		return "Hello world";
	}

	@GetMapping(value = "/emps", produces = APPLICATION_JSON_VALUE)
	public List<EmployeeEntity> findAllEmployees() {
		return employeeRepository.findAll();
	}

	@GetMapping(value = "/first-name", produces = TEXT_PLAIN_VALUE)
	public String getFirstName() {
		return firstName;
	}
}