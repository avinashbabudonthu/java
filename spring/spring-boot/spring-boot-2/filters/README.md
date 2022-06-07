# Using Request Scoped Beans

## Create project using maven
```
mvn archetype:generate -DgroupId=filters -DartifactId=filters -Dversion=1.0 -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
```

## Add gradle
```
gradle init --type pom
```

## Versions
* Maven **3.5.2**
* Gradle **5.0**

## Steps
* Add spring boot dependencies. Refer [pom.xml](pom.xml) or [build.gradle](build.gradle)
* Create filter **filters.all.FilterOne** executes for all requests as first filter
```
@Order(1)
```
* Create filter **filters.all.FilterTwo** execute for all requests as second filter
```
@Order(2)
```
* Create filter **filters.all.FilterThree**. Register for request **/api/v1** in **filters.config.AppConfig**
```
@Bean
public FilterRegistrationBean<FilterThree> registerApiOneFilter() {
	FilterRegistrationBean<FilterThree> registrationBean = new FilterRegistrationBean<>();

	registrationBean.setFilter(filterThree);
	registrationBean.addUrlPatterns("/api/v1/*");

	return registrationBean;
}
```
* Create filter **filters.all.FilterFour**. Register for request **/api/v2** in **filters.config.AppConfig**
```
@Bean
public FilterRegistrationBean<FilterFour> registerApiTwoFilter() {
	FilterRegistrationBean<FilterFour> registrationBean = new FilterRegistrationBean<>();

	registrationBean.setFilter(filterFour);
	registrationBean.addUrlPatterns("/api/v2/*");

	return registrationBean;
}
```
* Create filter **filters.all.FilterFive**. Register for requests **/api/v1**, **/api/v2** in **filters.config.AppConfig**
```
@Bean
public FilterRegistrationBean<FilterFive> registerFilterFive() {
	FilterRegistrationBean<FilterFive> registrationBean = new FilterRegistrationBean<>();

	registrationBean.setFilter(filterFive);
	registrationBean.setUrlPatterns(Arrays.asList("/api/v1/*", "/api/v2/*"));

	return registrationBean;
}
```

## Run this project
* Import project into IDE as Maven or Gradle project
* Execute **filters.App** class in each package

## Run using maven
```
mvn clean compile spring-boot:run
```

## Run using gradle
```
gradlew clean compileJava bootRun
```

## Create package using maven
```
mvn clean compile package
```

## Execute jar of Maven
```
java -jar target\filters.jar
```

## Create package using gradle
```
gradlew clean compileJava build
```

## Execute jar of Gradle
```
java -jar build\libs\filters-1.0.jar
```

## API
Refer [files/filters.postman_collection.json](files/filters.postman_collection.json)