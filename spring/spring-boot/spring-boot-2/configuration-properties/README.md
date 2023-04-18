# Read properties to class
* Refer dependencies in [pom.xml](pom.xml)
* Write properties in [application.properties](src/main/resources/application.properties)
* Create configuration class for properties - [MailConfig](src/main/java/com/java/config/MailConfig.java)
    * Give annotations - `Configuration`, `ConfigurationPropertiesScan`, `ConfigurationProperties`
* Inject into class where we need properties - [AppController](src/main/java/com/java/controller/AppController.java)
* Main class - [App](src/main/java/com/java/App.java)
------
# References
* https://www.baeldung.com/configuration-properties-in-spring-boot