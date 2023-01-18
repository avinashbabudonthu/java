# Java 11 features
1. JEP 181: Nest-Based Access Control
2. JEP 309: Dynamic Class-File Constants
3. JEP 315: Improve Aarch64 Intrinsics
4. JEP 318: Epsilon: A No-Op Garbage Collector (Experimental)
5. JEP 320: Remove the Java EE and CORBA Modules
6. JEP 321: HTTP Client (Standard)
7. JEP 323: Local-Variable Syntax for Lambda Parameters
8. JEP 324: Key Agreement with Curve25519 and Curve448
9. JEP 327: Unicode 10
10. JEP 328: Flight Recorder
11. JEP 329: ChaCha20 and Poly1305 Cryptographic Algorithms
12. JEP 330: Launch Single-File Source-Code Programs
13. JEP 331: Low-Overhead Heap Profiling
14. JEP 332: Transport Layer Security (TLS) 1.3
15. JEP 333: ZGC: A Scalable Low-Latency Garbage Collector (Experimental)
16. JEP 335: Deprecate the Nashorn JavaScript Engine
17. JEP 336: Deprecate the Pack200 Tools and API
------
# Java 11 developer features
* New HTTP Client APIs `java.net.http.*`
* `var` in lambda parameters
* Java fright recorder (JFR)
* Launch single-file program `java ClassName.java`
* Support `ChaCha20` cryptography algorithm
------
# JEP 181: Nest-Based Access Control

