# Swagger

## Maven command
```
mvn archetype:generate -DgroupId=swagger -DartifactId=swagger -Dversion=1.0 -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
```

## Gradle command
```
gradle init --type pom
```

## Steps
* Add `swagger` dependencies. Refer [pom.xml](pom.xml) (or) [build.gradle](build.gradle)
    * springfox-swagger2
    * springfox-swagger-ui
* Create [SwaggerConfig.java](src/main/java/swagger/config/SwaggerConfig.java)
    * Declare `@EnableSwagger2` annotation on [SwaggerConfig.java](src/main/java/swagger/config/SwaggerConfig.java) to enable swagger
    * Create `Docket` bean
* Create [AppController.java](src/main/java/swagger/controller/AppController.java)
* Run [App.java](src/main/java/swagger/App.java)
* Open URL - http://localhost:9000/swagger-ui.html
* API docs can be generated in JSON format. Refer `api-docs` in [postman-collection](files/swagger.postman_collection.json)
    * JSON response of this API can viewed using online swagger editor - https://editor.swagger.io/

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
java -jar target\swagger.jar
```

## Create package using gradle
```
gradlew clean compileJava build
```

## Execute jar of Gradle
```
java -jar build\libs\swagger-1.0.jar
```