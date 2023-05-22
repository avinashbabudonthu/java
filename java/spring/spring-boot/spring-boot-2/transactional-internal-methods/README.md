# Using Transactional annotation on public and private methods

## Requirement
* **@Transactional** should be applied on private methods
* Should be able to save each object by declaring **@Transactional** annotation on private method
* Should be able to save all objects in one transaction by declaring **@Transactional** annotation on public method

## Create project using maven
```
mvn archetype:generate -DgroupId=com.internal.methods.transactional -DartifactId=transactional-internal-methods -Dversion=1.0 -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
```

## Add gradle
```
gradle init --type pom
```

## Steps
* Add following dependencies. Refer [pom.xml](pom.xml) or [build.gradle](build.gradle)
```
spring boot
actuator
devtools
lombok
starter data jpa
mysql connector
```
* Create DB and user in mysql. Refer [Create DB and user scripts](https://github.com/avinashbabudonthu/sql/blob/master/mysql/create-db-and-user.sql)
* Create table. Refer [Create tables scripts](db/create_tables.sql)
* Refer [Select queries](db/select.sql), [Delete queries](db/delete.sql)
* Add database properties in [application.properties](src/main/resources/application.properties)
* Create [StudentEntity](src/main/java/com/internal/methods/transactional/entity/StudentEntity.java)
* Create [StudentModel](src/main/java/com/internal/methods/transactional/model/StudentModel.java)
* Create [StudentRepository](src/main/java/com/internal/methods/transactional/repository/StudentRepository.java)
* Create [StudentService](src/main/java/com/internal/methods/transactional/service/StudentService.java)
* Write private method **saveAndCommitEachStudentEntity()** in [StudentService](src/main/java/com/internal/methods/transactional/service/StudentService.java) and declare **@Transactional** annotation. This method will insert each object
* Write public method **saveAndCommitAllStudentModels()** in [StudentService](src/main/java/com/internal/methods/transactional/service/StudentService.java) and declare **@Transactional** annotation. This method will insert all objects in one transaction
* Create [StudentController](src/main/java/com/internal/methods/transactional/controller/StudentController.java)
* API **/save-and-commit-each-student-model** - **saveAndCommitEachStudentModel()** used to test **@Transactional** on private method
* API **/save-and-commit-all-student-models** - **saveAndCommitAllStudentModels()** used to test **@Transactional** on public method
* Create [App](src/main/java/com/internal/methods/transactional/App.java). Declare **@EnableAspectJAutoProxy(proxyTargetClass = true)** at class level

## Postman collection
* Import [postman-collection/transactional-internal-methods.postman_collection.json](postman-collection/transactional-internal-methods.postman_collection.json) for API
* Import [postman-collection/transactional-internal-methods.postman_environment.json](postman-collection/transactional-internal-methods.postman_environment.json) for postman environments

## Run this project
* Import project into IDE as Maven or Gradle project
* Execute App class in each package

## Run using maven
```
mvn clean compile spring-boot:run
```

## Run using gradle
```
gradlew clean compileJava bootRun
```

## Create package using maven
```
mvn clean compile package
```

## Execute jar of Maven
```
java -jar target\transactional-internal-methods.jar
```

## Create package using gradle
```
gradlew clean compileJava build
```

## Execute jar of Gradle
```
java -jar build\libs\transactional-internal-methods-1.0.jar
```
