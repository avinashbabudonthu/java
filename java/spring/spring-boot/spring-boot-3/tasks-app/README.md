# Tasks Web Application using Spring Boot 3
# Tech Stack
* JDK 17
* Maven
* Spring Boot 3
* JSP
------
# Steps
* Refer dependencies in [pom.xml](pom.xml)
* Main class - [TasksApplication](src/main/java/com/tasks/TasksAppApplication.java)
* Test Rest Controller - [HelloRestController](src/main/java/com/tasks/controller/HelloRestController.java)
* Test Controller - [HelloController](src/main/java/com/tasks/controller/HelloController.java)
* Properties - [application.properties](src/main/resources/application.properties)
------
# Display JSP
* Add below dependency in [pom.xml](pom.xml)
```
<dependency>
    <groupId>org.apache.tomcat.embed</groupId>
    <artifactId>tomcat-embed-jasper</artifactId>
</dependency>
```
* Create below folder structure in `src/main/resources`. Total path looks as below
```
/src/main/resources/META-INF/resources/WEB-INF/jsp/
```
* Create jsp page in above jsp folder - [sayHello.jsp](src/main/resources/META-INF/resources/WEB-INF/jsp/sayHello.jsp)
* Add prefix and suffix properties in [application.properties](src/main/resources/application.properties)
```
spring.mvc.view.prefix=/WEB-INF/jsp/
spring.mvc.view.suffix=.jsp
```
* Write method in `@Controller` class and return jsp name. [HelloController](src/main/java/com/tasks/controller/HelloController.java) - `hello2Jsp` method
* Start application and hit url in browser - http://localhost:9000/hello2-jsp
------
# Login page
* Add [login.jsp](src/main/resources/META-INF/resources/WEB-INF/jsp/login.jsp) in `src/main/resources/META-INF/resources/WEB-INF/jsp`
* Write [LoginController](src/main/java/com/tasks/controller/LoginController.java). Method `login` and return `login` jsp name
* Start application and hit url in browser - http://localhost:9000/login
------
# Login with request param
* Add [login2.jsp](src/main/resources/META-INF/resources/WEB-INF/jsp/login2.jsp) in `src/main/resources/META-INF/resources/WEB-INF/jsp`
* Write [LoginController](src/main/java/com/tasks/controller/LoginController.java). Method `login2` and return `login2` jsp name
* `login2` method takes `RequestParam` and `ModelMap` as arguments
* We need to put values into `ModelMap` to use in jsp. Kept `name` value in `ModelMap`
* Using `name` in [login2.jsp](src/main/resources/META-INF/resources/WEB-INF/jsp/login2.jsp) as `${name}`
* * Start application and hit url in browser - http://localhost:9000/login2?name=Ram
------
# Final Login page
* Create [login3.jsp](src/main/resources/META-INF/resources/WEB-INF/jsp/login3.jsp)
* write [LoginController](src/main/java/com/tasks/controller/LoginController.java). Method `login3` and return `login3` jsp name
* Write [AuthenticationService](src/main/java/com/tasks/service/AuthenticationService.java)
* write [LoginController](src/main/java/com/tasks/controller/LoginController.java). Method `gotToWelcome` and return `welcome` jsp name
  * Validates entered credentials then either return `welcome` or `login` page
* Open url - http://localhost:9000/login3
------
# SessionAttributes
* We added `name` to `ModelMap` while navigating to `welcome` page
* Navigate `welcome` to `tasks` page then `name` won't come
* We need to declare `SessionAttributes` in [LoginController](src/main/java/com/tasks/controller/LoginController.java) and [TaskController](src/main/java/com/tasks/controller/TaskController.java)
* Then `name` property will be in `session` scope
* Open url - http://localhost:9000/login3
* Enter credentials - admin/dummy
* Navigates `welcome` page, we can see name
* Click on `Tasks` link. Navigates to `Tasks` page. we can see name
* Now name will come in pages - `welcome`, `tasks`
