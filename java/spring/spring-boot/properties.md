# Spring Boot Properties
* Do not convert dates to timestamp while creating JSON using Jackson
```
spring.jackson.serialization.write-dates-as-timestamp=false
```
* Allow cors
```
web.cors.allowed-origins: ${cors_allowed_origins:http://localhost:4200}
```