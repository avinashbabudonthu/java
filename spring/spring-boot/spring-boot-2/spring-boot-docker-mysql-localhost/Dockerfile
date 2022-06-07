FROM openjdk:8-jdk-alpine

# Following command to create docker image with jar created using maven
COPY target/spring-boot-docker-mysql-localhost.jar spring-boot-docker-mysql-localhost.jar

# Following command to create docker image with jar created using gradle
# COPY build/libs/spring-boot-docker-mysql-localhost-1.0.jar spring-boot-docker-mysql-localhost.jar

EXPOSE 9000
ENTRYPOINT ["java", "-jar", "spring-boot-docker-mysql-localhost.jar"]