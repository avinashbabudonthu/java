* To change the source JDK version
```
sourceCompatibility=1.8
```
* To change target JDK version
```
targetCompatibility=1.8
```
* To specify the main class name
```
mainClassName="com.gradle.practice.App"
```
* A boolean property indicating whether the task completed successfully. Not all tasks may set didWork upon completion, but some built-in tasks like Compile, Copy, and Delete do set it to reflect the success or failure of their actions
```
didWork
```
* A boolean property indicating whether the task will execute. You can set any task's enabled property to false to cause it not to run. Its dependencies will still execute the way they would if the task were enabled
```
enabled
```
* A string property containing the fully qualified path of a task. By default, a task's path is simply the name of the task with a leading colon. The leading colon indicates that the task is located in the top-level build file. If the task existed in a nested build called subProject, then the path would be :subProject:taskName
```
path
```
* Gradle logger implements the org.slf4j.Logger interface. DEBUG, INFO, LIFECYCLE, WARN, QUIET, ERROR
```
logger
```
* Gives access to log level
```
loggingLevel
```
* To give description about the task
```
description
```
* temporaryDir: property returns a File object pointing to a temporary directory belonging to this build file
* projectDir: Directory containing the build script
* buildDir: Current project build directory. That is projectDir/build
* project.name: To get the current project name
* Dependency Scopes
	* default
	* compile
	* testCompile
	* runtime
	* testRuntime
	* archives
* Declare dependency
```
dependencies {
	compile "commons-beanutils:commons-beanutils:1.8.3" 
	testCompile "junit:junit:4.12" 
}
```
* Include your file system JAR dependencies
```
dependencies {
	runtime files("libs/a.jar", "libs/b.jar")   
	runtime fileTree(dir: "libs", include: "*.jar") 
}
```
* Declare repositories
```
repositories {
	jcenter() 
	mavenLocal() 
	mavenCentral() 
	maven { url "http://repo.maven.apache.org/maven2" } 
	maven { url "http://nexus.thermofisher.com/nexus/content/repositories/central/" } }
```
* Preserve parameter names in run time
```
compileJava {
	options.compilerArgs << '-parameters' 
}
```
* Add additional source directories
```
sourceSets.main.java.srcDirs = ["src/main/java", "srcAdditional/main/java"]
(or)
sourceSets.main.java.srcDirs "srcAdditionalTwo/main/java"
(or)
sourceSets {
	main.java.srcDir "src/main/java"
	test.java.srcDir "src/test/java"
}
```