FROM openjdk:17
COPY target/word-count-1.0.0-jar-with-dependencies.jar app.jar
#EXPOSE [application-running-port]
ENTRYPOINT ["java", "-jar", "app.jar"]