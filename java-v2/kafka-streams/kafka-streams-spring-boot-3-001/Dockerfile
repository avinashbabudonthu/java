FROM openjdk:17
COPY target/kafka-streams-spring-boot-3*.jar app.jar
EXPOSE 9000
ENTRYPOINT ["java", "-jar", "app.jar"]