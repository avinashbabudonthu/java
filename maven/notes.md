# Maven Notes

# Quick Notes
* What is Maven?
	* Build tool to automate the build process
	* Project management and comprehension tool
	* Standardizes and simplifies project build process
* Maven uses standard directory layout and default build life cycle
	* src/main/java
		* java source files means `.java` files
	* src/main/resources
		* project resource files like 
		* properties files
		* yml files
		* xml files
		* any project specific files
	* src/test/java
		* Java test source files
	* src/test/resources
		* resource files used by test classes
* Maven simplifies
	* Builds
	* Documentation
	* Reporting
	* Dependencies
	* Releases
	* Distribution
	* Mailing list
* Maven Overview\
![picture](images/maven-overview.png)
* POM
	* Project Object Model
	* It always resides in the base directory of the project
	* Name of the file `pom.xml`
* Group Id, Artifact Id, Version - Explanation\
![picture](images/groupId_artifactId_version.jpg)
* Default values in pom\
![picture](images/default_values_in_pom.jpg)
* goal or task
	* Specific tasks used in building and managing the project
* some configurations we can give in pom	
	* project dependencies, plugins, goals, build profiles, project versions, mailing list etc
* What uniquely identifies jar/project in maven repository?	
	* group (groupId), name(artifactId), version
* Project notation in repository	
	* groupId:artifactId:version
* pom.xml
	* Maven project structure
	* Contents are declared in pom.xml file
* Build life cycle
	* Sequence of phases which define the order in which the goals are to be executed
* Sequence of phases in maven build life cycle	
	* Prepare-resources
	* compile
	* package
	* install
* Maven uses archetype plugin to create projects
* Maven does the dependency management using concept of Maven Repositories	
* ${basedir}
	* Represents the directory containing pom.xml
* Adding external jars\
![picture](images/adding_external_dependencies.jpg)
* Archetype
	* Archetype is a Maven plugin whose task is to create a project structure as per its template
	* We are going to use quickstart archetype plugin to create a simple java application here
```
mvn archetype:generate
```
* SNAPSHOT
	* SNAPSHOT is a special version that indicates a current development copy. Unlike regular versions, Maven checks for a new SNAPSHOT version in a remote repository for every build
	* For example Now data-service team will release SNAPSHOT of its updated code every time to repository say data-service:1.0-SNAPSHOT replacing a older SNAPSHOT jar
* modelVersion
	* what version of the POM model you are using. Use the one matching the Maven version you are using. Version 4.0.0 matches Maven version 2 and 3
* Super POM
	* You can make a POM file explicitly inherit from another POM file
	* That way you can change the settings across all inheriting POM's via their common super POM
	* You specify the super POM at the top of a POM file
	* An inheriting POM file may override settings from a super POM. Just specify new settings in the inheriting POM file
* Inherting pom
```
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" 
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    
	<parent>
		<groupId>org.codehaus.mojo</groupId>
		<artifactId>my-parent</artifactId>
		<version>2.0</version>
		<relativePath>../my-parent</relativePath>
	</parent>
		
	<groupId>com.test</groupId>
	<artifactId>my-project</artifactId>
	<version>1.0.1</version>
</project>
```
* Effective POM
	* With all this POM inheritance it may be hard to know what the total POM file looks like when Maven executes. The total POM file (result of all inheritance) is called the effective POM. You can get Maven to show you the effective POM using this command
	* This command will make Maven write out the effective POM to the command line prompt
```
mvn help:effective-pom
```
* repositories
	* local
	* remote
	* central
* local repository
	* local machine
	* default location	`user-home/.m2`
* remote repository	
	* repository of specific organization
* central repository
	* repository provided by maven
* we can specify another location for your local repository by following entry in `settings.xml`
```
<settings>
    <localRepository>        d:\data\java\products\maven\repository    </localRepository>
</settings>
```
* Remote repository configuration in `pom.xml`. Put the following XML elements right after `<dependencies>` element	
	* If your internal repository requires authentication, the `id` element can be used in your `settings.xml` file to specify login information
