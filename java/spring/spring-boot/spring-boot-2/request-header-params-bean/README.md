# Request parameters as bean and Header parameters as map

## Requirement
* Request parameters should be assigned to bean properties
* Request headers should be passed as map

## Create project using maven
```
mvn archetype:generate -DgroupId=request.header.params.bean -DartifactId=request-header-params-bean -Dversion=1.0 -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
```

## Add gradle
```
gradle init --type pom
```

## Files
* Main class - [App.java](src/main/java/com/app/App.java)
* Controller class - [AppController.java](src/main/java/com/app/controller/AppController.java)
* Model classes
	* [RequestParamsModel.java](src/main/java/com/app/model/RequestParamsModel.java)
* Util classes
	* [HeadersEnum.java](src/main/java/com/app/util/HeadersEnum.java)
* Build files
	* [pom.xml](pom.xml)
	* [build.gradle](build.gradle)
* properties file
	* [application.properties](src/main/resources/application.properties)
* API
	* [files/request-header-params-bean.postman_collection.json](files/request-header-params-bean.postman_collection.json)
## Examples
* [Request parameters as bean properties](#request-params-to-bean-properties)
* [Request parameters as bean and headers as map](#request-parameters-as-bean-and-headers-as-map)

## Request params to bean properties
* Create model class for all request params - [RequestParamsModel.java](src/main/java/com/app/model/RequestParams.java)
* Initialize properties
* If request parameter is not passed default values will be taken
* Pass model as argument to API method
* Refer `requestParams` method in [RequestParamsController.java](src/main/java/com/app/controller/RequestParamsController.java)

## Request parameters as bean and headers as map
* Refer `requestParamsAndHeaders` method in [RequestParamsController.java](src/main/java/com/app/controller/RequestParamsController.java)
* Request parameters come as [RequestParamsModel.java](src/main/java/com/app/model/RequestParams.java) argument
* Headers comes as map  

## Run project from IDE
* Import project into IDE as Maven or Gradle project
* Execute App class in each package

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
java -jar target\request-header-params-bean.jar
```

## Create package using gradle
```
gradlew clean compileJava build
```

## Execute jar of Gradle
```
java -jar build\libs\request-header-params-bean-1.0.jar
```