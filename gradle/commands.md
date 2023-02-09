* Check installed gradle version
```
gradle --version
```
* Help on gradle commands
```
gradle --help
```
* Gradle information
```
gradle --info
```
* Execute task without debug logs
```
gradle --quiet taskName
```
* Enable debug mode
```
gradle --debug
```
* Gradle model
```
gradle model
```
* Check dependencies hierarchy
```
gradle dependencies (or) gradle dependencies --configuration runtime
```
* Initialize project as gradle project
```
gradle init
```
* Pass run time arguments
```
gradle --quiet taskName -Dproperty=value

Example: gradle --quiet taskName -Dcustom.config=myConfig.properties

Access above property in build.gradle - System.properties["custom.config"]
```
* Dry run gradle
```
gradle --dry-run
```
* To open gradle graphical user interface. Removed from version 5.0
```
gradle --gui
```
* Emits all the properties of the build's Project object. The Project object is an object representing the structure and state of the current build
```
gradle properties
```
* Package the project. Similar to mvn package
```
gradle build
```
* To see gradle tasks
```
gradle tasks
```
* To see all tasks
```
gradle tasks --all
```
* Package the project
```
gradle assemble
```
* Generate gradle wrapper files
```
gradle wrapper
```
* Generate java docs for project
```
gradle javadoc
```
* Deletes the build directory
```
gradle clean
```
* Compile src/main/java sources
```
gradle compileJava
```
* Compile test java sources
```
gradle compileTestJava
gradle testClasses
```
* Execute test cases
```
gradle test
```
* Execute multiple tasks
```
gradle clean compileJava test build
```
* Execute build with custom build file name
```
gradle --quiet --build-file build-2.gradle hello
gradle --quiet -b build-2.gradle hello
```
* Run sub project tasks from root project
```
gradle :mySubproject:taskName
gradle mySubproject:taskName
```
* Skip a task. Use either -x or --exclude-task flags
```
gradle clean build -x test
gradle clean build --execlude-task test
```
* Skip more than one task
```
gradle clean build -x checkStyle -x test -x pmd -x findbugs
```
* Upgradle gradle wrapper. If your existing Gradle-based build uses the Gradle Wrapper, you can easily upgrade by running the wrapper task, specifying the desired Gradle version
```
gradlew wrapper --gradle-version 5.0

./gradlew wrapper --gradle-version=7.6 --distribution-type=bin
```
* Force Gradle to execute all tasks ignoring up-to-date checks using the --rerun-tasks option
```
gradle compileJava --rerun-tasks
```
* Update group, description, version. Write below in `build.gradle`
```
group = 'gradle.install' , description = 'gradle-install' , version = '1.0'
```
* To create a Java library project
```
gradle init --type java-library
```
* To create a Java library project with Kotlin DSL build scripts
```
gradle init --type java-library --dsl kotlin
```
* To create a Java library project with Groovy DSL build scripts
```
gradle init --type java-library --dsl groovy
```
* Create core java application using junit framework
```
gradle init --type java-application
```
* Create core java application using spock unit testing framework
```
gradle init --type java-application --test-framework spock
```
* Create core java application using `testng` unit testing framework
```
gradle init --type java-application --test-framework testng
```
* Create core java application with Groovy DSL using spock unit testing framework
```
gradle init --type java-application --dsl groovy --test-framework spock
```
* `--type` options to create projects
	* java-library
	* scala-library
	* groovy-library
	* groovy-application
* To make maven project compatible to gradle
	* Create maven project
	* Go inside that project
	* Run any of the following commands
		* gradle init
		* gradle init --type pom
* Install to local maven repository. Same as mvn install. For this to work add maven plugin
	* Apply maven plugin `apply plugin: "maven"`
	* Update repositories to refer from mavenLocal `repositories { mavenCentral() mavenLocal() }`
	* Run `gradle install`
	* jar will be created and installed to local maven repository