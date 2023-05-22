package com.mockito.lombok.inject;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeControllerTest {

	@Mock
	private EmployeeService employeeService;

	@InjectMocks
	private EmployeeController employeeController;

	@Test
	public void getName() {
		Mockito.when(employeeService.getName()).thenReturn("test jim");
		String name = employeeController.getName();
		Assert.assertEquals("test jim", name);
	}
}
