package com.mockito.dependency;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class EmployeeServiceTestAnnotations {

	@InjectMocks
	private EmployeeService employeeService;
	@Mock
	private EmployeeDao employeeDao;

	// we have to use either @org.junit.runner.RunWith(MockitoJUnitRunner.class) or below code
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testGetEmployeeNames() {
		System.out.println("EmployeeServiceTestAnnotations:employeeService: " + employeeService);

		Mockito.when(employeeDao.getEmployeeNames()).thenReturn(
				Arrays.asList("ramesh", "suresh", "mahesh", "sunny", "bunny"));

		List<String> mockNames = employeeService.getEmployeeNames();
		System.out.println(mockNames);
	}
}
