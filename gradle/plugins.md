* Java plugin
```
apply plugin: "java"

plugins {
    id "java"
    id "maven"
    id "eclipse" 
}
```
* Groovy Plugin
```
apply plugin: "groovy"
```
* To make the application executable
```
apply plugin: "application"
```
* Maven Plugin
```
apply plugin: "maven"
```
* Apply plugins from other gradle files. Path is relative to project directory
```
apply from: "other.gradle"
```