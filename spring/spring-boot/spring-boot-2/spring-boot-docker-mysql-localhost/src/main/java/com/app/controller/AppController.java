package com.app.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.Employee;
import com.app.model.EmployeeModel;
import com.app.repository.EmployeeRepository;

@RestController
public class AppController {

	@Autowired
	private EmployeeRepository employeeRepository;

	@GetMapping(value = "/api/v1/employees", produces = APPLICATION_JSON_VALUE)
	public List<EmployeeModel> findAllEmployees() {
		List<Employee> employeeList = employeeRepository.findAll();
		return employeeList.stream().map(Employee::buildModel).collect(Collectors.toList());
	}
}