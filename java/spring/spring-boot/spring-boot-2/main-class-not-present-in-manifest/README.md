# Main class is not present in Manifest file

## Solution 1
* Use **spring-boot-maven-plugin**
```
<plugin>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-maven-plugin</artifactId>
</plugin>
```

## Solution 2
* Use **repackage** in **execution** tag
```
<plugin>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-maven-plugin</artifactId>
    <version>1.2.5.RELEASE</version>
    <executions>
        <execution>
            <goals>
                <goal>repackage</goal>
            </goals>
        </execution>
    </executions>
</plugin>
```

## Solution 3
* Declare main class in **spring-boot-maven-plugin**
* Declare property for main class
```
<properties>
      <!-- The main class to start by executing "java -jar" -->
      <start-class>com.example.MainApp</start-class>
</properties>
```
* Give main class entry in **spring-boot-maven-plugin**
```
<plugin>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-maven-plugin</artifactId>             
    <executions>
            <execution>
                <goals>
                    <goal>repackage</goal>
                </goals>
                <configuration>
                    <classifier>spring-boot</classifier>
                    <mainClass>${start-class}</mainClass>
                </configuration>
            </execution>
        </executions>
</plugin>
```

## Solution 4
* Using maven executable plugin
```
<plugin>
	<groupId>org.codehaus.mojo</groupId>
	<artifactId>exec-maven-plugin</artifactId>
	<version>1.3.2</version> <!-- This entry is not needed for spring boot applications -->
	<configuration>
		<mainClass>com.test.MainAppClassName</mainClass>
	</configuration>
</plugin>
```