# Using Annotations MessagingGateway Gateway ServiceActivator
------
# Steps
* Refer dependencies in [pom.xml](pom.xml)
* Spring boot main class - [App.java](src/main/java/com/spring/integration/App.java)
* Create constants class - [Constants.java](src/main/java/com/spring/integration/util/Constants.java)
* Create `requestChannel`, `replyChannel` as beans - [IntegrationConfig.java](src/main/java/com/spring/integration/config/IntegrationConfig.java)
* Create an interface and annotate with `org.springframework.integration.annotation.MessagingGateway` - [IntegrationGateway.java](src/main/java/com/spring/integration/service/IntegrationGateway.java)
    * Write method `sendMessage` and annotate with `org.springframework.integration.annotation.Gateway`
* Write class, annotate with `Component` - [IntegrationService.java](src/main/java/com/spring/integration/service/IntegrationService.java)
    * Write method `sendMessage`, annotate with `org.springframework.integration.annotation.ServiceActivator`
* Write a controller - [AppController.java](src/main/java/com/spring/integration/controller/AppController.java)
  * sendMessage - method
* Access API. Import postman collection - [postman collection](files/gateway-annotations.postman_collection.json)
------
# Flow
* [AppController.java](src/main/java/com/spring/integration/controller/AppController.java).sendMessage(..) &rarr; [IntegrationGateway.java](src/main/java/com/spring/integration/service/IntegrationGateway.java)sendMessage(..) &rarr; [IntegrationService.java](src/main/java/com/spring/integration/service/IntegrationService.java).sendMessage(..) &rarr; Response