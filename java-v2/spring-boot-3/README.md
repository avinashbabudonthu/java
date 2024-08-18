### [<<Back](../README.md) | [Java V2 All Examples](https://github.com/avinashbabudonthu/java/blob/master/java-v2/README.md) | [Java All Examples](https://github.com/avinashbabudonthu/java/blob/master/README.md)
------
# Spring Boot 3
* [Create Spring Boot 3 Project](../maven/files/create-spring-boot-3-project.md)
* [Dependencies](files/dependencies.md)
* [Hello World](hello-world)
* [Random Port](random-port)
* [REST API](rest-api)
* [REST API Swagger Spring Doc Open API Documentation](rest-api/#Swagger-Spring-Doc-Open-API-Documentation)
* [Build docker image and push to docker hub](rest-api/#Build-docker-image-and-push-to-docker-hub)
* To create schema on start of application. Add this file in `src/main/resources`
```
schema.sql
```
* To insert data on start of application. Add this file in `src/main/resources`
```
data.sql

Add this property in application.properties file otherwise table data will be deleted on creating entities
spring.jpa.hibernate.ddl-auto=none
```
* [Kafka Streams Spring Boot 3](../kafka-streams/kafka-streams-spring-boot-3-001)
------
### [<<Back](../README.md) | [Java V2 All Examples](https://github.com/avinashbabudonthu/java/blob/master/java-v2/README.md) | [Java All Examples](https://github.com/avinashbabudonthu/java/blob/master/README.md)