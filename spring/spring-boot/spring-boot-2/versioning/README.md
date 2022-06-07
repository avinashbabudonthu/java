# Versioning REST API

## Requirement
* Different ways REST API versioning

## Maven Command
```
mvn archetype:generate -DgroupId=com.versioning -DartifactId=versioning -Dversion=1.0 -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false 
```

## Gradle Command
```
gradle init --type pom
```

## Steps
* Dependencies - Refer [pom.xml](pom.xml) or [build.gradle](build.gradle)
* [application.yml](src/main/resources/application.yml)
* URI Versioning - Refer [URIVersioningController.java](src/main/java/com/versioning/controller/URIVersioningController.java)
    * Having `/v1` or `/v2` in URI
* Request parameter versioning - Refer [RequestParamVersioningController.java](src/main/java/com/versioning/controller/RequestParamVersioningController.java)
```
@GetMapping(value = "/students/param", params = "version=1", produces = MediaType.APPLICATION_JSON_VALUE)
@GetMapping(value = "/students/param", params = "version=2", produces = MediaType.APPLICATION_JSON_VALUE)
```
* Header versioning - Refe [HeaderVersioningController.java](src/main/java/com/versioning/controller/HeaderVersioningController.java)
```
@GetMapping(value = "/students/header", headers = "version=1", produces = MediaType.APPLICATION_JSON_VALUE)
@GetMapping(value = "/students/header", headers = "version=2", produces = MediaType.APPLICATION_JSON_VALUE)
```
* Content Type versioning - Refer [ContentTypeVersioningController.java](src/main/java/com/versioning/controller/ContentTypeVersioningController.java)
```
@GetMapping(value = "/students/produces", produces = "application/my.app-v1+json")
@GetMapping(value = "/students/produces", produces = "application/my.app-v2+json")
```

## API
* Refer [files/versioning.postman_collection.json](files/versioning.postman_collection.json)

## Run from IDE
* Import project into IDE as Maven or Gradle project
* Execute [App.java](src/main/java/com/versioning/App.java)

## Run using maven executive plugin
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
java -jar target\versioning.jar
```

## Create package using gradle
```
gradlew clean compileJava build
```

## Execute jar of Gradle
```
java -jar build\libs\versioning-1.0.jar
```