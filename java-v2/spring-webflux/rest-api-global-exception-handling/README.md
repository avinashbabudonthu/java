### [<<Back](../README.md) | [Java V2 All Examples](https://github.com/avinashbabudonthu/java/blob/master/java-v2/README.md) | [Java All Examples](https://github.com/avinashbabudonthu/java/blob/master/README.md)
------
# Spring WebFlux Rest API Global Exception Handling
------
# Requirements
* Write REST API
* Throw exception from APIs
* Handling exceptions using global exception handling
------
# Solution
* Create spring boot application - Refer [spring boot 3 project](../../maven/files/create-spring-boot-3-project.md)
* Main class - [Main](src/main/java/com/java/Main.java)
* Create 2 exception classes
  * [BadRequestException](src/main/java/com/java/BadRequestException.java)
  * [ResourceNotFoundException](src/main/java/com/java/ResourceNotFoundException.java)
* Create error response class - [ErrorResponse](src/main/java/com/java/ErrorResponse.java)
  * To return error response
* Write global exception handler - [GlobalExceptionHandler](src/main/java/com/java/GlobalExceptionHandler.java)
  * Handle exceptions using - `org.springframework.web.bind.annotation.ExceptionHandler`
  * [GlobalExceptionHandler](src/main/java/com/java/GlobalExceptionHandler.java) - handleResourceNotFoundException
  * [GlobalExceptionHandler](src/main/java/com/java/GlobalExceptionHandler.java) - handleBadRequestException
  * [GlobalExceptionHandler](src/main/java/com/java/GlobalExceptionHandler.java) - handleGenericException
* Write REST API. Refer [MyController](src/main/java/com/java/MyController.java)
------
### [<<Back](../README.md) | [Java V2 All Examples](https://github.com/avinashbabudonthu/java/blob/master/java-v2/README.md) | [Java All Examples](https://github.com/avinashbabudonthu/java/blob/master/README.md)