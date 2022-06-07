# Spring Boot Hateoas

## Requirement
* When we insert new record in DB return API path to get that record in response headers
* When we call any API return related HATEOAS link

## Maven command
```
mvn archetype:generate -DgroupId=spring.boot.hateoas -DartifactId=spring-boot-hateoas -Dversion=1.0 -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
```

## Gradle command
```
gradle init --type pom
```

## HATEOAS updates in latest realse of spring hateoas 1.0.0
### Spring Boot Release >= 2.2.0
```
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.ControllerLinkBuilder;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder; 

@GetMapping("/users/{id}")
public EntityModel<User> findUserById(@PathVariable int id) {
	User user = service.findOne(id);
	
	EntityModel<User> model = new EntityModel<>(user); 
	WebMvcLinkBuilder linkTo = WebMvcLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(this.getClass()).findAllUsers());
	model.add(linkTo.withRel("all-users"));
 
	return model;
}
```
### Older versions
```
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
 
Resource<User> resource = new Resource<User>(user);
ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAllUsers());
resource.add(linkTo.withRel("all-users"));
return resource;
```

## Files
* [AppController.java](src/main/java/spring/boot/hateoas/controller/AppController.java)
* Dependencies - [pom.xml](pom.xml) (or) [build.gradle](build.gradle)

## When we insert new record in DB return API path to get that record in response headers
* Refer `saveStudent()` method in [AppController.java](src/main/java/spring/boot/hateoas/controller/AppController.java)
```
URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
```

## When we call any API return related HATEOAS link
* Refer `findStudent(..)` method in [AppController.java](src/main/java/spring/boot/hateoas/controller/AppController.java)
```
Resource<Student> resource = new Resource<>(resultStudent);
ControllerLinkBuilder linkTo = ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(this.getClass()).findAllStudent());
resource.add(linkTo.withRel("find-all-students"));
```

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
java -jar target\spring-boot-hateoas.jar
```

## Create package using gradle
```
gradlew clean compileJava build
```

## Execute jar of Gradle
```
java -jar build\libs\spring-boot-hateoas-1.0.jar
```