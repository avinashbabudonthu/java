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
------
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

## Exceptions With orElseThrow()
* The orElseThrow() method follows from orElse() and orElseGet() and adds a new approach for handling an absent value.
* Instead of returning a default value when the wrapped value is not present, it throws an exception:
```
@Test(expected = IllegalArgumentException.class)
public void whenOrElseThrowWorks_thenCorrect() {
    String nullName = null;
    String name = Optional.ofNullable(nullName).orElseThrow(
      IllegalArgumentException::new);
}
```
* Method references in Java 8 come in handy here, to pass in the exception constructor.
* Java 10 introduced a simplified no-arg version of orElseThrow() method. In case of an empty Optional it throws a NoSuchElementException:
```
@Test(expected = NoSuchElementException.class)
public void whenNoArgOrElseThrowWorks_thenCorrect() {
    String nullName = null;
    String name = Optional.ofNullable(nullName).orElseThrow();
}
```

## Returning Value With get()
* The final approach for retrieving the wrapped value is the get() method:
```
@Test
public void givenOptional_whenGetsValue_thenCorrect() {
    Optional<String> opt = Optional.of("baeldung");
    String name = opt.get();
    assertEquals("baeldung", name);
}
```
* However, unlike the previous three approaches, get() can only return a value if the wrapped object is not null; otherwise, it throws a no such element exception:
```
@Test(expected = NoSuchElementException.class)
public void givenOptionalWithNull_whenGetThrowsException_thenCorrect() {
    Optional<String> opt = Optional.ofNullable(null);
    String name = opt.get();
}
```
* This is the major flaw of the get() method. Ideally, Optional should help us avoid such unforeseen exceptions. Therefore, this approach works against the objectives of Optional and will probably be deprecated in a future release.
* So, it's advisable to use the other variants that enable us to prepare for and explicitly handle the null case

## Conditional Return With filter()
* We can run an inline test on our wrapped value with the filter method. It takes a predicate as an argument and returns an Optional object. If the wrapped value passes testing by the predicate, then the Optional is returned as-is.
* However, if the predicate returns false, then it will return an empty Optional:
```
@Test
public void whenOptionalFilterWorks_thenCorrect() {
    Integer year = 2016;
    Optional<Integer> yearOptional = Optional.of(year);
    boolean is2016 = yearOptional.filter(y -> y == 2016).isPresent();
    assertTrue(is2016);
    boolean is2017 = yearOptional.filter(y -> y == 2017).isPresent();
    assertFalse(is2017);
}
```
* The filter method is normally used this way to reject wrapped values based on a predefined rule. We could use it to reject a wrong email format or a password that is not strong enough.
* Let's look at another meaningful example. Say we want to buy a modem, and we only care about its price.
* We receive push notifications on modem prices from a certain site and store these in objects:
```
public class Modem {
    private Double price;

    public Modem(Double price) {
        this.price = price;
    }
    // standard getters and setters
}
```
* We then feed these objects to some code whose sole purpose is to check if the modem price is within our budget range.
* Let's now take a look at the code without Optional:
```
public boolean priceIsInRange1(Modem modem) {
    boolean isInRange = false;

    if (modem != null && modem.getPrice() != null 
      && (modem.getPrice() >= 10 
        && modem.getPrice() <= 15)) {

        isInRange = true;
    }
    return isInRange;
}
```
* Pay attention to how much code we have to write to achieve this, especially in the if condition. The only part of the if condition that is critical to the application is the last price-range check; the rest of the checks are defensive:
```
@Test
public void whenFiltersWithoutOptional_thenCorrect() {
    assertTrue(priceIsInRange1(new Modem(10.0)));
    assertFalse(priceIsInRange1(new Modem(9.9)));
    assertFalse(priceIsInRange1(new Modem(null)));
    assertFalse(priceIsInRange1(new Modem(15.5)));
    assertFalse(priceIsInRange1(null));
}
```
* Apart from that, it's possible to forget about the null checks over a long day without getting any compile-time errors.
* Now let's look at a variant with Optional#filter:
```
public boolean priceIsInRange2(Modem modem2) {
     return Optional.ofNullable(modem2)
       .map(Modem::getPrice)
       .filter(p -> p >= 10)
       .filter(p -> p <= 15)
       .isPresent();
 }
```
* The map call is simply used to transform a value to some other value. Keep in mind that this operation does not modify the original value.
* In our case, we are obtaining a price object from the Model class. We will look at the map() method in detail in the next section.
* First of all, if a null object is passed to this method, we don't expect any problem.
* Secondly, the only logic we write inside its body is exactly what the method name describes — price-range check. Optional takes care of the rest:
```
@Test
public void whenFiltersWithOptional_thenCorrect() {
    assertTrue(priceIsInRange2(new Modem(10.0)));
    assertFalse(priceIsInRange2(new Modem(9.9)));
    assertFalse(priceIsInRange2(new Modem(null)));
    assertFalse(priceIsInRange2(new Modem(15.5)));
    assertFalse(priceIsInRange2(null));
}
```
* `The previous approach promises to check price range but has to do more than that to defend against its inherent fragility.` Therefore, we can use the filter method to replace unnecessary if statements and reject unwanted values.

