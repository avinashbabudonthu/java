# Application Client - client to Application Service

## Create project using maven
```
mvn archetype:generate -DgroupId=application.client-1 -DartifactId=application-client-1 -Dversion=1.0 -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
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
* Add spring cloud and Netflix dependencies
```
spring-cloud-dependencies:Greenwich.SR3
org.springframework.cloud:spring-cloud-starter-netflix-eureka-client
org.springframework.boot:spring-boot-starter-actuator
```
* Add **org.springframework.cloud.client.discovery.EnableDiscoveryClient** annotation on main class
* Add application name
```
spring.application.name=application-client-1
```
* Specify Eureka discovery server location
```
eureka.client.service-url.defaultZone=http://localhost:8761/eureka/
```
* To not to register with discovery server
```
eureka.client.register-with-eureka=false
```
* Add **org.springframework.cloud.client.discovery.EnableDiscoveryClient** annotation on main class
* Rest client with EurekaClient - **com.application.client.eureka.client.EurekaClientRestController**
* Rest client with DiscoveryClient - **com.application.client.discovery.client.DiscoveryClientRestController**

## Run this project
* Start discovery server first. Refer [Discover Server](../eureka-discovery-server)
* Start application service. Refer [Application Service](../application-service)
* Import this project into IDE as Maven or Gradle project
* Run **com.application.client.App**
* Check URL **http://localhost:8761**
* We can see registered service with name **application-service**

## API
* Refer **files/application-client-1.postman_collection.json**

## Run using maven
```
mvn clean compile spring-boot:run
```

## Run using gradle
```
gradlew clean compileJava bootRun
```