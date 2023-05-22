# Microservice Spring Cloud Config Server Config Client Cluoud Bus Rabbit MQ

## Requirement
* Create student service spring boot application
* Create spring cloud config server spring boot applicaiton
* Make student service as spring cloud config client
* Get configuration properties in student service from spring cloud config client by environment
* Start multiple instances of student service
* Change in the cloud config properties should reflect in all instances student service

## Solution
* In this example we are using Spring Cloud Bus with Rabbit MQ. We an use spring Cloud Bus with Kafka also
	* Refer Rabbit MQ installation and running in local - https://github.com/avinashbabudonthu/jms/blob/master/rabbit-mq/notes.md#install-rabbit-mq

## Postman Collection
* Import postman collection json to local postman - [spring-cloud-config-server-client-cloud-bus.postman_collection.json](files/spring-cloud-config-server-client-cloud-bus.postman_collection.json)

## Config Server
* Project folder - [config-server](config-server)
* Create project using maven Command
```
mvn archetype:generate -DgroupId=com.config.server -DartifactId=config-server -Dversion=1.0 -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
```
* Add gradle. Execute from `config-server` folder
```
gradle init --type pom
```
* Add spring-boot, devtools, actuator, `spring-cloud-config-server`, `spring-boot-configuration-processor` dependencies. Refer [pom.xml](config-server/pom.xml) (or) [build.gradle](config-server/build.gradle)
* Main class - [App.java](config-server/src/main/java/com/config/server/App.java)
* Create [applicaiton.yml](config-server/src/main/resources/application.yml). Configure following properties
```
server.port
spring.application.name
```
* Application is running on port - `8888`. Refer [applicaiton.yml](config-server/src/main/resources/application.yml) - `server.port` property
* Create git repo to configure all our properties for each microservice. Refer [spring-cloud-config-server-properties](https://github.com/avinashbabudonthu/spring-cloud-config-server-properties)
	* Clone this repo to local
	* Link this repo folder to our `config-server` project
		* In eclipse - right click on `config-server` - Build Path - Link Source
		* Browse to above cloned `spring-cloud-config-server-properties` folder

![picture](images/linking-config-repo.jpg)
![picture](images/link-source.jpg)

* Create [student-service.yml](https://github.com/avinashbabudonthu/spring-cloud-config-server-properties/blob/master/student-service.yml) in `spring-cloud-config-server-properties` which is linked to `config-server` project
* Commit and push the changes of `spring-cloud-config-server-properties`
* Connect `config-server` to local `spring-cloud-config-server-properties`
	* Open [config-server/applicaiton.yml](config-server/src/main/resources/application.yml). Add following property
		* spring.cloud.config.server.git.uri: file://C:\practice-projects\spring-cloud-config-server-properties
	* Add `@EnableConfigServer` at class level to [App.java](config-server/src/main/java/com/config/server/App.java)
	* Start the application
	* Open URLs in browser
		* http://localhost:8888/student-service/default
		* http://localhost:8888/student-service/dev
		* http://localhost:8888/student-service/test

![picture](images/config-server-link-to-local-git-repo.jpg)

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
* Main class - [App.java](student-service/src/main/java/com/student/service/App.java)
* Add spring-boot, devtools, actuator, `spring-cloud-config-client`, `spring-boot-configuration-processor` dependencies. Refer [pom.xml](student-service/pom.xml) (or) [build.gradle](student-service/build.gradle)
* Create [student-service/bootstrap.yml](student-service/src/main/resources/bootstrap.yml) file. Configure following properties
```
spring:
  application.name: student-service
  cloud.config.uri: http://localhost:8888
  profiles.active: test
  
management:
  endpoints:
    web:
      exposure:
        include:
        - '*'
```	
* Create [Student.java](student-service/src/main/java/com/student/service/model/Student.java)
* Create [StudentList.java](student-service/src/main/java/com/student/service/model/StudentList.java)
	* Declare `@ConfigurationProperties(prefix = "students")` at class level to enable to declare values for properties of this class in properties/yaml file
* Create [AppConfig.java](student-service/src/main/java/com/student/service/config/AppConfig.java). This class to enable configuring [StudentList.java](student-service/src/main/java/com/student/service/model/StudentList.java) class properties in properties/yaml file
* Create [AppController.java](student-service/src/main/java/com/student/service/controller/AppController.java)
	* Inject [StudentList.java](student-service/src/main/java/com/student/service/model/StudentList.java)
	* Write `/students` API - `findAllStudents()`

## Run Application
* Start Rabbit MQ - https://github.com/avinashbabudonthu/jms/blob/master/rabbit-mq/notes.md#install-rabbit-mq
* Start `config-server`. Run [config-server/App.java](config-server/src/main/java/com/config/server/App.java)
* Start `student-service` applicaiton - 3 instances with following batch files
	* Run [student-service/student-service-9000.bat](student-service/student-service-9000.bat)
	* Run [student-service/student-service-9001.bat](student-service/student-service-9001.bat)
	* Run [student-service/student-service-9002.bat](student-service/student-service-9002.bat)
* Import postman collection to local postman - [spring-cloud-config-server-client-cloud-bus.postman_collection.json](files/spring-cloud-config-server-client-cloud-bus.postman_collection.json)
	* student-service/find-all-students-9000
	* student-service/find-all-students-9001
	* student-service/find-all-students-9002
* Value of `test' profile from [student-service.yml](https://github.com/avinashbabudonthu/spring-cloud-config-server-properties/blob/master/student-service.yml)
```
{
    "studentList": [
        {
            "id": 5,
            "name": "james",
            "course": "spring-aop"
        },
        {
            "id": 6,
            "name": "jeni",
            "course": "spring-cloud"
        }
    ]
}
```
* Change properties of `test' profile from [student-service.yml](https://github.com/avinashbabudonthu/spring-cloud-config-server-properties/blob/master/student-service.yml)
	* Commit and Push
* Hit following API in postman collection
	* student-service/actuator-bus-refresh
* Now access API in post collection. Should be able to see new changes in all instances without restarting any one of them
	* student-service/find-all-students-9000
	* student-service/find-all-students-9001
	* student-service/find-all-students-9002