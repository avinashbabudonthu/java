### [<<Back](../README.md) | [Java V2 All Examples](https://github.com/avinashbabudonthu/java/blob/master/java-v2/README.md) | [Java All Examples](https://github.com/avinashbabudonthu/java/blob/master/README.md)
------
# Maven dependency scopes
------
# There are 6 scopes in maven
* compile
* provided
* runtime
* test
* system
* import
------
# compile
* This is maven default scope
* Dependencies with compile scope are needed to build, test, and run the project
```
<dependencies>
    <dependency>
        <groupId>log4j</groupId>
        <artifactId>log4j</artifactId>
        <version>1.2.14</version>
        <!-- You can ommit this because it is default -->
        <scope>compile</scope>
    </dependency>
</dependencies>
```
------
# provided
* Maven dependency scope provided is used during build and test the project
* They are also required to run, but should not exported, because the dependency will be provided by the runtime, for instance, by servlet container or application server
```
<dependency>
    <groupId>javax.servlet</groupId>
    <artifactId>servlet-api</artifactId>
    <version>3.0.1</version>
    <scope>provided</scope>
</dependency>
```
------
# runtime
* Dependencies with maven dependency scope runtime are not needed to build, but are part of the classpath to test and run the project
```
<dependency>
    <groupId>com.thoughtworks.xstream</groupId>
    <artifactId>xstream</artifactId>
    <version>1.4.4</version>
    <scope>runtime</scope>
 </dependency>
```
------
# test
* Dependencies with maven dependency scope test are not needed to build and run the project
* They are needed to compile and run the unit tests
```
<dependency>
    <groupId>junit</groupId>
    <artifactId>junit</artifactId>
    <version>4.12</version>
    <scope>test</scope>
</dependency>
```
------
# system
* Dependencies with system are similar to ones with scope provided. 
* The only difference is system dependencies are not retrieved from remote repository.
* They are present under project’s subdirectory and are referred from there
```
<dependency>
  <groupId>extDependency</groupId>
  <artifactId>extDependency</artifactId>
  <scope>system</scope>
  <version>1.0</version>
  <systemPath>${basedir}\war\WEB-INF\lib\extDependency.jar</systemPath>
</dependency>
```
------
# import
* import scope is only supported on a dependency of type pom in the dependencyManagement section. 
* It indicates the dependency to be replaced with the effective list of dependencies in the specified POM’s dependencyManagement section
```
<dependencyManagement>
    <dependencies>
        <dependency>
            <groupId>other.pom.group.id</groupId>
            <artifactId>other-pom-artifact-id</artifactId>
            <version>SNAPSHOT</version>
            <scope>import</scope>
            <type>pom</type>
        </dependency>   
    </dependencies>
</dependencyManagement>
```
------
### [<<Back](../README.md) | [Java V2 All Examples](https://github.com/avinashbabudonthu/java/blob/master/java-v2/README.md) | [Java All Examples](https://github.com/avinashbabudonthu/java/blob/master/README.md)