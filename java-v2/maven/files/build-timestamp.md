### [<<Back](../README.md) | [Java V2 All Examples](https://github.com/avinashbabudonthu/java/blob/master/java-v2/README.md) | [Java All Examples](https://github.com/avinashbabudonthu/java/blob/master/README.md)
------
# Using maven build timestamp in jar file name
* Define property for timestamp format
```
<properties>
	<maven.build.timestamp.format>yyyy-MM-dd HH:mm</maven.build.timestamp.format>
</properties>
```
* Use in-build variable `${maven.build.timestamp}`
```
<build>
	<finalName>${project.artifactId}-${project.version}-${maven.build.timestamp}</finalName>
</build>
```
------
### [<<Back](../README.md) | [Java V2 All Examples](https://github.com/avinashbabudonthu/java/blob/master/java-v2/README.md) | [Java All Examples](https://github.com/avinashbabudonthu/java/blob/master/README.md)