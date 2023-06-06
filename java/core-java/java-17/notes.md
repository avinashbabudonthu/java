# JDK 17 Features
* Restore or Rebuild the "Always-Strict Floating-Point" Semantics
* Enhanced faster the "pseudo-Random" Number Generators
* New macOS rendering pipelines
* macOS/AArch64 Port
* Dismiss the Applet API for Removal
* JDK Internals Encapsulate strongly
* Switch Pattern Matching (Preview)
* Activation of the Removal RMI
* Generate sealed Classes
* Removal of the Experimental AOT and JIT Compiler
* Remove the Security Manager.
* Foreign Functions and Memory API (Incubator)
* Vector API (Second Incubator)
* Deserialization Filters Based on Context (content-specific)
------
# Generate sealed Classes
* Adds sealed classes and interfaces to the Java language to make it better. Sealed classes and interfaces limit other classes, and interfaces can extend and implement them, respectively
* Showing some other progress to pattern matching along with the JEP 406 will make it possible to check the type, cast, and act code pattern more sophisticatedly and cleanly
* [Sealed class] - Refer classes
	* [Subjects](java-17/src/main/java/com/java/Subjects.java)
	* [Java](java-17/src/main/java/com/java/Java.java) extends `Subjects` and `final`
	* [Spring](java-17/src/main/java/com/java/Spring.java) extends `Subjects` and `final`
	* [SQL](java-17/src/main/java/com/java/SQL.java) extends `Subjects` and `final`
------
# Top 5 Java 17 features
* The new Java `Record` data type
* Java text blocks
* helpful NullPointerException guidance
* switch statement expressions
* sealed classes
------
# Java Records
* One knock about the Java programming language is its needless verbosity and ceremony, especially compared to other programming languages such as Python or Groovy. The new Java Record data type addresses that complaint.
* Quite often, a Java class simply represents data. In a data transfer class, no methods are required, the class has no need to support future extensibility and the data itself is immutable for the life of the object. The new Java Record type embraces these ideals, and its implementation uses a precise and succinct syntax.
```
record Point(long x, long y) { }
```
* A Record is implicitly final, its state is immutable, it can't be extended and it can't contain instance initializers. The Java Record creates a more readable and understandable syntax, while at the same time, immutable state will allow the JVM to implement efficiencies that will allow programs to perform significant list processing faster, making Java applications more linearly scalable. The Java Record data type is an exciting new addition to the Java language.
------
# Java text blocks
* Java has never prided itself on its ability to perform String manipulation.
* Previously, the simple task of hard-coding formatted text within a Java program was difficult because it required String terminators, concatenators and esoteric escape sequences that made text embedded within a Java program difficult to both read and write. But in Java 17, you can now use text blocks, which make the use of text in a Java program much more natural.
* Compare a traditional block of text embedded within a Java program to the new, Java 17 text block feature.
* Prior to Java 17, the text block looked like this:
```
String oldTextBlock = "<html>\n" +
              "    <body>\n" +
              "        <em>Cool LTS Java 17 Features</em>\n" +
              "    </body>\n" +
              "</html>\n";
```
* Now, it looks like this:
```
String newTextBlock = """
              <html>
                  <body>
                      <em>Cool LTS Java 17 Features</em>\
                  </body>
              </html>
              """;
```
------
# Helpful NullPointerException guidance
* Troubleshooting Java applications typically boils down to a tedious system log scan and a time-consuming analysis of the runtime exceptions that lay within
* A reference to a null object is a common trigger that causes an otherwise well-written program to fail. Unfortunately, the Java logs rarely provide a lot of detail about what the offending object was, or which property the program referenced when it triggered the NullPointException
* In the Java 17 LTS release, developers can take advantage of the new NullPointerException guidance feature. This Java 17 feature improves the usability of an exception's stack trace by logging the exact name of the variable that was null