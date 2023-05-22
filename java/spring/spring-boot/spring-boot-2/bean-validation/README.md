# Spring Boot 2 Bean Validation

## Create project using maven
```
mvn archetype:generate -DgroupId=bean.validation -DartifactId=bean-validation -Dversion=1.0 -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
```

## Add gradle
```
gradle init --type pom
```

## Dependencies
* spring-boot-starter-parent:2.1.8.RELEASE
* spring-boot-starter-web
* spring-boot-starter-test
* spring-boot-starter-actuator
* org.projectlombok:lombok

## Description
* Actuator end points
* Import **files/spring-boot-actuator.postman_collection.json** to postman to execute actuator end points
* **[References](#References)** to see full list of end points

## References
* [https://dzone.com/articles/spring-boot-actuator-in-spring-boot-20](https://dzone.com/articles/spring-boot-actuator-in-spring-boot-20)
* [https://www.baeldung.com/spring-boot-actuators](https://www.baeldung.com/spring-boot-actuators)
* [All available actuator end points](https://docs.spring.io/spring-boot/docs/current/reference/html/production-ready-endpoints.html)