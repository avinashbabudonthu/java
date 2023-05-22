# Avro Maven Plugin Practice

## Requirement
* Generate Avro schema model using `avro-maven-plugin`

## Maven Command
```
mvn archetype:generate -DgroupId=avro.maven.plugin.practice -DartifactId=avro-maven-plugin-practice -Dversion=1.0 -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
```

## Gradle Command
```
gradle init --type pom
```

## Steps
* Add `avro` dependency
* Add `avro-maven-plugin` plugin
* Full dependencies refer [pom.xml](pom.xml) or [build.gradle](build.gradle)
* Run below command from project folder
```
mvn clean compile package
```
* `User` class will be created in `src/main/java` in `com.app.avro.model` package
* Model generated in `src/main/java` because
```
<configuration>
	<!-- .avsc file location -->
	<sourceDirectory>${project.basedir}/src/main/resources/avro</sourceDirectory>
	<!-- target location for generated classes -->
	<outputDirectory>${project.basedir}/src/main/java/</outputDirectory>
	<stringType>String</stringType>
</configuration>
```