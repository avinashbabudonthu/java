# New features list in Java 8
* Default and static methods in interface - [Examples](../../../core-java/java-8/java8/src/main/java/com/interfaces)
* Functional Interface - [Examples](../../../core-java/java-8/java8/src/main/java/com/functional/interfaces)
* Lambda expressions (Closures) - [Examples](../../../core-java/java-8/java8/src/main/java/com/lambda/expressions)
* Method references - [Examples](../../../core-java/java-8/java8/src/main/java/com/method/references)
* Constructor references - [Examples](../../../core-java/java-8/java8/src/main/java/com/constructor/references)
* Repeating annotations
* Better Type Inference
* Extended Annotation Support
* Collection Streams
* JavaFX
* Date time API
* JAXP
* Optional
* Base64 Nashron Javascript Engine - jjs
* Class dependency analyzer - jdeps
* Parallel arrays
* java.util.function package
* Retain parameter names
* Permgen removed. Metaspace added

------
# Repeating annotations
* Since Java 5 introduced the annotations support, this feature became very popular and is very widely used. However, one of the
limitations of annotation usage was the fact that the same annotation cannot be declared more than once at the same location.
Java 8 breaks this rule and introduced the repeating annotations. It allows the same annotation to be repeated several times in
place it is declared.
* The repeating annotations should be themselves annotated with @Repeatable annotation. In fact, it is not a language change but
more a compiler trick as underneath the technique stays the same. Let us take a look on quick example
```
import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class RepeatingAnnotations {
@Target( ElementType.TYPE )
@Retention( RetentionPolicy.RUNTIME )
public @interface Filters {
	Filter[] value();
}

@Target( ElementType.TYPE )
@Retention( RetentionPolicy.RUNTIME )
@Repeatable( Filters.class )
public @interface Filter {
	String value();
};

@Filter( "filter1" )
@Filter( "filter2" )
public interface Filterable {
}

public static void main(String[] args) {
	for( Filter filter: Filterable.class.getAnnotationsByType( Filter.class ) ) {
		System.out.println( filter.value() );
	}
   }
}
```
* As we can see, there is an annotation class `Filter` annotated with `@Repeatable(Filters.class)`. The `Filters` is just a holder of
`Filter` annotations but Java compiler tries hard to hide its presence from the developers. As such, the interface `Filterable` has
`Filter` annotation defined twice (with no mentions of `Filters`).
* Also, the Reflection API provides new method getAnnotationsByType() to return repeating annotations of some type (please
notice that Filterable.class.getAnnotation( Filters.class ) will return the instance of Filters injected by the compiler)
* The program output looks like that:
```
filter1
filter2
```
* Refer - https://docs.oracle.com/javase/tutorial/java/annotations/repeating.html

# Better Type Inference
* Java 8 compiler has improved a lot on type inference. In many cases the explicit type parameters could be inferred by compiler
keeping the code cleaner. Let us take a look on one of the examples
```
public class Value< T > {
public static< T > T defaultValue() {
 return null;
}

public T getOrDefault( T value, T defaultValue ) {
 return ( value != null ) ? value : defaultValue;
 }
 
}
```
* And here is the usage of Value< String > type
```
public class TypeInference {
public static void main(String[] args) {
    final Value< String > value = new Value<>();
    value.getOrDefault( "22", Value.defaultValue() );
  }
}
```
* The type parameter of Value.defaultValue() is inferred and is not required to be provided. In Java 7, the same example will not
compile and should be rewritten to Value.< String >defaultValue()

# Extended Annotations Support
* Java 8 extends the context where annotation might be used. Now, it is possible to annotate mostly everything: local variables,
generic types, super-classes and implementing interfaces, even the method’s exceptions declaration. Couple of examples are
show below
```
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Collection;
public class Annotations {
@Retention( RetentionPolicy.RUNTIME )
@Target( { ElementType.TYPE_USE, ElementType.TYPE_PARAMETER } )
public @interface NonEmpty {
}

public static class Holder< @NonEmpty T > extends @NonEmpty Object {
  public void method() throws @NonEmpty Exception {
  }
}

@SuppressWarnings( "unused" )
public static void main(String[] args) {
  final Holder< String > holder = new @NonEmpty Holder< String >();
  @NonEmpty Collection< @NonEmpty String > strings = new ArrayList<>();
 }
}
```
* The ElementType.TYPE_USE and ElementType.TYPE_PARAMETER are two new element types to describe the applicable
annotation context. The Annotation Processing API also underwent some minor changes to recognize those new type
annotations in the Java programming language.
------
# Date time API
* Clock
* LocalDate
* LocalTime
* LocalDateTime
* ZonedDateTime
* Duration
------
# Optional
* [Notes](optional.md)
------
# java.util.function package
* [Examples](../../../core-java/java-8/java8/src/main/java/com/java/util/function/practice)
------
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
	* java.io.Closeable
* How to call default method in functional interface? Possible from implementation class only
```
InterfaceName.super.methodName()
```
------
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
	<version>3.8.1</version>
	<configuration>
	    <source>1.8</source>
	    <target>1.8</target>
	    <compilerArgument>-parameters</compilerArgument>
	</configuration>
</plugin>
```

# Jdeps
* jdeps is a really great command line tool. It shows the package-level or class-level dependencies of Java class files. It accepts .class file, a directory, or JAR file as an input. By default, jdeps outputs the dependencies to the system output (console)
* Using `jdeps` tool
```
jdeps org.springframework.core-3.0.5.RELEASE.jar
```
