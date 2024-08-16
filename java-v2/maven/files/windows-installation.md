### [<<Back](../README.md) | [Java V2 All Examples](https://github.com/avinashbabudonthu/java/blob/master/java-v2/README.md) | [Java All Examples](https://github.com/avinashbabudonthu/java/blob/master/README.md)
------
# Maven windows installation
* Install Java
* Set `JAVA_HOME` environment variable
```
JAVA_HOME=C:\Program Files\Java\jdk-17.0.3.1
```
* Download maven zip - https://maven.apache.org/download.cgi
* Extract zip
* Set `MAVEN_HOME` environment variable
```
MAVEN_HOME=[Full path of maven extraction]

MAVEN_HOME=C:\softwares\apache-maven-3.8.5-bin
```
* Edit `PATH` environment variable. Add new value
```
%MAVEN_HOME%\bin
```
* Click Ok on each of environment variables windows
* Open new command prompt
* Check version
```
mvn --version
```
------
### [<<Back](../README.md) | [Java V2 All Examples](https://github.com/avinashbabudonthu/java/blob/master/java-v2/README.md) | [Java All Examples](https://github.com/avinashbabudonthu/java/blob/master/README.md)