# Dependency Injection using Xml

## Create project using maven
```
mvn archetype:generate -DgroupId=spring.boot2.graphql -DartifactId=graphql -Dversion=1.0 -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
```

## Add gradle
```
gradle init --type pom
```

## Versions
* Maven **3.5.2**
* Gradle **5.0**

## Dependencies
* org.springframework.boot:spring-boot-starter-web
* com.graphql-java:graphql-spring-boot-starter:5.0.2
* com.graphql-java:graphql-java-tools:5.2.4
* com.graphql-java:graphiql-spring-boot-starter:5.0.2
* org.projectlombok:lombok:1.18.4
* org.projectlombok:lombok:1.18.4
* testorg.projectlombok:lombok:1.18.4
* annotationProcessor org.projectlombok:lombok:1.18.4
* testAnnotationProcessor org.projectlombok:lombok:1.18.4

## Steps
* Main class - **spring.boot2.graphql.App**
* properties file - **src/main/resources/application.properties**
* GraphQl is enabled with dependencies **graphql-spring-boot-starter**, **graphql-java-tools**
* GraphQl server is enabled with dependency **graphiql-spring-boot-starter**
* Write GraphQl queries in **src/main/resources/graph-ql/application.graphqls**. Refer [GraphQl Queries](#graphql-queries)
* For error handling write class implement **graphql.GraphQLError**. Refer **ApplicationNotFoundException**

### GraphQl Queries
* We have Query and Mutation operations declared
* Query operations performed by class implements **com.coxautodev.graphql.tools.GraphQLQueryResolver**. Refer **spring.boot2.graphql.query.resolver.AppQueryResolver**
* Mutation operations performed by class implements **com.coxautodev.graphql.tools.GraphQLMutationResolver**. Refer **spring.boot2.graphql.query.resolver.AppMutatonResolver**

## Run this project
* Import project into IDE as Maven or Gradle project
* Execute App class in each package
* Open url **http://localhost:9090/graphiql**
* Left side we can enter GraphQl query, we will get response on right side

## Run using maven
```
mvn clean compile spring-boot:run
```

## Run using gradle
```
gradlew clean compileJava bootRun
```

## Execute jar created with maven
* Package with maven
```
mvn clean compile package
```
* Execute jar
```
java -jar target/graphql.jar
```

## Execute jar created with gradle
* Package with maven
```
gradlew clean build
```
* Execute jar
```
java -jar build/libs/graphql.jar
```

## Some GraphQl queries and responses
1. Query
```
{
  findAllApplications{
    id,
    name,
    owner,
    description
  }
}
```
Response
```
{
  "data": {
    "findAllApplications": [
      {
        "id": "1",
        "name": "jarvis",
        "owner": "avinash",
        "description": "Jarvis"
      },
      {
        "id": "1",
        "name": "cerebro",
        "owner": "avinash",
        "description": "Cerebro"
      },
      {
        "id": "1",
        "name": "remembral",
        "owner": "avinash",
        "description": "Remembral"
      }
    ]
  }
}
```

2. Query
```
{
  findAllApplications{
    id,
    name
  }
}
```
Response
```
{
  "data": {
    "findAllApplications": [
      {
        "id": "1",
        "name": "jarvis"
      },
      {
        "id": "1",
        "name": "cerebro"
      },
      {
        "id": "1",
        "name": "remembral"
      }
    ]
  }
}
```