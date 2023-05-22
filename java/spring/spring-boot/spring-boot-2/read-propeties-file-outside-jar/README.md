# Spring Boot 2 Read Properties file that is outside jar

## Requirement
* Read properties file
* Properties file is not part jar
* Properties file path should be passed as VM argument while starting the application

## Create project using maven
```
mvn archetype:generate -DgroupId=read.properties.outside.jar -DartifactId=read-propeties-file-outside-jar -Dversion=1.0 -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
```

## Add gradle
```
gradle init --type pom
```

## Steps
* Add spring boot dependencies. Refer [pom.xml](pom.xml)
* Declare annotation **org.springframework.context.annotation.PropertySource** on main class [App.java](src/main/java/read/properties/outside/jar/App.java)
* Pass JVM argument **app.properties.file** while executing jar
```
-Dapp.properties.file=[projection-location]\files\application.properties
```

## API
* Refer [read-propeties-file-outside-jar.postman_collection.json](files/read-propeties-file-outside-jar.postman_collection.json)

## Run From Eclipse/STS
* Right click on [App.java](src/main/java/read/properties/outside/jar/App.java)
* Run As - Run Configurations
* Arguments tab - VM arguments
* Give **-Dapp.properties.file=[projection-location]\files\application.properties**
* Click on **Apply** - **Run**
* Tomcat should be started on port **9000**

## Run using Maven
* Create jar
```
mvn clean compile package
```
* Execute jar
```
java -jar -Dapp.properties.file=[projection-location]\files\application.properties target\read-propeties-file-outside-jar.jar
```

## Run using Gradle
* Create jar
```
gradlew clean compileJava build
```
* Execute jar
```
java -jar -Dapp.properties.file=[projection-location]\files\application.properties build\libs\read-propeties-file-outside-jar-1.0.jar
```

## Using spring.config.location
* Remove **org.springframework.context.annotation.PropertySource** annotation from **read.properties.outside.jar.App**
* Create jar using maven or gradle
* Execute maven jar
```
java -jar target\read-propeties-file-outside-jar.jar --spring.config.location=file:///[projection-location]\files\application.properties
```
* Execute gradle jar
```
java -jar build\libs\read-propeties-file-outside-jar-1.0.jar --spring.config.location=file:///[projection-location]\files\application.properties
```
* We can pass multiple properties with comma(,) separated
```
java -jar build\libs\read-propeties-file-outside-jar-1.0.jar --spring.config.location=file:///[projection-location]\files\application1.properties, [projection-location]\files\application2.properties
```

## References
* [https://www.baeldung.com/spring-properties-file-outside-jar](https://www.baeldung.com/spring-properties-file-outside-jar)