```
<repositories>
   <repository>
       <id>jenkov.code</id>
       <url>http://maven.jenkov.com/maven2/lib</url>
	   <releases>
			<enabled>true</enabled>
		</releases>
		<snapshots>
			<enabled>true</enabled>
		</snapshots>
   </repository>
</repositories>
```
* sample repositories tag
```
<repositories>
    <repository>
        <id>spring-snapshot</id>
        <name>Spring Maven Repository</name>
        <url>http://repo.springsource.org/libs-snapshot</url>
        <snapshots>
            <enabled>true</enabled>
        </snapshots>
        <releases>
            <enabled>false</enabled>
        </releases>
    </repository>
</repositories>
```
* settings.xml	
	* The repositories for download and deployment are defined by the repositories and distributionManagement elements of the POM. However, certain settings such as username and password should not be distributed along with the pom.xml. This type of information should exist on the build server in the settings.xml
* servers tag
	* id: This is the ID of the server (not of the user to login as) that matches the id element of the repository/mirror that Maven tries to connect to
	* username, password: These elements appear as a pair denoting the login and password required to authenticate to this server
	* privateKey, passphrase: Like the previous two elements, this pair specifies a path to a private key (default is ${user.home}/.ssh/id_dsa) and a passphrase, if required. The passphrase and password elements may be externalized in the future, but for now they must be set plain-text in the settings.xml file.
	* filePermissions, directoryPermissions: When a repository file or directory is created on deployment, these are the permissions to use. The legal  values of each is a three digit number corrosponding to *nix file permissions, ie. 664, or 775.
	* Note: If you use a private key to login to the server, make sure you omit the <password> element. Otherwise, the key will be ignored.
```
<servers>
	<server>
	  <id>server001</id>
	  <username>my_login</username>
	  <password>my_password</password>
	  <privateKey>${user.home}/.ssh/id_dsa</privateKey>
	  <passphrase>some_passphrase</passphrase>
	  <filePermissions>664</filePermissions>
	  <directoryPermissions>775</directoryPermissions>
	  <configuration></configuration>
	</server>
</servers>
```
* Transitive dependencies	
	* If we add one dependency in pom.xml and if that dependency has other dependencies then maven will download automatically all the dependent dependencies. These dependent dependencies are called Transitive dependencies.
* Goals 	
	* clean
	* compile
	* package
	* install
	* deploy
* clean	
	* Deletes target directory and any generated resources
* compile (this is goal, do not confuse with compile scope)	
	* compiles source code
	* copy resources to classes directory
* package	
	* run compile goal first
	* run unit test cases
	* packages the application based on packaging type we declared in `pom.xml`
* install	
	* Runs package goal
	* copies generated package into `local repository` based on groupId, artifactId, version declared in pom.xml
* deploy
	* Runs install goal
	* copies generated package into `remote repository`
* How to give specific name to out application jar/war	
	* using `<finalName>MavenHelloWorld</finalName>` tag in `<build>` tag
	* Now our war name will be MavenHelloWorld.war
```
<finalName>MavenHelloWorld</finalName>
(or)
<finalName>{project.artifactId}</finalName>
```
* Dependency types	
	* pom, jar, maven-plugin, ear, war, rar, par
	* default packaging type is jar
* pom dependency type	
	* If we declare dependency type as pom then all dependencies in that pom will be downloaded to our application
* There are 6 scopes in maven	
	* compile
	* provided
	* runtime
	* test
	* system
	* import
* compile (this is scope, do not confuse with compile goal)	
	* Default scope
	* Artifacts are available every where
* provided	
	* like compile, means artifact going to be provided by deployed environment
* runtime	
	* not needed for compilation but needed for execution
* test	
	* only available for the test compilation and execution phase
* system	
	* to specify a path to the jar on our file system
* import	
	* deals with dependencyManagement
	* DependencyManagement deals with sharing resources across multiple poms
