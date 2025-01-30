# Java Core Concepts and Utilities Demonstration

This project showcases various Java core concepts, utilities, and best practices through a comprehensive set of test classes and examples.

The repository contains a collection of Java classes that demonstrate the usage of core Java features, including string manipulation, collections, streams, date/time operations, and more. It serves as a reference and learning resource for Java developers looking to understand and implement common Java programming patterns and utilities.

## Repository Structure

```
.
├── pom.xml
└── src
    └── main
        ├── java
        │   └── com
        │       ├── practice
        │       │   ├── annotations
        │       │   ├── dates
        │       │   ├── enums
        │       │   ├── java
        │       │   │   ├── lang
        │       │   │   └── util
        │       │   │       ├── concurrent
        │       │   │       └── stream
        │       │   ├── overriding
        │       │   └── RecordClassTest.java
        │       └── serialization
        └── resources
            └── log4j.xml
```

Key Files:
- `pom.xml`: Maven project configuration file
- `src/main/java/com/practice/java/lang/StringTest.java`: Demonstrates string manipulation techniques
- `src/main/java/com/practice/java/util/ArrayListTest.java`: Showcases ArrayList operations
- `src/main/java/com/practice/java/util/stream/IntStreamTest.java`: Examples of IntStream usage
- `src/main/java/com/practice/RecordClassTest.java`: Demonstrates Java record classes

## Source File Documentation

### com.practice.java.lang

- [StringTest.java](src/main/java/com/practice/java/lang/StringTest.java): Demonstrates various string manipulation techniques, including formatting, splitting, and conversion between strings and byte arrays.
- [SystemTest.java](src/main/java/com/practice/java/lang/SystemTest.java): Shows how to retrieve system properties such as Java version, current time, and temporary directory path.
- [RuntimeTest.java](src/main/java/com/practice/java/lang/RuntimeTest.java): Illustrates the usage of the Runtime class to get information about the current Java runtime environment.

### com.practice.java.util

- [ArrayListTest.java](src/main/java/com/practice/java/util/ArrayListTest.java): Comprehensive demonstration of ArrayList operations, including adding, removing, sorting, and iterating over elements.
- [HashMapTest.java](src/main/java/com/practice/java/util/HashMapTest.java): Shows various operations on HashMap, including adding, retrieving, and removing key-value pairs.
- [HashSetTest.java](src/main/java/com/practice/java/util/HashSetTest.java): Demonstrates the usage of HashSet, including adding elements and handling duplicates.
- [LinkedListTest.java](src/main/java/com/practice/java/util/LinkedListTest.java): Illustrates LinkedList operations and comparisons with ArrayList.
- [TreeSetTest.java](src/main/java/com/practice/java/util/TreeSetTest.java): Shows the usage of TreeSet and its ordering capabilities.

#### com.practice.java.util.concurrent

- [CopyOnWriteArrayListTest.java](src/main/java/com/practice/java/util/concurrent/CopyOnWriteArrayListTest.java): Demonstrates the thread-safe CopyOnWriteArrayList and its iterator behavior.

#### com.practice.java.util.stream

- [IntStreamTest.java](src/main/java/com/practice/java/util/stream/IntStreamTest.java): Showcases various operations available in the IntStream class from the Java Streams API.

### com.practice.annotations

- [Column.java](src/main/java/com/practice/annotations/Column.java): Defines a custom annotation for database column metadata.
- [Table.java](src/main/java/com/practice/annotations/Table.java): Demonstrates the usage of the @Column annotation on class fields.
- [TableTest.java](src/main/java/com/practice/annotations/TableTest.java): Tests the retrieval and inspection of custom annotations using reflection.

#### com.practice.annotations.repeating

- [Author.java](src/main/java/com/practice/annotations/repeating/Author.java): Defines a repeatable annotation for specifying multiple authors.
- [Authors.java](src/main/java/com/practice/annotations/repeating/Authors.java): Container annotation for multiple Author annotations.
- [Book.java](src/main/java/com/practice/annotations/repeating/Book.java): Demonstrates the usage of repeatable annotations.
- [BookTest.java](src/main/java/com/practice/annotations/repeating/BookTest.java): Tests the retrieval and processing of repeatable annotations.

