# Requirement
* Create cloud config server pointing to github repo
* Create `customer-service` 
* Make `customer-service` as config client
* Fetch properties to client from config server

# spring-cloud-config-server
* Create git repo [spring-cloud-config-server](https://github.com/avinashpocs/spring-cloud-config-server)
* Create file `customer-service.yml` in this repo
* Add properties required in `customer-service.yml`
* Refer [customer-service.yml](https://github.com/avinashpocs/spring-cloud-config-server/blob/master/customer-service.yml)

# config-server
* Create project using below maven command
```
mvn archetype:generate -DgroupId=com.config.server -DartifactId=config-server -Dversion=1.0.0 -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
```
* Dependencies
	* Add spring boot depenedencies
	* Add `spring-cloud-config-server` dependency
	* Refer [pom.xml](config-server/pom.xml)
* Create [App.java](config-server/src/main/java/com/config/server/App.java)
	* Declare `org.springframework.cloud.config.server.EnableConfigServer` annotation
* Create [application.yml](config-server/src/main/resources/application.yml)
* Clone [spring-cloud-config-server](#spring-cloud-config-server) to local
* Refer `spring-cloud-config-server` local folder in [application.yml](config-server/src/main/resources/application.yml)

# customer-service
* `customer-service` is client of spring cloud config server
* Create project using below maven command
```
mvn archetype:generate -DgroupId=com.customer.service -DartifactId=customer-service -Dversion=1.0.0 -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
```
* Dependencies
	* Add spring boot depenedencies
	* Add `spring-cloud-config-client` dependency
	* Refer [pom.xml](customer-service/pom.xml)
* Create `bootstrap.yml` file in `src/main/resources`. File name should be `bootstrap.yml`
	* Refer to `config-server` to get properties from config server
	* Refer [bootstrap.yml](customer-service/src/main/resources/bootstrap.yml`)
* Create App and model classes. Refer
	* [App.java](customer-service/src/main/java/com/customer/App.java)
	* [CustomerConfig.java](customer-service/src/main/java/com/customer/config/CustomerConfig.java)
	* [CustomerModel](customer-service/src/main/java/com/customer/model/CustomerModel.java)
	* [CustomerListModel](customer-service/src/main/java/com/customer/CustomerListModel.java)
	* [CustomerController](customer-service/src/main/java/com/customer/controller/CustomerController.java)

# Run the application
* Run `config-server`
	* Run [App.java](config-server/src/main/java/com/config/server/App.java)
* Run `customer-service`
	* Run [App.java](customer-service/src/main/java/com/customer/App.java)
* Import postman collection to local postman
	* [infogain.postman_collection.json](files/infogain.postman_collection.json)
* Access API
	* customer-service/customers
	* Change active profile in `customer-service` [bootstrap.yml](customer-service/src/main/resources/bootstrap.yml`)
	* Check the result of API
	
# References
* [https://spring.io/guides/gs/centralized-configuration/](https://spring.io/guides/gs/centralized-configuration/)
* [https://www.javatpoint.com/connect-spring-cloud-config-server-to-local-git-repository](https://www.javatpoint.com/connect-spring-cloud-config-server-to-local-git-repository)
* [https://www.baeldung.com/spring-cloud-configuration](https://www.baeldung.com/spring-cloud-configuration)