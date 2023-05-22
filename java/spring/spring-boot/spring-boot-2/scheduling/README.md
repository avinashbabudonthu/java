# Spring Boot Scheduler Hello World

# Maven command
```
mvn archetype:generate -DgroupId=scheduling -DartifactId=scheduling -Dversion=1.0 -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false 
```

# Gradle command
```
gradle init --type pom
```

## Steps
* Add spring boot dependencies. Refer [pom.xml](pom.xml) or [build.gradle](build.gradle)
* Declare annotation 
	* `org.springframework.scheduling.annotation.EnableScheduling` on main class [src/main/java/scheduling/App.java](src/main/java/scheduling/App.java)

# Cron Scheduling Component
* User define scheduler with cron expression
* Refer [src/main/java/scheduling/component/CronComponent.java](src/main/java/scheduling/component/CronComponent.java)

# Fixed Rate Scheduling Component
* Fixed Rate scheduler is used to execute the tasks at the specific time. It does not wait for the completion of previous task. The values should be in milliseconds
* Refer [src/main/java/scheduling/component/FixedRateComponent.java](src/main/java/scheduling/component/FixedRateComponent.java)

# Fixed Delay Scheduling Component
* Fixed Delay scheduler is used to execute the tasks at a specific time. It should wait for the previous task completion. The values should be in milliseconds.
* Refer [src/main/java/scheduling/component/FixedDelayComponent.java](src/main/java/scheduling/component/FixedDelayComponent.java)

# Run this project
* Import project into IDE as Maven or Gradle project
* Execute [src/main/java/scheduling/App.java](src/main/java/scheduling/App.java)

# Run using maven
```
mvn clean compile spring-boot:run
```

# Run using gradle
```
gradlew clean compileJava bootRun
```

# Create package using maven
```
mvn clean compile package
```

# Execute jar of Maven
```
java -jar target\scheduling.jar
```

# Create package using gradle
```
gradlew clean compileJava build
```

# Execute jar of Gradle
```
java -jar build\libs\scheduling-1.0.jar
```
