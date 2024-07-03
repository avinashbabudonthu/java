### [<<Back](../README.md) | [Java V2 All Examples](https://github.com/avinashbabudonthu/java/blob/master/java-v2/README.md) | [Java All Examples](https://github.com/avinashbabudonthu/java/blob/master/README.md)
------
# Technical stack
* Java 17
* Maven
* Spring Boot 3.3.1
* Lombok
------
# How to run application?
* Application starts on port `9000`

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
* [pom.xml](pom.xml)
* [application.yml](src/main/resources/application.yml)
* Main class [Application](src/main/java/com/java/Application.java)
* Student Model class [Student](src/main/java/com/java/model/Student.java)
* StudentService interface [StudentService](src/main/java/com/java/service/StudentService.java)
* StudentServiceImpl class [StudentServiceImpl](src/main/java/com/java/service/impl/StudentServiceImpl.java)
* GetController interface [GetController](src/main/java/com/java/controller/GetController.java)
* GetControllerImpl class [GetControllerImpl](src/main/java/com/java/controller/impl/GetControllerImpl.java)
------
# Explanation
* [GetController](src/main/java/com/java/controller/GetController.java) has different ways of writing GET API
* [GetController](src/main/java/com/java/controller/GetController.java) interface has API declarations
* [GetControllerImpl](src/main/java/com/java/controller/impl/GetControllerImpl.java) class has API implementation
* Why interface and class for APIs
  * Implementation has only business logic
  * Interface will have API annotations, method comments, swagger documentation etc
------
### [<<Back](../README.md) | [Java V2 All Examples](https://github.com/avinashbabudonthu/java/blob/master/java-v2/README.md) | [Java All Examples](https://github.com/avinashbabudonthu/java/blob/master/README.md)