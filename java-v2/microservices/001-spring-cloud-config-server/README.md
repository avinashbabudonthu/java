### [<<Back](../README.md) | [Java V2 All Examples](https://github.com/avinashbabudonthu/java/blob/master/java-v2/README.md) | [Java All Examples](https://github.com/avinashbabudonthu/java/blob/master/README.md)
------
# Requirement
* Create spring cloud config server
* Configure spring cloud config server to configure properties in github repo
* Create spring cloud config client
* Connect with spring cloud config server
* Get properties from spring cloud config server
------
# Create spring cloud config server
* Refer [spring-cloud-config-server](spring-cloud-config-server)
* Create spring boot 3 project using - https://start.spring.io/
* Add dependencies - web, actuator, config server
* Add below properties in application.properties. Refer [spring-cloud-config-server/application.properties](spring-cloud-config-server/src/main/resources/application.properties)
```
spring.application.name=spring-cloud-config-server
server.port=8888

#spring.cloud.config.server.git.uri=file:///C:/github/spring-cloud-config
spring.cloud.config.server.git.uri=https://github.com/avinashbabudonthu/spring-cloud-config
#spring.cloud.config.server.git.username=username
#spring.cloud.config.server.git.password=password
spring.cloud.config.server.git.default-label=main
spring.cloud.config.server.git.skipSslValidation=true
# default is 5 milli seconds
spring.cloud.config.server.git.timeout=10
```
* Add `org.springframework.cloud.config.server.EnableConfigServer` annotation to Main class. Refer [Main](spring-cloud-config-server/src/main/java/com/java/Main.java)
------
# Create spring cloud config client
* Refer [student-service](student-service)
* Create spring boot 3 project using - https://start.spring.io/
* Add dependencies - web, actuator, devtools, config client
* Add below properties. Refer [student-service/application.properties](student-service/src/main/resources/application.properties)
```
spring.application.name=student-service
server.port=8001

spring.config.import=optional:configserver:http://localhost:8888
spring.cloud.config.profile=dev
```
* Refer classes in [student-service](student-service)
------
# Spring cloud config repo
* Create new repo - https://github.com/avinashbabudonthu/spring-cloud-config
* Add student-services properties by environment
------
### [<<Back](../README.md) | [Java V2 All Examples](https://github.com/avinashbabudonthu/java/blob/master/java-v2/README.md) | [Java All Examples](https://github.com/avinashbabudonthu/java/blob/master/README.md)