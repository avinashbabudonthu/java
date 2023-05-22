# Zuul Eurka Example

## Requirement
* Create Microservice
* Create Zuul gateway
* Create Eureka server
* Start multiple instances of microservice
* Consume REST API from zuul gateway
* Load balancing should be done automatically using zuul as and when we start new instances of microservice

## Eureka Discovery Server
* Maven Command
```
mvn archetype:generate -DgroupId=com.discovery.server -DartifactId=discovery-server -Dversion=1.0 -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
```
* Files
	* [pom.xml](pom.xml)
	* [App.java](src/main/java/com/discovery/server/App.java)
	* [application.yml](src/main/resources/application.yml)
* Declare `@EnableEurekaServer` annoation on [App.java](src/main/java/com/discovery/server/App.java) to make this application eureka server

## Zuul Gateway
* Maven Command
```
mvn archetype:generate -DgroupId=com.zuul.gateway -DartifactId=zuul-gateway -Dversion=1.0 -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
```
* Files
	* [pom.xml](pom.xml)
	* [App.java](src/main/java/com/app/App.java)
	* [application.yml](src/main/resources/application.yml)
	* Declare `@EnableZuulProxy` annoation on [App.java](src/main/java/com/app/App.java) to make this application as zuul server
	* Declare `@EnableEurekaClient` annotation on [App.java](src/main/java/com/app/App.java) to make this application as eureka client

## Account Service
* Maven Command
```
mvn archetype:generate -DgroupId=com.accounts.service -DartifactId=accounts-service -Dversion=1.0 -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
```
* Files
	* [pom.xml](pom.xml)
	* [App.java](src/main/java/com/app/App.java)
	* [AppController.java](src/main/java/com/app/controller/AppController.java)
	* [AccountModel.java](src/main/java/com/app/model/AccountModel.java)
* Declare `@EnableEurekaClient` annotaiton on [App.java](src/main/java/com/app/App.java) to declare this application as eureka client
* Write Rest API in [AppController.java](src/main/java/com/app/controller/AppController.java) which we consume from zuul gateway

## API
* Postman collection
	* [files/zuul-eureka.postman_collection.json](files/zuul-eureka.postman_collection.json)

## Run application
* Start `eureka` server 
	* Run [discovery-server/App.java](discovery-server/src/main/java/com/discovery/server/App.java)
* Start Account Service
	* Run [accounts-service/accounts-service-9000.bat](accounts-service/accounts-service-9000.bat)
	* Run [accounts-service/accounts-service-9001.bat](accounts-service/accounts-service-9001.bat)
	* Run [accounts-service/accounts-service-9002.bat](accounts-service/accounts-service-9002.bat)
* Start `zuul` gateway
	* Run [zuul-gateway/App.java](zuul-gateway/src/main/java/com/app/App.java)

## Deploying to AWS EC2 instance
