# Files
* Dependencies - [pom.xml](pom.xml)
* Application properties - [application.yml](src/main/resources/application.yml)
* Graphql schema - [schema.graphqls](src/main/resources/schema/schema.graphqls)

# Run App
* Run main class - [App](src/main/java/com/java/App.java)
* Open url - http://localhost:9000/graphiql
  * UI to write and execute graphql queries
* Postman collection - [graph-ql-spring-boot.postman_collection.json](files/graph-ql-spring-boot.postman_collection.json)
  * Import to postman to check graphql queries 
  
# Examples
* Graphql schema - [query.graphqls](src/main/resources/schema/schema.graphqls)
* firstQuery - [firstQuery method](src/main/java/com/java/query/Query.java)
* fullName - [fullName method](src/main/java/com/java/query/Query.java)
* studentRequest - [studentRequest method](src/main/java/com/java/query/Query.java)
* Update default `/graphiql` url - refer [application.yml](src/main/resources/application.yml)
```
graphiql.mapping: /app-ui
```
* Update default `/graphql` url - refer [application.yml](src/main/resources/application.yml)
```
graphql.servlet.mapping: /app
```
* JSON as response
  * studentAsResponse - [schema.graphqls](src/main/resources/schema/schema.graphqls)
  * [studentAsResponse method](src/main/java/com/java/query/Query.java)
* Response with list
  * responseWithList - [schema.graphqls](src/main/resources/schema/schema.graphqls)
  * [responseWithList method](src/main/java/com/java/query/Query.java)