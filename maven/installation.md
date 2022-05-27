# Maven Installation
* Download Maven archive from [here](http://maven.apache.org/download.html)
* Windows: apache-maven-2.0.11-bin.zip
* Linux: apache-maven-2.0.11-bin.tar.gz
* Mac: apache-maven-2.0.11-bin.tar.gz
* Extract maven archive
* Setup environment variables
* Set **M2_HOME**
```
M2_HOME=C:\Program Files\Apache Software Foundation\apache-maven-2.2.1
```
* Set **M2**
```
M2=%M2_HOME%\bin
```
* Set **MAVEN_OPTS**
```
MAVEN_OPTS=-Xms256m -Xmx512m
```
* Add maven bin directory location to system path
* Append the string **;%M2%** to the end of the system variable, Path
* Verify maven installation
* Open command prompt
* Run below command
```
mvn --version
```
* Output
```
Apache Maven 3.3.3 (7994120775791599e205a5524ec3e0dfe41d4a06; 2015-04-22T17:27:37+05:30)
Maven home: C:\JavaPrep\apache-maven-3.3.3
Java version: 1.8.0_40, vendor: Oracle Corporation
Java home: C:\Program Files\Java\jdk1.8.0_40\jre
Default locale: en_US, platform encoding: Cp1252
OS name: "windows 7", version: "6.1", arch: "amd64", family: "dos"
```