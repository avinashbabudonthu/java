# Spring Boot 1 Https

* Problem Statement
```
Enable Https to Spring Boot 1 Application
```

## Create project using maven
```
mvn archetype:generate -DgroupId=com.spring.boot.https -DartifactId=https -Dversion=1.0 -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
```

## Add gradle
```
gradle init --type pom
```
## Steps
* Add spring boot dependencies. Refer [pom.xml](pom.xml) or [build.gradle](build.gradle)
* Create self signed jks file using below command
```
keytool -genkey -alias selfsigned_localhost_sslserver -keyalg RSA -keysize 2048 -validity 700 -keypass changeit -storepass changeit -keystore ssl-server.jks
```
* Above command will generate **ssl-server.jks** file. Copy this file to [src/main/resources](src/main/resources)
* Add following properties in [src/main/resources/application.properties](src/main/resources/application.properties)
```
server.port=8443
server.ssl.key-alias=selfsigned_localhost_sslserver
server.ssl.key-password=changeit
server.ssl.key-store=classpath:ssl-server.jks
server.ssl.key-store-provider=SUN
server.ssl.key-store-type=JKS
```
* Create [src/main/java/com/spring/boot/https/controller/AppController.java](src/main/java/com/spring/boot/https/controller/AppController.java)
* Write GET API **/secured**
* Run [src/main/java/com/spring/boot/https/App.java](src/main/java/com/spring/boot/https/App.java)
* Open browser and hit URL **[https://localhost:8443/secured](https://localhost:8443/secured)**

### To redirect http calls to https
* Create **EmbeddedServletContainerFactory** bean. Refer [src/main/java/com/spring/boot/https/config/AppConfig.java](src/main/java/com/spring/boot/https/config/AppConfig.java)
* Open browser and hit URL **[http://localhost:8080/secured](http://localhost:8080/secured)**

## Run this project
* Import project into IDE as Maven or Gradle project
* Execute [src/main/java/com/spring/boot/https/App.java](src/main/java/com/spring/boot/https/App.java)

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
java -jar target\https.jar
```

## Create package using gradle
```
gradlew clean compileJava build
```

## Execute jar of Gradle
```
java -jar build\libs\https.jar
```