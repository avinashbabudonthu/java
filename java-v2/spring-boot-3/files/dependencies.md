### [<<Back](../README.md) | [Java V2 All Examples](https://github.com/avinashbabudonthu/java/blob/master/java-v2/README.md) | [Java All Examples](https://github.com/avinashbabudonthu/java/blob/master/README.md)
------
# Spring Boot 3 dependencies for maven project
* Add below properties
```
<properties>
	<java.version>17</java.version>
	<maven.compiler.source>17</maven.compiler.source>
	<maven.compiler.target>17</maven.compiler.target>
</properties>
```
* Parent dependency. Refer central repository for latest version - https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-parent
```
<parent>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-parent</artifactId>
	<version>3.3.1</version>
	<relativePath/>
</parent>
```
* Other dependencies. No need to add version. Compatible version to `spring-boot-starter-parent` will be downloaded
```
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-web</artifactId>
</dependency>
		
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-test</artifactId>
	<scope>test</scope>
</dependency>
```
* Actuator dependency
```
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
```
* [Lombok dependency](../../lombok/files/dependencies.md)
* For open-api and swagger
```
<dependency>
	<groupId>org.springdoc</groupId>
	<artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
	<version>2.0.3</version>
</dependency>
```
* `springboot-maven-plugin`
```
<plugin>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-maven-plugin</artifactId>
	<configuration>
		<excludes>
			<exclude>
				<groupId>org.projectlombok</groupId>
				<artifactId>lombok</artifactId>
			</exclude>
		</excludes>
	</configuration>
</plugin>
```
------
### [<<Back](../README.md) | [Java V2 All Examples](https://github.com/avinashbabudonthu/java/blob/master/java-v2/README.md) | [Java All Examples](https://github.com/avinashbabudonthu/java/blob/master/README.md)