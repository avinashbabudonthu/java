# Materials in study order
* TBD
------
# Dependencies
* Add following dependencies for Junit 5 test cases. Check maven central for latest versions
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
* For our test cases to be JUnit4 (vintage) compatible, for IDEs that  have no support for JUnit 5 yet then include these dependencies
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