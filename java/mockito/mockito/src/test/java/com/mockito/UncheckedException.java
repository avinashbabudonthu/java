package com.mockito;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import lombok.extern.slf4j.Slf4j;
import mockito.dependency.EmployeeDao;
import mockito.dependency.EmployeeService;

@Slf4j
@RunWith(MockitoJUnitRunner.class)
public class UncheckedException {

	@InjectMocks
	private EmployeeService employeeService;

	@Mock
	private EmployeeDao employeeDao;

	/**
	 * Use Mockito.when(..).thenThrow(exceptionObject) to throw Runtime exception
	 * Refer {@link CheckedException} to throw checked exceptions
	 */
	@Test(expected = RuntimeException.class)
	public void getEmployeeNamesRuntimeException() {
		log.info("Mockito throw checked exception");
		Mockito.when(employeeDao.getEmployeeNames()).thenThrow(new RuntimeException("test exception"));
		employeeService.getEmployeeNames();
	}
}