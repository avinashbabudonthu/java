### [<<Back](../README.md) | [Java V2 All Examples](https://github.com/avinashbabudonthu/java/blob/master/java-v2/README.md) | [Java All Examples](https://github.com/avinashbabudonthu/java/blob/master/README.md)
------
* Run nginx container
```
docker run nginx
```
* Run nginx container in detach mode
```
docker run -d nginx
```
* attach to container which is running in detach mode
```
docker attach [container-name/container-id]
```
* Check docker version
```
docker version
docker -v
docker --version
```
* Installed Docker information
```
docker info
```
* Docker installation path
```
where docker
```
* Information of docker container environment
```
docker-machine env
```
* Docker container IP. Does not work in windows
```
docker-machine ip
```
* get information above the container like ip address etc
```
docker inspect containerId
```
* To see docker images
```
docker images
docker image ls
docker image ls -a
docker image ls --all
```
* To see all docker containers both started and stopped
```
docker ps
docker ps -a
docker ps --all
docker container ls
docker container ls -a
docker container ls --all
```

* Start the container by running image
	* `-it` - Interactive terminal
		* If we give this option, when we press Ctrl+C container will stop without running docker stop again
	* `-p 9080:8080` - Does port mapping. 9080 == port number on the host system where container is running. 8080 == port number of application running in the container. We are mapping 8080 port of container to 9080 port on our system, so we can hit url with 9080
```
docker run -it -p 9080:8080 image-name
docker container run -it -p 9080:8080 image-name
```
* Build docker image using Dockerfile. Run from directory where Dockerfile is present
```
docker build . -t [image-name]
```
* Give name to docker container while starting the container
	* `--name` : to give a name to container
	* `-p` : to map host system port to application port in container
	* `-d` : run the container in the background as deamon
```
docker run -d --name applicationName -p 8080:8000 imageName
```
* Stop docker container
```
docker stop [container-id]
docker container stop [container-id]
```
* Start docker container
```
docker start [container-id]
docker container start [container-id]
```
* Run nginx using docker
```
docker run -p 80:80 nginx
```
* Pull image from docker central repository - docker hub. check for Tags in docker hub for versions
```
docker pull image-name
Ex: docker pull ubuntu

docker image pull tomcat:latest

docker image pull tomcat:9.0
```
* Run the container in detach mode. Means run the container in the background
```
-d
```
* Passing environment variables while running container
```
-e
```
* Logging into and accessing the container
```
docker exec -it [container-id] bash
docker container exec -it [container-id] bash
```
* Exit the container accessed using command `docker exec`
```
exit
```
* Kill docker container
```
docker kill [container-id]
```
* To remove a stopped container from system
```
docker rm [container-id]
docker rm containerId1 containerId2
```
* To remove image from system
```
docker rmi repositotyName
docker rmi repositotyName1 repositotyName2
docker rmi [image-name]
docker rmi ImageId1 imageId2
```
* To remove a running container from system
```
docker rm -f [container-id]
```
* Remove all stopped containers
```
docker container prune
```
* Remove all `containers` running or stopped present in the system
```
docker rm -f $(docker ps -a -q)
docker rm -f $(docker ps -aq)
```
* Remove all `containers` including its `volumes`
```
docker rm -vf $(docker ps -aq)
```
* Save container changes. New image is created which can be seen under 'docker images' with the same name passed in the command
```
docker commit [container-id] [name-for-new-image]
```
* Login to docker hub from cmd. Enter username and password
```
docker login
```
* Push local docker image to docker hub
```
docker push [image-name]
```
* Bind mount C:/docker/dockerfile from local system to /app folder in container
```
docker run -it -v C:/docker/dockerfile:/app -d image-name
```
* Create docker volume
```
docker volume create [volume-name]
```
* To use the volume while running the container
```
docker run -it --mount source=[name-of-volume],target=[path-to-directory-in-container] -d [image-name]
```
* List docker volumes
```
docker volume ls
```
* Copy files to container
```
docker cp [file-path/file-name] [container-id:/path-in-side-container]
```
* Run docker commands in linux machine without running sudo every time. Re login to session after running this command
```
sudo usermod -aG docker $USER
```
* Check logs of container
```
docker logs [container id/name]
docker container logs [container id/name]
```
* Monitor the logs
```
docker logs -f [container id/name]
docker container logs -f [container id/name]
```

* search docker hub from command line
```
docker help search
```
* search for docs
```
docker search docs
```
* create container from image
```
docker create
```
* Build docker image
```
docker build . -t docker-image-with-docker-file
```
* Tag an image before pushing to docker hub
```
docker image tag [image-id] [docker-id]/[image-name]
```
* Push image to docker hub. Image name should start with dockerhub-id
```
docker image push [image-name]
docker image push avinashbabudonthu/docker-image-with-docker-file
```
* Remove container when container is stopped. Use `--rm` argument
```
docker container run --network my-network-1 --name my-sql-container-1 --rm -e MYSQL_ROOT_PASSWORD=admin -e MYSQL_DATABASE=database1 -d mysql:5
```
* Inspect docker container. We will get container configuration
```
docker container inpsect [container-id]
```
* Create bridge network
```
docker network create [network-name]
docker network create my-network-1
```
* Create overlay network
```
docker network create --driver overlay my-overlay-network-1
```
* Check networks we have in docker installation. We should see `my-network-1` created above
```
docker network ls
```
* remove network
```
docke network rm my-network-1
```
* List all volumes
```
docker volume ls
```
* Delete all volumes currently in use
```
docker volume prune
```
* Remove all images
```
docker image prune --all --force

docker rmi -f $(docker images -aq)
```
* Pull redis image with 4.0 tag
```
docker run redis:4.0

4.0 - tag

default tag is latest
```
* -i - interactive mode
* -t - interact with terminal
* -p - port mapping
```
host-port:container-port
```
* volume mapping. Map directory outside container that is docker host to directory inside the container
```
docker run -v //C:/folder-1:/var/container/folder-1
```
* inspect: Gives container details like mount, stage, configs, networks etc
```
docker inspect [container-id/container-name]
```
* container logs
```
docker logs [container-id/container-name]
```
* Pull & Run jenkins container latest tag
```
docker run jenkins/jenkins
```
------
### [<<Back](../README.md) | [Java V2 All Examples](https://github.com/avinashbabudonthu/java/blob/master/java-v2/README.md) | [Java All Examples](https://github.com/avinashbabudonthu/java/blob/master/README.md)