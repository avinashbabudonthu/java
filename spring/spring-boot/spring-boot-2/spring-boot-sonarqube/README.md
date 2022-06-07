# Spring Boot 2 project integration with sonarqube

## Create project using maven
```
mvn archetype:generate -DgroupId=spring.boot.sonarqube -DartifactId=spring-boot-sonarqube -Dversion=1.0 -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
```

## Add gradle
```
gradle init --type pom
```

## Versions
* Maven version: **3.6.2**
* Gradle version: **5.0**
* Sonarqube version **7.7**
* Sonar scanner version **3.3.0.1492**

## Dependencies
* spring-boot-starter-parent:2.1.8.RELEASE
* spring-boot-starter-web
* spring-boot-starter-test

## Setup Sonarqube
* Refer **[Sonarqube](https://github.com/avinashbabudonthu/others/tree/master/sonarqube/setup-with-mysql)**

## Configure sonarqube to maven spring boot 2 project
* Add **sonar-project.properties** in the root of the project
```spring-boot-2-sonar-properties
sonar.projectKey=Spring-Boot-2-Sonarqube
sonar.projectName=Spring-Boot-2-Sonarqube
sonar.projectVersion=1.0
sonar.java.source=1.8
sonar.sources=.
sonar.language=java
sonar.sourceEncoding=UTF-8
sonar.host.url=http://localhost:9000
#sonar.ws.timeout=3000
#sonar.verbose=true
```
* run command **mvn clean install sonar:sonar**
* Once maven completed we will see url **http://localhost:9000/dashboard?id=spring.boot.sonarqube%3Aspring-boot-sonarqube**
* Open url in browser, we will see sonar report

## Configure sonarqube to gradle spring boot 2 project
* Add **sonarqube** plugin
```
id "org.sonarqube" version "2.7.1"
```
* Create task in build.gradle with sonar properties as below:
```
sonarqube{
    properties{
        property "sonar.projectKey", "Spring-Boot-2-Gradle-Sonarqube"
        property "sonar.projectName", "Spring-Boot-2-Gradle-Sonarqube"
        property "sonar.projectVersion", "1.0"
        property "sonar.java.source", "1.8"
        property "sonar.projectDescription", "Spring Boot 2 Gradle Sonarqube"
        property "sonar.sourceEncoding", "UTF-8"
        property "sonar.host.url", "http://localhost:9000"
    }
}
```
* run command **gradle clean build sonarqube**
* Once build completed, open url **http://localhost:9000**
* On home page we can see number of projects analyzed. Navigate to your project from there

## References
* [Sonarqube implementation with maven spring boot](https://www.oodlestechnologies.com/blogs/SonarQube-implementation-with-maven-spring-boot/)
* [Sonar scanner with Gradle](https://docs.sonarqube.org/latest/analysis/scan/sonarscanner-for-gradle/)
