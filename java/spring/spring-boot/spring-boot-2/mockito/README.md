# Mockito

## Requirement

## Create project using maven
```
mvn archetype:generate -DgroupId=mockito -DartifactId=mockito -Dversion=1.0 -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
```

## Add gradle
```
gradle init --type pom
```

## Versions
* Maven **3.5.2**
* Gradle **5.0**

## API
* Refer [files/mockito.postman_collection.json](files/mockito.postman_collection.json)

## Examples
* [Inject Actual Object](#inject-actual-object)

## Inject Actual Object
* Use annotation **org.mockito.Spy**
* Create object using new
* Refer **mockito.repository.StudentRepositoryTest**
* Run **findStudent()** as Junit Test case