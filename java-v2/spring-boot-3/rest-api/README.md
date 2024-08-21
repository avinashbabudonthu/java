### [<<Back](../README.md) | [Java V2 All Examples](https://github.com/avinashbabudonthu/java/blob/master/java-v2/README.md) | [Java All Examples](https://github.com/avinashbabudonthu/java/blob/master/README.md)
------
# Technical stack
* Java 17
* Maven
* Spring Boot 3.3.1
* Lombok
------
# How to run application?
* Application starts on port `9000`

## Method 1
* Set Java 17 and Maven to path
* Import application to IntelliJ
* Run main class [Application](src/main/java/com/java/Application.java)

## Method 2
* Run below maven command
```
mvn clean compile spring-boot:run
```
* This command clean compile and run application
------
# Files
* [pom.xml](pom.xml)
* [application.yml](src/main/resources/application.yml)
* Main class [Application](src/main/java/com/java/Application.java)
* Student Model class [Student](src/main/java/com/java/model/Student.java)
* StudentService interface [StudentService](src/main/java/com/java/service/StudentService.java)
* StudentServiceImpl class [StudentServiceImpl](src/main/java/com/java/service/impl/StudentServiceImpl.java)
* GetController interface [GetController](src/main/java/com/java/controller/GetController.java)
* GetControllerImpl class [GetControllerImpl](src/main/java/com/java/controller/impl/GetControllerImpl.java)
* PostController interface [PostController](src/main/java/com/java/controller/PostController.java)
* PostControllerImpl class [PostControllerImpl](src/main/java/com/java/controller/impl/PostControllerImpl.java)
* PutController interface [PutController](src/main/java/com/java/controller/PutController.java)
* PutControllerImpl class [PutControllerImpl](src/main/java/com/java/controller/impl/PutControllerImpl.java)
* DeleteController interface [DeleteController](src/main/java/com/java/controller/DeleteController.java)
* DeleteControllerImpl class [DeleteControllerImpl](src/main/java/com/java/controller/impl/DeleteControllerImpl.java)
------
# REST APIs
* Download and import [Postman collection](postman/rest-api.postman_collection.json) for below APIs
* [GetController](src/main/java/com/java/controller/GetController.java)
  * Interface has GET API declarations
  * Has different ways of writing GET APIs
* [GetControllerImpl](src/main/java/com/java/controller/impl/GetControllerImpl.java) class has API implementation
* Why interface and class for APIs
  * Implementation has only business logic
  * Interface will have API annotations, method comments, swagger documentation etc
* [PostController](src/main/java/com/java/controller/PostController.java)
  * Interface has POST API declarations
  * Has different ways of writing POST APIs
* [PostControllerImpl](src/main/java/com/java/controller/impl/PostControllerImpl.java) class has API implementation
* [PutController](src/main/java/com/java/controller/PutController.java)
  * Interface has PUT API declarations
  * Has different ways of writing PUT APIs
* [PutControllerImpl](src/main/java/com/java/controller/impl/PutControllerImpl.java) class has API implementation
* [DeleteController](src/main/java/com/java/controller/DeleteController.java)
  * Interface has DELETE API declarations
  * Has different ways of writing DELETE APIs
* [DeleteControllerImpl](src/main/java/com/java/controller/impl/DeleteControllerImpl.java) class has API implementation

