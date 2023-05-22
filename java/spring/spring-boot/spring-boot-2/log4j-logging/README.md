# Spring Boot 2 Logging with Log4J, SLF4, Lombok

## Requirement
* Use Log4J2.xml for logging
* Use Log4J with SLF4J
* Use SLF4J with Lombok

## Create project using maven
```
mvn archetype:generate -DgroupId=log4j.logging -DartifactId=log4j-logging -Dversion=1.0 -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
```

## Add gradle
```
gradle init --type pom
```

## Steps
* Import project into IDE as Maven or Gradle project
* Maven - exclude **spring-boot-starter-logging** from **spring-boot-starter**. Refer [pom.xml](pom.xml)
```
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter</artifactId>
	<exclusions>
		<exclusion>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-logging</artifactId>
		</exclusion>
	</exclusions>
</dependency>
```
* Add **spring-boot-starter-log4j2** dependency
```
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-log4j2</artifactId>
</dependency>
```
* Gradle exclude **spring-boot-starter-logging** module. Refer [build.gradle](build.gradle)
```
configurations{
	compile.exclude module: "spring-boot-starter-logging"
}
```
* Add **spring-boot-starter-log4j2** dependency
```
compile "org.springframework.boot:spring-boot-starter-log4j2"
```
* Add [log4j2.xml](src/main/resources/log4j2.xml) in **src/main/resources**
* Execute [App.java](src/main/java/log4j/logging/App.java)
* Hit GET API **http://localhost:9000/actuator**

## API
* Refer [files/log4j-logging.postman_collection.json](files/log4j-logging.postman_collection.json)

## Run using maven
```
mvn clean compile spring-boot:run
```

## Run using gradle
```
gradlew clean compileJava bootRun
```

## Create package using Maven
```
mvn clean compile package
```

## Execute jar of Maven
```
java -jar target\log4j-logging.jar
```

## Create package using Gradle
```
gradlew clean compileJava build
```

## Execute jar of Gradle
```
java -jar build\libs\log4j-logging.jar
```

## Asynchronous Loggers
* Add **lmax disruptor** dependency
```
<dependency>
	<groupId>com.lmax</groupId>
	<artifactId>disruptor</artifactId>
	<version>3.4.2</version>
</dependency>
```
* Set the System property
```
log4j2.contextSelector=org.apache.logging.log4j.core.async.AsyncLoggerContextSelector
```
* Executing jar by passing system property
```
java -Dlog4j2.contextSelector=org.apache.logging.log4j.core.async.AsyncLoggerContextSelector -jar target/log4j-logging.jar
```

## Use log4j.xml out side jar
* Give location of log4j xml file while running jar **logging.config**
```
java -jar -Dlogging.config=[path]\log4j2.xml target\log4j-logging.jar
```