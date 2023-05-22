# Create docker image with maven plugin

## Create project using maven
```
mvn archetype:generate -DgroupId=docker.maven.plugin -DartifactId=docker-with-maven-pugin -Dversion=1.0 -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
```

## Versions
* Maven **3.5.2**

## Dependencies
* org.springframework.boot:spring-boot-starter-parent:2.1.8.RELEASE
* org.springframework.boot:spring-boot-starter-web
* org.springframework.boot:spring-boot-starter-actuator
* org.projectlombok:lombok:1.18.8

## Plugins
* org.springframework.boot:spring-boot-maven-plugin
* org.apache.maven.plugins:maven-compiler-plugin:3.5.1
* org.codehaus.mojo:exec-maven-plugin
* com.spotify:docker-maven-plugin


## Run this project
* Import project into IDE as Maven or Gradle project
* Execute App class in each package
* Go to project location in cmd
* Run maven docker build command. Build should be successful
```
mvn docker:build
```
* Check the docker image
```
docker images
```

## References
* [Docker Maven Plugin](https://github.com/spotify/docker-maven-plugin)