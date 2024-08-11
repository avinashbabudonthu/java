### [<<Back](../README.md) | [Java V2 All Examples](https://github.com/avinashbabudonthu/java/blob/master/java-v2/README.md) | [Java All Examples](https://github.com/avinashbabudonthu/java/blob/master/README.md)
------
* Add below dependency. Refer central repository for latest version - https://mvnrepository.com/artifact/com.github.javafaker/javafaker
```
<dependency>
    <groupId>com.github.javafaker</groupId>
    <artifactId>javafaker</artifactId>
    <version>1.0.2</version>
</dependency>
```
* Above version will vulnerability with transitive dependency. Use below code
* Refer central repository for `snakeyaml` latest version - https://mvnrepository.com/artifact/org.yaml/snakeyaml
```
<dependency>
	<groupId>com.github.javafaker</groupId>
	<artifactId>javafaker</artifactId>
	<version>1.0.2</version>
	<exclusions>
		<exclusion>
			<groupId>org.yaml</groupId>
			<artifactId>snakeyaml</artifactId>
		</exclusion>
	</exclusions>
</dependency>

<dependency>
    <groupId>org.yaml</groupId>
    <artifactId>snakeyaml</artifactId>
    <version>2.2</version>
</dependency>
```
------
### [<<Back](../README.md) | [Java V2 All Examples](https://github.com/avinashbabudonthu/java/blob/master/java-v2/README.md) | [Java All Examples](https://github.com/avinashbabudonthu/java/blob/master/README.md)