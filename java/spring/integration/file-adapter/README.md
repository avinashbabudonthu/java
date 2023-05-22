# Spring Integration File Adapter Example
* Read file from `inputFiles` folder
* Write file to `outputFiles` folder

# Steps
* Add following dependencies in [pom.xml](pom.xml)
    * spring-boot-starter-parent
    * spring-boot-starter-integration
    * spring-integration-file
      * For spring provided File adapter lib classes
    * lombok - optional
* Spring boot main class - [App.java](src/main/java/com/spring/integration/App.java)
* Write component class for transform operation - [Transform.java](src/main/java/com/spring/integration/component/Transform.java)
* Configuration class where all integration is there - [AppConfig.java](src/main/java/com/spring/integration/config/AppConfig.java)
    * Write 2 bean methods
        * fileReader() - To read file from `inputFiles` directory. Using spring provided class `org.springframework.integration.file.FileReadingMessageSource`
        * fileWriter() - To write file to `outputFiles` directory. Using spring proveded class `org.springframework.integration.file.FileWritingMessageHandler`
    * Write `integrationFlow()` method where all integration is there
        * This method has to return `org.springframework.integration.dsl.IntegrationFlow` object
        * `org.springframework.integration.dsl.IntegrationFlows.from(messageSource, poller)` - polls messageSource
        * Once file created in `inputFiles` directory `com.spring.integration.component.Transform.tranform` method will be called
        * After transform `handle` method is used to write file to `outputFiles` directory