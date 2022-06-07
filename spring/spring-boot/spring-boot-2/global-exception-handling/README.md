# Spring Boot 2 Bean Validation

## Maven command
```
mvn archetype:generate -DgroupId=global.exception.handling -DartifactId=global-exception-handling -Dversion=1.0 -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
```

## Add gradle
```
gradle init --type pom
```

## Description
* All errors are in [ErrorsEnum.java](src/main/java/global/exception/handling/util/ErrorsEnum.java)
* All constants are in [Constants.java](src/main/java/global/exception/handling/util/Constants.java)
* Exception and error models are in [src/main/java/global/exception/handling/model](src/main/java/global/exception/handling/model)
* Build app exception - [Utils.java](src/main/java/global/exception/handling/util/Utils.java)
* Global exception handler class - [GlobalExceptionHandler.java](src/main/java/global/exception/handling/config/GlobalExceptionHandler.java)
* Main class - [App.java](src/main/java/global/exception/handling/App.java)

## API
* Refer [files/global-exception-handler.postman_collection.json](files/global-exception-handler.postman_collection.json)

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

## Package using maven
```
mvn clean compile package
```

## Package using gradle
```
gradlew clean compileJava build
```

## Execute jar
```
java -jar path\jar-file-name.jar
```