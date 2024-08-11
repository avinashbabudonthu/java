### [<<Back](../README.md) | [Java V2 All Examples](https://github.com/avinashbabudonthu/java/blob/master/java-v2/README.md) | [Java All Examples](https://github.com/avinashbabudonthu/java/blob/master/README.md)
------
# Setting the Java Version in Maven
------
# Use the Compiler Plugin
* We can specify the desired Java version in the compiler plugin.
* Compiler Plugin - The first option is setting the version in compiler plugin properties:
```
<properties>
    <maven.compiler.target>1.8</maven.compiler.target>
    <maven.compiler.source>1.8</maven.compiler.source>
</properties>
```
* The Maven compiler accepts this command with –target and –source versions. If we want to use the Java 8 language features, the –source should be set to 1.8.
* Also, for the compiled classes to be compatible with JVM 1.8, the –target value should be 1.8.
* The default value for both of them is the 1.6 version.
* Alternatively, we can configure the compiler plugin directly:
```
<build>
	<plugins>
		<plugin>
			<groupId>org.apache.maven.plugins</groupId>
			<artifactId>maven-compiler-plugin</artifactId>
			<version>3.8.1</version>
			<configuration>
				<source>1.8</source>
				<target>1.8</target>
			</configuration>
		</plugin>
	</plugins>
</build>
```
* The `maven-compiler-plugin` also has additional configuration properties that allow us to have more control over the compilation process beyond -source and -target versions.
------
# Java 9 and Beyond
* Furthermore, starting from the JDK 9 version, we can use a new `-release` command-line option. This new argument will automatically configure the compiler to produce class files that will link against the implementation of the given platform version.
* By default, the -source and -target options don’t guarantee a cross-compilation.
* This means that we cannot run our application on older versions of the platform. Additionally, to compile and run the programs for older Java versions, we also need to specify -bootclasspath option.
* To cross-compile correctly, the new -release option replaces three flags: -source, -target and -bootclasspath.
* After transforming our examples, we can declare the following for the plugin properties:
```
<properties>
    <maven.compiler.release>17</maven.compiler.release>
</properties>
```
* For the maven-compiler-plugin starting from the 3.6 version, this is what we can write. Refer central repository for latest version - https://mvnrepository.com/artifact/org.apache.maven.plugins/maven-compiler-plugin
```
<build>
	<plugins>
		<plugin>
			<groupId>org.apache.maven.plugins</groupId>
			<artifactId>maven-compiler-plugin</artifactId>
			<version>3.12.1</version>
			<configuration>
				<release>7</release>
			</configuration>
		</plugin>
	</plugins>
</build>
```
* Notice that we can add the Java version in a new <release> attribute. In this example, we compile our application for Java 7.
* What’s more, we don’t need a JDK 7 installed in our machine. Java 17 already contains all the information for linking the new language features with JDK 7
------
# Spring Boot Specification
* Spring Boot applications specify the JDK version inside of the properties tags in the pom.xml file.
* First, we need to add `spring-boot-starter-parent` as a parent to our project:
```
<parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-parent</artifactId>
</parent>
```
* This parent POM allows us to configure default plugins and multiple properties including the Java version — by default, the Java version is 1.8.
* However, we can override the default version of the parent by specifying the `java.version` property:
```
<properties>
    <java.version>17</java.version>
</properties>
```
* By setting the java.version property, we declare that the source and the target Java versions are both equal to 17
* Above all, we should keep in mind that this property is a Spring Boot Specification. Additionally, starting from Spring Boot 2.0, Java 8 is the minimum version. This means we can’t use or configure Spring Boot for the older JDK versions.
------
# Conclusion
* Using <java.version> is possible only with the Spring Boot application
* For simple cases, `maven.compiler.source` and `maven.compiler.target` properties should be the best fit
* Finally, to have more control over the compilation process, use the `maven-compiler-plugin` configuration settings
------
### [<<Back](../README.md) | [Java V2 All Examples](https://github.com/avinashbabudonthu/java/blob/master/java-v2/README.md) | [Java All Examples](https://github.com/avinashbabudonthu/java/blob/master/README.md)