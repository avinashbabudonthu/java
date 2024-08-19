# What is Dispatcher Servlet?
* We add `sprin-boot-starter-web` dependency which has transitive dependency on `spring web mvc`
* So `DispatcherServlet` class added to our class path
* So spring boot auto configures `DispatcherServlet` using `DispatcherServletAutoConfiguration`
* All REST requests will reach to `DispatcherServlet`
* `DispatcherServlet` follows `Frontend controller` pattern
------
## Command Line Argument in Spring Boot
### Command Line Arguments Spring Boot 1.x while running with Maven plugin
* Pass argument using -Drun.arguments
```
mvn spring-boot:run -Drun.arguments=--appArgument=appArgumentValue
```
* Pass multiple arguments as comma separated
	* Arguments should be comma separated
	* Each argument should be prefixed with `--`
	* We can also pass configuration properties, like `spring.main.banner-mode`
```
mvn spring-boot:run -Drun.arguments=--spring.main.banner-mode=off,--appArgument=appArgumentValue
```
### Command Line Arguments Spring Boot 2.x while running with Maven plugin
* Pass the arguments using -Dspring-boot.run.arguments
```
mvn spring-boot:run -Dspring-boot.run.arguments=--spring.main.banner-mode=off,--appArgument=appArgumentValue
```
### Command Line Arguments while running with Maven plugin
* Add `bootRun` task in `build.gradle`
```
bootRun {
    if (project.hasProperty('args')) {
        args project.args.split(',')
    }
}
```
* Pass arguments
```
gradlew bootRun -Pargs=--spring.main.banner-mode=off,--appArgument=appArgumentValue
```
### We can overriding system properties like below by passing as command line arguments
```
server.port=9090
spring.application.name=student-service
```
* Spring Boot 1.x
```
mvn spring-boot:run -Drun.arguments=--server.port=9090
gradlew bootRun -Pargs=--server.port=9090
```
* Spring Boot 2.x
```
mvn spring-boot:run -Dspring-boot.run.arguments=--server.port=9090
gradlew bootRun -Pargs=--server.port=9090
```
------
### Short Command Line Arguments
* Spring Boot converts command-line arguments to properties and adds them as environment variables
* We can use short command-line arguments `–port=9090` instead of `–server.port=9090` by using a placeholder in our application.properties
```
server.port=${port:8080}
```
* Command-line arguments take precedence over application.properties values
### Stop our application from converting command-line arguments to properties
```
@SpringBootApplication
public class Application extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(Application.class);
        application.setAddCommandLineProperties(false);
        application.run(args);
    }
}
```
### Accessing Command Line Arguments
```
@SpringBootApplication
public class Application extends SpringBootServletInitializer {
    public static void main(String[] args) {
        for(String arg:args) {
            System.out.println(arg);
        }
        SpringApplication.run(Application.class, args);
    }
}
```
------
### Passing Command-Line Arguments to the SpringBootTest
* With the release of Spring Boot 2.2, we gained the possibility to inject command-line arguments during testing using @SpringBootTest and its args attribute
```
@SpringBootTest(args = "--spring.main.banner-mode=off")
public class ApplicationTest {
 
    @Test
    public void whenUsingSpringBootTestArgs_thenCommandLineArgSet(@Autowired Environment env) {
        Assertions.assertThat(env.getProperty("spring.main.banner-mode")).isEqualTo("off");
    }
}
```
------
# Spring Boot connecting to mysql using docker
* Launch MySQL using Docker
```
docker run --detach --env MYSQL_ROOT_PASSWORD=rootpassword1 --env MYSQL_USER=user1 --env MYSQL_PASSWORD=password1 --env MYSQL_DATABASE=mydb1 --name mysql --publish 3306:3306 mysql:8-oracle
```
* application.properties configuration
```
spring.jpa.hibernate.ddl-auto=update
spring.datasource.url=jdbc:mysql://localhost:3306/mydb1
spring.datasource.username=user1
spring.datasource.password=password1
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect

#user1@localhost:3306
```
* mysqlsh commands
```
mysqlsh
\connect user1@localhost:3306
\sql
use mydb1
select * from emp;
\quit
```
* Docker Commands
```
docker container ls
docker container stop ID
```
* Installation - https://dev.mysql.com/doc/mysql-shell/8.0/en/mysql-shell-install.html