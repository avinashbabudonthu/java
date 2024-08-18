### [<<Back](../README.md) | [Java V2 All Examples](https://github.com/avinashbabudonthu/java/blob/master/java-v2/README.md) | [Java All Examples](https://github.com/avinashbabudonthu/java/blob/master/README.md)
------
# Exception Assertion
* Call method that throws exception un `Assertions.assertThrows`
```
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Exceptions {

	@DisplayName("Assert Throws")
	@Test
	public void assertThrows() {
		Exception exception = Assertions.assertThrows(RuntimeException.class, () -> {
			throw new RuntimeException("run time exception");
		});
		Assertions.assertEquals(exception.getMessage(), "run time exception");
	}

}
```
------
### [<<Back](../README.md) | [Java V2 All Examples](https://github.com/avinashbabudonthu/java/blob/master/java-v2/README.md) | [Java All Examples](https://github.com/avinashbabudonthu/java/blob/master/README.md)