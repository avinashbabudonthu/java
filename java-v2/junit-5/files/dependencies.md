### [<<Back](../README.md) | [Java V2 All Examples](https://github.com/avinashbabudonthu/java/blob/master/java-v2/README.md) | [Java All Examples](https://github.com/avinashbabudonthu/java/blob/master/README.md)
------
# Junit 5 dependencies
* Add following dependencies for Junit 5 test cases
* Check maven central for latest versions
```
<dependency>
	<groupId>org.junit.jupiter</groupId>
	<artifactId>junit-jupiter-engine</artifactId>
	<version>5.8.1</version>
	<scope>test</scope>
</dependency>

<dependency>
	<groupId>org.junit.platform</groupId>
	<artifactId>junit-platform-launcher</artifactId>
	<version>1.4.2</version>
</dependency>
```

------
# For Junit4 Compatibility
* Add following dependencies for our test cases to be JUnit4 (vintage) compatible, for IDEs that have no support for JUnit 5 yet then include these dependencies
* Check maven central for latest versions
```
 <dependency>
	<groupId>org.junit.platform</groupId>
	<artifactId>junit-platform-runner</artifactId>
	<version>1.2.0</version>
	<scope>test</scope>
</dependency>
<dependency>
	<groupId>org.junit.vintage</groupId>
	<artifactId>junit-vintage-engine</artifactId>
	<version>5.8.1</version>
	<scope>test</scope>
</dependency>
```
------
### [<<Back](../README.md) | [Java V2 All Examples](https://github.com/avinashbabudonthu/java/blob/master/java-v2/README.md) | [Java All Examples](https://github.com/avinashbabudonthu/java/blob/master/README.md)