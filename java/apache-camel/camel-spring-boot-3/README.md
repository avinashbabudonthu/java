# Apache Camel Spring Boot 3 Hello World
* [pom.xml](pom.xml)
* Main class - [App.java](src/main/java/com/java/App.java)
* Controller class - [AppController.java](src/main/java/com/java/controller/AppController.java)
------
# Timer route calling Rest API
* Rest Route - Camel route to call rest end point - [RestRoute.java](src/main/java/com/java/route/RestRoute.java)
* `timer.period` in [RestRoute.java](src/main/java/com/java/route/RestRoute.java) is in [application.yml](src/main/resources/application.yml)
------
# Timer route
* Simple timer route - [TimerRoute.java](src/main/java/com/java/route/TimerRoute.java)
* Sample output
```
2023-08-07T10:36:24.888+05:30  INFO 16116 --- [           main] o.a.c.impl.engine.AbstractCamelContext   : Apache Camel 4.0.0-RC1 (camel-1) started in 296ms (build:0ms init:0ms start:296ms)
2023-08-07T10:36:24.896+05:30  INFO 16116 --- [           main] com.java.App                             : Started App in 4.81 seconds (process running for 5.649)
2023-08-07T10:36:25.889+05:30  INFO 16116 --- [ timer://route3] route3                                   : running route3
2023-08-07T10:36:25.892+05:30  INFO 16116 --- [ timer://route2] route2                                   : running route2
2023-08-07T10:36:26.043+05:30  INFO 16116 --- [nio-8080-exec-1] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring DispatcherServlet 'dispatcherServlet'
2023-08-07T10:36:26.044+05:30  INFO 16116 --- [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : Initializing Servlet 'dispatcherServlet'
2023-08-07T10:36:26.046+05:30  INFO 16116 --- [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : Completed initialization in 1 ms
2023-08-07T10:36:26.211+05:30  INFO 16116 --- [ timer://route1] route1                                   : Got pu9K5yg
2023-08-07T10:36:26.894+05:30  INFO 16116 --- [ timer://route1] route1                                   : Got TbgAj1z
2023-08-07T10:36:27.892+05:30  INFO 16116 --- [ timer://route1] route1                                   : Got p7zcSG
2023-08-07T10:36:27.893+05:30  INFO 16116 --- [ timer://route2] route2                                   : running route2
2023-08-07T10:36:28.886+05:30  INFO 16116 --- [ timer://route3] route3                                   : running route3
2023-08-07T10:36:28.890+05:30  INFO 16116 --- [ timer://route1] route1                                   : Got Fn6baeV
2023-08-07T10:36:29.894+05:30  INFO 16116 --- [ timer://route2] route2                                   : running route2
2023-08-07T10:36:29.895+05:30  INFO 16116 --- [ timer://route1] route1                                   : Got nqTPlgU
2023-08-07T10:36:30.895+05:30  INFO 16116 --- [ timer://route1] route1                                   : Got 6pHhls
2023-08-07T10:36:31.887+05:30  INFO 16116 --- [ timer://route3] route3                                   : running route3
2023-08-07T10:36:31.891+05:30  INFO 16116 --- [ timer://route1] route1                                   : Got rQCraKe
2023-08-07T10:36:31.894+05:30  INFO 16116 --- [ timer://route2] route2                                   : running route2
2023-08-07T10:36:32.893+05:30  INFO 16116 --- [ timer://route1] route1                                   : Got hpFtnM7
2023-08-07T10:36:33.896+05:30  INFO 16116 --- [ timer://route2] route2                                   : running route2
2023-08-07T10:36:33.897+05:30  INFO 16116 --- [ timer://route1] route1                                   : Got cqdZoZ
2023-08-07T10:36:34.887+05:30  INFO 16116 --- [ timer://route3] route3                                   : running route3
2023-08-07T10:36:34.892+05:30  INFO 16116 --- [ timer://route1] route1                                   : Got MGvKv1Xe
Disconnected from the target VM, address: '127.0.0.1:58703', transport: 'socket'
2023-08-07T10:36:35.356+05:30  INFO 16116 --- [ionShutdownHook] o.a.c.impl.engine.AbstractCamelContext   : Apache Camel 4.0.0-RC1 (camel-1) is shutting down (timeout:45s)
2023-08-07T10:36:35.361+05:30  INFO 16116 --- [ionShutdownHook] o.a.c.impl.engine.AbstractCamelContext   : Routes stopped (stopped:3)
2023-08-07T10:36:35.362+05:30  INFO 16116 --- [ionShutdownHook] o.a.c.impl.engine.AbstractCamelContext   :     Stopped route1 (timer://route1)
2023-08-07T10:36:35.362+05:30  INFO 16116 --- [ionShutdownHook] o.a.c.impl.engine.AbstractCamelContext   :     Stopped route3 (timer://route3)
2023-08-07T10:36:35.362+05:30  INFO 16116 --- [ionShutdownHook] o.a.c.impl.engine.AbstractCamelContext   :     Stopped route2 (timer://route2)
2023-08-07T10:36:35.366+05:30  INFO 16116 --- [ionShutdownHook] o.a.c.impl.engine.AbstractCamelContext   : Apache Camel 4.0.0-RC1 (camel-1) shutdown in 10ms (uptime:10s)

Process finished with exit code 130
```
------
# Stop Router
* Write route - [StopRoute.java](src/main/java/com/java/route/StopRoute.java)
* Processor to stop this route after 5 executions - [StopRouteProcessor.java](src/main/java/com/java/processor/StopRouteProcessor.java)
------
# Kafka Router
* Add dependency in pom or gradle file - [pom.xml](pom.xml)
```
<dependency>
    <groupId>org.apache.camel.springboot</groupId>
    <artifactId>camel-kafka-starter</artifactId>
</dependency>
```
* Add following properties in [application yaml or properties file](src/main/resources/application.yml)
```
camel:
  component:
    kafka:
      brokers: localhost:29092
      auto-offset-reset: earliest
  health.enabled: false
```
* [KafkaRouteComponent.java](src/main/java/com/java/processor/KafkaRouteComponent.java) used in route to build message
* Write route - [KafkaRoute.java](src/main/java/com/java/route/KafkaRoute.java)
* Property to enable/disable this route `app.kafka.route` - [application.yml](src/main/resources/application.yml)