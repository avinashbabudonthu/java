# Spring Boot 2 REST API
------
# API
* Postman collection - [rest-api.postman_collection.json](files/rest-api.postman_collection.json) to postman
------
# Rest Controllers
* [Delete Controller](src/main/java/com/rest/api/controller/DeleteController.java)
* [GetController](src/main/java/com/rest/api/controller/GetController.java)
* [Patch Controller](src/main/java/com/rest/api/controller/PatchController.java)
* [Put Controller](src/main/java/com/rest/api/controller/PutController.java)
------
# Examples
# Request body with enum property
* `studentWithEnum` method - [Post Controller](src/main/java/com/rest/api/controller/PostController.java)
* [Student2](src/main/java/com/rest/api/model/Student2.java)
* [GenderEnum](src/main/java/com/rest/api/util/GenderEnum.java)
  * Check methods - `getGender`, `getValue`
* Default enum conversion work with name. If we need to work with value then we need to write static method and annotate with `com.fasterxml.jackson.annotation.JsonCreator`. Refer `getGender` method in [GenderEnum](src/main/java/com/rest/api/util/GenderEnum.java)
* PostController/request-body-with-enum-name - postman collection - [rest-api.postman_collection.json](files/rest-api.postman_collection.json)
* Reference - https://fullstackdeveloper.guru/2020/05/08/how-to-map-enum-types-to-json-requests-in-spring-boot-automatically/
* Controller - [Post Controller](src/main/java/com/rest/api/controller/PostController.java)

# Enum as request parameter and path variable
* `enumAsRequestParameter` method - [GetController](src/main/java/com/rest/api/controller/GetController.java)
* [GenderEnum](src/main/java/com/rest/api/util/GenderEnum.java)
* By default, works for enum name but if we want enum to conversion to work with properties like code etc
  * Write annotation and declare `Component` - [ParameterConverter](src/main/java/com/rest/api/config/ParameterConverter.java)
  * Write converter class to convert code to enum. Refer - [StringToGenderEnumConverter](src/main/java/com/rest/api/config/StringToGenderEnumConverter.java)
  * Register [StringToGenderEnumConverter](src/main/java/com/rest/api/config/StringToGenderEnumConverter.java) to spring beans. Refer - [WebConfig](src/main/java/com/rest/api/config/WebConfig.java)
* Now this below both APIs work
```
http://localhost:9000/gets/enum-as-request-param?gender=MALE
http://localhost:9000/gets/enum-as-request-param?gender=male
```
* GetController/enum-as-request-param - Postman collection - [rest-api.postman_collection.json](files/rest-api.postman_collection.json)
* Reference - https://medium.com/javarevisited/an-effective-way-to-use-java-enums-in-your-spring-application-485c969794a8

# Student object as request body
* [Post Controller](src/main/java/com/rest/api/controller/PostController.java)
* `saveStudent` method

# Path variable
* [Post Controller](src/main/java/com/rest/api/controller/PostController.java)
* `findStudent` method