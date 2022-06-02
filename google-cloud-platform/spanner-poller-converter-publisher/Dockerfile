FROM adoptopenjdk/openjdk11:alpine-jre

# maintainer info
LABEL maintainer="donthu.babu@infogain.com"

# add volume pointing to /tmp
VOLUME /tmp

# Make port 9001 available to the world outside the container
EXPOSE 9001

# application jar file when packaged
ARG jar_file=target/spanner-poller-converter-publisher.jar

# add application jar file to container
COPY ${jar_file} spanner-poller-converter-publisher.jar

# run the jar file
ENTRYPOINT ["java", "-jar", "spanner-poller-converter-publisher.jar"]