# Spring Boot 2 Read yaml file that is outside jar

## Requirement
* Read yaml file
* Yaml file is not part jar
* Yaml file path should be passed as VM argument while starting the application

## Create project using maven
```
mvn archetype:generate -DgroupId=read.yaml.outside.jar -DartifactId=read-yaml-file-outside-jar -Dversion=1.0 -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
```

## Add gradle
```
gradle init --type pom
```

## Versions
* Maven **3.5.2**
* Gradle **5.0**

## Steps
* Add spring boot dependencies. Refer [pom.xml](pom.xml)
* Create class **read.yaml.outside.jar.config.YamlPropertySourceFactory** to read yaml file
* Declare annotation **org.springframework.context.annotation.PropertySource** with attributes **valuevalue = "file:${app.properties.file}", factory = YamlPropertySourceFactory.class**  on main class **read.properties.outside.jar.App**
* 
* Pass JVM argument **app.properties.file** while executing jar
```
-Dapp.properties.file=[projection-location]\files\application.yml
```

## API
* Refer [files/read-yaml-file-outside-jar.postman_collection.json](files/read-yaml-file-outside-jar.postman_collection.json)

## Run From Eclipse/STS
* Right click on **read.properties.outside.jar.App**
* Run As - Run Configurations
* Arguments tab - VM arguments
* Give **-Dapp.properties.file=[projection-location]\files\application.yml**
* Click on **Apply** - **Run**
* Tomcat should be started on port **9000**

## Run using Maven
* Create jar
```
mvn clean compile package
```
* Execute jar
```
java -jar -Dapp.properties.file=[projection-location]\files\application.yml target\read-yaml-file-outside-jar.jar
```

## Run using Gradle
* Create jar
```
gradlew clean compileJava build
```
* Execute jar
```
java -jar -Dapp.properties.file=[projection-location]\files\application.yml build\libs\read-yaml-file-outside-jar-1.0.jar
```