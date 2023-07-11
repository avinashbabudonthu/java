package com.mockito.dependency;

import java.util.List;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EmployeeService {

	private EmployeeDao employeeDao;

	public EmployeeDao getEmployeeDao() {
		return employeeDao;
	}

	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	public List<String> getEmployeeNames() {
		log.info("inside getEmployeeNames() method");
		return employeeDao.getEmployeeNames();
	}

	public List<String> getEmployeeNames(String name) {
		log.info("inside getEmployeeNames(String name) method");
		return employeeDao.getEmployeeNames(name);
	}
}