# New features list in Java 8
* Default and static methods in interface
	* [Examples](../java-8/java8/src/main/java/com/interfaces)
* Functional Interface
	* [Examples](../java-8/java8/src/main/java/com/functional/interfaces)
* Lambda expressions (Closures)
	* [Examples](../java-8/java8/src/main/java/com/lambda/expressions)
* Method references
	* [Examples](../java-8/java8/src/main/java/com/method/references)
* Constructor references
	* [Examples](../java-8/java8/src/main/java/com/constructor/references)
* Repeating annotations
* Type annotations
* Collection streams
* JavaFX
* JAXP
* Date time API
	* Clock
	* LocalDate
	* LocalTime
	* LocalDateTime
	* ZonedDateTime
	* Duration
* Optional
* Base64 Nashron javascript engine (jjs)
* class dependency analyzer(jdeps)
* Parallel arrays
* java.util.function package
	* [Examples](../java-8/java8/src/main/java/com/java/util/function/practice)

# New features in java compiler
* Parameter names
	* pom
```
<configuration>
	<compilerArgument>-parameters</compilerArgument>
</configuration>
```
* New Java Tools
	* Nashorn engine
		* jjs
	* Class dependency analyzer
		* jdeps

# New Features in JVM
* The PermGen space is removed and replaced with `Metaspace` 
* The JVM options `-XX:PermSize` and `-XX:MaxPermSize` have been replaced by `-XX:MetaSpaceSize` and `-XX:MaxMetaspaceSize` respectively

# FunctionalInterface
* Interface with only one abstract method
* Use `@FunctionalInterface` annotation to declare functional interface
* If we add more than one abstract method to interface which is annotated with @FunctionalInterface, compilation error will come
* Even though these 2 interfaces are functional interfaces, these are not annotated with @FunctionalInterface annotation
	* java.lang.AutoCloseable
	* java.util.Closeable
* How to call default method in functional interface? this is possible in implementation class only
```
InterfaceName.super.methodName()
```

# Parameter names
* Literally for ages Java developers are inventing different ways to preserve method parameter names in Java byte-code and make them available at runtime (for example, Paranamer library). And finally, Java 8 bakes this demanding feature into the language (using Reflection API and Parameter.getName() method) and the byte-code (using new javac compiler argument -parameters)
* compile this class 
	* without using `-parameters` argument and then run this program, you will see something like that: `Parameter: arg0`
	* With `-parameters` argument passed to the compiler the program output will be different (the actual name of the parameter will be shown): `Parameter: args`
```
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
public class ParameterNames {
	public static void main(String[] args) throws Exception {
		Method method = ParameterNames.class.getMethod( "main", String[].class );
		for( final Parameter parameter: method.getParameters() ) {
			System.out.println( "Parameter: " + parameter.getName() );
		}
	}
}
```
* Executing above code from command prompt
	* Go to location where .java file is there in command prompt
	* javac -parameters className.java
	* come back to location until java package starts
	* java className
* Executing above code from Eclipse
	* Window
		* Preferences
		* Java
		* Compiler
		* check mark `Store Information about method parameters (usable via reflection)`
	* check will preserve method arguments at run time 
	* uncheck will not preserve method arguments at run time
* For Maven users the `-parameters` argument could be added to the compiler using configuration section of the `maven-compiler-plugin`
```
<plugin>
	<groupId>org.apache.maven.plugins</groupId>
	<artifactId>maven-compiler-plugin</artifactId>
	<version>3.1</version>
	<configuration>
		<compilerArgument>-parameters</compilerArgument>
		<source>1.8</source>
		<target>1.8</target>
	</configuration>
</plugin>
```

# Jdeps
* jdeps is a really great command line tool. It shows the package-level or class-level dependencies of Java class files. It accepts .class file, a directory, or JAR file as an input. By default, jdeps outputs the dependencies to the system output (console)
* Using `jdeps` tool
```
jdeps org.springframework.core-3.0.5.RELEASE.jar
```
