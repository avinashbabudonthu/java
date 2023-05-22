FROM openjdk:8-jdk-alpine

# Following command to create docker image with jar created using maven
COPY target/spring-boot-mysql-docker.jar spring-boot-mysql-docker.jar

# Following command to create docker image with jar created using gradle
# COPY build/libs/spring-boot-mysql-docker-1.0.jar spring-boot-mysql-docker.jar

EXPOSE 9000
ENTRYPOINT ["java", "-jar", "spring-boot-mysql-docker.jar"]