### [<<Back](../README.md) | [Java V2 All Examples](https://github.com/avinashbabudonthu/java/blob/master/java-v2/README.md) | [Java All Examples](https://github.com/avinashbabudonthu/java/blob/master/README.md)
------
# Enable Dependency Management in Parent Project
* Dependency management is a mechanism for centralizing the dependency information for a multi-module parent project and its children.
* When you have a set of projects or modules that inherit a common parent, you can put all the required information about the dependencies in the common pom.xml file. This will simplify the references to the artifacts in the child POMs.
* parent [parent/pom.xml](parent/pom.xml)
```
<dependencyManagement>
	<dependencies>
		<dependency>
			<groupId>junit</groupId>
			<artifactId>junit</artifactId>
			<version>4.12</version>
			<scope>test</scope>
		</dependency>
	</dependencies>
</dependencyManagement>
```
* By declaring the `junit` version in the parent, all submodules that depend on `junit` can declare the dependency using only the groupId and artifactId, and the version will be inherited
```
<dependency>
	<groupId>junit</groupId>
	<artifactId>junit</artifactId>
	<scope>test</scope>
</dependency>
```
* Moreover, you can provide exclusions for dependency management in parent's pom.xml, so that specific libraries will not be inherited by child modules
```
<exclusions>
    <exclusion>
        <groupId>org.hamcrest</groupId>
        <artifactId>hamcrest-core</artifactId>
    </exclusion>
</exclusions>
```
* Finally, if a child module needs to use a different version of a managed dependency, you can override the managed version in the child's pom.xml file
```
<dependency>
	<groupId>junit</groupId>
	<artifactId>junit</artifactId>
	<version>4.13</version>
	<scope>test</scope>
</dependency>
```
------
# dependencyManagement vs dependencies
* `dependencies` tag - dependencies downloaded automatically - means sub modules no need to write `<dependency>` tag 
* `dependencyManagement` tag - sub module have to declare `<dependency>` to inherit dependencies from parent
* Refer [parent/pom.xml](parent/pom.xml)
* If we comment `<dependencies>` and uncomment `<dependencyManagement>` then compilation error will come in sub module test classes
	* [controller/AppTest](parent/controller/src/test/java/com/java/maven/AppTest.java)
	* [repository/AppTest](parent/repository/src/test/java/com/java/maven/AppTest.java)
	* [service/AppTest](parent/service/src/test/java/com/java/maven/AppTest.java)
* In child we can remove `<groupId>`, `<version>` tags. In this case they will be inherited from `parent`
------
### [<<Back](../README.md) | [Java V2 All Examples](https://github.com/avinashbabudonthu/java/blob/master/java-v2/README.md) | [Java All Examples](https://github.com/avinashbabudonthu/java/blob/master/README.md)