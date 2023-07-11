package com.mockito;

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
public class CheckedException {

	@InjectMocks
	private EmployeeService employeeService;

	@Mock
	private EmployeeDao employeeDao;

	/**
	 * We cannot throw checked exception with Mockito.when(..).thenThrow(..) 
	 * So we need to Mockito.when(..).thenAnswer(answer -> {throw new Exception(...);}
	 * 
	 * Refer {@link UncheckedException} to throw RuntimeException
	 */
	@Test(expected = Exception.class)
	public void getEmployeeNamesCheckedException() {
		log.info("Mockito throw checked exception");
		Mockito.when(employeeDao.getEmployeeNames()).thenAnswer(answer -> {
			throw new Exception("test exception");
		});
		employeeService.getEmployeeNames();
	}
}