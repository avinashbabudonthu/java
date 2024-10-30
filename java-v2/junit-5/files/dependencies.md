### [<<Back](../README.md) | [Java V2 All Examples](https://github.com/avinashbabudonthu/java/blob/master/java-v2/README.md) | [Java All Examples](https://github.com/avinashbabudonthu/java/blob/master/README.md)
------
# Junit 5 dependencies
* Add following dependencies for Junit 5 test cases
* Check maven central for latest versions
```
<dependency>
	<groupId>org.junit.jupiter</groupId>
	<artifactId>junit-jupiter-engine</artifactId>
	<version>5.8.1</version>
	<scope>test</scope>
</dependency>

<dependency>
	<groupId>org.junit.platform</groupId>
	<artifactId>junit-platform-launcher</artifactId>
	<version>1.4.2</version>
</dependency>
```
* If below exception comes due to above dependencies then add another dependency given below
```
No tests found

Exception in thread "main" java.lang.NoClassDefFoundError: org/junit/platform/commons/PreconditionViolationException
	at com.intellij.junit5.JUnit5TestRunnerUtil.createClassSelector(JUnit5TestRunnerUtil.java:226)
	at com.intellij.junit5.JUnit5TestRunnerUtil.createSelector(JUnit5TestRunnerUtil.java:213)
	at com.intellij.junit5.JUnit5TestRunnerUtil.buildRequest(JUnit5TestRunnerUtil.java:101)
	at com.intellij.junit5.JUnit5IdeaTestRunner.startRunnerWithArgs(JUnit5IdeaTestRunner.java:43)
	at com.intellij.rt.junit.IdeaTestRunner$Repeater$1.execute(IdeaTestRunner.java:38)
	at com.intellij.rt.execution.junit.TestsRepeater.repeat(TestsRepeater.java:11)
	at com.intellij.rt.junit.IdeaTestRunner$Repeater.startRunnerWithArgs(IdeaTestRunner.java:35)
	at com.intellij.rt.junit.JUnitStarter.prepareStreamsAndStart(JUnitStarter.java:232)
	at com.intellij.rt.junit.JUnitStarter.main(JUnitStarter.java:55)
Caused by: java.lang.ClassNotFoundException: org.junit.platform.commons.PreconditionViolationException
	at java.base/jdk.internal.loader.BuiltinClassLoader.loadClass(BuiltinClassLoader.java:641)
	at java.base/jdk.internal.loader.ClassLoaders$AppClassLoader.loadClass(ClassLoaders.java:188)
	at java.base/java.lang.ClassLoader.loadClass(ClassLoader.java:520)
	... 9 more
```
* Add below dependency if we get above exception & remove above dependencies. Below dependency is aggregator for all required dependencies
```
<dependency>
	<groupId>org.junit.jupiter</groupId>
	<artifactId>junit-jupiter-api</artifactId>
	<version>5.11.3</version>
	<scope>test</scope>
</dependency>
```
------
# For Junit4 Compatibility
* Add following dependencies for our test cases to be JUnit4 (vintage) compatible, for IDEs that have no support for JUnit 5 yet then include these dependencies
* Check maven central for latest versions
```
 <dependency>
	<groupId>org.junit.platform</groupId>
	<artifactId>junit-platform-runner</artifactId>
	<version>1.2.0</version>
	<scope>test</scope>
</dependency>
<dependency>
	<groupId>org.junit.vintage</groupId>
	<artifactId>junit-vintage-engine</artifactId>
	<version>5.8.1</version>
	<scope>test</scope>
</dependency>
```
------
### [<<Back](../README.md) | [Java V2 All Examples](https://github.com/avinashbabudonthu/java/blob/master/java-v2/README.md) | [Java All Examples](https://github.com/avinashbabudonthu/java/blob/master/README.md)