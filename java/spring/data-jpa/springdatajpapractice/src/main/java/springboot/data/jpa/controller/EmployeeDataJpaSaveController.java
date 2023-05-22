package springboot.data.jpa.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import springboot.data.jpa.model.Employee;
import springboot.data.jpa.repository.EmployeeJpaRepository;

@RestController
public class EmployeeDataJpaSaveController {

	@Autowired
	@Qualifier("employeeJpaRepository")
	private EmployeeJpaRepository employeeJpaRepository;

	@RequestMapping(value = "/saveOne", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Employee save() {
		Employee employee = null;
		try {
			employee = new Employee(1, "testName1", "testJob1", 65432L, null, null, new Date());
			return employeeJpaRepository.save(employee);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return employee;
	}

	@RequestMapping(value = "/save/{id}/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Employee save(@PathVariable("id") Integer id, @PathVariable("name") String name) {
		Employee employee = null;
		try {
			employee = new Employee(id, name, "testJob2", 65432L, null, null, new Date());
			employeeJpaRepository.save(employee);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return employee;
	}

	// un-comment below method for multi tenant implementation
	/*@RequestMapping(value = "/multiTenant", method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
	public @ResponseBody String multiTenant(@RequestHeader("X-TenantID") String tenantName) {
	TenantContext.setCurrentTenant(tenantName);
	
	Employee employee = new Employee(1, "testName1", "testJob1", 65432L, null, null, new Date());
	employee.setId(12);
	employeeJpaRepository.save(employee);
	
	return "multi tenant success";
	}*/
}