## Transforming Value With map()
* In the previous section, we looked at how to reject or accept a value based on a filter.
* We can use a similar syntax to transform the Optional value with the map() method:
```
@Test
public void givenOptional_whenMapWorks_thenCorrect() {
    List<String> companyNames = Arrays.asList(
      "paypal", "oracle", "", "microsoft", "", "apple");
    Optional<List<String>> listOptional = Optional.of(companyNames);

    int size = listOptional
      .map(List::size)
      .orElse(0);
    assertEquals(6, size);
}
```
* In this example, we wrap a list of strings inside an Optional object and use its map method to perform an action on the contained list. The action we perform is to retrieve the size of the list.
* The map method returns the result of the computation wrapped inside Optional. We then have to call an appropriate method on the returned Optional to retrieve its value.
* Notice that the filter method simply performs a check on the value and returns an Optional describing this value only if it matches the given predicate. Otherwise returns an empty Optional. The map method however takes the existing value, performs a computation using this value, and returns the result of the computation wrapped in an Optional object:
```
@Test
public void givenOptional_whenMapWorks_thenCorrect2() {
    String name = "baeldung";
    Optional<String> nameOptional = Optional.of(name);

    int len = nameOptional
     .map(String::length)
     .orElse(0);
    assertEquals(8, len);
}
```
* We can chain map and filter together to do something more powerful.
* Let's assume we want to check the correctness of a password input by a user. We can clean the password using a map transformation and check its correctness using a filter:
```
@Test
public void givenOptional_whenMapWorksWithFilter_thenCorrect() {
    String password = " password ";
    Optional<String> passOpt = Optional.of(password);
    boolean correctPassword = passOpt.filter(
      pass -> pass.equals("password")).isPresent();
    assertFalse(correctPassword);

    correctPassword = passOpt
      .map(String::trim)
      .filter(pass -> pass.equals("password"))
      .isPresent();
    assertTrue(correctPassword);
}
```
* As we can see, without first cleaning the input, it will be filtered out — yet users may take for granted that leading and trailing spaces all constitute input. So, we transform a dirty password into a clean one with a map before filtering out incorrect ones

## Transforming Value With flatMap()
* Just like the map() method, we also have the flatMap() method as an alternative for transforming values. The difference is that map transforms values only when they are unwrapped whereas flatMap takes a wrapped value and unwraps it before transforming it.
* Previously, we created simple String and Integer objects for wrapping in an Optional instance. However, frequently, we will receive these objects from an accessor of a complex object.
* To get a clearer picture of the difference, let's have a look at a Person object that takes a person's details such as name, age and password:
```
public class Person {
    private String name;
    private int age;
    private String password;

    public Optional<String> getName() {
        return Optional.ofNullable(name);
    }

    public Optional<Integer> getAge() {
        return Optional.ofNullable(age);
    }

    public Optional<String> getPassword() {
        return Optional.ofNullable(password);
    }

    // normal constructors and setters
}
```
* We would normally create such an object and wrap it in an Optional object just like we did with String.
* Alternatively, it can be returned to us by another method call:
```
Person person = new Person("john", 26);
Optional<Person> personOptional = Optional.of(person);
```
* Notice now that when we wrap a Person object, it will contain nested Optional instances:
```
@Test
public void givenOptional_whenFlatMapWorks_thenCorrect2() {
    Person person = new Person("john", 26);
    Optional<Person> personOptional = Optional.of(person);

    Optional<Optional<String>> nameOptionalWrapper  
      = personOptional.map(Person::getName);
    Optional<String> nameOptional  
      = nameOptionalWrapper.orElseThrow(IllegalArgumentException::new);
    String name1 = nameOptional.orElse("");
    assertEquals("john", name1);

    String name = personOptional
      .flatMap(Person::getName)
      .orElse("");
    assertEquals("john", name);
}
```
* Here, we're trying to retrieve the name attribute of the Person object to perform an assertion.
* Note how we achieve this with map() method in the third statement, and then notice how we do the same with flatMap() method afterwards.
* The Person::getName method reference is similar to the String::trim call we had in the previous section for cleaning up a password.
* The only difference is that getName() returns an Optional rather than a String as did the trim() operation. This, coupled with the fact that a map transformation wraps the result in an Optional object, leads to a nested Optional.
* While using map() method, therefore, we need to add an extra call to retrieve the value before using the transformed value. This way, the Optional wrapper will be removed. This operation is performed implicitly when using flatMap

