# Execption handling
* Create custom exception - [RuntimeException1](src/main/java/com/java/exceptions/RuntimeException1.java)
* Throw exception from anywhere in application - `exception` method in [Student4Resolver](src/main/java/com/java/resolver/Student4Resolver.java)
* Enable exception handling using below property in [application.yml](src/main/resources/application.yml)
```
graphql.servlet.exception-handlers-enabled: true
```
* Create Exception handler class - `handleRuntimeException1` method in [GraphqlExceptionHandler](src/main/java/com/java/exceptions/handlers/GraphqlExceptionHandler.java)
* Refer - exception-handling in [postman collection](files/graph-ql-spring-boot.postman_collection.json)
* API URL
```
http://localhost:9000/graphql
```
* Request body
```
query exception($id: Int) {
    student4SubjectsWithResolver(id: $id){
        id,
        firstName,
        subjects {
            id,
            name,
            marks
        },
        exception
    }
}
```
* Graphql variables
```
{
    "id": 1000
}
```
* Response
```
{
    "errors": [
        {
            "message": "Runtime exception 1",
            "locations": []
        }
    ],
    "data": {
        "student4SubjectsWithResolver": {
            "id": 1000,
            "firstName": "jim",
            "subjects": [
                {
                    "id": 1,
                    "name": "Java",
                    "marks": 4.99
                },
                {
                    "id": 1,
                    "name": "GraphQL",
                    "marks": 4.98
                }
            ],
            "exception": null
        }
    }
}
```

# DataFetcherResult
* Used to return data and errors in final response
* Return `DataFetcherResult<Subject>` from method - refer `dataFetcherResult` method in [Student4Resolver](src/main/java/com/java/resolver/Student4Resolver.java)
* Postman collection - [dataFetcherResult](files/graph-ql-spring-boot.postman_collection.json)
* API
```
http://localhost:9000/graphql
```
* Request body
```
query dataFetcherResult($id: Int){
    student4SubjectsWithResolver(id: $id) {
        id,
        firstName,
        dataFetcherResult {
            id,
            name,
            marks
        }
    }
}
```
* Graphql variables
```
{
    "id": 1000
}
```
* Response
```
{
    "errors": [
        {
            "message": "Could not get marks details",
            "locations": []
        }
    ],
    "data": {
        "student4SubjectsWithResolver": {
            "id": 1000,
            "firstName": "jim",
            "dataFetcherResult": {
                "id": 1,
                "name": "Java",
                "marks": null
            }
        }
    }
}
```

# Async Resolvers
* Return CompletableFuture from resolver methods. Refer following methods from [Student4Resolver](src/main/java/com/java/resolver/Student4Resolver.java)
    * subjects2
    * subjects3
* With log messages in above methods we can see that these resolvers executed by differnt threads
```
2023-01-26 20:11:12.172  INFO 17736 --- [pool-1-thread-2] com.java.resolver.Student4Resolver       : current thread=Thread[pool-1-thread-2,5,main]
2023-01-26 20:11:12.170  INFO 17736 --- [pool-1-thread-1] com.java.resolver.Student4Resolver       : current thread=Thread[pool-1-thread-1,5,main]
```
* Postman collection - [asyncResolvers](files/graph-ql-spring-boot.postman_collection.json)

# File Upload
* Write mutation operation - refer `fileUpload` in `type Mutation` in [schema.graphqls](src/main/resources/schema/schema.graphqls)
* Write `fileUpload` method [Mutation resolver class](src/main/java/com/java/query/Mutation.java)
* Using `graphql.schema.DataFetchingEnvironment` we can get `graphql.kickstart.servlet.context.DefaultGraphQLServletContext`
  * `DefaultGraphQLServletContext` class contains reference to - `javax.servlet.http.HttpServletRequest`, `javax.servlet.http.HttpServletResponse`, `javax.servlet.http.Part` etc
* Postman collection - [fileUpload](files/graph-ql-spring-boot.postman_collection.json)

