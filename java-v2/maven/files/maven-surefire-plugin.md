### [<<Back](../README.md) | [Java V2 All Examples](https://github.com/avinashbabudonthu/java/blob/master/java-v2/README.md) | [Java All Examples](https://github.com/avinashbabudonthu/java/blob/master/README.md)
------
# Run test cases with maven-surefire-plugin
* We can run the tests of a project using the surefire plugin. By default, this plugin generates XML reports in the directory target/surefire-reports.
* This plugin has only one goal, test. This goal is bound to the test phase of the default build lifecycle, and the command mvn test will execute it
* The surefire plugin can work with the test frameworks JUnit and TestNG. No matter which framework we use, the behavior of surefire is the same
* By default, surefire automatically includes all test classes whose name starts with Test, or ends with Test, Tests or TestCase
* We can change this configuration using the excludes and includes parameters
```
<plugin>
    <artifactId>maven-surefire-plugin</artifactId>
    <version>3.2.5</version>
    <configuration>
        <excludes>
            <exclude>DataTest*.java</exclude>
        </excludes>
        <includes>
            <include>DataCheck*.java</include>
        </includes>
    </configuration>
</plugin>
```
* Refer central repository for latest version - https://mvnrepository.com/artifact/org.apache.maven.plugins/maven-surefire-plugin
* Source code - https://github.com/eugenp/tutorials/tree/master/maven-modules/maven-integration-test
------
### [<<Back](../README.md) | [Java V2 All Examples](https://github.com/avinashbabudonthu/java/blob/master/java-v2/README.md) | [Java All Examples](https://github.com/avinashbabudonthu/java/blob/master/README.md)