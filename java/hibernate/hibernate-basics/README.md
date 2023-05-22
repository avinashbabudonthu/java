# Hibernate Basics

## Requirement
* Create
* Read
* Update
* Delete

## Create project using maven
```
mvn archetype:generate -DgroupId=com.hibernate.basics -DartifactId=hibernate-basics -Dversion=1.0 -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
```

## Add gradle
```
gradle init --type pom
```

## DB Scripts
* Refer - **create.sql**, **drop.sql**, **select.sql** in [db-mysql](db-mysql)

## Examples
* [Save - save()](src/test/java/com/hibernate/basics/Create.java)
* [Save or Update - saveOrUpdate()](src/test/java/com/hibernate/basics/Create.java)
* [Find All - findAll()](src/test/java/com/hibernate/basics/Read.java)
* [Get By Id - get()](src/test/java/com/hibernate/basics/Read.java)
* [Update - update()](src/test/java/com/hibernate/basics/Update.java)
* [Delete - delete()](src/test/java/com/hibernate/basics/Delete.java)
* [Enum Mapping with Ordinal](src/main/java/com/hibernate/basics/model/Student.java)
* [Enum Mapping with Value](src/main/java/com/hibernate/basics/model/Student.java)
* [Date Mapping](src/main/java/com/hibernate/basics/model/Student.java)

## References
* [https://www.baeldung.com/jpa-persisting-enums-in-jpa](https://www.baeldung.com/jpa-persisting-enums-in-jpa)
