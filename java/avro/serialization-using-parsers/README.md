# Serialization DeSerialization Using Parsers

## Requirement
* Serialize and de-serialize using parsers without generating classes from avro schema

## Maven Command
```
mvn archetype:generate -DgroupId=serialization.using.parsers -DartifactId=serialization-using-parsers -Dversion=1.0 -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false 
```

## Gradle Command
```
gradle init --type pom
```

## Steps
* Add `avro` dependencies. Refer [pom.xml](pom.xml) or [build.gradle](build.gradle)
* Serialization - Refer [Serialization.java](src/main/java/serialization/using/parsers/SerializePractice.java)
* DeSerialization - Refer [DeSerialization.java](src/main/java/deserialization/using/parsers/DeSerializePractice.java)