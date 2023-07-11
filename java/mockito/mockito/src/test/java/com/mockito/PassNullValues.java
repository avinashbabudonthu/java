package com.mockito;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import lombok.extern.slf4j.Slf4j;
import com.mockito.dependency.EmployeeDao;
import com.mockito.dependency.EmployeeService;

@Slf4j
@RunWith(MockitoJUnitRunner.class)
public class PassNullValues {

	@InjectMocks
	private EmployeeService employeeService;

	@Mock
	private EmployeeDao employeeDao;

	/**
	 * We cannot stub method passing null value then use Mockito.isNull()
	 * 
	 * Refer below method - another way for passing null value
	 */
	@Test
	public void getEmployeeNames() {
		Mockito.when(employeeDao.getEmployeeNames(Mockito.isNull())).thenReturn(new ArrayList<>());
		List<String> employeeNames = employeeService.getEmployeeNames(null);
		log.info("result: {}", employeeNames);
	}

	/**
	 * We can use Mockito.eq(null) also to pass null value
	 */
	@Test
	public void getEmployeeNames2() {
		Mockito.when(employeeDao.getEmployeeNames(Mockito.eq(null))).thenReturn(new ArrayList<>());
		List<String> employeeNames = employeeService.getEmployeeNames(null);
		log.info("result: {}", employeeNames);
	}
}