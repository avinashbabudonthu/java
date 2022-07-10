# Spring Cloud Config Server Cloud Config Client Feign Ribbon Eureka Zuul

## What is Ribbon?
* Client/API Consumer side load balancing tool
* In below example
	* [Accounts Service](accounts-service) is API client/consumer
	* [Savings Accounts Service](savings-accounts-service) is API producer
	* API Calls from [Accounts Service](accounts-service) to [Savings Accounts Service](savings-accounts-service) will be distributed among running instances of [Savings Accounts Service](savings-accounts-service) using `Ribbon`

## Requirement
* Create API producer - [Savings Accounts Service](savings-accounts-service)
* Create API consumer - [Accounts Service](accounts-service)
* Create [Spring cloud config server](config-server)
* Setup above [Savings Accounts Service](savings-accounts-service) as client to [Spring cloud config server](config-server)
* On calling API in [Savings Accounts Service](savings-accounts-service) get account details from [Spring cloud config server](config-server)
* Call API in [Accounts Service](accounts-service) which call [Savings Accounts Service](savings-accounts-service) using `Feign` and get account details
* Start multiple instances of [Savings Accounts Service](savings-accounts-service) on different ports - `9000`, `9001`, `9002`
* Configure ribbon at [Accounts Service](accounts-service) and distribute load on [Savings Accounts Service](savings-accounts-service) running instances
* Create Zuul API gateway and implement logging
	* All requests should go through API gateway and print log
	* [Accounts Service](accounts-service) to [Savings Accounts Service](savings-accounts-service) al should go through API gateway
* Enable Sleuth in `zuul-gateway`, `saving-accounts-service`, `accounts-service`
* Install Rabbit MQ
* Put `zuul-gateway`, `saving-accounts-service`, `accounts-service` logs in Rabbit MQ
* `zipkin-distributed-tracing-server` listening on Rabbit MQ
* zipkin-distributed-tracing-server` takes logs from Rabbit MQ to in memory DB

## Pre Requisite
* Go through below examples
	* https://github.com/avinashbabudonthu/micro-services/tree/master/example-1
	* https://github.com/avinashbabudonthu/micro-services/tree/master/feign-eureka
	* https://github.com/avinashbabudonthu/micro-services/tree/master/spring-cloud-config-client-feign
	* https://github.com/avinashbabudonthu/micro-services/tree/master/spring-cloud-config-client-feign-ribbon
	* https://github.com/avinashbabudonthu/micro-services/tree/master/spring-cloud-config-client-feign-ribbon-eureka

## API
* Import [spring-cloud-config-client-feign-ribbon-eureka-zuul-sleuth-zipkin.postman_collection.json](files/spring-cloud-config-client-feign-ribbon-eureka-zuul-sleuth-zipkin.postman_collection.json)

## Config Server
* Create project using maven command
```
mvn archetype:generate -DgroupId=com.config.server -DartifactId=config-server -Dversion=1.0 -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
```
* Add gradle. Execute from `config-server` folder
```
gradle init --type pom
```
* For maven - add following in [config-server/pom.xml](config-server/pom.xml)
```
<dependencyManagement>
<dependencies>
	<dependency>
		<groupId>org.springframework.cloud</groupId>
		<artifactId>spring-cloud-dependencies</artifactId>
		<version>Greenwich.SR3</version>
		<type>pom</type>
		<scope>import</scope>
	</dependency>
</dependencies>
</dependencyManagement>

<dependency>
	<groupId>org.springframework.cloud</groupId>
	<artifactId>spring-cloud-config-server</artifactId>
</dependency>
```
* For gradle - add following in  [config-server/build.gradle](config-server/build.gradle) for gradle
```
ext {
	set('springCloudVersion', "Greenwich.SR3")
}

dependencyManagement {
	imports {
		mavenBom "org.springframework.cloud:spring-cloud-dependencies:${springCloudVersion}"
	}
}