* plugin repositories - for downloading plugins	
```
<pluginRepositories>
    <pluginRepository>
        <id>cerebro corp</id>
        <name>Cerebro plugin repository</name>
        <url>http://cerebrocorp.com/plugins</url>
        <snapshots>
            <enabled>true</enabled>
        </snapshots>
        <releases>
            <enabled>false</enabled>
        </releases>
    </pluginRepository>
</pluginRepositories>
```
* Maven plugins	
	* Plugins are what maven uses to build and package our application as well as do anything outside of just downloading and storing artifacts for us
	* compiler plugin	
```	
<plugin>
	<groupId>org.apache.maven.plugins</groupId>
	<artifactId>maven-compiler-plugin</artifactId>
	<version>3.5.1</version>
	<configuration>
		<source>1.8</source>
		<target>1.8</target>
		<showDeprecation>true</showDeprecation>
		<showWarnings>1.8</showWarnings>
		<compilerArgument>-Xlint:all</compilerArgument>
		<compilerArgument>-parameters</compilerArgument>
	</configuration>
</plugin>
```	
	* jar plugin	
	* sources plugin	
	* javadoc plugin	
* Some built in phases	
	* validate
	* compile
	* test
	* package
	* integration-test
	* verify
	* install
	* deploy
* validate
	* validates the project is correct and has all the necessary information is available 
* compile
	* phase where our source code is compiled. Here test code will not compile
* test
	* phase where test code is compiled. Executes test cases
* package
	* packages all our code into it's defined packaging such as jars
* integration-test
	* deploy and run integration test
* source plugin	
	* to attache our source code to jar
* run mvn by passing aws.access key and secret key as java parameters	
	* mvn -Daws.accessKeyId=XYZ -Daws.secretKey=ABC clean compile install
	* http://docs.aws.amazon.com/sdk-for-java/v1/developer-guide/credentials.html

* built in build life cycles
	* default
	* clean
	* site
* default	
	* everything related to compiling and packaging your project
* clean
	* everything related to removing temporary files from the output directory, including generated source files, compiled classes, previous JAR files etc
* site
	* everything related to generating documentation for your project. In fact, site can generate a complete website with documentation for your   project
* mvn validate
	* validates that the project is correct and all necessary information is available.
	* This makes sure the dependencies are downloaded
* validate
	* Validates that the project is correct and all necessary information is available. This also makes sure the dependencies are downloaded.
* compile
	* Compiles the source code of the project.
* test
	* Runs the tests against the compiled source code using a suitable unit testing framework. These tests should not require the code be packaged or deployed.
* package
	* Packs the compiled code in its distributable format, such as a JAR.
* integration-test
	* process and deploy the package if necessary into an environment where integration tests can be run
* verify
	* run any checks to verify the package is valid and meets quality criteria
* install
	* Install the package into the local repository, for use as a dependency in other projects locally. This is part of default build life cycle
* deploy
	* Copies the final package to the remote repository for sharing with other developers and projects.
* Maven Build Profiles
	* Maven build profiles enable you to build your project using different configurations
	* Instead of creating two separate POM files, you can just specify a profile with the different build configuration, and build your project with this build profile when needed
```
<profiles>
<profile>
  <id>test</id>
  <activation>...</activation>
  <build>...</build>
  <modules>...</modules>
  <repositories>...</repositories>
  <pluginRepositories>...</pluginRepositories>
  <dependencies>...</dependencies>
  <reporting>...</reporting>
  <dependencyManagement>...</dependencyManagement>
  <distributionManagement>...</distributionManagement>
</profile>
</profiles>
```
* activation
	* Inside the profile element you can see a activation element. This element describes the condition that triggers this build profile to be used
	* way 1: One way to choose what profile is being executed is in the settings.xml file. There you can set the active profile
```
<activeProfiles>
	<activeProfile>test</activeProfile>
</activeProfiles>
```
	* way 2: Another way is to add -P profile-name to the Maven command line.
	* To see which profile will activate in a certain build, use the maven-help-plugin: `mvn help:active-profiles`