### com.practice.dates

- [DisplayDayNameOfWeekTest.java](src/main/java/com/practice/dates/DisplayDayNameOfWeekTest.java): Shows various ways to display the day name of the week using different Java date/time APIs.

### com.practice.enums

- [EnumIssue.java](src/main/java/com/practice/enums/EnumIssue.java): Demonstrates the usage of enums in Java, including initialization and mapping.

### com.practice.overriding

- [Main.java](src/main/java/com/practice/overriding/Main.java): Illustrates method overriding and dynamic method dispatch in Java.
- [Child1.java](src/main/java/com/practice/overriding/Child1.java): Demonstrates a child class overriding methods from its parent.
- [Parent1.java](src/main/java/com/practice/overriding/Parent1.java): Shows the parent class with methods that can be overridden.

### com.practice

- [RecordClassTest.java](src/main/java/com/practice/RecordClassTest.java): Demonstrates the usage of Java record classes, including compact constructors and custom methods.

### com.serialization

- [StudentModel.java](src/main/java/com/serialization/StudentModel.java): Defines a serializable class with custom serialization methods.
- [SerializationTest.java](src/main/java/com/serialization/SerializationTest.java): Demonstrates the serialization and deserialization of objects.

## Usage Instructions

### Installation

Prerequisites:
- Java Development Kit (JDK) 17 or later
- Apache Maven 3.6.0 or later

To set up the project:

1. Clone the repository:
   ```
   git clone <repository-url>
   ```
2. Navigate to the project directory:
   ```
   cd core-java
   ```
3. Build the project:
   ```
   mvn clean install
   ```

### Running Tests

To run all tests:
```
mvn test
```

To run a specific test class:
```
mvn test -Dtest=ClassName
```

Replace `ClassName` with the name of the test class you want to run (e.g., `StringTest`).

### Common Use Cases

1. String Manipulation:
   ```java
   String input = "Hello, World!";
   String[] words = input.split("\\s+");
   System.out.println(Arrays.toString(words));
   ```

2. ArrayList Operations:
   ```java
   List<String> list = new ArrayList<>();
   list.add("Apple");
   list.add("Banana");
   list.add("Cherry");
   System.out.println(list);
   ```

3. IntStream Usage:
   ```java
   IntStream.range(1, 5)
            .map(n -> n * 2)
            .forEach(System.out::println);
   ```

4. Java Record Class:
   ```java
   record Student(int id, String name, String course) {}
   Student student = new Student(1, "John Doe", "Computer Science");
   System.out.println(student);
   ```

### Troubleshooting

1. Problem: `java.lang.UnsupportedClassVersionError`
   - Cause: The project is compiled with a newer Java version than the one used to run it.
   - Solution: Ensure you're using Java 17 or later to run the project.
   ```
   java -version
   ```

2. Problem: Maven build fails
   - Cause: Incorrect Maven configuration or missing dependencies.
   - Solution: Check the `pom.xml` file for any errors and ensure all dependencies are correctly specified.
   ```
   mvn dependency:tree
   ```

3. Debugging:
   - Enable debug logging by modifying `src/main/resources/log4j.xml`:
     ```xml
     <root>
         <level value="DEBUG"/>
         ...
     </root>
     ```
   - Use IDE debugging tools or add logging statements in the code:
     ```java
     log.debug("Variable value: {}", someVariable);
     ```

## Data Flow

1. Test classes in `src/main/java/com/practice` define various scenarios and use cases.
2. Each test method initializes necessary objects and calls relevant Java APIs.
3. The test execution triggers the underlying Java core libraries and utilities.
4. Results are typically logged using SLF4J (backed by Log4j).

```
[Test Class] -> [Java API Call] -> [Core Java Library] -> [Logging Output]
```

## Infrastructure

The project uses Maven for dependency management and build automation. Key infrastructure components defined in the `pom.xml` file include:

- JUnit 5 for unit testing
- SLF4J and Log4j for logging
- Lombok for reducing boilerplate code
- Google Guava for additional utilities
- Apache Commons Lang3 and Collections4 for extended Java API support
- Apache Tika for content analysis

The project is configured to use Java 17 as the compiler release version.