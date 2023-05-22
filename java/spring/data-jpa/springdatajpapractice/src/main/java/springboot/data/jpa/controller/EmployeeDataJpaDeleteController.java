package springboot.data.jpa.controller;

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
public class EmployeeDataJpaDeleteController {

    @Autowired
    @Qualifier("employeeJpaRepository")
    private EmployeeJpaRepository employeeJpaRepository;

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
    public @ResponseBody String delete(@PathVariable("id") Integer id) {
	String status = "success";
	try {
	    Employee employee = employeeJpaRepository.findOne(id);
	    employeeJpaRepository.delete(employee);
	} catch (Exception e) {
	    status = "failed";
	    e.printStackTrace();
	}
	return status;
    }
}
