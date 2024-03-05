# Materials
* Udemy - MongoDB with Java Spring Boot & Spring Framework
* https://www.baeldung.com/spring-data-mongodb-tutorial
* Spring Data Mongo: Getting Started
------
# Project setup
* Project - [spring-data-mongo](spring-data-mongo)
* Add following dependency in [pom.xml](spring-data-mongo/pom.xml)
```
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-data-mongodb</artifactId>
</dependency>
```
* Add below properties in [application.yml](spring-data-mongo/src/main/resources/application.yml)
```
spring:
  data:
    mongodb:
      host: localhost
      port: 27017
      database: database1
```
* Write repository interface extends `org.springframework.data.mongodb.repository.MongoRepository`. Refer [StudentRepository](spring-data-mongo/src/main/java/com/app/repository/StudentRepository.java)
* [StudentRepository](spring-data-mongo/src/main/java/com/app/repository/StudentRepository.java)
* [StudentService](spring-data-mongo/src/main/java/com/app/service/StudentService.java)
* [Postman collection](spring-data-mongo/files/spring-data-mongo.postman_collection.json)
* APIs - refer [StudentController](spring-data-mongo/src/main/java/com/app/controller/StudentController.java)
	* /save-student
	* /student-by-id/{id}
	* /all-students
	* /delete-student-by-id/{id}
	* /students-by-name/{name}
	* /students-by-name-email
	* /students-by-name-or-email
	* /all-students-pagination
	* /all-students-with-sorting
	* /all-students-by-department-name
	* /all-students-by-email-like
	* /all-students-name-starting-with
	* /students-by-name-native-query/{name}
------
# Print mongo queries in logging
* Add below property in application.properties/yaml in spring boot project. Refer - [application.yml](spring-data-mongo/src/main/resources/application.yml)
```
logging.level.org.springframework.data.mongodb.core.MongoTemplate: DEBUG
```
* Output
```
o.s.data.mongodb.core.MongoTemplate      : find using query: { } fields: Document{{}} for class: class com.app.entity.Student in collection: student

o.s.data.mongodb.core.MongoTemplate      : find using query: { "name" : "Ana" } fields: Document{{}} for class: class com.app.entity.Student in collection: student
```
* Reference - https://www.baeldung.com/spring-boot-mongodb-logging
------
# Relatioship between collections
* use `org.springframework.data.mongodb.core.mapping.DBRef` annotation
* Refer
	* `address` property in [Student class](spring-data-mongo/src/main/java/com/app/entity/Student.java)
	* [Address class](spring-data-mongo/src/main/java/com/app/entity/Address.java)