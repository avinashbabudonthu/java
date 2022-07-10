# Microservice Hystrix

## Requirement
* If microservice fails return default response using Hystrix
* This acts as fault tolerance

## Student Service
* Project folder - [student-service](student-service)
* Create project using maven Command
```
mvn archetype:generate -DgroupId=com.student.service -DartifactId=student-service -Dversion=1.0 -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
```
* Add gradle. Execute from `student-service` folder
```
gradle init --type pom
```
* For maven add following - refer [student-service/pom.xml](student-service/pom.xml)
```
<dependencyManagement>
	<dependencies>
		<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-dependencies</artifactId>
			<version>Greenwich.SR3</version>
			<type>pom</type>
			<scope>import</scope>
		</dependency>
	</dependencies>
</dependencyManagement>

<dependency>
	<groupId>org.springframework.cloud</groupId>
	<artifactId>spring-cloud-starter-netflix-hystrix</artifactId>
</dependency>
```
* For gradle add following - refer [student-service/build.gradle](student-service/build.gradle)
```
ext {
	set('springCloudVersion', "Greenwich.SR3")
}

dependencyManagement {
	imports {
		mavenBom "org.springframework.cloud:spring-cloud-dependencies:${springCloudVersion}"
	}
}

compile 'org.springframework.cloud:spring-cloud-starter-netflix-hystrix'
```
* Add `@EnableHystrix` on main class - [App.java](student-service/src/main/java/com/student/service/App.java)
* Add `@HystrixCommand(fallbackMethod = "fallbackFindAllStudents")` annotation on API method
	* [AppController.java](student-service/src/main/java/com/student/service/controller/AppController.java)
		* `findAllStudent` method
	* `fallbackFindAllStudents` is fall back method of actual API which called on exception. Write that method in [AppController.java](student-service/src/main/java/com/student/service/controller/AppController.java)
		* `fallbackFindAllStudents` method returning default values
		
## API
* [hystrix.postman_collection.json](files/hystrix.postman_collection.json)
* Import this to local postman
* HIT API `students-throws-exception`