* How to get effective pom into a text file	
```
mvn help:effective-pom > c:\poms\test.txt
```
* Executing main class from maven command prompt
```
mvn exec:java -Dexec.mainClass=com.camel.spring.CamelSpringHelloWorld
```
* Maven install plugin to install any jar automatically before building our war/jar
```
 <plugin>
<groupId>org.apache.maven.plugins</groupId>
<artifactId>maven-install-plugin</artifactId>
<version>2.5.2</version>
<executions>
	<execution>
		<id>whatevs</id>
		<phase>validate</phase>
		<goals>
			<goal>install-file</goal>
		</goals>
		<configuration>
			<groupId>com.oracle</groupId>
			<artifactId>ojdbc6</artifactId>
			<version>${oracle.version}</version>
			<packaging>jar</packaging>
			<file>${basedir}/dev-setup/lib/ojdbc6.jar</file>
		</configuration>
	</execution>
</executions>
</plugin>
```
* Runnning test cases using maven
```
mvn -f dashboard/domain/pom.xml -Dtest=DomainTestsSuite test
```
* parameters
	* To preserve method parameter names in Java byte-code and make them available at runtime
```
<plugin>
	<groupId>org.apache.maven.plugins</groupId>
	<artifactId>maven-compiler-plugin</artifactId> 
	<version>3.5.1</version>
	<configuration>
		<compilerArgument>-parameters</compilerArgument>
		<source>1.8</source>
		<target>1.8</target>
	</configuration>
</plugin>
```
* create encrypted password that can go to settings.xml
	* mvn --encrypt-passord
		* From maven 3.2.1 and above - running above command will prompt for password. After entering password encrypted password will be created.
```
<servers>
	<id>my.server</id>
	<username>myusername</username>
	<password>{encrypted_password}</password>
</servers>
```
* In Spring boot applications we will not have web.xml then in pom.xml if we are adding maven-web-plugin then this will complain like web.xml is missing. To resolve this error we need to add <failOnMissingWebXml> tag value to false
```
<build>
<finalName>merchantinteractivepayments</finalName>
<plugins>
	<plugin>
		<groupId>org.apache.maven.plugins</groupId>
		<artifactId>maven-war-plugin</artifactId>
		<configuration>
			<failOnMissingWebXml>false</failOnMissingWebXml>
		</configuration>
	</plugin>
</plugins>
</build>
```
* How to Run “Execute” Java Main Class Using Maven Command
	* mvn exec:java
```
<plugin>
<groupId>org.codehaus.mojo</groupId>
<artifactId>exec-maven-plugin</artifactId>
<configuration>
	 <mainClass>com.hmkcode.MainClassName</mainClass>
</configuration>
</plugin>
```

## Maven dependency scopes
* compile
	* This is maven default scope
	* Dependencies with compile scope are needed to build, test, and run the project
```
<dependencies>
    <dependency>
        <groupId>log4j</groupId>
        <artifactId>log4j</artifactId>
        <version>1.2.14</version>
        <!-- You can ommit this because it is default -->
        <scope>compile</scope>
    </dependency>
</dependencies>
```

* provided
	* Maven dependency scope provided is used during build and test the project
	* They are also required to run, but should not exported, because the dependency will be provided by the runtime, for instance, by servlet container or application server
```
<dependency>
    <groupId>javax.servlet</groupId>
    <artifactId>servlet-api</artifactId>
    <version>3.0.1</version>
    <scope>provided</scope>
</dependency>
```
* runtime
	* Dependencies with maven dependency scope runtime are not needed to build, but are part of the classpath to test and run the project
```
<dependency>
    <groupId>com.thoughtworks.xstream</groupId>
    <artifactId>xstream</artifactId>
    <version>1.4.4</version>
    <scope>runtime</scope>
 </dependency>
```
* test
	* Dependencies with maven dependency scope test are not needed to build and run the project
	* They are needed to compile and run the unit tests
```
<dependency>
    <groupId>junit</groupId>
    <artifactId>junit</artifactId>
    <version>4.12</version>
    <scope>test</scope>
</dependency>
```
* system
	* Dependencies with system are similar to ones with scope provided. 
	* The only difference is system dependencies are not retrieved from remote repository.
	* They are present under project’s subdirectory and are referred from there
