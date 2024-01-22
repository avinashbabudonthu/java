# Graphql Hello World Example
* This example works with Java 8
* Add below dependencies
```
<dependency>
    <groupId>com.graphql-java</groupId>
    <artifactId>graphql-spring-boot-starter</artifactId>
    <version>5.0.2</version>
</dependency>

<dependency>
    <groupId>com.graphql-java</groupId>
    <artifactId>graphql-java-tools</artifactId>
    <version>5.2.4</version>
</dependency>

<dependency>
    <groupId>com.graphql-java</groupId>
    <artifactId>graphiql-spring-boot-starter</artifactId>
    <version>5.0.2</version>
</dependency>
```
* Add spring boot dependencies
* Main class - [HelloWorlApplication](src/main/java/com/ab/graphql/HelloWorldApplication.java)
* Define Query resolver class - [Query](src/main/java/com/ab/graphql/component/Query.java)
  * This class implements interface `com.coxautodev.graphql.tools.GraphQLQueryResolver`
  * Implement our methods - `helloWorld`, `helloWorld2`
* Write schema file - [query.graphqls](src/main/resources/graphql/query.graphqls)
* Refer postman collection for API details - [postman](files/postman/hello-world.postman_collection.json)