## Chaining Optionals in Java 8
* Sometimes, we may need to get the first non-empty Optional object from a number of Optionals. In such cases, it would be very convenient to use a method like orElseOptional(). Unfortunately, such operation is not directly supported in Java 8.
* Let's first introduce a few methods that we'll be using throughout this section:
```
private Optional<String> getEmpty() {
    return Optional.empty();
}

private Optional<String> getHello() {
    return Optional.of("hello");
}

private Optional<String> getBye() {
    return Optional.of("bye");
}

private Optional<String> createOptional(String input) {
    if (input == null || "".equals(input) || "empty".equals(input)) {
        return Optional.empty();
    }
    return Optional.of(input);
}
```
* In order to chain several Optional objects and get the first non-empty one in Java 8, we can use the Stream API:
```
@Test
public void givenThreeOptionals_whenChaining_thenFirstNonEmptyIsReturned() {
    Optional<String> found = Stream.of(getEmpty(), getHello(), getBye())
      .filter(Optional::isPresent)
      .map(Optional::get)
      .findFirst();
    
    assertEquals(getHello(), found);
}
```
* The downside of this approach is that all of our get methods are always executed, regardless of where a non-empty Optional appears in the Stream.
* If we want to lazily evaluate the methods passed to Stream.of(), we need to use the method reference and the Supplier interface:
```
@Test
public void givenThreeOptionals_whenChaining_thenFirstNonEmptyIsReturnedAndRestNotEvaluated() {
    Optional<String> found =
      Stream.<Supplier<Optional<String>>>of(this::getEmpty, this::getHello, this::getBye)
        .map(Supplier::get)
        .filter(Optional::isPresent)
        .map(Optional::get)
        .findFirst();

    assertEquals(getHello(), found);
}
```
* In case we need to use methods that take arguments, we have to resort to lambda expressions:
```
@Test
public void givenTwoOptionalsReturnedByOneArgMethod_whenChaining_thenFirstNonEmptyIsReturned() {
    Optional<String> found = Stream.<Supplier<Optional<String>>>of(
      () -> createOptional("empty"),
      () -> createOptional("hello")
    )
      .map(Supplier::get)
      .filter(Optional::isPresent)
      .map(Optional::get)
      .findFirst();

    assertEquals(createOptional("hello"), found);
}
```
* Often, we'll want to return a default value in case all of the chained Optionals are empty. We can do so just by adding a call to orElse() or orElseGet():
```
@Test
public void givenTwoEmptyOptionals_whenChaining_thenDefaultIsReturned() {
    String found = Stream.<Supplier<Optional<String>>>of(
      () -> createOptional("empty"),
      () -> createOptional("empty")
    )
      .map(Supplier::get)
      .filter(Optional::isPresent)
      .map(Optional::get)
      .findFirst()
      .orElseGet(() -> "default");

    assertEquals("default", found);
}
```

## Misuse of Optionals
* Finally, let's see a tempting, however dangerous, way to use Optionals: passing an Optional parameter to a method.
* Imagine we have a list of Person and we want a method to search through that list for people with a given name. Also, we would like that method to match entries with at least a certain age, if it's specified.
* With this parameter being optional, we come with this method:
```
public static List<Person> search(List<Person> people, String name, Optional<Integer> age) {
    // Null checks for people and name
    return people.stream()
            .filter(p -> p.getName().equals(name))
            .filter(p -> p.getAge().get() >= age.orElse(0))
            .collect(Collectors.toList());
}
```
* Then we release our method, and another developer tries to use it:
```
someObject.search(people, "Peter", null);
```
* Now the developer executes its code and gets a NullPointerException. There we are, having to null check our optional parameter, which defeats our initial purpose in wanting to avoid this kind of situation.
* Here are some possibilities we could have done to handle it better:
```
public static List<Person> search(List<Person> people, String name, Integer age) {
    // Null checks for people and name
    final Integer ageFilter = age != null ? age : 0;

    return people.stream()
            .filter(p -> p.getName().equals(name))
            .filter(p -> p.getAge().get() >= ageFilter)
            .collect(Collectors.toList());
}
```
* There, the parameter's still optional, but we handle it in only one check.
* Another possibility would have been to create two overloaded methods:
```
public static List<Person> search(List<Person> people, String name) {
    return doSearch(people, name, 0);
}

public static List<Person> search(List<Person> people, String name, int age) {
    return doSearch(people, name, age);
}

private static List<Person> doSearch(List<Person> people, String name, int age) {
    // Null checks for people and name
    return people.stream()
            .filter(p -> p.getName().equals(name))
            .filter(p -> p.getAge().get().intValue() >= age)
            .collect(Collectors.toList());
}
```
* That way we offer a clear API with two methods doing different things (though they share the implementation).
* So, there are solutions to avoid using Optionals as method parameters. The intent of Java when releasing Optional was to use it as a return type, thus indicating that a method could return an empty value

------
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
