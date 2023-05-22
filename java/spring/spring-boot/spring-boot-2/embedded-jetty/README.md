# Spring Boot 2 application with Embedded Jetty Server

## Create project using maven
```
mvn archetype:generate -DgroupId=embedded.jetty -DartifactId=embedded-jetty -Dversion=1.0 -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
```

## Add gradle
```
gradle init --type pom
```

## Versions
* Maven **3.5.2**
* Gradle **5.0**

## Steps in Maven
* Exclude **spring-boot-starter-tomcat** from **spring-boot-starter-web**
```
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-web</artifactId>
	<exclusions>
		<exclusion>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-tomcat</artifactId>
		</exclusion>
	</exclusions>
</dependency>
```
* Add **spring-boot-starter-jetty** dependency
```
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-jetty</artifactId>
</dependency>
```
* Refer [pom.xml](pom.xml)

## Steps in Gradle
* Exclude **spring-boot-starter-tomcat** module
```
configurations{
	compile.exclude module: "spring-boot-starter-tomcat"
}
```
* Add **spring-boot-starter-jetty** dependency
```
compile "org.springframework.boot:spring-boot-starter-jetty"
```
* Refer [build.gradle](build.gradle)

## Run this project
* Import project into IDE as Maven or Gradle project
* Execute App class in each package
* Hit GET API **http://localhost:9090/actuator**

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

## Create package using gradle
```
gradlew clean compileJava build
```

## Execute jar of Maven
```
java -jar target\embedded-jetty.jar
```

## Execute jar of Gradle
```
java -jar build\libs\embedded-jetty.jar
```