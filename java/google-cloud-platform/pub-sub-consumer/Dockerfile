#FROM openjdk:8-jdk-alpine

FROM adoptopenjdk/openjdk11:alpine-jre

# maintainer info
LABEL maintainer="donthu.babu@infogain.com"

# add volume pointing to /tmp
VOLUME /tmp

# Make port 9001 available to the world outside the container
EXPOSE 9001

# application jar file when packaged
ARG jar_file=target/pub-sub-consumer.jar

# add application jar file to container
COPY ${jar_file} pub-sub-consumer.jar

# run the jar file
ENTRYPOINT ["java", "-jar", "pub-sub-consumer.jar"]

#RUN mkdir -p /app/config/ \
#    && chmod -R a+rwx /app

#COPY keys.json /app/config/keys.json

#ENTRYPOINT ["java", "-jar", "pub-sub-consumer.jar", "--spring.cloud.gcp.credentials.location=file:///app/config/keys.json"]