### [<<Back](../README.md) | [Java V2 All Examples](https://github.com/avinashbabudonthu/java/blob/master/java-v2/README.md) | [Java All Examples](https://github.com/avinashbabudonthu/java/blob/master/README.md)
------
# Skip Tests
* To skip running the tests for a particular project, set the skipTests property to true
```
<project>
  [...]
  <build>
    <plugins>
      <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-surefire-plugin</artifactId>
        <version>2.19.1</version>
        <configuration>
          <skipTests>true</skipTests>
        </configuration>
      </plugin>
    </plugins>
  </build>
  [...]
</project>
```
* Skip the tests via the command line by executing the following command
```
mvn install -DskipTests
```
* Can also use the `maven.test.skip` property to skip compiling the tests. maven.test.skip is honored by Surefire, Failsafe and the Compiler Plugin
```
mvn install -Dmaven.test.skip=true
```
* Skipping by Default - If you want to skip tests by default but want the ability to re-enable tests from the command line, you need to go via a properties section in the pom.xml. This will allow you to run with tests disabled by default and to run them with this command `mvn install -DskipTests=false`
```
<project>
  [...]
  
  <properties>
    <skipTests>true</skipTests>
  </properties>
  
  [...]
  
  <build>
    <plugins>
      <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-surefire-plugin</artifactId>
        <version>2.19.1</version>
        <configuration>
          <skipTests>${skipTests}</skipTests>
        </configuration>
      </plugin>
    </plugins>
  </build>
  
  [...]
</project>
```
------
### [<<Back](../README.md) | [Java V2 All Examples](https://github.com/avinashbabudonthu/java/blob/master/java-v2/README.md) | [Java All Examples](https://github.com/avinashbabudonthu/java/blob/master/README.md)