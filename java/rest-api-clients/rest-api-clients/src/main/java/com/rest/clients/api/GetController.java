package com.rest.clients.api;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rest.clients.api.service.EmployeeService;
import com.rest.clients.model.Employee;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/get/v1")
public class GetController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping(value = "/api-1", produces = MediaType.TEXT_PLAIN_VALUE)
	public String api1() {
		log.info("/get/v1/api-1");
		return "Hello World Get API 1";
	}

	@GetMapping(value = "/api-2", produces = APPLICATION_JSON_VALUE)
	public List<Employee> findAllEmployees() {
		return employeeService.findAllEmployees();
	}

	@GetMapping(value = "/api-3", produces = APPLICATION_JSON_VALUE)
	public Employee findEmployeeById(@RequestParam("id") Long employeeId) {
		return employeeService.findEmployeeById(employeeId);
	}

}