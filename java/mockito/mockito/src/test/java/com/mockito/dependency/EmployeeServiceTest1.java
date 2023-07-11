package com.mockito.dependency;

import java.util.Arrays;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

public class EmployeeServiceTest1 {

	private static EmployeeService employeeService = null;

	@BeforeClass
	public static void setupClass() {
		employeeService = new EmployeeService();
	}

	@AfterClass
	public static void tearDownClass() {
		employeeService = null;
	}

	@Test
	public void testGetEmployeeNames() {
		List<String> mockNames = Arrays.asList("ramesh", "suresh", "mahesh", "sunny", "bunny");

		EmployeeDao employeeDaoMock = Mockito.mock(EmployeeDao.class);
		Mockito.when(employeeDaoMock.getEmployeeNames()).thenReturn(mockNames);

		employeeService.setEmployeeDao(employeeDaoMock);

		List<String> actualResult = employeeService.getEmployeeNames();
		System.out.println("actualResult: " + actualResult);

		Mockito.verify(employeeDaoMock).getEmployeeNames();

		Assert.assertNotNull(mockNames);
		Assert.assertEquals(5, mockNames.size());
		Assert.assertEquals("ramesh", mockNames.get(0));
	}
}
