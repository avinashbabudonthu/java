# Avro Serialization DeSerialization By Generating Class

## Requirement
* Generate classes by avro schema file
* Create data as per schema
* Serialize data

## Maven Command
```
mvn archetype:generate -DgroupId=serialization.by.generating.class -DartifactId=serialization-by-generating-class -Dversion=1.0 -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false 
```

## Gradle Command
```
gradle init --type pom
```

## Serialization Steps
* Add Avro dependencies. Refer [pom.xml](pom.xml) or [build.gradle](build.gradle)
* Download `avro`, `avro-tools` jar. Refer https://github.com/avinashbabudonthu/others/blob/master/avro/setup.md
* Write avro schema file - [emp.avsc](src/main/resources/emp.avsc)
* Generate classes from schema file [emp.avsc](src/main/resources/emp.avsc) using following command
```
java -jar avro-tools-1.9.2.jar compile schema [path-to-avro-schema-file]\emp.avsc [path-to-generating-classes]\serialization-by-generating-class\src\main\java
```
```
java -jar avro-tools-1.9.2.jar compile schema C:\practice-projects\others\avro\serialization-by-generating-class\src\main\resources\emp.avsc C:\practice-projects\others\avro\serialization-by-generating-class\src\main\java
```
* Use the classes and create objects and serialize. Refer [Serialization.java](src/main/java/serialization/practice/Serialization.java)

## DeSerialization Steps
* Refer [DeserializationPractice.java](src/main/java/deserialization/practice/DeserializationPractice.java)