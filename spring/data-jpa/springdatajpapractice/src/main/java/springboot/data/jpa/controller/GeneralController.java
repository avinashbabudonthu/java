package springboot.data.jpa.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import springboot.data.jpa.repository.EmployeeJpaRepository;

//comment all code inside class for multi tenant implementation
@RestController
public class GeneralController {

	@Autowired
	@Qualifier(value = "primaryDataSource")
	private DataSource primaryDataSource;

	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	@Qualifier("objectMapper")
	private ObjectMapper objectMapper;

	@Autowired
	@Qualifier("employeeJpaRepository")
	private EmployeeJpaRepository employeeJpaRepository;

	@RequestMapping(value = "/hello", method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
	public @ResponseBody String hello() {
		return "Welcome to Spring Boot Data JPA";
	}

	@RequestMapping(value = "/primaryDataSource", method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
	public @ResponseBody String dataSource() {
		return "dataSource: " + primaryDataSource;
	}

	@RequestMapping(value = "/entityManager", method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
	public @ResponseBody String entityManager() {
		return "entityManager: " + entityManager;
	}

	@RequestMapping(value = "/objectMapper", method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
	public @ResponseBody String objectMapper() {
		return "objectMapper: " + objectMapper;
	}

	@RequestMapping(value = "/employeeJpaRepository", method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
	public @ResponseBody String employeeJpaRepository() {
		return "employeeJpaRepository: " + employeeJpaRepository;
	}

}
