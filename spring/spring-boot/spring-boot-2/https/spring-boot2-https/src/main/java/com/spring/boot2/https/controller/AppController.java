package com.spring.boot2.https.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot2.https.model.Employee;

@RestController
public class AppController {

	@GetMapping(value = "/employees", produces = APPLICATION_JSON_VALUE)
	public List<Employee> findEmployees() {
		List<Employee> employeeList = new ArrayList<>();
		employeeList.add(Employee.builder().id(1L).name("jack").designation("SE").build());
		employeeList.add(Employee.builder().id(2L).name("jill").designation("SSE").build());
		return employeeList;
	}
}