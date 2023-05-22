# Spring Boot 2 Global Exception Handling with Hibernate Bean Validator

## Maven command
```
mvn archetype:generate -DgroupId=global.exception.handling -DartifactId=global-exception-handling -Dversion=1.0 -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
```

## Gradle command
```
gradle init --type pom
```

## Description
* All errors are in **ErrorsEnum**
* All constants are in **Constants**
* Exception and error models are in **global.exception.handler.error.model**
* Create AppException - **Utils**
* Global exception handler class - **GlobalExceptionHandler**
* Overridden method **handleMethodArgumentNotValid** is used to handle Hibernate Validator exceptions
* Main class - **App**

## API
* Refer **files**

## Run using maven
* Execute following maven spring boot plugin
```
mvn clean compile spring-boot:run
```

## Run using maven exec plugin
```
mvn exec:java
```

## Run with Gradle
```
gradle clean compileJava bootRun
```

## Execute jar
* Package using maven
```
mvn clean compile package
```
* Packate using gradle
```
gradlew clean compileJava build
```
* Execute jar
```
java -jar path\jar-file-name.jar
```