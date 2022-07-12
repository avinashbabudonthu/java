package com.junit5.mockito;

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
		log.info("inside getEmployeeNames()");
		return employeeDao.getEmployeeNames();
	}

}