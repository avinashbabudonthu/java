# Basic Authentication Authorization API With MySQL DB

## Requirement
* Authentication implementation
* API to create new user
* Get existing users
* Update user
* Password encoding

## Create project using maven
```
mvn archetype:generate -DgroupId=basic.authentication.authorization -DartifactId=basic-authentication-authorization -Dversion=1.0 -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
```

## Add gradle
```
gradle init --type pom
```

## Steps
* Create database. Refer [database/db.sql](database/db.sql)
* Create tables. Refer [database/schema.sql](database/schema.sql)
* Insert data. Refer [database/data.sql](database/data.sql)
* Drop tables. Refer [database/drop.sql](database/drop.sql)
* Select queries. Refer [database/select.sql](database/select.sql)
* Delete queries. Refer [database/delete.sql](database/delete.sql)
* Create Entity, Repository, Service classes
* Add DB properties in **application.properties**. Refer [src/main/resources/application.properties](src/main/resources/application.properties)
* Add spring security dependencies. Refer [pom.xml](pom.xml) (or) [build.gradle](build.gradle)
* Configure security. Refer [src/main/java/basic/authentication/authorization/configuration/SecurityConfig.java](src/main/java/basic/authentication/authorization/configuration/SecurityConfig.java)
* Make **UserModel** as request scoped bean
* Refer [src/main/java/basic/authentication/authorization/controller](src/main/java/basic/authentication/authorization/controller) for controllers 

## API
* Refer [files/basic-authentication-authorization.postman_collection.json](files/basic-authentication-authorization.postman_collection.json)

## Run project from IDE
* Import project into IDE as **Maven** or **Gradle** project
* Execute **basic.authentication.authorization.App**

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
java -jar target\basic-authentication-authorization-1.0.jar
```

## Create package using gradle
```
gradlew clean compileJava build
```

## Execute jar of Gradle
```
java -jar build\libs\basic-authentication-authorization-1.0.jar
```