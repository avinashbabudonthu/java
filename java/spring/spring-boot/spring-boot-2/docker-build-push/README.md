# Spring Boot 2 Docker Build Image and Push

# Requirement
* Build docker image for Spring Boot 2 application
* Push docker image to docker hub
* Use fabric8 maven plugin

# Maven Command
```
mvn archetype:generate -DgroupId=com.cerebro -DartifactId=docker-build-push -Dversion=1.0.0 -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
```

# Steps
* Create Spring Boot 2 application. Add required jar files as per application needs
* Add `io.fabric8:docker-maven-plugin` plugin. Refer [pom.xml](pom.xml)
* Following `execution` tag is to attach package with docker image build step
```
<execution>
    <phase>package</phase>
    <goals>
        <goal>build</goal>
    </goals>
</execution>
```
* If above `execution` tag added to plugin then execute `mvn clean package` to build docker image
* If above `execution` tag not added to plugin then execute `mvn clean package docker:build` to build docker image
* Following `execution` tag is to attach maven deploy to push docker image to docker hub. Add docker hub credentials in [settings.xml](settings.xml)
```
<execution>
     <id>myDeploy</id>
     <phase>deploy</phase>
     <goals>
         <goal>push</goal>
     </goals>
 </execution>
```
* If we are using above `execution` tag then add below plugin also
```
<plugin>
    <artifactId>maven-deploy-plugin</artifactId>
    <configuration>
        <skip>true</skip>
    </configuration>
</plugin>
```
* If above `execution` tag added to plugin then execute `mvn clean package deploy` to build docker image
* If above `execution` tag not added to plugin then execute `mvn clean package docker:push` to push docker image to docker hub