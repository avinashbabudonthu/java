package springboot.data.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import springboot.data.jpa.model.Employee;
import springboot.data.jpa.repository.EmployeeJpaRepository;

@RestController
public class EmployeeDataJpaUpdateController {

    @Autowired
    @Qualifier("employeeJpaRepository")
    private EmployeeJpaRepository employeeJpaRepository;

    @RequestMapping(value = "/updateOne", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Employee updateEmployee(@RequestBody Employee employee) {
	return employeeJpaRepository.saveAndFlush(employee);
    }

    @RequestMapping(value = "/updateByName/{oldName}/{newName}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public int updateByName(@PathVariable("oldName") String oldName, @PathVariable("newName") String newName) {
	return employeeJpaRepository.updateByName(oldName, newName);
    }
}
