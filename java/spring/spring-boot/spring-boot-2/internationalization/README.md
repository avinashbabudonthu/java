# Spring Boot 2 Internationalization

## Maven command
```
mvn archetype:generate -DgroupId=internationalization -DartifactId=internationalization -Dversion=1.0 -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
```

## Gradle command
```
gradle init --type pom
```

## Solution 1
* Dependencies - Refer [pom.xml](pom.xml) (or) [build.gradle](build.gradle)
* Add [application.yml](src/main/resources/application.yml)
* Add [log4j.properties](src/main/resources/log4j.properties)
* Add [messages.properties](src/main/resources/messages.properties) for english messages
* Add [messages_fr.properties](src/main/resources/messages_fr.properties) for french messages
* Create `LocaleResolver` and `ResourceBundleMessageSource` beans. Refer [AppConfig.java](src/main/java/internationalization/config/AppConfig.java)
* Inject `MessageSource` to [AppController](src/main/java/internationalization/controller/AppController.java)
* Pass required `Locale` as `Accept-Language` header. Get message using `messageSource.getMessage`
```
@RequestHeader(name = "Accept-Language", required = false) Locale locale
```
* Refer `greeting` method in [AppController](src/main/java/internationalization/controller/AppController.java)
* Pass `Accept-Language` header while calling API

## Solution 2
* Create `AcceptHeaderLocaleResolver` bean. Refer [AppConfig2.java](src/main/java/internationalization/config/AppConfig2.java)
* Give following entry in [application.yml](src/main/resources/application.yml)
```
spring.messages.basename: messages
```
* Get local using following code in [AppController.java](src/main/java/internationalization/controller/AppController.java) - Refer method `greeting2`
```
LocaleContextHolder.getLocale()
```
* Pass `Accept-Language` header while calling API 

## API
* [postman-colleciton](files/internationalization.postman_collection.json)

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
java -jar target\internationalization.jar
```

## Create package using gradle
```
gradlew clean compileJava build
```

## Execute jar of Gradle
```
java -jar build\libs\internationalization-1.0.jar
```