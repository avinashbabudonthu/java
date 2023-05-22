package data.jpa.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import data.jpa.entity.EmployeeDepartmentEntity;
import data.jpa.entity.EmployeeEntity;
import data.jpa.model.ResponseModel;
import data.jpa.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping(value = "/employees", produces = APPLICATION_JSON_VALUE)
	public List<EmployeeEntity> findAllEmployeesList() {
		return employeeService.findAllEmployeesList();
	}

	@GetMapping(value = "/employees/dept/{id}", produces = APPLICATION_JSON_VALUE)
	public List<EmployeeEntity> findAllEmployeesByDeptId(@PathVariable("id") Integer deptId) {
		return employeeService.findAllEmployeesByDeptId(deptId);
	}

	@GetMapping(value = "/employees/depts")
	public List<EmployeeDepartmentEntity> findEmployeeAndDept() {
		return employeeService.findEmployeeAndDept();
	}

	@GetMapping(value = "/paginated/employees", produces = APPLICATION_JSON_VALUE)
	public ResponseModel findEmployeeModelListAllByPagination(
			@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "size", required = false) Integer size) {
		return employeeService.findEmployeeModelListAllByPagination(page, size);
	}

	@GetMapping(value = "/employees/sort", produces = APPLICATION_JSON_VALUE)
	public ResponseModel findEmployeeModelListAllSortByENameAscAndSalaryDesc() {
		return employeeService.findEmployeeModelListAllSortByENameAscAndSalaryDesc();
	}

}