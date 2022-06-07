# This application is in progeress.. 

## Spring Boot MySql Docker

### Requirement
* Run Spring Boot in Docker container
* Run MySql in docker container
* Connect to MySql running in docker container from spring boot running in another docker container

### Maven command
```
mvn archetype:generate -DgroupId=springboot.mysql.docker -DartifactId=spring-boot-mysql-docker -Dversion=1.0 -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
```

### Gradle command
```
gradle init --type pom
```

## Steps
* Add spring boot dependencies. Refer [pom.xml](pom.xml) or [build.gradle](build.gradle)
* Create docker image and start container. Refer [docker-image-with-docker-file](https://github.com/avinashbabudonthu/spring-boot/tree/master/spring-boot-2/docker-image-with-docker-file)
* Run MySql docker container. Refer [MySQL Docker](https://github.com/avinashbabudonthu/sql/blob/master/mysql/mysql-docker.md#mysql-docker-container)

## Postman collection
* Refer [files/spring-boot-mysql-docker.postman_collection.json](files/spring-boot-mysql-docker.postman_collection.json)

## Run this project
* Import project into IDE as Maven or Gradle project
* Execute [App.java](src/main/java/springboot/mysql/docker/App.java)
* Table create scripts. Refer [schema.sql](db/schema.sql)
* Data scripts. Refer [data.sql](db/data.sql)
* Select scripts. Refer [select.sql](db/select.sql)
* Delete scripts. Refer [delete.sql](db/delete.sql)
* Entity class [StudentEntity.java](src/main/java/springboot/mysql/docker/entity/StudentEntity.java)
* Model class [StudentModel.java](src/main/java/springboot/mysql/docker/model/StudentModel.java)
* Repository interface [StudentRepository.java](src/main/java/springboot/mysql/docker/repository/StudentRepository.java)
* Controller class [AppController.java](src/main/java/springboot/mysql/docker/controller/AppController.java)
* Yaml file [application.yml](src/main/resources/application.yml)
* [Dockerfile](Dockerfile)

## Run using maven exective plugin
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
java -jar target\spring-boot-mysql-docker.jar
```

## Create package using gradle
```
gradlew clean compileJava build
```

## Execute jar of Gradle
```
java -jar build\libs\spring-boot-mysql-docker-1.0.jar
```

## Run as Docker Container
* Create package
```
mvn clean compile package
```
* Build docker image
```
docker build . -t spring-boot-mysql-docker
```
* Run container
```
docker run -it -p 9000:9000 spring-boot-mysql-docker --link mysql-docker:mysql
```
* Check all containers
```
docker ps --all
```
* Remove container
```
docker rm [container-id]
```
* Remove image
```
docker rmi spring-boot-mysql-docker
```