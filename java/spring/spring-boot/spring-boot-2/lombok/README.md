# Spring Boot 2 integration Lombok

## Versions
* spring boot version **2.1.8.RELEASE**
* Maven version **3.6.2**
* Gradle version **5.0**

## Project creation steps
* Create project using maven
```
mvn archetype:generate -DgroupId=spring.boot2.lombok -DartifactId=lombok -Dversion=1.0 -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
```
* Add gradle
```
gradle init --type pom
```

## Dependencies
* spring-boot-starter-parent
* spring-boot-starter-web
* spring-boot-starter-test
* org.projectlombok:lombok

## Classes
* App
* AppController
* Student

## Enable lombok in maven
* Add **org.projectlombok:lombok**  dependency in pom.xml

## Enable lombok in gradle
* Add following dependencies
```
compile "org.projectlombok:lombok:1.18.4"
compileOnly "org.projectlombok:lombok:1.18.4"
testCompileOnly "org.projectlombok:lombok:1.18.4"
annotationProcessor "org.projectlombok:lombok:1.18.4"
testAnnotationProcessor "org.projectlombok:lombok:1.18.4"
```

## Steps to execute from IDE
* Import project to any IDE
* Execute App.java
* Should see application up and running
* Hit the url **http://localhost:9092/students**

## Steps to execute using maven
* Install maven in local
* Navigate to project in terminal
* Run command **mvn clean spring-boot:run**
* Hit the url **http://localhost:9092/students**

## Steps to execute using gradle
* Navigate to project in terminal
* Run command **gradlew clean compileJava bootRun**

## Create executable jar using maven and run it
* Create jar
```
mvn clean compile package
```
* Execute jar
```
java -jar target\lombok.jar
```

## Create executable jar using gradle and run it
* Create jar
```
gradlew clean compileJava build
```
* Execute jar
```
java -jar target\lombok.jar
```