## API with pagination
* Refer `studentsV7` method in [GetController](src/main/java/com/java/controller/GetController.java)
* We can directly use `Pageable`
* `ParameterObject` is used for swagger documentation
* Swagger without `ParameterObject`\
![picture](img/004.jpg)
* Swagger with `ParameterObject`\
![picture](img/005.jpg)
------
# Swagger Spring Doc Open API Documentation
* Pre-requisite for this is to understand how to write APIs. Refer [here](#REST-APIs)
* Add below dependency. Refer [pom.xml](pom.xml)
```
<dependency>
    <groupId>org.springdoc</groupId>
    <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
    <version>2.0.3</version>
</dependency>
```
* Add below annotations to API method. Refer [GetController](src/main/java/com/java/controller/GetController.java) & [PostController](src/main/java/com/java/controller/PostController.java)
```
@Operation(summary = "Hello World GET API")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Hello World",
                content = {@Content(mediaType = TEXT_PLAIN_VALUE, schema = @Schema(implementation = String.class))}
            )
    })
```
* Add below annotation to define API class
```
@Tag(name = "Get APIs")
```
* Start application
* Open URL - http://localhost:9000/swagger-ui/index.html
![picture](img/001.jpg)
* We can find OpenAPI descriptions at `/v3/api-docs` - http://localhost:9000/v3/api-docs
* We can customize path using below property. Refer property in [application.yml](src/main/resources/application.yml). Now we can access docs using http://localhost:9000/rest-api-docs
```
springdoc.api-docs.path=/rest-api-docs
```
* Above OpenAPI definitions are in JSON format by default. For yaml format, use this link http://localhost:9000/rest-api-docs.yaml
* We can change default swagger ui path using below property. Refer [application.yml](src/main/resources/application.yml)
```
springdoc.swagger-ui.path=/rest-api-swagger.html
```
* So now our documentation is available in http://localhost:9000/swagger-ui/index.html
* We can sort the API paths according to their HTTP methods with the `springdoc.swagger-ui.operationsSorter` property
```
springdoc.swagger-ui.operationsSorter=alpha
```
* Refer swagger-ui properties here - https://springdoc.org/#swagger-ui-properties
* Reference - https://www.baeldung.com/spring-rest-openapi-documentation

## To change OpenAPI definition heading
* Add below annotation. Refer [Application](src/main/java/com/java/Application.java)
```
@OpenAPIDefinition(info = @Info(title = "Rest API Documentation"))
```
* Before
![picture](img/002.jpg)
* After
![picture](img/003.jpg)
 
## Annotations explanation
* io.swagger.v3.oas.annotations.OpenAPIDefinition
  * Used to define main title of swagger documentation UI
  * Refer [Main.java](src/main/java/com/java/Main.java)
* io.swagger.v3.oas.annotations.Operation
  * Used to define API
  * Refer controller classes in [com.java.controller](src/main/java/com/java/controller)
* io.swagger.v3.oas.annotations.responses.ApiResponses
  * container for different responses returned by API
  * Refer controller classes in [com.java.controller](src/main/java/com/java/controller)
* io.swagger.v3.oas.annotations.responses.ApiResponse
  * Define details of response for different scenarios
  * Refer controller classes in [com.java.controller](src/main/java/com/java/controller)
* io.swagger.v3.oas.annotations.tags.Tag
  * Used define API class description
  * Declare at controller class level
  * Refer controller classes in [com.java.controller](src/main/java/com/java/controller)
* io.swagger.v3.oas.annotations.media.Schema
  * Used for properties of model. Refer [Student.java](src/main/java/com/java/model/Student.java)
* io.swagger.v3.oas.annotations.Parameter
  * Used for parameters of API resource request
  * Refer [DeleteController.java](src/main/java/com/java/controller/DeleteController.java)
------
# Build docker image and push to docker hub
* Write [Dockerfile](Dockerfile)
* We are using `openjdk java 17` base image
* Build image using below command
```
docker build . -t rest-api
``` 
* Run and check the container
```
docker run -it -p 9000:9000 rest-api
```
* Open url - http://localhost:9000/swagger-ui/index.html
* Swagger should start without any issues
* Tag an image before pushing to docker hub
```
docker image tag rest-api donthuavinashbabu/rest-api
```
* Push image to docker hub
```
docker image push donthuavinashbabu/rest-api
```
------
### [<<Back](../README.md) | [Java V2 All Examples](https://github.com/avinashbabudonthu/java/blob/master/java-v2/README.md) | [Java All Examples](https://github.com/avinashbabudonthu/java/blob/master/README.md)