# Exception Handling 

## Maven command
```
mvn archetype:generate -DgroupId=exception.handling.reponsestatus.annotation -DartifactId=exception-handling-response-status-annotation -Dversion=1.0 -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
```

## Add gradle
```
gradle init --type pom
```

## Steps
* Add spring boot dependencies. Refer [pom.xml](pom.xml) or [build.gradle](build.gradle)
* Create custom exception classes. Refer [src/main/java/exception/handling/reponsestatus/annotation/exception/model](src/main/java/exception/handling/reponsestatus/annotation/exception/model)
	* Add `org.springframework.web.bind.annotation.ResponseStatus` annotation
	* [InvalidObjectException](src/main/java/exception/handling/reponsestatus/annotation/exception/model/InvalidObjectException.java)
	* [ObjectNotFoundException](src/main/java/exception/handling/reponsestatus/annotation/exception/model/ObjectNotFoundException.java) 
* Throw exception objects based on validations
	* Refer [src/main/java/exception/handling/reponsestatus/annotation/controller/AppController.java](src/main/java/exception/handling/reponsestatus/annotation/controller/AppController.java)
		* [src/main/java/exception/handling/reponsestatus/annotation/utils/Utils.java](src/main/java/exception/handling/reponsestatus/annotation/utils/Utils.java)
			* throwObjectNotFound()
			* throwInvalidObjectException() 

## API
* Refer [files/exception-handling-response-status-annotation.postman_collection.json](files/exception-handling-response-status-annotation.postman_collection.json)

## Run this project
* Import project into IDE as Maven or Gradle project
* Execute [App.java](src/main/java/exception/handling/reponsestatus/annotation/App.java)

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
java -jar target\exception-handling-response-status-annotation.jar
```

## Create package using gradle
```
gradlew clean compileJava build
```

## Execute jar of Gradle
```
java -jar build\libs\exception-handling-response-status-annotation-1.0.jar
```