# Dependency Injection using Xml

## Create project using maven
```
mvn archetype:generate -DgroupId=spring.boot.profiles -DartifactId=profiles -Dversion=1.0 -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
```

## Add gradle
```
gradle init --type pom
```

## Dependencies
* Refer [pom.xml](pom.xml) or [build.gradle](build.gradle)

## Steps with properties files
* Copy properties from [files/properties](files/properties) to [src/main/resources](src/main/resources)
* Change [spring.profiles.active] to `dev` and start the application. Run [App.java](src/main/java/spring/boot/profiles/App.java)
	* Now application will start in `9090`
* Change [spring.profiles.active] to `test` and start the application. Run [App.java](src/main/java/spring/boot/profiles/App.java)
	* Now application will start in `9091`
* Change [spring.profiles.active] to `prod` and start the application. Run [App.java](src/main/java/spring/boot/profiles/App.java)
	* Now application will start in `9092`
	
## Steps with yaml file
* Copy `application.yml` from [files/yaml](files/yaml) to [src/main/resources](src/main/resources)
* Change `spring.profiles.active` property value to - `default`, `dev`, `test`, `prod`
* Run [App.java](src/main/java/spring/boot/profiles/App.java)
* We can see application running in different port based on active profile

## Run this project
* Import project into IDE as Maven or Gradle project
* Execute [App.java](src/main/java/spring/boot/profiles/App.java)

## Run using maven
```
mvn clean compile spring-boot:run
```
```
mvn clean compile spring-boot:run -Dspring-boot.run.arguments=--spring.profiles.active=dev
```

## Run using gradle
```
gradlew clean compileJava bootRun
```
```
gradlew clean compileJava bootRun -Dspring-boot.run.arguments=--spring.profiles.active=dev
```

## Execute jar created with maven
* Package with maven
```
mvn clean compile package
```
* Execute jar
```
java -jar -Dspring.profiles.active=dev target/profiles.jar
```

## Execute jar created with gradle
* Package with maven
```
gradlew clean build
```
* Execute jar
```
java -jar -Dspring.profiles.active=dev build/libs/profiles.jar
```