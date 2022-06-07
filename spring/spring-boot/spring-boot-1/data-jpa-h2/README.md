# Sprint Boot 1 Hello World Example

## Create project using below maven command
```
mvn archetype:generate -DgroupId=data.jpa.h2 -DartifactId=data-jpa-h2 -Dversion=1.0 -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
```

## Make project gradle support using following command
```
gradle init --type pom
```

## Dependencies
* spring-boot-starter-parent:1.5.22.RELEASE
* spring-boot-starter-web
* spring-boot-starter-data-jpa
* com.h2database:h2
* org.projectlombok:lombok:1.18.8

## Classes
* Main class: **App**

## Run application from IDE
* Import project to IDE
* Execute **data.jpa.h2.App**
* Application should be up and running at port 9191

## Run with maven
* Install maven in local
* Go to project location in terminal
* Run the following command
```
mvn clean compile spring-boot:run
```

## Run with gradle
* Go to project location in terminal
* Run the following command
```
gradlew clean compileJava bootRun
```

## Run executable jar created by maven
* Create jar using following command
```
mvn clean compile package
```
* Execute the jar using following command
```
java -jar target\data-jpa-h2.jar
```

## Run executable jar created by gradle
* Create jar using following command
```
gradlew clean compileJava build
```
* Execute jar file
```
java -jar build\libs\data-jpa-h2.jar
```