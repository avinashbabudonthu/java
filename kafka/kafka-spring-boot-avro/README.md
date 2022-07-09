# Spring Boot Kafka Avro Producer Consumer

## Requirement
* Spring Boot Kafka Avro Producer
* Spring Boot Kafka Avro Consumer


## Maven Command
```
mvn archetype:generate -DgroupId=com.kafka.spring.boot.avro -DartifactId=kafka-spring-boot-avro -Dversion=1.0 -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
```

## Gradle Command
```
gradle init --type pom
```

## Steps
* Dependencies refer in [pom.xml](pom.xml) or [build.gradle](build.gradle)
* Add `avro-maven-plugin` plugin
* Generate pojo classes as per schema [user.avsc](src/main/resources/avro/user.avsc)
```
mvn clean compile package
```
* We can see model classes getting generated in the package [com.app.avro.model](src/main/java/com/app/avro/model)
	* Model classes are generated in this package because following code in `avro-maven-plugin`
```
<configuration>
	<sourceDirectory>${project.basedir}/src/main/resources/avro</sourceDirectory>
	<outputDirectory>${project.basedir}/src/main/java/</outputDirectory>
	<stringType>String</stringType>
</configuration>
```

## API
* Refer [files/kafka-spring-boot-avro.postman_collection.json](files/kafka-spring-boot-avro.postman_collection.json)