```
<dependency>
  <groupId>extDependency</groupId>
  <artifactId>extDependency</artifactId>
  <scope>system</scope>
  <version>1.0</version>
  <systemPath>${basedir}\war\WEB-INF\lib\extDependency.jar</systemPath>
</dependency>
```
* import
	* import scope is only supported on a dependency of type pom in the dependencyManagement section. 
	* It indicates the dependency to be replaced with the effective list of dependencies in the specified POM’s dependencyManagement section
```
<dependencyManagement>
    <dependencies>
        <dependency>
            <groupId>other.pom.group.id</groupId>
            <artifactId>other-pom-artifact-id</artifactId>
            <version>SNAPSHOT</version>
            <scope>import</scope>
            <type>pom</type>
        </dependency>   
    </dependencies>
</dependencyManagement>
```
* Maven dependency transitivity resolution
	* When you include a maven dependency and it has it’s own other dependencies (i.e. transitive dependencies) then you may want to be clear about the scope of these transitive dependencies as well
	* First column - scope of dependency, scope of transitive dependency at the top row

Dependency            | compile   		| provided  	  | runtime   		| test
--------------------  | --------------- | --------------- | --------------- | ---------------
compile				  | compile			| 	 			  | runtime			| 
provided			  | provided		| 	 			  | provided		| 
runtime				  | runtime			| 	 			  | runtime			| 
test				  | test			| 	 			  | test			|

## Maven Pull from remote repository - repositories tag
```
<repositories>
    <repository>
        <id>browserid-snapshots</id>
        <name>browserid-snapshots</name>
        <url>https://oss.sonatype.org/content/repositories/snapshots/</url>
    </repository>
</repositories>
```

## Maven Push to remote repository - distributionManagement tag
```
<distributionManagement>
    <repository>
      <id>operative-releases</id>
      <name>Operative Releases Repository</name>
      <url>${operative.nexus}/repositories/operative-releases</url>
    </repository>
    <snapshotRepository>
      <id>operative-snapshots</id>
      <name>Operative Snapshots Repository</name>
      <url>${operative.nexus}/repositories/operative-snapshots</url>
    </snapshotRepository>
    <site>
      <id>operative-mavensite</id>
      <name>Operative Maven WebSite</name>
      <url>operative-global</url>
    </site>
  </distributionManagement>
```

## Maven Spring Boot Plugin
```
<plugin>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-maven-plugin</artifactId>
</plugin>
```

## Maven Execute Exec Plugin
* Add `exec-maven-plugin` plugin under `build/plugins` in `pom.xml`
* Configure full packaged class name of main class in the plugin
* Execute main program using command: `mvn exec:java`
```
<plugin>
	<groupId>org.codehaus.mojo</groupId>
	<artifactId>exec-maven-plugin</artifactId>
	<version>1.6.0</version>
	<configuration>
	  <mainClass>com.test.MainAppClassName</mainClass>
	  <executable>java</executable>
	  <arguments>
		<argument>-Xms1024M</argument>
		<argument>-Xmx1024M</argument>
		<argument>-cp</argument>
		<classpath/>
	  </arguments>
	</configuration>
 </plugin>
```

