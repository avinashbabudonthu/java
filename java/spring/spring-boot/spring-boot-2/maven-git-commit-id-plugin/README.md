# Spring boot 2 maven git commit id plugin

## Versions
* spring boot version 2.1.8.RELEASE
* Maven version 3.6.2

## Create project using maven command
```maven command
mvn archetype:generate -DgroupId=maven.git.commit.id.plugin -DartifactId=maven-git-commit-id-plugin -Dversion=1.0 -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
```

## Dependencies
* spring-boot-starter-parent
* spring-boot-starter-web
* spring-boot-starter-test
* org.projectlombok:lombok

## Steps
* Create project
* Add plugin **pl.project13.maven:git-commit-id-plugin:2.2.3**
* Run maven build **mvn clean compile package**
* Above step will create git.properties file in target/classes
* Read properties file and return as response of **/version** API
* In the case actuator we will get actuator API to return version by reading **git.properties**

## API
* Refer folder - **files**

## Run application from IDE
* Import project to IDE
* Execute the main class **maven.git.commit.id.plugin.App**

## Run application using maven
* Execute the command **mvn clean compile spring-boot:run**

## References
* [DZone](https://dzone.com/articles/maven-git-commit-id-plugin)