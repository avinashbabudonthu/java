# Dependency Injection using XML

## Create project
### Maven command
```
mvn archetype:generate -DgroupId=com.dependency.injection.xml -DartifactId=dependency-injection-xml -Dversion=1.0 -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
```
### Add Gradle
```
gradle init --type pom
```
## Dependencies
* Refer [pom.xml](pom.xml) or [build.gradle](build.gradle) for dependencies

## Examples
* [Setter Injection](#setter-injection)
* [Constructor Injection](#constructor-injection)
* [Autowire dependency injection byType](src/main/java/autowire/by/type)
* [Autowire dependency injection by constructor](src/main/java/autowire/constructor)
* [Date injection](src/main/java/date/injection)
* [Properties injection](src/main/java/properties/injection)

## Spring Config file
* `beans` tag: Parent tag for all spring beans in spring config file
* `bean` tag: Tag to create spring bean
* Inject property of bean class either with `p:[property-name]` or `property` tag
```
<bean name="student1" class="setter.injection.Student" p:id="1" p:grade="3.24">
<property name="name" value="jill" />
```
* To inject value to property use **value** attribute of **property** tag
```
<property name="name" value="jill" />
```
* To inject one bean to another bean property use **ref** attribute of **property** tag
```
<property name="student" ref="student1" />
```
* `constructor-arg` to do dependency injection using constructor
```
<constructor-arg index="0" ref="student1" />
```

## Setter Injection
* Refer classes in package [src/main/java/setter/injection](src/main/java/setter/injection)
* Create beans and do dependency injection in spring config file. Refer [src/main/resources/setter.injection/setter-injection.xml](src/main/resources/setter.injection/setter-injection.xml)
* Create **Student** bean. Inject values
* Create **StudentRepository** bean. Inject **Student** bean
* Create **StudentService** bean. Inject **StudentRepository** bean
* Get **StudentService** bean from spring config file using **ClassPathXmlApplicationContext**. Refer [src/main/java/setter/injection/App.java](src/main/java/setter/injection/App.java)

## Constructor Injection
* Refer classes in [src/main/java/basic/constructor/injection](src/main/java/basic/constructor/injection)
* Create beans and do dependency injection in spring config file. Refer [src/main/resources/basic.constructor.injection/applicationContext.xml](src/main/resources/basic.constructor.injection/applicationContext.xml)
* Create **Student** bean. Inject values 
* Create **StudentRepository** bean. Inject **Student** bean using **constructor-arg** tag
```
<constructor-arg index="0" ref="student1" />
```
* Create **StudentService** bean. Inject **StudentRepository** bean using **constructor-arg** tag
* Get **StudentService** bean from spring config file using **ClassPathXmlApplicationContext**. Refer [src/main/java/basic/constructor/injection/App.java](src/main/java/basic/constructor/injection/App.java)

## Run this project
* Import project into IDE as Maven or Gradle project
* Execute App class in each package