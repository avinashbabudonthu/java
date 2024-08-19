### [<<Back](../README.md) | [Java V2 All Examples](https://github.com/avinashbabudonthu/java/blob/master/java-v2/README.md) | [Java All Examples](https://github.com/avinashbabudonthu/java/blob/master/README.md)
------
# Mockito with Junit 4
* Use this annotation at class level
```
@org.junit.runner.RunWith(org.mockito.runners.MockitoJUnitRunner.class)
```
* Use this annotation on class under Test
```
org.mockito.InjectMocks
```
* Sample code
```
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
```
------
### [<<Back](../README.md) | [Java V2 All Examples](https://github.com/avinashbabudonthu/java/blob/master/java-v2/README.md) | [Java All Examples](https://github.com/avinashbabudonthu/java/blob/master/README.md)