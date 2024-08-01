### [<<Back](../README.md) | [Java V2 All Examples](https://github.com/avinashbabudonthu/java/blob/master/java-v2/README.md) | [Java All Examples](https://github.com/avinashbabudonthu/java/blob/master/README.md)
------
* File - [Dockerfile-spring-boot-3-java-17](Dockerfile-spring-boot-3-java-17)
* We are using `openjdk java 17` base image
* Build image using below command
```
docker build . -t [my-app]
``` 
* Run and check the container
```
docker run -it -p [host-port]:[my-app-port] [my-app]
```
* Tag an image before pushing to docker hub
```
docker image tag [my-app] [docker-username]/[my-app]
```
* Push image to docker hub
```
docker image push [docker-username]/[my-app]
```
* Refer - Spring Boot 3 with Dockerfile example [here](../../spring-boot-3/rest-api#Build-docker-image-and-push-to-docker-hub)
------
### [<<Back](../README.md) | [Java V2 All Examples](https://github.com/avinashbabudonthu/java/blob/master/java-v2/README.md) | [Java All Examples](https://github.com/avinashbabudonthu/java/blob/master/README.md)