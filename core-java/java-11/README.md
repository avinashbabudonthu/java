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
# Improved Aarch64 Intrinsics
* Java 11 optimizes the existing string and array intrinsics on ARM64 or AArch64 processors. Additionally, new intrinsics are implemented for sin, cos, and log methods of java.lang.Math
* We use an intrinsic function like any other; however, the intrinsic function gets handled in a special way by the compiler. It leverages CPU architecture-specific assembly code to boost performance
------
# A No-Op Garbage Collector
* A new garbage collector called `Epsilon` is available for use in Java 11 as an experimental feature
* It's called a No-Op (no operations) because it allocates memory but does not actually collect any garbage. Thus, Epsilon is applicable for simulating out of memory errors
* Obviously Epsilon won't be suitable for a typical production Java application; however, there are a few specific use-cases where it could be useful
	* Performance testing
	* Memory pressure testing
	* VM interface testing
	* Extremely short-lived jobs
* In order to enable it, use the `-XX:+UnlockExperimentalVMOptions -XX:+UseEpsilonGC` flag
------
# Flight Recorder
* Java Flight Recorder (JFR) is now open-source in Open JDK, whereas it used to be a commercial product in Oracle JDK. JFR is a profiling tool that we can use to gather diagnostics and profiling data from a running Java application
* To start a 120 seconds JFR recording, we can use the following parameter
```
-XX:StartFlightRecording=duration=120s,settings=profile,filename=java-demo-app.jfr
```
* We can use JFR in production since its performance overhead is usually below 1%. Once the time elapses, we can access the recorded data saved in a JFR file; however, in order to analyze and visualize the data, we need to make use of another tool called `JDK Mission Control (JMC)`
------
## Removed and Deprecated Modules
* As Java evolves, we can no longer use any of its removed features and should stop using any deprecated features. Let's take a quick look at the most notable ones.

### Java EE and CORBA
* Standalone versions of the Java EE technologies are available on third-party sites; therefore, there is no need for Java SE to include them.
	* Java 9 already deprecated selected Java EE and CORBA modules. In release 11, it has now completely removed:
	* Java API for XML-Based Web Services (java.xml.ws)
	* Java Architecture for XML Binding (java.xml.bind)
	* JavaBeans Activation Framework (java.activation)
	* Common Annotations (java.xml.ws.annotation)
	* Common Object Request Broker Architecture (java.corba)
	* JavaTransaction API (java.transaction)
	
### JMC and JavaFX
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