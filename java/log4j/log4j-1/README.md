# Create log file name with date suffix
* Rename any of the below properties file to `log4j.poperties` before executing this example
* [log4j.properties](src/main/resources/log4j-1.properties)
* [log4j-2.properties](src/main/resources/log4j-2.properties)

# Solution 1 - Using custom FileAppender class
* Add log4j dependencies in [pom.xml](pom.xml)
* Write class to change file name - [DateFormatFileAppender](src/main/java/com/java/DateFormatFileAppender.java)
* Give above class name [log4j.properties](src/main/resources/log4j-1.properties)
* Execute main class - [App.java](src/main/java/com/java/App.java)

# Solution 2 - Using TimeBasedRollingPolicy
* Refer [log4j-2.properties](src/main/resources/log4j-2.properties)

