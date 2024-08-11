### [<<Back](../README.md) | [Java V2 All Examples](https://github.com/avinashbabudonthu/java/blob/master/java-v2/README.md) | [Java All Examples](https://github.com/avinashbabudonthu/java/blob/master/README.md)
------
# MySQL
* [Run MySQL using docker](files/using-docker.md)
* Java application connection URL
```
jdbc:mysql://DATABASE_HOST:DATABASE_PORT/DATABASE_NAME
jdbc:mysql://localhost:3306/db1
```
* Spring boot application properties to connect to mysql database
```
spring.datasource.url=jdbc:mysql://${DATABASE_HOST:localhost}:${DATABASE_PORT:3307}/${DATABASE_NAME:db1}
spring.datasource.username=${DATABASE_USERNAME:root}
spring.datasource.password=${DATABASE_PASSWORD:root}
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.show-sql=${JPA_SHOW_SQL:true}
#This is actually a shortcut for the "hibernate.hbm2ddl.auto" property. Default to "create-drop" when using an embedded database, "none" otherwise
spring.jpa.hibernate.ddl-auto=none
spring.jpa.database-platform=org.hibernate.dialect.MySQL5Dialect
spring.jpa.properties.hibernate.format_sql=${HIBERNATE_FORMAT_SQL:true}
```
------
### [<<Back](../README.md) | [Java V2 All Examples](https://github.com/avinashbabudonthu/java/blob/master/java-v2/README.md) | [Java All Examples](https://github.com/avinashbabudonthu/java/blob/master/README.md)