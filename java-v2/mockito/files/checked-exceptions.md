### [<<Back](../README.md) | [Java V2 All Examples](https://github.com/avinashbabudonthu/java/blob/master/java-v2/README.md) | [Java All Examples](https://github.com/avinashbabudonthu/java/blob/master/README.md)
------
# How to throw checked exceptions
* We cannot throw checked exception with `Mockito.when(..).thenThrow(..)`
* We need to do `Mockito.when(..).thenAnswer(answer -> {throw new Exception(...);}`
```
import org.mockito.Mockito;

Mockito
	.when(employeeDao.getEmployeeNames())
	.thenAnswer(answer -> {
		throw new Exception("test exception");
	});
```
------
### [<<Back](../README.md) | [Java V2 All Examples](https://github.com/avinashbabudonthu/java/blob/master/java-v2/README.md) | [Java All Examples](https://github.com/avinashbabudonthu/java/blob/master/README.md)