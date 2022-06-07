# Response Header for Each API

## Requirement
* Include response header for each REST API response

## Create project using maven
```
mvn archetype:generate -DgroupId=com.api.response.header -DartifactId=api-response-header -Dversion=1.0 -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
```

## Add gradle
```
gradle init --type pom
```

## Solutions
* [Using HttpServletResponse](#using-httpServletResponse)
* [Using ResponseEntity](#using-responseEntity)
* [Using Filter To All APIs](#using-filter-to-all-aPIs)

## Using HttpServletResponse
* Pass **HttpServletResponse** as an argument to API method
* Add header to **HttpServletResponse** object
* Refer [AppController.java](src/main/java/com/api/response/header/controller/AppController.java) - **apiOne** method

## Using ResponseEntity
* Create HttpHeaders object. Add header to HttpHeaders object
```
HttpHeaders httpHeaders = new HttpHeaders();
httpHeaders.set("response-header", "response-header-value");
httpHeaders.set("transaction-id", String.valueOf(UUID.randomUUID()));
return ResponseEntity.ok().headers(httpHeaders).body(student);
```
* Refer [AppController.java](src/main/java/com/api/response/header/controller/AppController.java) - **apiTwo** method

## Using Filter To All APIs
* Add header to **javax.servlet.http.HttpServletResponse**
* Refer [RequestResponseFilter.java](src/main/java/com/api/response/header/filter/RequestResponseFilter.java) - **doFilter** method
* Unique transaction id generated using [RequestUUIDGenerator.java](src/main/java/com/api/response/header/util/RequestUUIDGenerator.java)

## All logs should have transaction id
* Add header to **javax.servlet.http.HttpServletResponse**
* Refer [RequestResponseFilter.java](src/main/java/com/api/response/header/filter/RequestResponseFilter.java) - **doFilter** method
* Add **log4j-core** dependency. Refer [pom.xml](pom.xml) or [build.gradle](build.gradle)
* Unique transaction id generated using [RequestUUIDGenerator.java](src/main/java/com/api/response/header/util/RequestUUIDGenerator.java)
* Add transaction id to **org.apache.logging.log4j.ThreadContext**
* Add **%X** to **logging.pattern.console** property in [application.properties](src/main/resources/application.properties)
```
logging.pattern.console=%X{global-transaction-id} %d{yyyy-MM-dd HH:mm:ss} %-5level %C:%L - %m%n
```
* Following are other formats to use from log4j ThreadContext. Refer [https://logging.apache.org/log4j/2.x/manual/thread-context.html](https://logging.apache.org/log4j/2.x/manual/thread-context.html)
```
The PatternLayout provides mechanisms to print the contents of the ThreadContext Map and Stack.

Use %X by itself to include the full contents of the Map.
Use %X{key} to include the specified key.
Use %x to include the full contents of the Stack.
```
* Import postman collection to postman - [files/api-response-header.postman_collection.json](files/api-response-header.postman_collection.json)
* Hit API **3**
* We can see log in console like below
```
4566d301-2876-11ea-bb65-00155d000502 2019-12-27 12:28:30 INFO  com.api.response.header.controller.AppController:43 - Inside api /3
```
* We can see response header **global-transaction-id** in **/3** api response

## Run this project
* Import project into IDE as Maven or Gradle project
* Execute **com.api.response.header.App** class in each package

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
java -jar target\api-response-header.jar
```

## Create package using gradle
```
gradlew clean compileJava build
```

## Execute jar of Gradle
```
java -jar build\libs\api-response-header-1.0.jar
```

## References
* [https://www.baeldung.com/spring-response-header](https://www.baeldung.com/spring-response-header)