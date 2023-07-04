# Spring Boot 3 Hello World application
* Add spring boot 3 dependencies - [pom.xml](pom.xml)
* Update tomcat server port - [application.yml](src/main/resources/application.yml)
* Main class - [App.java](src/main/java/com/java/App.java)
* Controller class - [GetController.java](src/main/java/com/java/controller/GetController.java)
* postman collection - [postman collection](postman)
* Start the main class. Application will be running in port `9000`
* Hit the APIs in postman collection

# Setup logging level of any package
* For example setup package level of `org.springframework`
```
logging.level.org.springframework: debug
```

# Enable more end points from spring boot actuator
* Add below property
```
management.endpoints.web.exposure.include: '*'
```
* If specific only needed. For example `health`, `metrics`
```
management.endpoints.web.exposure.include: health,metrics
```