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
* Using `DataFetchingEnvironment` we can get `graphql.kickstart.servlet.context.DefaultGraphQLServletContext`
  * `DefaultGraphQLServletContext` class contains reference to - `javax.servlet.http.HttpServletRequest`, `javax.servlet.http.HttpServletResponse`, `javax.servlet.http.Part` etc
* Postman collection - [fileUpload](files/graph-ql-spring-boot.postman_collection.json)