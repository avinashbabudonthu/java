package mockito.dependency;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceTestAnnotations2 {

	@InjectMocks
	private EmployeeService employeeService;

	@Mock
	private EmployeeDao employeeDao;

	@Test
	public void getEmployeeNames() {
		log.info("EmployeeServiceTestAnnotations2.getEmployeeNames::employeeService: {}", employeeService);
		Mockito.when(employeeDao.getEmployeeNames()).thenReturn(Arrays.asList("john", "jack"));
		List<String> names = employeeService.getEmployeeNames();
		log.info("EmployeeServiceTestAnnotations2.getEmployeeNames::names: {}", names);
	}
}