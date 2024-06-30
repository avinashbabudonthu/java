# [<< Back](../README.md)
------
# Spring Boot 3 Hello World Application
------
# Technical Stack
* Java 17
* Maven 3.8.x
* Spring Boot 3.3.1
------
# Files
* Main class [Application](src/main/java/com/java/Application.java)
* Application yaml file [application.yml](src/main/resources/application.yml)
* POM file [pom.xml](pom.xml)
------
# How to run application
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
# Explanation
* Go to https://start.spring.io/
* Give required details and generate application
* Create [application.yml](src/main/resources/application.yml) file
* Add below property to start application on port `9000`
```
server.port: 9000
```
------
# [Other Spring Boot Examples](../README.md)