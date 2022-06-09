# Spring Batch Hello World

# Maven Command
```
mvn archetype:generate -DgroupId=com.cerebro -DartifactId=hello-world -Dversion=1.0 -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
```

# Files
* [App](src/main/java/com/cerebro/App.java)
* [CSVProcessor](src/main/java/com/cerebro/batch/CSVProcessor.java)
* [UserWriter](src/main/java/com/cerebro/batch/UserWriter.java)
* [AppConfig](src/main/java/com/cerebro/config/AppConfig.java)
* [AppController](src/main/java/com/cerebro/controller/AppController.java)
* [UserEntity](src/main/java/com/cerebro/model/UserEntity.java)
* [UserRepository](src/main/java/com/cerebro/repository/UserRepository.java)

# References
* [Spring Batch in Spring Boot _ CSV to Database _ Tech Primers](https://www.youtube.com/watch?v=1XEX-u12i0A)