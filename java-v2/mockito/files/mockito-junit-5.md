### [<<Back](../README.md) | [Java V2 All Examples](https://github.com/avinashbabudonthu/java/blob/master/java-v2/README.md) | [Java All Examples](https://github.com/avinashbabudonthu/java/blob/master/README.md)
------
# Mockito with Junit 5
* Use this annotation at class level
```
org.junit.jupiter.api.extension.ExtendWith(MockitoExtension.class)
```
* Use this annotation on class under Test
```
org.mockito.InjectMocks
```
* Sample code
```
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ExtendWith(MockitoExtension.class)
public class MockitoExtensionsPractice {

	@InjectMocks
	private EmployeeService employeeService;

	@Mock
	private EmployeeDao employeeDao;

	@DisplayName("get employee names")
	@Test
	public void getEmployeeNames() {
		Mockito.when(employeeDao.getEmployeeNames()).thenReturn(Arrays.asList("jim"));
		List<String> names = employeeService.getEmployeeNames();
		log.info("result: {}", names);
	}

}
```
------
### [<<Back](../README.md) | [Java V2 All Examples](https://github.com/avinashbabudonthu/java/blob/master/java-v2/README.md) | [Java All Examples](https://github.com/avinashbabudonthu/java/blob/master/README.md)