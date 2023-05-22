# Global Filters Exception Handling

## Problem Statement
* Handle exceptions thrown from Filter

## Create project using maven
```
mvn archetype:generate -DgroupId=global.filters.exception.handling -DartifactId=global-filters-exception-handling -Dversion=1.0 -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
```

## Add gradle
```
gradle init --type pom
```

## Steps
* Add spring boot dependencies. Refer [pom.xml](pom.xml) or [build.gradle](build.gradle)
* Create filter. Refer [RequestResponseFilter.java](src/main/java/global/filters/exception/handling/filter/RequestResponseFilter.java)
* Throw exception from Filter
* Write globale erorr handler [GlobalErrorHandler.java](src/main/java/global/filters/exception/handling/config/GlobalErrorHandler.java)
* Global error handler implements **org.springframework.boot.web.servlet.error.ErrorController**
* Override **getErrorPath()** and return **"/error"**
* Create GET API **"/error"** in [GlobalErrorHandler.java](src/main/java/global/filters/exception/handling/config/GlobalErrorHandler.java)
* Handle exception and return **ErrorModel** object
* Refer model classes in [src/main/java/global/filters/exception/handling/error/model](src/main/java/global/filters/exception/handling/error/model)
* Execute main class [App.java](src/main/java/global/filters/exception/handling/App.java)
* Import postman collection to postman from [files/global-filters-exception-handling.postman_collection.json](files/global-filters-exception-handling.postman_collection.json)
* Hit an API **without-header**. We will get error as below
```
{
    "errors": {
        "code": "CODE1",
        "message": "Missing request header",
        "property": "app",
        "timestamp": "2019-12-27T11:21:44.332",
        "status": 400,
        "path": "/app/hello",
        "method": "GET"
    }
}
```

## Run this project
* Import project into IDE as Maven or Gradle project
* Execute [App.java](src/main/java/global/filters/exception/handling/App.java)

## Run using maven
```
mvn clean compile spring-boot:run
```

## Run using gradle
```
gradlew clean compileJava bootRun
```

## Create package using maven
```
mvn clean compile package
```

## Execute jar of Maven
```
java -jar target\global-filters-exception-handling.jar
```

## Create package using gradle
```
gradlew clean compileJava build
```

## Execute jar of Gradle
```
java -jar build\libs\global-filters-exception-handling-1.0.jar
```