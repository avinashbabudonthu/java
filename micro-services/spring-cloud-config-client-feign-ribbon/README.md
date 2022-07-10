# Communication between microservice with Feign and Client side Load balancing with Ribbon

## What is Ribbon?
* Client/Consumer side load balancing tool
* In below example
	* [Accounts Service](accounts-service) is client/consumer
	* [Savings Accounts Service](savings-accounts-service) is producer
	* API Calls from [Accounts Service](accounts-service) to [Savings Accounts Service](savings-accounts-service) will be distributed among running instances of [Savings Accounts Service](savings-accounts-service) using `Ribbon`

## Requirement
* Create 2 services
	* [Savings Accounts Service](savings-accounts-service)
	* [Accounts Service](accounts-service)
* Create [Spring cloud config server](config-server)
* Setup above [Savings Accounts Service](savings-accounts-service) as client to [Spring cloud config server](config-server)
* On calling API in [Savings Accounts Service](savings-accounts-service)
	* Get accounts details from [Spring cloud config server](config-server)
* Call API in [Accounts Service](accounts-service) which call [Savings Accounts Service](savings-accounts-service) using `Feign` and get account details
* Start multiple instances of [Savings Accounts Service](savings-accounts-service)
* Configure ribbon at [Accounts Service](accounts-service) and distribute load on [Savings Accounts Service](savings-accounts-service)

## Pre Requisite
* Should know 
	* Create Spring Cloud config server
	* Connecting Spring Cloud config server to git repo
	* Connecting Spring cloud client to spring cloud config server
* Refer - https://github.com/avinashbabudonthu/micro-services/tree/master/example-1

## API
* Import [spring-cloud-config-client-feign.postman_collection.json](files/spring-cloud-config-client-feign.postman_collection.json) to local postman

## Config Server
* Maven command
```
mvn archetype:generate -DgroupId=com.config.server -DartifactId=config-server -Dversion=1.0 -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
```
* Gradle command
```
gradle init --type pom
```
* Config Server is getting config details from [saving-accounts-service.yml](https://github.com/avinashbabudonthu/spring-cloud-config-server-properties/blob/master/savings-accounts-service.yml) in [spring-cloud-config-server-properties](https://github.com/avinashbabudonthu/spring-cloud-config-server-properties)
* Refer dependencies in [config-server/pom.xml](config-server/pom.xml) or [config-server/build.gradle](config-server/build.gradle)
* Configure spring cloud config server in [config-server/application.yml](config-server/src/main/resources/application.yml)
* Configure spring cloud config server in [App.java](config-server/src/main/java/com/config/server/App.java)
	* Declare `@EnableConfigServer` at class level


## Savings Accounts Service
* Maven command
```
mvn archetype:generate -DgroupId=com.accounts.service -DartifactId=accounts-service -Dversion=1.0 -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
```
* Gradle command
```
gradle init --type pom
```
* Refer dependencies in [savings-accounts-service/pom.xml](savings-accounts-service/pom.xml) or [savings-accounts-service/build.gradle](savings-accounts-service/build.gradle)
	* Add `spring-cloud-starter-openfeign` dependency for Feign
* Connect to spring cloud config server as client. Refer [savings-accounts-service/bootstrap.yml](savings-accounts-service/src/main/resources/bootstrap.yml)
* Classes
	* Main class - [App.java](savings-accounts-service/src/main/java/com/savings/accounts/service/App.java)
	* Main class - [AppConfig.java](savings-accounts-service/src/main/java/com/savings/accounts/service/config/AppConfig.java)
	* Model classes - [savings-accounts-service/src/main/java/com/savings/accounts/service/model](savings-accounts-service/src/main/java/com/savings/accounts/service/model)
	* Controller class - [AppController.java](savings-accounts-service/src/main/java/com/savings/accounts/service/controller/AppController.java)

## Accounts Service
* Maven command
```
mvn archetype:generate -DgroupId=com.savings.accounts.service -DartifactId=savings-accounts-service -Dversion=1.0 -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
```
* Gradle command
```
gradle init --type pom
```
* Refer dependencies in [savings-accounts-service/pom.xml](savings-accounts-service/pom.xml) or [savings-accounts-service/build.gradle](savings-accounts-service/build.gradle)
* Properties in [accounts-service/bootstrap.yml](accounts-service/src/main/resources/bootstrap.yml)
* Classes
	* Main class - [App.java](accounts-service/src/main/java/com/accounts/service/App.java)
	* config class - [AppConfig.java](accounts-service/src/main/java/com/accounts/service/config/AppConfig.java)
	* Controller class - [AppController.java](accounts-service/src/main/java/com/accounts/service/controller/AppController.java)
	* Model classes - [accounts-service/src/main/java/com/accounts/service/model](accounts-service/src/main/java/com/accounts/service/model)
	* Feign proxy interface - [AccountService.java](accounts-service/src/main/java/com/savings/accounts/service/rest/clients/AccountService.java)
* Configure `ribbon`
	* Add `spring-cloud-starter-netflix-ribbon` dependency. Refer dependencies in [savings-accounts-service/pom.xml](savings-accounts-service/pom.xml) or [savings-accounts-service/build.gradle](savings-accounts-service/build.gradle)
	* Add `@RibbonClient` to [AccountService.java](accounts-service/src/main/java/com/savings/accounts/service/rest/clients/AccountService.java) at class level
	* Remove `url` property of `@FeignClient` annotation in [AccountService.java](accounts-service/src/main/java/com/savings/accounts/service/rest/clients/AccountService.java) at class level
	* Add below property in [accounts-service/bootstrap.yml](accounts-service/src/main/resources/bootstrap.yml)
```
savings-accounts-service.ribbon.listOfServers: http://localhost:9000,http://localhost:9001
```
	
## Run application
* Start `config-server` - [App.java](config-server/src/main/java/com/config/server/App.java)
* Start 2 instances of `savings-accounts-service` - [App.java](savings-accounts-service/src/main/java/com/savings/accounts/service/App.java)
	* Run [savings-accounts-service/savings-accounts-service-9000.bat](savings-accounts-service/savings-accounts-service-9000.bat)
	* Run [savings-accounts-service/savings-accounts-service-9001.bat](savings-accounts-service/savings-accounts-service-9001.bat)
* Start `accounts-service` - [App.java](accounts-service/src/main/java/com/accounts/service/App.java)
* Hit API - [spring-cloud-config-client-feign.postman_collection.json](files/spring-cloud-config-client-feign.postman_collection.json)
	* savings-accounts-service/feign-accounts - http://localhost:9090/feign/accounts
	* We can see port number in response. Some responses will come from 9000 and some from 9001