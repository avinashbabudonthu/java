# Dependency Injection using Xml

## Create project using maven
```
mvn archetype:generate -DgroupId=command.line.runner -DartifactId=command-line-runner -Dversion=1.0 -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
```

## Add gradle
```
gradle init --type pom
```

## Versions
* Maven **3.5.2**
* Gradle **5.0**

## Steps
* Add spring boot dependencies. Refer [pom.xml](pom.xml) or [build.gradle](build.gradle)
* Create configuration class **command.line.runner.config.AppConfig**. Declare following bean
```
@Bean
public CommandLineRunner initialize() {
	log.info("initializing");

	return (args) -> {
		Student student = studentService.findStudent();
		log.info("student id={}, name={}", student.getId(), student.getName());
	};
}
```
* Run main class **command.line.runner.App**
* We can see following output in console
```
student id=1, name=jack
```

## Run this project
* Import project into IDE as Maven or Gradle project
* Execute main class **command.line.runner.App**

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
java -jar target\command-line-runner.jar
```

## Create package using gradle
```
gradlew clean compileJava build
```

## Execute jar of Gradle
```
java -jar build\libs\command-line-runner-1.0.jar
```