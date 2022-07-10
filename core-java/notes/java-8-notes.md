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

# Collection streams
# JavaFX
# JAXP
# Date time API
	* Clock
	* LocalDate
	* LocalTime
	* LocalDateTime
	* ZonedDateTime
	* Duration
# Optional
* [Examples](../java-8/java8/src/main/java/com/java/util/OptionalPractice.java)
* The famous NullPointerException is by far the most popular cause of Java application failures. Long time ago the great Google
Guava project introduced the Optional as a solution to NullPointerException, discouraging codebase pollution with null checks
and encouraging developers to write cleaner code. Inspired by Google Guava, the Optional is now a part of Java 8 library.
* Optional is just a container: it can hold a value of some type T or just be null. It provides a lot of useful methods so the explicit
null checks have no excuse anymore. Please refer to official Java 8 documentation for more details.
* We are going to take a look on two small examples of Optional usages: with the nullable value and with the value which does
not allow null
```
Optional< String > fullName = Optional.ofNullable( null );
System.out.println( "Full Name is set? " + fullName.isPresent() );
System.out.println( "Full Name: " + fullName.orElseGet( () -> "[none]" ) );
System.out.println( fullName.map( s -> "Hey " + s + "!" ).orElse( "Hey Stranger!" ) );
```
* The isPresent() method returns true if this instance of Optional has non-null value and false otherwise. The orElseGet()
method provides the fallback mechanism in case Optional has null value by accepting the function to generate the default one.
The map() method transforms the current Optional’s value and returns the new Optional instance. The orElse() method is
similar to orElseGet() but instead of function it accepts the default value. Here is the output of this program
```
Full Name is set? false
Full Name: [none]
Hey Stranger!
```
* Let us briefly look on another example
```
Optional< String > firstName = Optional.of( "Tom" );
System.out.println( "First Name is set? " + firstName.isPresent() );
System.out.println( "First Name: " + firstName.orElseGet( () -> "[none]" ) );
System.out.println( firstName.map( s -> "Hey " + s + "!" ).orElse( "Hey Stranger!" ) );
```
* And here is the output:
```
First Name is set? true
First Name: Tom
Hey Tom!
```
## ifPresent
* The ifPresent() method enables us to run some code on the wrapped value if it's found to be non-null. Before Optional, we'd do:
```
if(name != null) {
    System.out.println(name.length());
}
```
* This code checks if the name variable is null or not before going ahead to execute some code on it. This approach is lengthy, and that's not the only problem — it's also prone to error.
* Indeed, what guarantees that after printing that variable, we won't use it again and then forget to perform the null check?
* This can result in a NullPointerException at runtime if a null value finds its way into that code. When a program fails due to input issues, it's often a result of poor programming practices.
* Optional makes us deal with nullable values explicitly as a way of enforcing good programming practices.
* Let's now look at how the above code could be refactored in Java 8.
* In typical functional programming style, we can execute perform an action on an object that is actually present
```
@Test
public void givenOptional_whenIfPresentWorks_thenCorrect() {
    Optional<String> opt = Optional.of("ana");
    opt.ifPresent(name -> System.out.println(name.length()));
}
```
## Difference Between orElse and orElseGet()
* To a lot of programmers who are new to Optional or Java 8, the difference between orElse() and orElseGet() is not clear. As a matter of fact, these two methods give the impression that they overlap each other in functionality.
* However, there's a subtle but very important difference between the two that can affect the performance of our code drastically if not well understood.
* Let's create a method called getMyDefault() in the test class, which takes no arguments and returns a default value:
```
public String getMyDefault() {
    System.out.println("Getting Default Value");
    return "Default Value";
}
```
* Let's see two tests and observe their side effects to establish both where orElse() and orElseGet() overlap and where they differ:
```
@Test
public void whenOrElseGetAndOrElseOverlap_thenCorrect() {
    String text = null;

    String defaultText = Optional.ofNullable(text).orElseGet(this::getMyDefault);
    assertEquals("Default Value", defaultText);

    defaultText = Optional.ofNullable(text).orElse(getMyDefault());
    assertEquals("Default Value", defaultText);
}
```
* In the above example, we wrap a null text inside an Optional object and attempt to get the wrapped value using each of the two approaches.
The side effect is:
```
Getting default value...
Getting default value...
```
* The getMyDefault() method is called in each case. It so happens that when the wrapped value is not present, then both orElse() and orElseGet() work exactly the same way.
* Now let's run another test where the value is present, and ideally, the default value should not even be created:
```
@Test
public void whenOrElseGetAndOrElseDiffer_thenCorrect() {
    String text = "Text present";

    System.out.println("Using orElseGet:");
    String defaultText 
      = Optional.ofNullable(text).orElseGet(this::getMyDefault);
    assertEquals("Text present", defaultText);

    System.out.println("Using orElse:");
    defaultText = Optional.ofNullable(text).orElse(getMyDefault());
    assertEquals("Text present", defaultText);
}
```
* In the above example, we are no longer wrapping a null value, and the rest of the code remains the same.
* Now let's take a look at the side effect of running this code:
```
Using orElseGet:
Using orElse:
Getting default value...
```
* Notice that when using orElseGet() to retrieve the wrapped value, the getMyDefault() method is not even invoked since the contained value is present.
* However, when using orElse(), whether the wrapped value is present or not, the default object is created. So in this case, we have just created one redundant object that is never used.
* In this simple example, there is no significant cost to creating a default object, as the JVM knows how to deal with such. However, when a method such as getMyDefault() has to make a web service call or even query a database, the cost becomes very obvious

# Base64 Nashron javascript engine (jjs)
# class dependency analyzer(jdeps)
# Parallel arrays
# java.util.function package
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
