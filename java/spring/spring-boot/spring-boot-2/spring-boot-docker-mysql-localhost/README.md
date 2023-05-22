# Spring Boot Docker Container Connecting To MySQL Running in Local or AWS RDS

## Requirement
* Create Spring Boot Application
* Connect to MySQL Running in local with profile `localhost`
* Connect to MySQL Running in local from docker container with profile `docker-container-mysql-localhost`
* Connect to MySQL Running in AWS RDS with profile `test`
* Create docker image and start the container
* Should be able to execute queries and get response

## Connection to MySQL in local from docker container
* Use `host.docker.internal` instead of `localhost`
```
datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://host.docker.internal:3306/practice?useSSL=false&verifyServerCertificate=false&noAccessToProcedureBodies=true
    username: practice_admin
    password: practice_admin
```

## Maven Command
```
mvn archetype:generate -DgroupId=com.spring.boot.docker.mysql-localhost -DartifactId=spring-boot-docker-mysql-localhost -Dversion=1.0 -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false 
```

## Gradle Command
```
gradle init --type pom
```

## Steps
* Dependencies - Refer [pom.xml](pom.xml) or [build.gradle](build.gradle)

## API
* Refer [files/spring-boot-docker-mysql-localhost.postman_collection.json](files/spring-boot-docker-mysql-localhost.postman_collection.json)

## Run from IDE
* Import project into IDE as Maven or Gradle project
* Execute [App.java](src/main/java/com/app/App.java)

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
java -jar target\spring-boot-docker-mysql-localhost.jar
```

## Create package using gradle
```
gradlew clean compileJava build
```

## Execute jar of Gradle
```
java -jar build\libs\spring-boot-docker-mysql-localhost-1.0.jar
```

## Run with docker container
* set `spring.profiles.active` value in [application.yml](src/main/resources/application.yml) to `docker-container-mysql-localhost`
* Create package
```
mvn clean compile package
```
* Navigate to project folder in cmd. Create docker image with below command
```
docker build . -t spring-boot-docker-mysql-localhost
```
* Check images
```
docker images
```
* Run docker container
```
docker run -it -p 9000:9000 spring-boot-docker-mysql-localhost 
```

## Other useful docker commands
* Check running docker container
```
docker ps
```
* Check all docker containers
```
docker ps --all
```
* Remove docker container
```
docker rm [container-id]
```
* Remove docker image
```
docker rmi spring-boot-docker-mysql-localhost
```