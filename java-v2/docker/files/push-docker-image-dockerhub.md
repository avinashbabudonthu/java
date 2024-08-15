### [<<Back](../README.md) | [Java V2 All Examples](https://github.com/avinashbabudonthu/java/blob/master/java-v2/README.md) | [Java All Examples](https://github.com/avinashbabudonthu/java/blob/master/README.md)
------
# Build docker image and push to docker hub
* Write Dockerfile. Refer [Dockerfiles](../README.md#dockerfiles)
* We are using `openjdk java 17` base image
* Build image using below command
```
docker build . -t [image-name]
``` 
* Check created image. Should see an image with [image-name]
```
docker images
```
* Run the container in interactive mode and check
```
with port mapping
docker run -it -p 9000:9000 rest-api

without port mapping
docker run -it [image-name]

with network
docker run -it --network [network-name] [image-name]
```
* Application should be up and running
* Tag an image before pushing to docker hub
```
docker image tag [image-name] [dockerhub-username]/[image-name]
```
* Push image to docker hub
```
docker image push [dockerhub-username]/[image-name]
```
* Check dockerhub for pushed image
* Remove image from local
```
docker rmi [image-id]
```
* Pull image from dockerhub
```
docker pull [dockerhub-username]/[image-name]
```
* Run the container in interactive mode and check
```
with port mapping
docker run -it -p 9000:9000 rest-api

without port mapping
docker run -it [image-name]
```
------
### [<<Back](../README.md) | [Java V2 All Examples](https://github.com/avinashbabudonthu/java/blob/master/java-v2/README.md) | [Java All Examples](https://github.com/avinashbabudonthu/java/blob/master/README.md)