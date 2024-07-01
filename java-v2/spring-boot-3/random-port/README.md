### [<<Back](../README.md) | [All Examples](https://github.com/avinashbabudonthu/java/blob/master/java-v2/README.md) | [Java All Examples](https://github.com/avinashbabudonthu/java/blob/master/README.md)
------
# Random Port
------
# Technical Stack
* Java 17
* Maven 3.8.x
* Spring Boot 3.3.1
------
# How to run application
* Application starts random available port

## Method 1
* Set Java 17 and Maven to path
* Import application to IntelliJ
* Run main class [Application](src/main/java/com/java/Application.java)

## Method 2
* Run below maven command
```
mvn clean compile spring-boot:run
```
* This command clean compile and run application
------
# Files
* Main class [Application](src/main/java/com/java/Application.java)
* Application yaml file [application.yml](src/main/resources/application.yml)
* POM file [pom.xml](pom.xml)
------
# Explanation
* Go to https://start.spring.io/
* Give required details and generate application
* Create [application.yml](src/main/resources/application.yml) file
* Add below property to start application on port `9000`
```
server.port: 9000
```
------
### [<<Back](../README.md) | [All Examples](https://github.com/avinashbabudonthu/java/blob/master/java-v2/README.md) | [Java All Examples](https://github.com/avinashbabudonthu/java/blob/master/README.md)
