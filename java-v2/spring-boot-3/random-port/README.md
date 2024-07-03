### [<<Back](../README.md) | [Java V2 All Examples](https://github.com/avinashbabudonthu/java/blob/master/java-v2/README.md) | [Java All Examples](https://github.com/avinashbabudonthu/java/blob/master/README.md)
------
# Requirement
* Start spring boot 3 application with embedded tomcat on random available port
------
# Why do we need a random or dynamic port?
* Sometimes we want to run multiple instances of a single app on the same server. And if you want to do this then we need to assign different ports in the run time only. And for this reason, we need to allocate random/dynamic ports at app startup
------
# Technical Stack
* Java 17
* Maven 3.8.x
* Spring Boot 3.3.1
------
# How to run application?
* Application starts on random available port

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

## Method 1 - Using `server.port` property in application yaml/properties file
* Go to https://start.spring.io/
* Give required details and generate application
* Create [application.yml](src/main/resources/application.yml) file
* Add below property in [application.yml](src/main/resources/application.yml) file
```
server.port: 0
```
* Now application will start on random available port
* We can see port number on console

## Method 2 - Using `SpringApplication` class in main method
* Add below code in main method
```
SpringApplication.run(Application.class, "--server.port=0");
```
* Refer [Application](src/main/java/com/java/Application.java)
* Now application will start on random available port
* We can see port number on console
------
### [<<Back](../README.md) | [Java V2 All Examples](https://github.com/avinashbabudonthu/java/blob/master/java-v2/README.md) | [Java All Examples](https://github.com/avinashbabudonthu/java/blob/master/README.md)
