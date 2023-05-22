# Dependency Injection using Java Annotations

## Create project using maven
```
mvn archetype:generate -DgroupId=dependency.inject.annoations -DartifactId=dependency-injection-annotations -Dversion=1.0 -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
```

## Add gradle
```
gradle init --type pom
```

## Versions
* Maven **3.5.2**
* Gradle **5.0**

## Dependencies
* junit:junit:4.12
* org.projectlombok:lombok:1.18.8
* org.slf4j:slf4j-api:1.7.28
* org.slf4j:slf4j-log4j12:1.7.28
* org.springframework:spring-core:5.1.9.RELEASE
* org.springframework:spring-context:5.1.9.RELEASE

## Examples
* [Setter dependency injection](src/main/java/dependency/injection/setter)
* [Constructor dependency injection](src/main/java/dependency/injection/constructor)
* [Properties injection](src/main/java/properties/injection)

## Run this project
* Import project into IDE as Maven or Gradle project
* Execute App class in each package