compile 'org.springframework.cloud:spring-cloud-config-server'
```
* Refer full dependencies - [config-server/pom.xml](config-server/pom.xml) or [config-server/build.gradle](config-server/build.gradle)
* Config Server is getting config details from [saving-accounts-service.yml](https://github.com/avinashbabudonthu/spring-cloud-config-server-properties/blob/master/savings-accounts-service.yml) in [spring-cloud-config-server-properties](https://github.com/avinashbabudonthu/spring-cloud-config-server-properties)
* Add below properties in [config-server/application.yml](config-server/src/main/resources/application.yml)
```
server.port: 8888

spring:
  application.name: config-server
  cloud.config.server.git.uri: file://[path of config properties repo cloned to local]
```
* `config-server` running on port `8888`
* Add `@EnableConfigServer` annotation on [App.java](config-server/src/main/java/com/config/server/App.java)
* Start application. Execute [App.java](config-server/src/main/java/com/config/server/App.java)
* Access APIs
	* postman-collection/config-server
		* accounts-service-default
		* accounts-service-dev
		* accounts-service-test

## Discovery Server
* Maven command
```
mvn archetype:generate -DgroupId=com.discovery.server -DartifactId=discovery-server -Dversion=1.0 -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
```
* Gradle command
```
gradle init --type pom
```
* For maven add following in - [discovery-server/pom.xml](discovery-server/pom.xml)
```
<dependencyManagement>
	<dependencies>
		<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-dependencies</artifactId>
			<version>Greenwich.SR3</version>
			<type>pom</type>
			<scope>import</scope>
		</dependency>
	</dependencies>
</dependencyManagement>

<dependency>
	<groupId>org.springframework.cloud</groupId>
	<artifactId>spring-cloud-starter-netflix-eureka-server</artifactId>
</dependency>
```
* For gradle add following in - [discovery-server/build.gradle](discovery-server/build.gradle)
```
ext {
	set('springCloudVersion', "Greenwich.SR3")
}

dependencyManagement {
	imports {
		mavenBom "org.springframework.cloud:spring-cloud-dependencies:${springCloudVersion}"
	}
}

compile 'org.springframework.cloud:spring-cloud-starter-netflix-eureka-server'
```
* Refer dependencies in [discovery-server/pom.xml](discovery-server/pom.xml) or [discovery-server/build.gradle](discovery-server/build.gradle)
* Add following properties in [application.yml](discovery-server/src/main/resources/application.yml)
```
spring:
  application.name: discovery-server
  
## eureka server should not register with eureka
eureka:
  client:
    register-with-eureka: false #built-in Eureka Client not to register with ‘itself' because our application should be acting as a server
    fetch-registry: false
```
* Full [application.yml](discovery-server/src/main/resources/application.yml)
* Add `@EnableEurekaServer` annotation on main class - [App.java](discovery-server/src/main/java/com/discovery/server/App.java)
* Start application. Execute main class - [App.java](discovery-server/src/main/java/com/discovery/server/App.java)
* Application runs on port - `8761`
* open url - http://localhost:8761

## Savings Accounts Service
* Maven command
```
mvn archetype:generate -DgroupId=com.savings.accounts.service -DartifactId=savings-accounts-service -Dversion=1.0 -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
```
* Gradle command
```
gradle init --type pom
```
* For maven - add following in [savings-accounts-service/pom.xml](savings-accounts-service/pom.xml)
```
<dependencyManagement>
	<dependencies>
		<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-dependencies</artifactId>
			<version>Greenwich.SR3</version>
			<type>pom</type>
			<scope>import</scope>
		</dependency>
	</dependencies>
</dependencyManagement>

<dependency>
	<groupId>org.springframework.cloud</groupId>
	<artifactId>spring-cloud-config-client</artifactId>
</dependency>

<dependency>
	<groupId>org.springframework.cloud</groupId>
	<artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
</dependency>

<dependency>
	<groupId>org.springframework.cloud</groupId>
	<artifactId>spring-cloud-starter-sleuth</artifactId>
</dependency>
```
* For maven add following to connect to zipkin and rabbit mq
```
<dependency>
	<groupId>org.springframework.cloud</groupId>
	<artifactId>spring-cloud-starter-zipkin</artifactId>
