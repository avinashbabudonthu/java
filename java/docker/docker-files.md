# Build docker image for spring boot maven appliation
```
FROM openjdk:8-jdk-alpine

MAINTAINER Donthu Avinash Babu "avinashbabu.donthu@gmail.com"

COPY target/docker-image-with-docker-file.jar docker-image-with-docker-file.jar

EXPOSE 9080

ENTRYPOINT ["java", "-jar", "docker-image-with-docker-file.jar"]
```

# Build docker image for spring boot gradle appliation
```
FROM openjdk:8-jdk-alpine

MAINTAINER Donthu Avinash Babu "avinashbabu.donthu@gmail.com"

# Following command to create docker image with jar created using gradle
COPY build/libs/docker-image-with-docker-file-1.0.jar docker-image-with-docker-file.jar

EXPOSE 9080

ENTRYPOINT ["java", "-jar", "docker-image-with-docker-file.jar"]
```

