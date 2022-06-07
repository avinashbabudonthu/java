# Using Request Scoped Beans

## Create project using maven
```
mvn archetype:generate -DgroupId=request.scopes.beans -DartifactId=request-scoped-beans -Dversion=1.0 -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
```

## Add gradle
```
gradle init --type pom
```

## Versions
* Maven **3.5.2**
* Gradle **5.0**

## Steps
* Add spring boot dependencies. Refer [pom.xml](pom.xml)
* Create bean class **request.scopes.beans.model.Student**
* Make bean as request scoped using following code. Refer **request.scopes.beans.config.AppConfig**
```
@Bean
@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
public Student student() {
	return new Student();
}
```
* proxyMode
```
The proxyMode attribute is necessary because, at the moment of the instantiation of the web application context, there is no active request. 
Spring will create a proxy to be injected as a dependency, and instantiate the target bean when it is needed in a request
```
* Inject **request.scopes.beans.model.Student** into **request.scopes.beans.controller.AppController**, **request.scopes.beans.service.AppServiceOne**, **request.scopes.beans.service.AppServiceTwo**
* With in the same request one bean will created. That mean will used in all injections.

## Run this project
* Import project into IDE as Maven or Gradle project
* Execute **request.scopes.beans.App** class in each package

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
java -jar target\request-scoped-beans.jar
```

## Create package using gradle
```
gradlew clean compileJava build
```

## Execute jar of Gradle
```
java -jar build\libs\request-scoped-beans-1.0.jar
```

## References
* [https://www.baeldung.com/spring-bean-scopes](https://www.baeldung.com/spring-bean-scopes)