## Maven compile plugin
* For Java 8
```
<plugin>
	<groupId>org.apache.maven.plugins</groupId>
	<artifactId>maven-compiler-plugin</artifactId>
	<version>3.8.1</version>
	<configuration>
		<source>1.8</source>
		<target>1.8</target>
		<meminitial>128m</meminitial>
		<maxmem>512m</maxmem>
		<showDeprecation>true</showDeprecation>
		<showWarnings>true</showWarnings>
		<encoding>UTF-8</encoding>
		<verbose>true</verbose>
		<compilerArgument>-Xlint:all</compilerArgument>
		<compilerArgument>-parameters</compilerArgument>
	</configuration>
</plugin>
```
* For Java 9
```
<plugin>
	<groupId>org.apache.maven.plugins</groupId>
	<artifactId>maven-compiler-plugin</artifactId>
	<version>3.8.1</version>
	<configuration>
		<release>9</release>
	</configuration>
</plugin>
```
* For Java 11. Reference - [https://winterbe.com/posts/2018/08/29/migrate-maven-projects-to-java-11-jigsaw/](https://winterbe.com/posts/2018/08/29/migrate-maven-projects-to-java-11-jigsaw/)
* In order to compile your project for Java 11 add the `release` configuration to the compiler plugin
* New compiler parameter to replace the `source` and `target` version parameters
* Don't forget to set your IDEs project SDK to same JDK version
```
<plugin>
	<groupId>org.apache.maven.plugins</groupId>
	<artifactId>maven-compiler-plugin</artifactId>
	<version>3.8.1</version>
	<configuration>
		<release>11</release>
	</configuration>
</plugin>
```
* Java 12
```
<build>
    <plugins>
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-compiler-plugin</artifactId>
            <version>3.8.0</version>
            <configuration>
                <source>12</source>
                <compilerArgs>--enable-preview</compilerArgs>
            </configuration>
        </plugin>
    </plugins>
</build>	
```

## Maven Surefire Plugin
* Java 11 - surefire plugin we add an additional argument `--illegal-access=permit` to allow all reflection access for third party libraries
```
<plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-surefire-plugin</artifactId>
    <version>2.22.0</version>
    <configuration>
        <argLine>
            --illegal-access=permit
        </argLine>
    </configuration>
</plugin>
```
* This is only needed if your dependencies make heavy use of reflection. If you're unsure whether you need this you can add the `argLine` later if your tests run into trouble.
* You'll see warnings like this when a library tries to illegally access classes via setAccessible(true)
```
WARNING: Please consider reporting this to the maintainers of org.codehaus.groovy.reflection.CachedClass
WARNING: Use --illegal-access=warn to enable warnings of further illegal reflective access operations
WARNING: All illegal access operations will be denied in a future release
```

## maven-failsafe-plugin
* Java 11 - failsafe plugins we add an additional argument `--illegal-access=permit` to allow all reflection access for third party libraries
```
<plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-failsafe-plugin</artifactId>
    <version>2.22.0</version>
    <configuration>
        <argLine>
            --illegal-access=permit
        </argLine>
    </configuration>
</plugin>
```

## Skip Test Cases
* To skip running the tests for a particular project, set the skipTests property to true
```
<project>
  [...]
  <build>
    <plugins>
      <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-surefire-plugin</artifactId>
        <version>2.19.1</version>
        <configuration>
          <skipTests>true</skipTests>
        </configuration>
      </plugin>
    </plugins>
  </build>
  [...]
</project>
```
* skip the tests via the command line by executing the following command
```
mvn install -DskipTests
```
* can also use the maven.test.skip property to skip compiling the tests. maven.test.skip is honored by Surefire, Failsafe and the Compiler Plugin
```
mvn install -Dmaven.test.skip=true
```
* Skipping by Default - If you want to skip tests by default but want
 the ability to re-enable tests from the command line, you need to go via a properties section in the pom
	* This will allow you to run with tests disabled by default and to run them with this command `mvn install -DskipTests=false`

```
<project>
  [...]
  <properties>
    <skipTests>true</skipTests>
  </properties>
  [...]
  <build>
    <plugins>
      <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-surefire-plugin</artifactId>
        <version>2.19.1</version>
        <configuration>
          <skipTests>${skipTests}</skipTests>
        </configuration>
      </plugin>
    </plugins>
  </build>
  [...]
</project>
```

## Maven version plugin
* This plugin helps finding the latest plugin or dependency versions for your modules
```
<plugin>
    <groupId>org.codehaus.mojo</groupId>
    <artifactId>versions-maven-plugin</artifactId>
    <version>2.5</version>
    <configuration>
        <generateBackupPoms>false</generateBackupPoms>
    </configuration>
</plugin>
```
* Open up the terminal and execute this command to find the plugin versions you have to update
```
mvn versions:display-plugin-updates
```
* You will see a list of plugins used in your project with newer versions available. Update all of those plugins to the lastest stable version. After you've updated your plugin versions make sure that your project still compiles and runs properly
* Use mvn -N ... from your projects root directory to just check your parent POM in case of multi-module projects.