# [DataFetchingEnvironment](https://github.com/graphql-java/graphql-java/blob/master/src/main/java/graphql/schema/DataFetchingEnvironment.java)
* package - graphql.schema.DataFetchingEnvironment
* [Java doc](https://javadoc.io/doc/com.graphql-java/graphql-java/12.0/graphql/schema/DataFetchingEnvironment.html)
* [Graphql Documentation](https://www.graphql-java.com/documentation/data-fetching#the-interesting-parts-of-the-datafetchingenvironment)
* This should be last parameter in resolver methods
* Method
  * getSelectionSet() - fields requested
  * getContext() - returns `graphql.kickstart.servlet.context.DefaultGraphQLServletContext`
    * Created once per request
    * Passed to all resolvers during that request
  * getVariables()
    * get variables if used any during graphql query
  * getDataLoader() & getDataLoaderRegistry()
    * Used to solve `N+1` problem
  
# Scalars
* To use extra data types in graphql schema file
* Refer - https://github.com/graphql-java/graphql-java-extended-scalars
* Add below dependency in [pom.xml](pom.xml)
```
<dependency>
    <groupId>com.graphql-java</groupId>
    <artifactId>graphql-java-extended-scalars</artifactId>
    <version>20.0</version>
    <exclusions>
        <exclusion>
            <groupId>com.graphql-java</groupId>
            <artifactId>graphql-java</artifactId>
        </exclusion>
    </exclusions>
</dependency>
```
* Refer available scalars in class `graphql.scalars.ExtendedScalars`
* Add scalar to schema file - [schema.graphqls](src/main/resources/schema/schema.graphqls)
```
scalar NonNegativeInt
```
* Refer `type Student4` in [schema.graphqls](src/main/resources/schema/schema.graphqls) using `NonNegativeInt` for `age` property
* `age` property in [Student4.java](src/main/java/com/java/model/Student4.java)
* Create bean for `NonNegativeInt` - [ScalarConfig](src/main/java/com/java/config/ScalarConfig.java)

# Listeners
* Write class implements `graphql.kickstart.servlet.core.GraphQLServletListener` - [LoggingListener.java](src/main/java/com/java/listners/LoggingListener.java)
* Override `onRequest` method
* This listener executes for each request. Framework class which execute these listeners  is `graphql.kickstart.servlet.AbstractGraphQLHttpServlet`
  * Refer method - `doRequest(HttpServletRequest request, HttpServletResponse response)`
* Postman collection - [servlet-listeners](files/graph-ql-spring-boot.postman_collection.json)
* Log in console
```
2023-01-26 22:15:08.087  INFO 16232 --- [nio-9000-exec-1] com.java.listners.LoggingListener        : Request execution started
2023-01-26 22:15:08.089  INFO 16232 --- [nio-9000-exec-1] com.java.listners.LoggingListener        : Request compelted. Time taken=2 ms
```

# Pagination
* Yet to prepare example
* Example Reference
  * https://www.youtube.com/watch?v=J9Nq0Fq7t_8&list=PLiwhu8iLxKwL1TU0RMM6z7TtkyW-3-5Wi&index=20&ab_channel=PhilipStarritt
* References
  * https://graphql.org/learn/pagination/
  
# Custom Context
* Custom GraphQL Context will be build once per request. Passed to all resolvers during request
* So we can use this to pass `authentication/authorization` information
* Write class implementing `graphql.kickstart.servlet.context.GraphQLServletContext`. Refer [CustomGraphQLContext](src/main/java/com/java/context/CustomGraphQLContext.java)
* Write class implementing `graphql.kickstart.servlet.context.GraphQLServletContextBuilder`. Refer [CustomGraphQLContextBuilder](src/main/java/com/java/context/CustomGraphQLContextBuilder.java)
  * In `build` method return our [CustomGraphQLContext](src/main/java/com/java/context/CustomGraphQLContext.java)
* In resolver - get our context from `graphql.schema.DataFetchingEnvironment`. Refer `customGraphQLContext` method in [Student4Resolver](src/main/java/com/java/resolver/Student4Resolver.java)
* Postman collection - [customGraphQLContextExample](files/graph-ql-spring-boot.postman_collection.json)

# Data Loader problem
* Used to solve `N+1 fetch problem`. Refer https://springhow.com/n-plus-1-selects-problem-in-hibernate/
* We have [Student6 class](src/main/java/com/java/model/Student6.java)
* Refer - dataLoadersExample in [schema.graphqls](src/main/resources/schema/schema.graphqls)
* `dataLoadersProblem` method in [Query.java](src/main/java/com/java/query/Query.java)
* We are returning 4 students in list
* We have resolver for address - `address` method [Student6Resolver](src/main/java/com/java/resolver/Student6Resolver.java)
* Resolver method will be called multiple times. Once for each student object. This is call `N+1` problem
```
Getting student address
Getting student address
Getting student address
Getting student address
```
* dataLoadersExample - [Postman collection](files/graph-ql-spring-boot.postman_collection.json)

# Data Loader solution
* Create [DataLoaderRegistryFactory](src/main/java/com/java/data/loader/DataLoaderRegistryFactory.java)
* Write `create` method return `org.dataloader.DataLoaderRegistry`
* Register our Dataload methods to `org.dataloader.DataLoaderRegistry`
* Register our [DataLoaderRegistryFactory](src/main/java/com/java/data/loader/DataLoaderRegistryFactory.java) to [CustomGraphQLContextBuilder](src/main/java/com/java/context/CustomGraphQLContextBuilder.java) - refer `build` method
* In resolver method call `dataLoader.load` method. Refer [Student7Resolver](src/main/java/com/java/resolver/Student7Resolver.java)
* dataLoadersSolution - [Postman collection](files/graph-ql-spring-boot.postman_collection.json)

* Example Reference
  * https://www.youtube.com/watch?v=YsM2VSnWUcg&list=PLiwhu8iLxKwL1TU0RMM6z7TtkyW-3-5Wi&index=21&ab_channel=PhilipStarritt  
  * https://www.youtube.com/watch?v=tbxskis_ny4&list=PLiwhu8iLxKwL1TU0RMM6z7TtkyW-3-5Wi&index=22&ab_channel=PhilipStarritt
* Reference
  * https://github.com/graphql-java/java-dataloader