# Async Controller

## Requirement
* Consume 3 API asynchronously
* Wrap 3 API calls response and return final response
* 3 API calls run in parallel

## Maven command
```
mvn archetype:generate -DgroupId=async.controller -DartifactId=async-controller -Dversion=1.0 -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
```

## Gradle command
```
gradle init --type pom
```

## Steps
* Add spring boot dependencies. Refer [pom.xml](pom.xml) or [build.gradle](build.gradle)
* Create **async.controller.config.AppConfig** class. Declare annotation **org.springframework.scheduling.annotation.EnableAsync**
* Create **async.controller.service.AsyncService** class. Declare methods calling API with annotation **org.springframework.scheduling.annotation.Async**
* All async methods in service class return **java.util.concurrent.CompletableFuture**
* Create **async.controller.controller.AsyncController**. Call API consuming method in service class

## Postman collection
* Refer [files/async-controller.postman_collection.json](files/async-controller.postman_collection.json)

## Run this project
* Import project into IDE as Maven or Gradle project
* Execute [App.java](src/main/java/async/controller/App.java)

## Run using maven exective plugin
```
mvn clean compile exec:java
```

## Run using spring boot maven plugin
```
mvn clean compile spring-boot:run
```

## Run using spring boot gradle plugin
```
gradlew clean compileJava bootRun
```

## Create package using maven
```
mvn clean compile package
```

## Execute jar of Maven
```
java -jar target\async-controller.jar
```

## Create package using gradle
```
gradlew clean compileJava build
```

## Execute jar of Gradle
```
java -jar build\libs\async-controller.jar
```