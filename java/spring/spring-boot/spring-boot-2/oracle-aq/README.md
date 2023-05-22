# Spring Boot 2 Oracle AQ (Advanced Queue)

# Requirement
* Spring Boot 2 Oracle AQ (Advanced Queue) Integration

# Create project using maven Command
```
mvn archetype:generate -DgroupId=com.cerebro -DartifactId=oracle-aq -Dversion=1.0.0 -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
```

# Install ojdbc8 jar in maven local repository
```
mvn install:install-file -Dfile=C:/jars/ojdbc8.jar -DgroupId=com.oracle -DartifactId=ojdbc8 -Dversion=12.2.0.1 -Dpackaging=jar
```

# Install aqapi jar in maven local repository
```
mvn install:install-file -Dfile=C:/jars/aqapi-19.3.0.0.jar -DgroupId=com.oracle -DartifactId=aqapi -Dversion=19.3.0.0 -Dpackaging=jar
```

# Install jmscommon jar in maven local repository
```
mvn install:install-file -Dfile=C:/jars/jmscommon-9i.jar -DgroupId=com.oracle -DartifactId=jmscommon -Dversion=9i -Dpackaging=jar
```

# Files
* [pom.xml](pom.xml)