* Further Reading - [JEP 181: Nest-Based Access Control](https://openjdk.org/jeps/181)
* [java-11-nest-based-access-control](https://mkyong.com/java/java-11-nest-based-access-control/)
------
# Running Java Files
* A major change in this version is that we don't need to compile the Java source files with `javac` explicitly anymore:
```
$ javac HelloWorld.java
$ java HelloWorld 
Hello Java 8!
```
* Instead, we can directly run the file using the `java` command
```
$ java HelloWorld.java
Hello Java 11!
```
------
# Dynamic Class-File Constants
* Java class-file format is extended to support a new constant-pool form named `CONSTANT_Dynamic`
* Loading the new constant-pool will delegate creation to a bootstrap method, just as linking an invokedynamic call site delegates linkage to a bootstrap method
* This feature enhances performance and targets language designers and compiler implementors
------
# JEP 315: Improve Aarch64 Intrinsics
* Java 11 optimizes the existing string and array intrinsics on ARM64 or AArch64 processors. Additionally, new intrinsics are implemented for sin, cos, and log methods of java.lang.Math
* We use an intrinsic function like any other; however, the intrinsic function gets handled in a special way by the compiler. It leverages CPU architecture-specific assembly code to boost performance
* An [intrinsic](https://en.wikipedia.org/wiki/Intrinsic_function) is used to leverage CPU architecture-specific assembly code to improve the performance.
* Further Reading - [JEP 315: Improve Aarch64 Intrinsics](https://openjdk.org/jeps/315)
------
# JEP 318: Epsilon: A No-Op Garbage Collector (Experimental)
* A new garbage collector called `Epsilon` is available for use in Java 11 as an experimental feature
* It's called a No-Op (no operations) because it allocates memory but does not actually collect any garbage. Thus, Epsilon is applicable for simulating out of memory errors
* Obviously Epsilon won't be suitable for a typical production Java application; however, there are a few specific use-cases where it could be useful
	* Performance testing
	* Memory pressure testing
	* VM interface testing
	* Extremely short-lived jobs
* In order to enable it, use the `-XX:+UnlockExperimentalVMOptions -XX:+UseEpsilonGC` flag
* Further Reading - [JEP 318: Epsilon: A No-Op Garbage Collector (Experimental)](https://openjdk.org/jeps/318)
------
# JEP 328: Flight Recorder
* Java Flight Recorder (JFR) is now open-source in Open JDK 11, whereas it used to be a commercial product in Oracle JDK. JFR is a profiling tool that we can use to gather diagnostics and profiling data from a running Java application
* To start a 120 seconds JFR recording, we can use the following parameter
```
-XX:StartFlightRecording=duration=120s,settings=profile,filename=java-demo-app.jfr
```
* The below command starts a 60 seconds JFR recording on a Java application, dumps the recorded data into a ‘.jfr’ file
```
$ java -XX:StartFlightRecording=duration=60s,settings=profile,filename=app.jfr MyApp
```
* So what to do with the .jfr file? We can use [Java Mission Control (JMC)](https://openjdk.org/projects/jmc/) to analyze and visualize the .jfr file
* We can use JFR in production since its performance overhead is usually below 1%. Once the time elapses, we can access the recorded data saved in a JFR file; however, in order to analyze and visualize the data, we need to make use of another tool called `JDK Mission Control (JMC)`
------
# JEP 320: Remove the Java EE and CORBA Modules
* Standalone versions of the Java EE technologies are available on third-party sites; therefore, there is no need for Java SE to include them.
* Java 9 deprecated the following Java EE and CORBA modules and now removed in Java 11. If you want to migrate to Java 11, make sure your project didn’t use any of the following packages or tools
* Removed packages
	* java.xml.ws - Java API for XML-Based Web Services
	* java.xml.ws.annotation - Common Annotations
	* java.xml.bind - Java Architecture for XML Binding
	* java.activation - JavaBeans Activation Framework
	* java.corba - Common Object Request Broker Architecture
	* java.transaction - JavaTransaction API
	* java.se.ee - Aggregator module for the six modules above
* Removed Tools
	* wsgen and wsimport (from jdk.xml.ws)
	* schemagen and xjc (from jdk.xml.bind)
	* idlj, orbd, servertool, and tnamesrv (from java.corba)
* Further Reading - [JEP 320: Remove the Java EE and CORBA Modules](https://openjdk.org/jeps/320)
------
# 6. JEP 321: HTTP Client (Standard)
* This HTTP Client API, in the java.net.http package was introduced in Java 9, updated in Java 10, now a standard feature in Java 11.
* A Java 11 HttpClient to send a simple GET request
```
HttpClient httpClient = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_1_1)
            .connectTimeout(Duration.ofSeconds(10))
            .build();

HttpRequest request = HttpRequest.newBuilder()
		.GET()
		.uri(URI.create("https://localhost:8080/get"))
		.setHeader("User-Agent", "Java 11 HttpClient Bot")
		.build();

HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

HttpHeaders headers = response.headers();
headers.map().forEach((key, value) -> System.out.println(key + ":" + value));

System.out.println(response.statusCode());

System.out.println(response.body());
```
* Further Reading
	* [JEP 321: HTTP Client (Standard)](https://openjdk.org/jeps/321)
	* [Java 11 HttpClient Examples](https://mkyong.com/java/java-11-httpclient-examples/)
------
# JMC and JavaFX
* JDK Mission Control (JMC) is no longer included in the JDK. A standalone version of JMC is now available as a separate download
* The same is true for JavaFX modules; JavaFX will be available as a separate set of modules outside of the JDK

### Deprecated Modules
* Furthermore, Java 11 deprecated the following modules
	* Nashorn JavaScript engine, including the JJS tool
	* Pack200 compression scheme for JAR files
------
## Miscellaneous Changes
* Java 11 introduced a few more changes that are important to mention
* New `ChaCha20` and `ChaCha20-Poly1305` cipher implementations replace the insecure `RC4 stream cipher`
* Support for cryptographic key agreement with Curve25519 and Curve448 replace the existing ECDH scheme
* Upgraded Transport Layer Security (TLS) to version 1.3 brings security and performance improvements
* Introduced a low latency garbage collector, ZGC, as an experimental feature with low pause times
* Support for Unicode 10 brings more characters, symbols, and emojis
------
# References
* https://mkyong.com/java/what-is-new-in-java-11/
* https://www.javatpoint.com/java-8-vs-java-11
* https://www.tutorialspoint.com/java11/java11_quick_guide.htm