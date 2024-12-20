# Optional
------
## Methods
* of
* ofNullable
* isPresent
* ifPresent
* orElse
* orElseGet
* orElseThrow
* get
* filter
* map
* flatMap

## Java 9 additions:
* or
* ifPresentOrElse
* stream
------
# Notes
* [Examples](../../../java/core-java/java-8/java8/src/main/java/com/java/util/OptionalPractice.java)
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
* Refer [Sonar rule about not using Optional as parameter](https://rules.sonarsource.com/java/RSPEC-3553)
------
# Java 9 Optional API Additions
## The or() Method
* Sometimes, when our Optional is empty, we want to execute some other action that also returns an Optional.
* Prior Java 9 the Optional class had only the orElse() and orElseGet() methods but both need to return unwrapped values.
* Java 9 introduces the or() method that returns another Optional lazily if our Optional is empty. If our first Optional has a defined value, the lambda passed to the or() method will not be invoked, and value will not be calculated and returned
```
@Test
public void givenOptional_whenPresent_thenShouldTakeAValueFromIt() {
    //given
    String expected = "properValue";
    Optional<String> value = Optional.of(expected);
    Optional<String> defaultValue = Optional.of("default");

    //when
    Optional<String> result = value.or(() -> defaultValue);

    //then
    assertThat(result.get()).isEqualTo(expected);
}
```
* In the case of Optional being empty, the returned result will be the same as the defaultValue:
```
@Test
public void givenOptional_whenEmpty_thenShouldTakeAValueFromOr() {
    // given
    String defaultString = "default";
    Optional<String> value = Optional.empty();
    Optional<String> defaultValue = Optional.of(defaultString);

    // when
    Optional<String> result = value.or(() -> defaultValue);

    // then
    assertThat(result.get()).isEqualTo(defaultString);
}
```
## The ifPresentOrElse() Method
* When we have an Optional instance, often we want to execute a specific action on the underlying value of it. On the other hand, if the Optional is empty we want to log it or track that fact by incrementing some metric.
* The ifPresentOrElse() method is created exactly for such scenarios. We can pass a Consumer that will be invoked if the Optional is defined, and Runnable that will be executed if the Optional is empty.
* Let's say that we have a defined Optional and we want to increment a specific counter if the value is present:
```
@Test
public void givenOptional_whenPresent_thenShouldExecuteProperCallback() {
    // given
    Optional<String> value = Optional.of("properValue");
    AtomicInteger successCounter = new AtomicInteger(0);
    AtomicInteger onEmptyOptionalCounter = new AtomicInteger(0);

    // when
    value.ifPresentOrElse(
      v -> successCounter.incrementAndGet(), 
      onEmptyOptionalCounter::incrementAndGet);

    // then
    assertThat(successCounter.get()).isEqualTo(1);
    assertThat(onEmptyOptionalCounter.get()).isEqualTo(0);
}
```
* Note, that the callback passed as the second argument was not executed.
* In the case of an empty Optional, the second callback gets executed:
```
@Test
public void givenOptional_whenNotPresent_thenShouldExecuteProperCallback() {
    // given
    Optional<String> value = Optional.empty();
    AtomicInteger successCounter = new AtomicInteger(0);
    AtomicInteger onEmptyOptionalCounter = new AtomicInteger(0);

    // when
    value.ifPresentOrElse(
      v -> successCounter.incrementAndGet(), 
      onEmptyOptionalCounter::incrementAndGet);

    // then
    assertThat(successCounter.get()).isEqualTo(0);
    assertThat(onEmptyOptionalCounter.get()).isEqualTo(1);
}
```
## The stream() Method
* The last method, which is added to the Optional class in the Java 9, is the stream() method.
* Java has a very fluent and elegant Stream API that can operate on the collections and utilizes many functional programming concepts. The newest Java version introduces the stream() method on the Optional class that allows us to treat the Optional instance as a Stream.
* Let's say that we have a defined Optional and we are calling the stream() method on it. This will create a Stream of one element on which we can use all the methods that are available in the Stream API:
```
@Test
public void givenOptionalOfSome_whenToStream_thenShouldTreatItAsOneElementStream() {
    // given
    Optional<String> value = Optional.of("a");

    // when
    List<String> collect = value.stream().map(String::toUpperCase).collect(Collectors.toList());

    // then
    assertThat(collect).hasSameElementsAs(List.of("A"));
}
```
* On the other hand, if Optional is not present, calling the stream() method on it will create an empty Stream:
```
@Test
public void givenOptionalOfNone_whenToStream_thenShouldTreatItAsZeroElementStream() {
    // given
    Optional<String> value = Optional.empty();

    // when
    List<String> collect = value.stream()
      .map(String::toUpperCase)
      .collect(Collectors.toList());

    // then
    assertThat(collect).isEmpty();
}
```
* We can now quickly filter Streams of Optionals.
* Operating on the empty Stream will not have any effect, but thanks to the stream() method we can now chain the Optional API with the Stream API. This allows us to create more elegant and fluent code
------
# Java Optional as Return Type
## Optional as Return Type
* An Optional type can be a return type for most methods except some scenarios discussed later in the tutorial.
* Most of the time, returning an Optional is just fine:
```
public static Optional<User> findUserByName(String name) {
    User user = usersByName.get(name);
    Optional<User> opt = Optional.ofNullable(user);
    return opt;
}
```
* This is handy since we can use the Optional API in the calling method:
```
public static void changeUserName(String oldFirstName, String newFirstName) {
    findUserByFirstName(oldFirstName).ifPresent(user -> user.setFirstName(newFirstName));
}
```
* It's also appropriate for a static method or utility method to return an Optional value.  However, there are many situations where we should not return an Optional type.

## When to Not Return Optional
* Because Optional is a wrapper and value-based class, there are some operations that can't be done against Optional object. Many times, it's just simply better to return the actual type rather than an Optional type.
* Generally speaking, for getters in POJOs, it's more suitable to return the actual type, not an Optional type. Particularly, it's important for Entity Beans, Data Models, and DTOs to have traditional getters.
* We'll examine some of the important use cases below.
### Serialization
* Let's imagine we have a simple entity:
```
public class Sock implements Serializable {
    Integer size;
    Optional<Sock> pair;

    // ... getters and setters
}
```
* This actually won't work at all. If we were to try and serialize this, we'd get an NotSerializableException:
```
new ObjectOutputStream(new ByteArrayOutputStream()).writeObject(new Sock());
```
* And really, while serializing Optional may work with other libraries, it certainly adds what may be unnecessary complexity.
* Let's take a look at another application of this same serialization mismatch, this time with JSON.
### JSON
* Modern applications convert Java objects to JSON all the time. If a getter returns an Optional type, we'll most likely see some unexpected data structure in the final JSON.
* Let's say we have a bean with an optional property:
```
private String firstName;

public Optional<String> getFirstName() {
    return Optional.ofNullable(firstName);
}

public void setFirstName(String firstName) {
    this.firstName = firstName;
}
```
* So, if we use Jackson to serialize an instance of Optional, we'll get:
```
{"firstName":{"present":true}}
```
* But, what we'd really want is:
```
{"firstName":"Baeldung"}
```
* So, Optional is a pain for serialization use cases. Next, let's look at the cousin to serialization: writing data to a database.
### JPA
* In JPA, the getter, setter, and field should have name as well as type agreement. For example, a firstName field of type String should be paired with a getter called getFirstName that also returns a String.
* Following this convention makes several things simpler, including the use of reflection by libraries like Hibernate, to give us great Object-Relational mapping support.
* Let's take a look at our same use case of an optional first name in a POJO.
* This time, though, it'll be a JPA entity:
```
@Entity
public class UserOptionalField implements Serializable {
    @Id
    private long userId;

    private Optional<String> firstName;

    // ... getters and setters
}
```
* And let's go ahead and try to persist it:
```
UserOptionalField user = new UserOptionalField();
user.setUserId(1l);
user.setFirstName(Optional.of("Baeldung"));
entityManager.persist(user);
```
* Sadly, we run into an error:
```
Caused by: javax.persistence.PersistenceException: [PersistenceUnit: com.baeldung.optionalReturnType] Unable to build Hibernate SessionFactory
	at org.hibernate.jpa.boot.internal.EntityManagerFactoryBuilderImpl.persistenceException(EntityManagerFactoryBuilderImpl.java:1015)
	at org.hibernate.jpa.boot.internal.EntityManagerFactoryBuilderImpl.build(EntityManagerFactoryBuilderImpl.java:941)
	at org.hibernate.jpa.HibernatePersistenceProvider.createEntityManagerFactory(HibernatePersistenceProvider.java:56)
	at javax.persistence.Persistence.createEntityManagerFactory(Persistence.java:79)
	at javax.persistence.Persistence.createEntityManagerFactory(Persistence.java:54)
	at com.baeldung.optionalReturnType.PersistOptionalTypeExample.<clinit>(PersistOptionalTypeExample.java:11)
Caused by: org.hibernate.MappingException: Could not determine type for: java.util.Optional, at table: UserOptionalField, for columns: [org.hibernate.mapping.Column(firstName)]
```
* We could try deviating from this standard. For example, we could keep the property as a String, but change the getter:
```
@Column(nullable = true) 
private String firstName; 

public Optional<String> getFirstName() { 
    return Optional.ofNullable(firstName); 
}
```
* It appears that we could have both ways: have an Optional return type for the getter and a persistable field firstName.
* However, now that we are inconsistent with our getter, setter, and field, it'll be more difficult to leverage JPA defaults and IDE source code tools.
* Until JPA has elegant support of Optional type, we should stick to the traditional code. It's simpler and better:
```
private String firstName;
// ... traditional getter and setter
```
* Let's finally take a look at how this affects the front end – check to see if the problem we run into sounds familiar.

### Expression Languages
* Preparing a DTO for the front-end presents similar difficulties.
* For example, let's imagine that we are using JSP templating to read our UserOptional DTO's firstName from the request:
```
<c:out value="${requestScope.user.firstName}" />
```
* Since it's an Optional, we'll not see “Baeldung“. Instead, we'll see the String representation of the Optional type:
```
Optional[ana]
```
* And this isn't a problem just with JSP. Any templating language, be it Velocity, Freemarker, or something else, will need to add support for this. Until then, let's continue to keep our DTOs simple.
------
# Using Optional with Jackson
* Our Book Object
* Then, let's create a class Book, containing one ordinary and one Optional field:
```
public class Book {
   String title;
   Optional<String> subTitle;
   
   // getters and setters omitted
}
```
* Keep in mind that Optionals should not be used as fields and we are doing this to illustrate the problem.
## Serialization
* Now, let's instantiate a Book:
```
Book book = new Book();
book.setTitle("Oliver Twist");
book.setSubTitle(Optional.of("The Parish Boy's Progress"));
```
* And finally, let's try serializing it using a Jackson ObjectMapper:
```
String result = mapper.writeValueAsString(book);
```
* We'll see that the output of the Optional field, does not contain its value, but instead a nested JSON object with a field called present:
```
{"title":"Oliver Twist","subTitle":{"present":true}}
```
* Although this may look strange, it's actually what we should expect.
* In this case, isPresent() is a public getter on the Optional class. This means it will be serialized with a value of true or false, depending on whether it is empty or not. This is Jackson's default serialization behavior.
* If we think about it, what we want is for actual the value of the subtitle field to be serialized.
## Deserialization
* Now, let's reverse our previous example, this time trying to deserialize an object into an Optional. We'll see that now we get a JsonMappingException:
```
@Test(expected = JsonMappingException.class)
public void givenFieldWithValue_whenDeserializing_thenThrowException
    String bookJson = "{ \"title\": \"Oliver Twist\", \"subTitle\": \"foo\" }";
    Book result = mapper.readValue(bookJson, Book.class);
}
```
* Let's view the stack trace:
```
com.fasterxml.jackson.databind.JsonMappingException:
  Can not construct instance of java.util.Optional:
  no String-argument constructor/factory method to deserialize from String value ('The Parish Boy's Progress')
This behavior again makes sense. Essentially, Jackson needs a constructor which can take the value of subtitle as an argument. This is not the case with our Optional field.
```
## Solution
* What we want, is for Jackson to treat an empty Optional as null, and to treat a present Optional as a field representing its value.
* Fortunately, this problem has been solved for us. Jackson has a set of modules that deal with JDK 8 datatypes, including Optional.
### Maven Dependency and Registration
* First, let's add the latest version as a Maven dependency:
```
<dependency>
   <groupId>com.fasterxml.jackson.datatype</groupId>
   <artifactId>jackson-datatype-jdk8</artifactId>
   <version>2.9.6</version>
</dependency>
```
* Now, all we need to do is register the module with our ObjectMapper:
```
ObjectMapper mapper = new ObjectMapper();
mapper.registerModule(new Jdk8Module());
```
### Serialization
* Now, let's test it. If we try and serialize our Book object again, we'll see that there is now a subtitle, as opposed to a nested JSON:
```
Book book = new Book();
book.setTitle("Oliver Twist");
book.setSubTitle(Optional.of("The Parish Boy's Progress"));
String serializedBook = mapper.writeValueAsString(book);
 
assertThat(from(serializedBook).getString("subTitle"))
  .isEqualTo("The Parish Boy's Progress");
```
* If we try serializing an empty book, it will be stored as null:
```
book.setSubTitle(Optional.empty());
String serializedBook = mapper.writeValueAsString(book);
 
assertThat(from(serializedBook).getString("subTitle")).isNull();
```
### Deserialization
* Now, let's repeat our tests for deserialization. If we reread our Book, we'll see that we no longer get a JsonMappingException:
```
Book newBook = mapper.readValue(result, Book.class);
assertThat(newBook.getSubTitle()).isEqualTo(Optional.of("The Parish Boy's Progress"));
```
* Finally, let's repeat the test again, this time with null. We'll see that yet again we don't get a JsonMappingException, and in fact, have an empty Optional:
```
assertThat(newBook.getSubTitle()).isEqualTo(Optional.empty());
```
