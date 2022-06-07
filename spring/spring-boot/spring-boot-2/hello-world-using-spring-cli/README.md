# Spring boot project using Spring cli

## Versions
* Spring Boot vesion **2.1.8.RELEASE**

## Steps
* Install spring cli in local. Click **[here](https://docs.spring.io/spring-boot/docs/current/reference/html/getting-started-installing-spring-boot.html)** for reference
* Run command
```
spring init --dependencies=web,data-jpa hello-world-using-spring-cli
```
* Above command creates Spring boot project with dependencies
```
spring-boot-starter-web
spring-boot-starter-test
spring-boot-starter-data-jpa
```
* Spring boot plugin also will be added
```
spring-boot-maven-plugin
```

## References
* [Spring Boot Cli Installation reference](https://docs.spring.io/spring-boot/docs/current/reference/html/getting-started-installing-spring-boot.html)


## Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.1.8.RELEASE/maven-plugin/)
* [Spring Web](https://docs.spring.io/spring-boot/docs/{bootVersion}/reference/htmlsingle/#boot-features-developing-web-applications)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/{bootVersion}/reference/htmlsingle/#boot-features-jpa-and-spring-data)

## Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)

