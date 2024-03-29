# Spring Boot Spring Security Custom Credentials with InMemoryUserDetailsManager
* Add spring security dependency in [pom.xml](pom.xml)
* Properties - [application.properties](src/main/resources/application.properties)
* Create `InMemoryUserDetailsManager` bean - [AppConfig.java](src/main/java/com/java/config/AppConfig.java)
  * inMemoryUserDetailsManager() - with default password encoder
  * inMemoryUserDetailsManager2() - with custom password encoder - creating 1 user
  * * inMemoryUserDetailsManager3() - with custom password encoder - creating multiple user
* Controller class - [AppController.java](src/main/java/com/java/controller/AppController.java)
* Main class - [App.java](src/main/java/com/java/App.java)
* Start the application
* If using default password encoder, user credentials 
  * http://localhost:9000/api/v1/students
  * username - admin
  * password - dummy
* If using custom password encoder, user credentials
  * http://localhost:9000/api/v1/students
  * username - admin2
  * password - dummy2
* Import [Postman collection](postman/custom-creds-in-memory-user-details.postman_collection.json) for APIs
------
# Reference Documentation
For further reference, please consider the following sections:
* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.1.1/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.1.1/maven-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/3.1.1/reference/htmlsingle/#web)
* [Spring Boot Actuator](https://docs.spring.io/spring-boot/docs/3.1.1/reference/htmlsingle/#actuator)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/3.1.1/reference/htmlsingle/#using.devtools)
* [Spring Security](https://docs.spring.io/spring-boot/docs/3.1.1/reference/htmlsingle/#web.security)
------
# Guides
The following guides illustrate how to use some features concretely:
* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
* [Building a RESTful Web Service with Spring Boot Actuator](https://spring.io/guides/gs/actuator-service/)
* [Securing a Web Application](https://spring.io/guides/gs/securing-web/)
* [Spring Boot and OAuth2](https://spring.io/guides/tutorials/spring-boot-oauth2/)
* [Authenticating a User with LDAP](https://spring.io/guides/gs/authenticating-ldap/)