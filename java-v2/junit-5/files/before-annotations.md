### [<<Back](../README.md) | [Java V2 All Examples](https://github.com/avinashbabudonthu/java/blob/master/java-v2/README.md) | [Java All Examples](https://github.com/avinashbabudonthu/java/blob/master/README.md)
------
# Junit 5 before annotations
* Before annotation
```
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@TestInstance(Lifecycle.PER_CLASS) //if we don't declare this annotation, we need to declare @BeforeAll method as static
public class BeforeAnnotations {

	@BeforeAll
	public void setupAll() {
		log.info("@BeforeAll - executes once before all test cases");
	}

	@BeforeEach
	public void setup() {
		log.info("@BeforeEach - executes once before each test case");
	}

	@Test
	public void test1() {
		log.info("test1");
	}

	@Test
	public void test2() {
		log.info("test2");
	}
}
```
------
### [<<Back](../README.md) | [Java V2 All Examples](https://github.com/avinashbabudonthu/java/blob/master/java-v2/README.md) | [Java All Examples](https://github.com/avinashbabudonthu/java/blob/master/README.md)