</dependency>

<dependency>
	<groupId>org.springframework.amqp</groupId>
	<artifactId>spring-rabbit</artifactId>
</dependency>
```
* For gradle - add following in [savings-accounts-service/build.gradle](savings-accounts-service/build.gradle)
```
ext {
	set('springCloudVersion', "Greenwich.SR3")
}

dependencyManagement {
	imports {
		mavenBom "org.springframework.cloud:spring-cloud-dependencies:${springCloudVersion}"
	}
}

compile 'org.springframework.cloud:spring-cloud-config-client'
compile 'org.springframework.cloud:spring-cloud-starter-netflix-eureka-client'
compile 'org.springframework.cloud:spring-cloud-starter-sleuth'
```
* For gradle add following to connect to zipkin and rabbit mq
```
compile 'org.springframework.cloud:spring-cloud-starter-zipkin'
compile 'org.springframework.amqp:spring-rabbit'
```
* Refer full dependencies in [savings-accounts-service/pom.xml](savings-accounts-service/pom.xml) or [savings-accounts-service/build.gradle](savings-accounts-service/build.gradle)
* Add following properties in [savings-accounts-service/bootstrap.yml](savings-accounts-service/src/main/resources/bootstrap.yml) to make as spring cloud config client
```
spring:
  cloud.config.uri: http://localhost:8888
  profiles.active: dev
```
* Add following properties in [savings-accounts-service/bootstrap.yml](savings-accounts-service/src/main/resources/bootstrap.yml) to make eureka client
```
eureka:  
  client:
    service-url:
      default-zone: http://localhost:8761/eureka
  instance:
    prefer-ip-address: true
```
* Add `@EnableEurekaClient` annotation on main class [App.java](savings-accounts-service/src/main/java/com/savings/accounts/service/App.java)
* Other Classes
	* Main class - [App.java](savings-accounts-service/src/main/java/com/savings/accounts/service/App.java)
	* Config class - [AppConfig.java](savings-accounts-service/src/main/java/com/savings/accounts/service/config/AppConfig.java)
		* Add following Bean 
```
import brave.sampler.Sampler;
@Bean
public Sampler defaultSampler() {
	return Sampler.ALWAYS_SAMPLE;
}
```
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
* For maven - add following in [accounts-service/pom.xml](accounts-service/pom.xml)
```
<dependencyManagement>
	<dependencies>
		<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-dependencies</artifactId>
			<version>Greenwich.SR3</version>
			<type>pom</type>
			<scope>import</scope>
		</dependency>
	</dependencies>
</dependencyManagement>
	
<dependency>
	<groupId>org.springframework.cloud</groupId>
	<artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
</dependency>

<dependency>
	<groupId>org.springframework.cloud</groupId>
	<artifactId>spring-cloud-starter-openfeign</artifactId>
</dependency>

<dependency>
	<groupId>org.springframework.cloud</groupId>
	<artifactId>spring-cloud-starter-netflix-ribbon</artifactId>
</dependency>

<dependency>
	<groupId>org.springframework.cloud</groupId>
	<artifactId>spring-cloud-starter-sleuth</artifactId>
</dependency>	
```
* For maven add following to connect to zipkin and rabbit mq
```
<dependency>
	<groupId>org.springframework.cloud</groupId>
	<artifactId>spring-cloud-starter-zipkin</artifactId>
</dependency>

<dependency>
	<groupId>org.springframework.amqp</groupId>
	<artifactId>spring-rabbit</artifactId>
</dependency>
```

* For gradle add following in [savings-accounts-service/build.gradle](savings-accounts-service/build.gradle)
```
ext {
	set('springCloudVersion', "Greenwich.SR3")
}

dependencyManagement {
	imports {
		mavenBom "org.springframework.cloud:spring-cloud-dependencies:${springCloudVersion}"
	}
}

