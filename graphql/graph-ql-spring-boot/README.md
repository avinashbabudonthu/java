# Execption handling
* Create custom exception - [RuntimeException1](src/main/java/com/java/exceptions/RuntimeException1.java)
* Throw exception from anywhere in application - exception method in [Student4Resolver](src/main/java/com/java/resolver/Student4Resolver.java)
* Enable exception handling using below property in [application.yml](src/main/resources/application.yml)
```
graphql.servlet.exception-handlers-enabled: true
```
* Create Exception handler class - handleRuntimeException1 method in [GraphqlExceptionHandler](src/main/java/com/java/exceptions/handlers/GraphqlExceptionHandler.java)
* Refer - exception-handling in [postman collection](files/graph-ql-spring-boot.postman_collection.json)
* API URL
```
http://localhost:9000/graphql
```
* Request body
```
query student4SubjectsWithResolver($id: Int) {
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
* Output
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