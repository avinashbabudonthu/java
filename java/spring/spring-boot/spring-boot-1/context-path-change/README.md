# Sprint Boot 1 Change Context Path

## Create project using below maven command
```
mvn archetype:generate -DgroupId=context.path.change -DartifactId=context-path-change -Dversion=1.0 -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
```

## Make project gradle support using following command
```
gradle init --type pom
```

## Dependencies
* spring-boot-starter-parent:1.5.22.RELEASE
* spring-boot-starter-web

## Classes
* Main class: **App**
* Controller classe: **AppController**

## Steps
* Using property in **applicattion.properties**
```
server.context-path=/our-context-path
```
* Using Java system property
```
public static void main(String[] args) {
    System.setProperty("server.context-path", "/our-context-path");
    SpringApplication.run(Application.class, args);
}
```
* Linux environment variable
```
export SERVER_CONTEXT_PATH=/out-context-path
```
* Windows environment variable
```
set SERVER_CONTEXT_PATH=/out-context-path
```
* Command line argument
```
java -jar app.jar --server.context-path=/our-context-path
```
* Using Java config - **EmbeddedServletContainerCustomizer**
```
@Bean
public EmbeddedServletContainerCustomizer
  embeddedServletContainerCustomizer() {
    return container -> container.setContextPath("/our-context-path");
}
```

## API
* Refer **files** folder

## Run application
* Import project to IDE either as gradle or maven project
* Run App.java
* Application should be up and running on port 9090

## Run with maven
* Install maven in local
* Go to project location in terminal
* Execute following command
```
mvn clean compile spring-boot:run
```

## Run with gradle
* Install gradle in local
* Go to project location in terminal
* Execute following command
```
gradle clean compileJava bootRun
```