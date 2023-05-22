# Spring Cloud Eureka Discovery Server

## Create project using maven
```
mvn archetype:generate -DgroupId=eureka.discovery.server -DartifactId=eureka-discovery-server -Dversion=1.0 -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
```

## Add gradle
```
gradle init --type pom
```

## Versions
* Maven **3.5.2**
* Gradle **5.0**

## Dependencies
* org.springframework.boot:spring-boot-starter-parent:2.1.9.RELEASE
* org.springframework.cloud:spring-cloud-dependencies:Greenwich.SR3
* org.springframework.boot:spring-boot-starter-web
* org.springframework.cloud:spring-cloud-starter-netflix-eureka-server

## Steps
* Add above dependencies
* Add annotation **org.springframework.cloud.netflix.eureka.server.EnableEurekaServer** on main class
* Add below properties in **application.properties**
```
server.port=8761
spring.application.name=discovery-server
eureka.client.register-with-eureka=false
eureka.client.fetch-registry=false
```
* Execute main class **App**
* Open url **http://localhost:8761/**

## Run this project
* Import project into IDE as Maven or Gradle project
* Execute **com.discovery.server.App**

## Run using maven
```
mvn clean compile spring-boot:run
```

## Run using gradle
```
gradlew clean compileJava bootRun
```