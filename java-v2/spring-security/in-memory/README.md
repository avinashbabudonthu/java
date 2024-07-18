### [<<Back](../README.md) | [Java V2 All Examples](https://github.com/avinashbabudonthu/java/blob/master/java-v2/README.md) | [Java All Examples](https://github.com/avinashbabudonthu/java/blob/master/README.md)
------
# Spring Security In Memory Credentials
* Implementing basic spring boot 3 spring security 6
* Define in memory credentials in java class 
------
# How to run application?
* Application starts on port 9000

## Method 1
* Import code to IDE (IntelliJ or Eclipse)
* Run main class - [Main](src/main/java/com/java/Main.java)

## Method 2
* Run below maven command
```
mvn clean compile spring-boot:run
```
------
# Explanation
* Add spring security dependency in [pom.xml](pom.xml)
```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-security</artifactId>
</dependency>
```
* Define bean with user credentials in [SecurityConfig](src/main/java/com/java/config/SecurityConfig.java)
* Start the application
* Hit this API in browser - http://localhost:9000/status
* Following form will prompt for credentials\
![picture](img/001.jpg)
* Enter credentials defined in [SecurityConfig](src/main/java/com/java/config/SecurityConfig.java)
------
# Files
* [pom.xml](pom.xml)
* Main class - [Main](src/main/java/com/java/Main.java)
* Controller - [AppController](src/main/java/com/java/controller/AppController.java)
* [SecurityConfig](src/main/java/com/java/config/SecurityConfig.java)
* [application.properties](src/main/resources/application.properties)
* [Postman collection](postman/in-memory.postman_collection.json)
------
### [<<Back](../README.md) | [Java V2 All Examples](https://github.com/avinashbabudonthu/java/blob/master/java-v2/README.md) | [Java All Examples](https://github.com/avinashbabudonthu/java/blob/master/README.md)