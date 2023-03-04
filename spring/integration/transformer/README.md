# Transformer
------
# Steps
* Refer dependencies in [pom.xml](pom.xml)
* Spring boot main class [App.java](src/main/java/com/spring/integration/App.java). Declare following annotations
    * org.springframework.integration.config.EnableIntegration
    * org.springframework.integration.annotation.IntegrationComponentScan
    * org.springframework.boot.autoconfigure.SpringBootApplication
* Declare channel String in [Constants.java](src/main/java/com/spring/integration/util/Constants.java)
* Create beans for a transform - [IntegrationConfig.java](src/main/java/com/spring/integration/config/IntegrationConfig.java)
    * requestChannel() - request channel bean
    * replyChannel() - reply channel bean
    * objectToJsonTransformer() - object to json transformer
        * input channel - `gateway.channel.student.input`
        * output channel - `gateway.channel.objectToJson`
    * getMapper() - jackson object mapper bean
    * jsonToObjectTransformer() - json to object transformer
        * input channel - `gateway.channel.jsonToObject`
        * output channel - `gateway.channel.jsonToObject.to.response`
* Messaging Gateway - [IntegrationGateway.java](src/main/java/com/spring/integration/service/IntegrationGateway.java)
    * Declare annotation - `org.springframework.integration.annotation.MessagingGateway`
    * write method, declare annotation - `org.springframework.integration.annotation.Gateway`
    * request channel - `gateway.channel.student.input`
* Service activators for business logic - [StudentService.java](src/main/java/com/spring/integration/service/StudentService.java)
    * receiveMessage method
        * input channel - `gateway.channel.objectToJson`
        * output channel - `gateway.channel.jsonToObject`
    * processJsonToObject method
        * input channel - `gateway.channel.jsonToObject.to.response`
* Controller - [StudentController.java](src/main/java/com/spring/integration/controller/StudentController.java)
* Model class - [Student.java](src/main/java/com/spring/integration/model/Student.java)
* Refer - [Postman collection](files/transformer.postman_collection.json) 
------
# Flow
* [StudentController.java](src/main/java/com/spring/integration/controller/StudentController.java) - `processStudent` method
* [IntegrationGateway.java](src/main/java/com/spring/integration/service/IntegrationGateway.java) - `processStudent` method
* [IntegrationConfig.java](src/main/java/com/spring/integration/config/IntegrationConfig.java) - `objectToJsonTransformer` method
* [StudentService.java](src/main/java/com/spring/integration/service/StudentService.java) - `receiveMessage` method
* [IntegrationConfig.java](src/main/java/com/spring/integration/config/IntegrationConfig.java) - `jsonToObjectTransformer` method
* [StudentService.java](src/main/java/com/spring/integration/service/StudentService.java) - `processJsonToObject` method
* API Response