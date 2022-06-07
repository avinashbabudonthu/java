package async.controller.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.Arrays;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import async.controller.model.Employee;
import async.controller.model.Employees;

@RestController
public class EmployeeController {

	@GetMapping(value = "/employees", produces = APPLICATION_JSON_VALUE)
	public Employees findAllEmployees() {
		Employee employee1 = Employee.builder().id(1).name("jack").salary(1001L).build();
		Employee employee2 = Employee.builder().id(2).name("jill").salary(1002L).build();
		Employee employee3 = Employee.builder().id(3).name("jim").salary(1003L).build();

		return Employees.builder().employees(Arrays.asList(employee1, employee2, employee3)).build();
	}
}
