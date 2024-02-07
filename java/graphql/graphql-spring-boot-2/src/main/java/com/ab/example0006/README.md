# GraphQL Resolver
* [Student](Student0006.java) class has list of [Subjects](Subject0006.java)
* If consumer does not request for subject then we should not compute/query for them
* So on demand we should query for subject. This will be done by `GrapghQL Resolvers`
* Every model class will have only one resolver
* In our example [Student](Student0006.java) class has resolver [Student6Resolver](Student0006Resolver.java)
* `subjects` method in [Student6Resolver](Student0006Resolver.java) returns subject list. Here we need to write our business logic
* `findAllStudents` method in [Query](Query0006.java)
* `findAllStudents` in [schema.graphqls](../../../../resources/schema.graphqls)
* `Student0006` in [schema.graphqls](../../../../resources/schema.graphqls)
* `Subject0006` in [schema.graphqls](../../../../resources/schema.graphqls)
* [Postman Collection](example0006.postman_collection.json)