compile 'org.springframework.cloud:spring-cloud-starter-netflix-eureka-client'
compile 'org.springframework.cloud:spring-cloud-starter-openfeign'
compile 'org.springframework.cloud:spring-cloud-starter-netflix-ribbon'
compile 'org.springframework.cloud:spring-cloud-starter-sleuth'
```
* For gradle add following to connect to zipkin and rabbit mq
```
compile 'org.springframework.cloud:spring-cloud-starter-zipkin'
compile 'org.springframework.amqp:spring-rabbit'
```
* Refer dependencies in [accounts-service/pom.xml](accounts-service/pom.xml) or [savings-accounts-service/build.gradle](savings-accounts-service/build.gradle)
* Add following properties in [accounts-service/bootstrap.yml](accounts-service/src/main/resources/bootstrap.yml) to make as eureka client
```
eureka:
  client:
    service-url:
      default-zone: http://localhost:8761/eureka
    healthcheck:
      enabled: true
```
* Refer all properties in [accounts-service/bootstrap.yml](accounts-service/src/main/resources/bootstrap.yml)
* Add `@EnableFeignClients`, `@EnableEurekaClient` in main class - [App.java](accounts-service/src/main/java/com/accounts/service/App.java)
* Add `@FeignClient(name = "zuul-gateway")`, `@RibbonClient(name = "savings-accounts-service")` in [SavingsAccountsServiceRestClient.java](accounts-service/src/main/java/com/accounts/service/rest/clients/SavingsAccountsServiceRestClient.java)
* Each API call mapping should have `applicatio name` prefix like. Refer [SavingsAccountsServiceRestClient.java](accounts-service/src/main/java/com/accounts/service/rest/clients/SavingsAccountsServiceRestClient.java)
	* /savings-accounts-service/accounts
	* /savings-accounts-service/v2/accounts
* Other Classes
	* Config class - [AppConfig.java](accounts-service/src/main/java/com/accounts/service/config/AppConfig.java)
		* Add following Bean 
```
import brave.sampler.Sampler;
@Bean
public Sampler defaultSampler() {
	return Sampler.ALWAYS_SAMPLE;
}
```
	* Controller class - [AppController.java](accounts-service/src/main/java/com/accounts/service/controller/AppController.java)
	* Model classes - [accounts-service/src/main/java/com/accounts/service/model](accounts-service/src/main/java/com/accounts/service/model)

## Zuul API Gateway
* Create project using maven
```
mvn archetype:generate -DgroupId=com.zuul.gateway -DartifactId=zuul-gateway -Dversion=1.0 -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
```
* Add gradle. Execute below command from `zuul-gateway` folder
```
gradle init --type pom
```
* For maven add following dependencies in [zuul-gateway/pom.xml](zuul-gateway/pom.xml)
```
<dependencyManagement>
	<dependencies>
		<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-dependencies</artifactId>
			<version>Greenwich.SR3</version>
			<type>pom</type>
			<scope>import</scope>
		</dependency>
	</dependencies>
</dependencyManagement>
	
<dependency>
	<groupId>org.springframework.cloud</groupId>
	<artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
</dependency>

<dependency>
	<groupId>org.springframework.cloud</groupId>
	<artifactId>spring-cloud-starter-netflix-zuul</artifactId>
</dependency>

<dependency>
	<groupId>org.springframework.cloud</groupId>
	<artifactId>spring-cloud-starter-sleuth</artifactId>
</dependency>	
```
* For maven add following to connect to zipkin and rabbit mq
```
<dependency>
	<groupId>org.springframework.cloud</groupId>
	<artifactId>spring-cloud-starter-zipkin</artifactId>
</dependency>

<dependency>
	<groupId>org.springframework.amqp</groupId>
	<artifactId>spring-rabbit</artifactId>
</dependency>
```
* For gradle add following dependencies in [zuul-gateway/build.gradle](zuul-gateway/build.gradle)
```
ext {
	set('springCloudVersion', "Greenwich.SR3")
}

