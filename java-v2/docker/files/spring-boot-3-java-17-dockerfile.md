### [<<Back](../README.md) | [Java V2 All Examples](https://github.com/avinashbabudonthu/java/blob/master/java-v2/README.md) | [Java All Examples](https://github.com/avinashbabudonthu/java/blob/master/README.md)
------
* Dockerfile content to build spring boot 3 on java 17 base image
```
FROM openjdk:17
COPY target/[my-app].jar [my-app].jar
EXPOSE 9000
ENTRYPOINT ["java", "-jar", "[my-app].jar"]
```
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
------
### [<<Back](../README.md) | [Java V2 All Examples](https://github.com/avinashbabudonthu/java/blob/master/java-v2/README.md) | [Java All Examples](https://github.com/avinashbabudonthu/java/blob/master/README.md)