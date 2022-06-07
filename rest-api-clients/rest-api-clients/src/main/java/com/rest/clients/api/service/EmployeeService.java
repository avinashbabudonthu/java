package com.rest.clients.api.service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.rest.clients.model.Employee;

@Service
public class EmployeeService {

	public List<Employee> findAllEmployees() {
		Employee employee1 = Employee.builder().id(1L).name("name1").joiningDate(new Date()).createDate(new Date())
				.build();
		Employee employee2 = Employee.builder().id(2L).name("name2").joiningDate(new Date()).createDate(new Date())
				.build();
		Employee employee3 = Employee.builder().id(3L).name("name3").joiningDate(new Date()).createDate(new Date())
				.build();

		return Arrays.asList(employee1, employee2, employee3);
	}

	public Employee findEmployeeById(Long employeeId) {
		List<Employee> employees = findAllEmployees();
		return employees.stream().filter(employee -> employee.getId().equals(employeeId)).findAny().get();
	}
}