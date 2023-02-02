# Spring Boot 2 REST API

# API
* Postman collection - [rest-api.postman_collection.json](files/rest-api.postman_collection.json) to postman

# Rest Controllers
* [Delete Controller](src/main/java/com/rest/api/controller/DeleteController.java)
* [GetController](src/main/java/com/rest/api/controller/GetController.java)
* [Patch Controller](src/main/java/com/rest/api/controller/PatchController.java)
* [Post Controller](src/main/java/com/rest/api/controller/PostController.java)
  * Student object as request body - `saveStudent` method
  * Path variable - `findStudent` method
  * Request body with enum property - `studentWithEnum` method
    * [Student2](src/main/java/com/rest/api/model/Student2.java)
    * [GenderEnum](src/main/java/com/rest/api/util/GenderEnum.java)
    * Default enum conversion work with name. If we need to work with value then we need to write static method and annotate with `com.fasterxml.jackson.annotation.JsonCreator`. Refer `getGender` method in [GenderEnum](src/main/java/com/rest/api/util/GenderEnum.java)
    * posts/request-body-with-enum-name - postman collection - [rest-api.postman_collection.json](files/rest-api.postman_collection.json)
    * Reference - https://fullstackdeveloper.guru/2020/05/08/how-to-map-enum-types-to-json-requests-in-spring-boot-automatically/
* [Put Controller](src/main/java/com/rest/api/controller/PutController.java)
