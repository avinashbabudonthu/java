### [<<Back](../README.md) | [Java V2 All Examples](https://github.com/avinashbabudonthu/java/blob/master/java-v2/README.md) | [Java All Examples](https://github.com/avinashbabudonthu/java/blob/master/README.md)
------
# Spring Security Generating Credentials
* Implementing basic spring boot 3 spring security 6
* Spring generates random password on start of the application
* Username fixed - `user`
------
# How to run application?
* Application starts on port 9000

## Method 1
* Import code to IDE (IntelliJ or Eclipse)
* Run main class - [Main](src/main/java/com/java/Main.java)
* Random password will be generated in application console

## Method 2
* Run below maven command
```
mvn clean compile spring-boot:run
```
* Random password will be generated in application console
------
# Explanation
* Add spring security dependency in [pom.xml](pom.xml)
```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-security</artifactId>
</dependency>
```
* Start the application
* Spring security by default generates random password. We can see in console
* Default credentials
    * username: user
    * password: generated in console
* Hit this API in browser - http://localhost:9000/status
* Following form will prompt for credentials\
![picture](img/001.jpg)
* Enter above credentials
* We will get success response
------
# Files
* [pom.xml](pom.xml)
* Main class - [Main](src/main/java/com/java/Main.java)
* Controller - [AppController](src/main/java/com/java/controller/AppController.java)
* [application.properties](src/main/resources/application.properties)
* [Postman collection](postman/spring-security-generated-credentials.postman_collection.json)
------
### [<<Back](../README.md) | [Java V2 All Examples](https://github.com/avinashbabudonthu/java/blob/master/java-v2/README.md) | [Java All Examples](https://github.com/avinashbabudonthu/java/blob/master/README.md)