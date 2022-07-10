package com.employee.service.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.service.model.EmployeeList;

@RestController
public class AppController {

	@Autowired
	private EmployeeList employeeList;

	@GetMapping(value = "/employees", produces = APPLICATION_JSON_VALUE)
	public EmployeeList findAllEmployees() {
		return employeeList;
	}
}
