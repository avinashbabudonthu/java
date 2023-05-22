# Spring Boot Dynamic Filtering

## Requirement
* Create AppModel
    * field1
    * field2
    * field3
* For /api1 send field1, field2
* For /api2 send field2, field3

## Maven Command
```
mvn archetype:generate -DgroupId=dynamic.filtering -DartifactId=dynamic-filtering -Dversion=1.0 -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false 
```

## Gradle Command
```
gradle init --type pom
```

## Steps
* Dependencies - Refer [pom.xml](pom.xml) or [build.gradle](build.gradle)
* Create [AppModel.java](src/main/java/dynamic/filtering/model/AppModel.java)
* Declare `@JsonFilter("AppModelFilter")` annotation on [AppModel.java](src/main/java/dynamic/filtering/model/AppModel.java)
* Create [AppController.java](src/main/java/dynamic/filtering/controller/AppController.java)
* Write filtering like below. Refer `api1()`, `api2()` methods
```
SimpleBeanPropertyFilter simpleBeanPropertyFilter = SimpleBeanPropertyFilter
                .filterOutAllExcept("field1", "field2");
FilterProvider filterProvider = new SimpleFilterProvider().addFilter("AppModelFilter",simpleBeanPropertyFilter);
MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(appModel);
mappingJacksonValue.setFilters(filterProvider);
```
* Import postman collection from [files](files) folder to local postman
* Run [App.java](src/main/java/dynamic/filtering/App.java)
* Hit APIs 
    * `api1` returns field1, field2 
    * `api2` returns field2, field3

## API
* Refer [dynamic-filtering.postman_collection.json](files/dynamic-filtering.postman_collection.json)

## Run from IDE
* Import project into IDE as Maven or Gradle project
* Execute [App.java](src/main/java/dynamic/filtering/App.java)

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
java -jar target\dynamic-filtering.jar
```

## Create package using gradle
```
gradlew clean compileJava build
```

## Execute jar of Gradle
```
java -jar build\libs\dynamic-filtering-1.0.jar
```