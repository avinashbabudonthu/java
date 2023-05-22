# Mulitiple Profiles in Single Yaml File

* Problem Statement
* Declare all profile in one **application.yml** file
* Made one profile active by environment

## Create project using maven
```
mvn archetype:generate -DgroupId=multiple.profile.in.one.yaml -DartifactId=multiple-profile-in-one-yaml -Dversion=1.0 -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
```

## Add gradle
```
gradle init --type pom
```

## Steps
* Add spring boot dependencies. Refer [pom.xml](pom.xml) or [build.gradle](build.gradle)
* Create main class - [App.java](src/main/java/com/app/App.java)
* Create [application.yml](src/main/resources/application.yml)
* The three dashes separating the two profiles indicate the start of a new document so all the profiles can be described in the same YAML file

## API
* Refer [files/multiple-profile-in-one-yaml.postman_collection.json](files/multiple-profile-in-one-yaml.postman_collection.json)

## Run this project
* Import project into IDE as Maven or Gradle project
* Execute [src/main/java/com/app/App.java](src/main/java/com/app/App.java)

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
java -jar target\multiple-profile-in-one-yaml.jar
```

## Create package using gradle
```
gradlew clean compileJava build
```

## Execute jar of Gradle
```
java -jar build\libs\multiple-profile-in-one-yaml-1.0.jar
```

## References
* [https://www.baeldung.com/spring-yaml](https://www.baeldung.com/spring-yaml)
* [https://www.mkyong.com/spring-boot/spring-boot-yaml-example/](https://www.mkyong.com/spring-boot/spring-boot-yaml-example/)