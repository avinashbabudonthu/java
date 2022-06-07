FROM openjdk:8-jdk-alpine

# Following command to create docker image with jar created using maven
COPY maven/docker-build-push.1.0.0.jar spring-boot-2-docker-build-push-example.jar

# Following command to create docker image with jar created using gradle
# COPY build/libs/docker-image-with-docker-file-1.0.jar docker-image-with-docker-file.jar

EXPOSE 9080
ENTRYPOINT ["java", "-jar", "spring-boot-2-docker-build-push-example.jar"]