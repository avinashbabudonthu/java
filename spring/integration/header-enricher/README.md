# HeaderEnricher
* Add headers to message
------
# Steps
* Refer dependencies in [pom.xml](pom.xml)
* Spring boot main class [App.java](src/main/java/com/spring/integration/App.java)
* Constants for gateway channels [Constants.java](src/main/java/com/spring/integration/utils/Constants.java)
* Configuration class to add headers [IntegrationConfig.java](src/main/java/com/spring/integration/config/IntegrationConfig.java)
  * `requestChannel` method - Request channel
  * `replyChannel` method - Reply channel
  * `headerEnricher` method to add new headers
* Gateway class - [IntegrationGateway.java](src/main/java/com/spring/integration/config/gateway/IntegrationGateway.java)
* Model class [Student.java](src/main/java/com/spring/integration/model/Student.java)
* Service class to return response [StudentService.java](src/main/java/com/spring/integration/service/StudentService.java)
* Controller class [StudentController.java](src/main/java/com/spring/integration/controller/StudentController.java)
------
# Flow
* Controller class [StudentController.java](src/main/java/com/spring/integration/controller/StudentController.java)
* Gateway class - [IntegrationGateway.java](src/main/java/com/spring/integration/config/gateway/IntegrationGateway.java)
    * `saveStudent` method
* IntegrationConfig class - [IntegrationConfig.java](src/main/java/com/spring/integration/config/IntegrationConfig.java)
    * `headerEnricher` method
* StudentService class - [StudentService.java](src/main/java/com/spring/integration/service/StudentService.java)
    * `saveStudent` method
* Response