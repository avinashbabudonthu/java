# Spring Boot 2 Docker image with Dockerfile

## Create project using maven
```
mvn archetype:generate -DgroupId=com.docker.image.dockerfile -DartifactId=docker-image-with-docker-file -Dversion=1.0 -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
```

## Add gradle
```
gradle init --type pom
```

## Versions
* Maven version: **3.6.2**

## Dependencies
* spring-boot-starter-parent: 2.1.8.RELEASE
* spring-boot-starter-web
* org.projectlombok:lombok

## Docker image with maven jar
* Go to project location in terminal and run following command to create jar
```
mvn clean compile package
```
* Open Dockerfile un comment (remove hash at start of line) below line
```
# COPY target/docker-image-with-docker-file.jar docker-image-with-docker-file.jar
```
* Comment (put has at start of line) below line
```
COPY build/libs/docker-image-with-docker-file-1.0.jar docker-image-with-docker-file.jar
```
* Create docker image 
```
docker build . -t docker-image-with-docker-file
```
* Create container using docker image created in above step
```
docker run -it -p 9081:9080 docker-image-with-docker-file
```

## Docker image with gradle jar
* Create jar
```
gradlew clean compileJava build
```
* Open Dockerfile, comment (put hash at start of line) below line
```
COPY target/docker-image-with-docker-file.jar docker-image-with-docker-file.jar
```
* Open Dockerfile, un Comment (remove has at start of line) below line
```
COPY build/libs/docker-image-with-docker-file-1.0.jar docker-image-with-docker-file.jar
```
* Create docker image 
```
docker build . -t docker-image-with-docker-file
```
* Create container using docker image created in above step
```
docker run -it -p 9081:9080 docker-image-with-docker-file
```

## API
* Refer **files/spring-boot-2-maven-docker-image-with-docker-file.postman_collection.json** for API 

## References
* [https://www.javacodegeeks.com/2019/08/dockerizing-spring-boot-application-2.html](https://www.javacodegeeks.com/2019/08/dockerizing-spring-boot-application-2.html)
* [https://www.baeldung.com/dockerizing-spring-boot-application](https://www.baeldung.com/dockerizing-spring-boot-application)
* [https://www.callicoder.com/spring-boot-docker-example/](https://www.callicoder.com/spring-boot-docker-example/)
* [https://spring.io/guides/gs/spring-boot-docker/](https://spring.io/guides/gs/spring-boot-docker/)