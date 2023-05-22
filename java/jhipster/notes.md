# What Is it
* JHipster’s goal is to generate for you a complete and modern web app, unifying:
	* A high-performance and robust Java stack on the server-side with Spring Boot
	* A sleek, modern, mobile-first front-end with AngularJS and Bootstrap
	* A powerful workflow to build your application with Yeoman, Bower, Gulp and Maven

# Client-side Stack
* Responsive web design
* HTML5 boilerplate
* Twitter Bootstrap
* AngularJS
* Compatible with IE9+ and modern browsers
* Full internationalization support with Angular Translate
* Optional Sass support for CSS design
* Optional WebSocket support with Spring Websocket

# Server-side Stack
* Spring Boot for easy application configuration
* Maven or Gradle configuration for building, testing, and running the application “development” and “production” profiles (both for Maven and Gradle)
* Spring Security
* Spring MVC REST + Jackson
* Optional WebSocket support with Spring Websocket
* Spring Data JPA + Bean Validation
* Database updates with Liquibase
* Elasticsearch support if you want to have search capabilities on top of your database
* MongoDB support if you’d rather use a document-oriented NoSQL database instead of JPA
* Cassandra support if you’d rather use a column-oriented NoSQL database instead of JPA

# Production Utilities and the Like
* Monitoring with Metrics
* Caching with ehcache (local cache) or hazelcast (distributed cache)
* Optional HTTP session clustering with hazelcast
* Optimized static resources (gzip filter, HTTP cache headers)
* Log management with Logback, configurable at runtime
* Connection pooling with HikariCP for optimum performance
* Builds a standard WAR file or an executable JAR file

# Installation
* install yo
```
npm install -g yo
```
* yo version
```
yo --version
```
* install bower
```
npm install -g bower
```
* bower version
```
bower --version
```

* install gulp
```
npm install -g gulp
```
* gulp version
```
gulp --version
```
* install generator-jhipster
* Vagrant support
* Docker support

# Monolithic or Microservice
* The first question JHipster will ask you is what kind of application you want to generate. You have in fact the choice between two architecture styles.
	* Choose which one you want at build – Monolith or Microservice
	* Maven or Gradle
	* Other DB support (Oracle separate)
* A “monolithic” architecture uses a single, one-size-fits-all application, which contains both the front-end AngularJS code, and the back-end Spring Boot code. A “microservices” architecture splits the front-end and the back-end, so that it’s easier for your application to scale and survive infrastructure issues.
* A monolithic application is much easier to work on, so if you don’t have any specific requirements, this is the option we recommend, and our default option

# Monolithic Path
* We will be pretty much following JHipster’s quick-start guide [https://jhipster.github.io/#quick](https://jhipster.github.io/#quick) for this exercise
	* Install JHipster `npm install -g generator-jhipster`
	* Create a new directory and go into it `mkdir app1 && cd app1`
	* Run JHipster and follow instructions on screen `yo jhipster`
	* Model your entities with JDL Studio and download the resulting jhipster-jdl.jh file
	* Generate your entities with yo jhipster:import-jdl jhipster-jdl.jh
	* Assuming you have already installed Java, Git, Node.js, Bower, Yeoman and Gulp