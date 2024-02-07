# GraphQL Resolver with filter
* [Student](Student0007.java) class has list of [Subjects](Subject0007.java)
* If consumer does not request for subject then we should not compute/query for them
* So on demand we should query for subject. This will be done by `GrapghQL Resolvers`
* Every model class will have only one resolver
* In our example [Student](Student0007.java) class has resolver [Student0007Resolver](Student0007Resolver.java)
* `subjects` method in [Student6Resolver](Student0007Resolver.java) returns subject list. Here we need to write our business logic
* `findAllStudents2` method in [Query](Query0007.java)
* `findAllStudents2` in [schema.graphqls](../../../../resources/schema.graphqls)
* `Student0007` in [schema.graphqls](../../../../resources/schema.graphqls)
* `Subject0007` in [schema.graphqls](../../../../resources/schema.graphqls)
* Here we are passing `subjectName` as input to [Student0007Resolver](Student0007Resolver.java)
* First argument to resolver is always model class. 2nd argument is input `subjectName`
* `subjects` field in `Student0007` in [schema.graphqls](../../../../resources/schema.graphqls) is taking `subjectName` input
```
subjects(subjectName: String): [Subject0007]
```
* [Postman Collection](example0007.postman_collection.json)