compile 'org.springframework.cloud:spring-cloud-starter-netflix-eureka-client'
compile 'org.springframework.cloud:spring-cloud-starter-netflix-zuul'
compile 'org.springframework.cloud:spring-cloud-starter-sleuth'
```
* For gradle add following to connect to zipkin and rabbit mq
```
compile 'org.springframework.cloud:spring-cloud-starter-zipkin'
compile 'org.springframework.amqp:spring-rabbit'
```
* Add `@EnableZuulProxy`, `@EnableEurekaClient` annotations in main class [zuul-gateway/App.java](zuul-gateway/src/main/java/com/zuul/gateway/App.java)
* Create LoggingFilter class extends com.netflix.zuul.ZuulFilter - [zuul-gateway/LoggingFilter.java](zuul-gateway/src/main/java/com/zuul/gateway/filter/LoggingFilter.java)
* Add following properties in [zuul-gateway/application.yml](zuul-gateway/src/main/resources/application.yml) to make this Eureka client
```
eureka:  
  client:
    service-url:
      default-zone: http://localhost:8761/eureka
  instance:
    prefer-ip-address: true  
```
* Create config class - [AppConfig.java](zuul-gateway/src/main/java/com/zuul/gateway/config/AppConfig.java)
	* Add following bean
```
import brave.sampler.Sampler;
@Bean
public Sampler defaultSampler() {
	return Sampler.ALWAYS_SAMPLE;
}
```

## Zipkin server
* Open URL - https://zipkin.io/pages/quickstart
* Click on `latest release` link in `Java` section. This downloads executable jar file
* Execute following command from zipkin executable jar location
```
java -jar zipkin-server-*-exec.jar
```
* Open URL - http://localhost:9411 (or) http://localhost:9411/zipkin
* Start zipkin with Rabbit MQ connection. Start Rabbit MQ - https://github.com/avinashbabudonthu/jms/blob/master/rabbit-mq/notes.md#install-rabbit-mq. Execute following command after Rabbit MQ started
```
SET RABBIT_URI=amqp://localhost
java -jar zipkin-server-*-exec.jar
```

## Run application - Stop everything running and start again all in the following order. Give warm up time afer starting
* Start Rabbit MQ - https://github.com/avinashbabudonthu/jms/blob/master/rabbit-mq/notes.md#install-rabbit-mq
	* Open URL - http://localhost:15672/
* Start zipkin server. Execute following command from zipkin executable jar location. After starting open URL - http://localhost:9411
```
SET RABBIT_URI=amqp://localhost
java -jar zipkin-server-*-exec.jar
```
* Start `config-server` - [App.java](config-server/src/main/java/com/config/server/App.java)
* Start `discovery-server` - [App.java](discovery-server/src/main/java/com/discovery/server/App.java)
	* Check url - http://localhost:8761
	* We can see list of APIs registered with discovery server
* Start `zuul-gateway` - [zuul-gateway/App.java](zuul-gateway/src/main/java/com/zuul/gateway/App.java)
* Start 3 instances of `savings-accounts-service`
	* Run [savings-accounts-service/savings-accounts-service-9000.bat](savings-accounts-service/savings-accounts-service-9000.bat)
	* Run [savings-accounts-service/savings-accounts-service-9001.bat](savings-accounts-service/savings-accounts-service-9001.bat)
	* Run [savings-accounts-service/savings-accounts-service-9002.bat](savings-accounts-service/savings-accounts-service-9002.bat)
* Start `accounts-service` - [App.java](accounts-service/src/main/java/com/accounts/service/App.java)
* Hit APIs in [spring-cloud-config-client-feign-ribbon-eureka-zuul-sleuth-zipkin.postman_collection.json](files/spring-cloud-config-client-feign-ribbon-eureka-zuul-sleuth-zipkin.postman_collection.json)
	* zuul-gateway folder in postman collection
		* Hit any API and check `zuul-gateway` console log - should be able to request URI in log
* Check the console of `zuul-gateway`, `accounts-service`, `savings-accounts-service`
	* we can see log being generated with unique id
* Go to `zipkin` URL http://localhost:9411
![picture](images/logs-in-zipkin.jpg)