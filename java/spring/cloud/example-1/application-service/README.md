# Application Service - Client to Discovery Server

## Create project using maven
```
mvn archetype:generate -DgroupId=application.service -DartifactId=application-service -Dversion=1.0 -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
```

## Add gradle
```
gradle init --type pom
```

## Versions
* Maven **3.5.2**
* Gradle **5.0**

## Steps
* Add spring boot dependencies
* Add following dependencies to make spring boot application as client to eureka discovery server
```
org.springframework.cloud:spring-cloud-dependencies:Greenwich.SR3
org.springframework.cloud:spring-cloud-starter-netflix-eureka-client
org.springframework.boot:spring-boot-starter-actuator
```
* Actuator dependency will be used by discovery server to check the health status of registered services
* Add annotation **org.springframework.cloud.client.discovery.EnableDiscoveryClient** on main class
* Add application name
```
spring.application.name=application-service
```
* Eureka discovery server location
```
eureka.client.service-url.defaultZone=http://localhost:8761/eureka/
```
* Make eureka instance run as localhost. If docker is running in local machine by defaul docker internal will be taken
```
eureka.instance.hostname=localhost
```
* Registering service to register as localhost instead docker internal host
```
spring.cloud.client.hostname=localhost
```

## Run this project
* Start discovery server first. Refer [Discover Server](../eureka-discovery-server)
* Import project into IDE as Maven or Gradle project
* Execute **com.discovery.server.App**
* Open URL **http://localhost:8761**
* We can see this service is registered with discovery server with the name **application-service**

## API
* Refer **files/application-service.postman_collection.json**

## Run using maven
```
mvn clean compile spring-boot:run
```

## Run using gradle
```
gradlew clean compileJava bootRun
```