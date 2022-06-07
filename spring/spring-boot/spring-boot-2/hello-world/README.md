# Spring Boot 2 Hello World

## Maven command
```
mvn archetype:generate -DgroupId=com.hello.world -DartifactId=hello-world -Dversion=1.0 -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
```

## Gradle command
```
gradle init --type pom
```
## Files
* [App.java](src/main/java/com/hello/world/App.java)
* [AppController.java](src/main/java/com/hello/world/controller/AppController.java)
* Dependencies [pom.xml](pom.xml) (or) [build.gradle](build.gradle)

## Postman collection
* Refer [files/spring-boot-2-maven-hello-world.postman_collection.json](files/spring-boot-2-maven-hello-world.postman_collection.json)

## Exception
* Exception Description
```
Description:

Failed to configure a DataSource: 'url' attribute is not specified and no embedded datasource could be configured.

Reason: Failed to determine suitable jdbc url


Action:

Consider the following:
	If you want an embedded database (H2, HSQL or Derby), please put it on the classpath.
	If you have database settings to be loaded from a particular profile you may need to activate it (no profiles are currently active).
```
* Solution 1 - **disable the auto-configuration using the spring.autoconfigure.exclude property in our application.properties file**
```
The class DataSourceAutoConfiguration is the base class for configuring a data source using the spring.datasource.* properties. 
Now, there are a few ways that we can exclude this from the auto-configuration. 
First, we can disable the auto-configuration using the spring.autoconfigure.exclude property in our application.properties file.

spring.autoconfigure.exclude=org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
```
*application.yml
```
spring:
  autoconfigure:
    exclude:
    - org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
```
* We can use the **exclude** attribute on our **@SpringBootApplication** or **@EnableAutoConfiguration** annotation:
```
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
```

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
java -jar target\hello-world.jar
```

## Create package using gradle
```
gradlew clean compileJava build
```

## Execute jar of Gradle
```
java -jar build\libs\hello-world-1.0.jar
```