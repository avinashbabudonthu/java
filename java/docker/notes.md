# Docker Notes

# docker container life cycle
![picture alt](images/doker-containter-life-cycle.jpg "Docker Container Life Cycle")

# 15 usefeul docker commands
![picture alt](images/docker-commands.jpg "15 useful docker commands")

# Docker Notes
* docker image
	* packaged software like war, jar etc
	* Software we run with in a container
	* Image will be build in layers
	* We will have base image then we will add our software and create a new image
* container
	* Stripped to basic version of linux operating system. It is run time environment for our images
	* the movement we run the image with docker engine, It will become container
	* Instead of installing hypervisor and virtual machine and OS in virtual machine, we install one operating system. one top of one operating system, create n no.of containers. Each container is slice of operating system. Inside these containers we run our apps. One-to-one mapping. Means one app per container
* Dockerfile - Name should be same. No extensions
	* Dockerfile is a text document that contains all the commands a user could call on the command line to create an image
	* Using docker build user can create automated build that executes several command line instructions in sequence present in Dockerfile
	* Dockerfile present in root directory of project
	* Simple powershell or shell script to install software, build the image
```
docker build . -t [image-name]
```
* Docker volume
	* docker volume is used to persist the data across the life time of a container
	* Way to map host file system to container so any files accessed by container won't be lost even container went down
	* Start mysql docker container with volume location (windows) specified. On running below command, docker will give warning like `Share drive` with `Share It` and `Cancel` options. Click `Share It`
```
docker container run -v //c/mysql/volume1:/var/lib/mysql --network my-network-1 --name my-sql-container-1 -e MYSQL_ROOT_PASSWORD=admin -e MYSQL_DATABASE=database1 -d mysql:5
```
* Bind mount vs docker volume
	* `bind mount`: mount particual file location inside the container. For example we want to mount `dockerfile` folder in local system to `/app` directory in container then use this command `docker run -it -v C:/docker/dockerfile:/app -d image-name`
	* Files from `dockerfile` directory won't be copied into container but container directory will be mirrored. For Bind mount to work the container on which it is build and docker run should be same. Because we will have issue with path for example between linux and windows paths
	* docker volume
		* docker engine will automatically identifies where this volume has to exist. We don't need to specify the paths
* Whenever we want to push our image to docker hub account. Then docker image name should be
	* `username/user-defined-image-name`
* Start the container by running image
	* `-it` - Interactive terminal
	* `-p 9080:8080`
		* Does port mapping
		* 9080 == port number on the host system where container is running
		* 8080 == port number of application running in the container
		* We are mapping 8080 port of container to 9080 port on our system, so we can hit url with 9080
```
docker run -it -p 9080:8080 image-name
```
* Docker Hub
	* public docker registry, a place where we can strore and retrieve docker images
* Open container initiative (OCI)
	* responsible for standards around basic and fundamental components of a container eco system, the container format and the container run time
	* If every one starts writing their own standards for container like core OS, it will be difficult to maintain container technology. So OCI formed to maintain standards for containers
* Some tools build around container technology
	* Orchestration tools
	* Clustering tools
	* Management tools
	* Monitoring and logging tools
* can containers used for statefull apps or they only for stateless apps?
	* container can handle both. But containers excel in handling stateless
* Container registries
	* place where we store and retrieve images.
* Some container registries
	* Docker Hub by Docker Inc.
	* Quay by Core OS
	* Google Container registry by Google
	* Amazon EC2 container registry by Amazon
* Private registries to run with in corporate firewall
	* Docker trusted registry (DTR)
	* Quay Enterprise
* Flow of using containers
	* Write application -> push to SCM like github, bitbucket > Testing > Push to container registry which builds and creates updated container image > We can deploy image to any where like private cloud, AWS etc
	* All above steps can be automated
* On Premises docker products
	* Tools for build
		* Docker Engine
		* Docker Swarm
	* Tools for shipping
		* Docker trusted registry
	* Tools to run images
		* Docker universal control plane
* On cloud docker products
	* Tools for Build
		* Docker Engine
		* Docker Swarm - For docker clustering
		* Docker Content Trust - verifies the pusblisher and content of image
	* Tools for shipping images
		* Docker Hub
	* Tools to run images
		* Tutum - for deploying and managing apps in the cloud. Can be used to deploy app in AWS, Azure etc in multiple cloud platforms
* Container orchestration
	* Container apps spawning acorss multiple containers and hosts
	* Orchestration tool takes care of which containers should go into which hosts etc
* Docker Orchestration products
	* Docker machine
	* Docker compose - define and compose multi container apps
	* Docker swarm - scheduling container across estate of docker hosts
	* Docker Tutum - UI lets us control and manage everything
* Other orchestration products
	* Kubernetes by Google
	* Mesosphere Datacenter OS
	* CoreOS Fleet, etcd
	* Openstack Magnum
	* Cloudify
* [Let’s make your Docker Image better than 90% of existing ones](https://medium.com/@chamilad/lets-make-your-docker-image-better-than-90-of-existing-ones-8b1e5de950d)
* [Docker Image Size Concerns Out of the Window — Squash with Confidence](https://medium.com/@chamilad/docker-image-size-concerns-out-of-the-window-squash-with-confidence-796f7c48f5c6)

# Dockerfile notes
* [Docker documentation](https://docs.docker.com/engine/reference/builder/)
* Name should be always `Dockerfile`
* FROM
	* First line of dockerfile is always FROM
	* The FROM keyword is used to define the base image, on which we will be building
* ADD
	* The ADD keyword is used to add files to the container being built
```
ADD [source] [destination in container]
```
* RUN
	* The RUN command is used to add layers to the base image by installing component. Whenever we want to run any commands in the container
	* `-y` in the image will not prompt for yes/no while running command
```
RUN apt-get -y install apache2
```
* CMD
	* The CMD keyword is used to run commands on the start of the container. These commands run only when there is no argument specified while running the container
* ENTRYPOINT
	* Used to strictly run commands the moment the container initializes
	* The difference between CMD and ENTRYPOINT is, ENTRYPOINT will run irrespective whether argument is specified or not while running the container
```
ENTRYPOINT ["java", "-jar", "test-app.jar"]
```
* ENV
	* Is used to set environment variables in side the container
```
ENV [name-of-variable] [value-of-variable]
```
* WORKDIR
	* To give base directory for container. Any future commands we run after setting WORKDIR will work relative to this directory
	* Below command will copy `test-app.jar` to `/usr/local/` location
```
WORKDIR /usr/local/
COPY tes-app.jar .
```
* MAINTAINER
	* Set `Author` filed of the generate image
	* This is deprecated
	* Use `LABEL`
```
MAINTAINER Donthu Avinash Babu "avinashbabu.donthu@gmail.com"
```
* Labels
```
LABEL maintainer="avinashbabu.donthu@gmail.com"
LABEL creationdate="18 September 2021"
```
* VOLUME - data of container will store in host computed specified path
```
VOLUME C:/var/lib/mysql
```
* List all volumes
```
docker volume ls
```
* Delete all volumes currently in use
```
docker volume prune
```

# Push docker image to docker hub
* Login to docker from local. Enter credentials when prompted
```
docker login
```
* build docker image
```
docker build . -t docker-image-with-docker-file
```
* Give image tag name
```
docker image tag [image-id] [docker-id]/[image-name]
docker image tag 734c5b36a4d6 avinashbabudonthu/docker-image-with-docker-file
```
* Push image to docker hub. Image name should start with dockerhub-id
```
docker image push [image-name]
docker image push avinashbabudonthu/docker-image-with-docker-file
```

# Networking
* One container should contain only one service. Means only one `CMD` command
* So we will have multiple containers
* For inter communication between containers we need to have `Network of containers`
* Check networks we have in docker installation
```
docker network ls
```
* Sees output like this
```
NETWORK ID          NAME                    DRIVER              SCOPE
d8bcb193a37a        bridge                  bridge              local
a8a5934f6dec        host                    host                local
a97b4df20f8b        none                    null                local
```
* `bridge` network used for container to internet connection
* For container to container to communication we need to create our own network and add it to our network list
* Create network
```
docker network create [network-name]
docker network create my-network-1
```
* Check networks we have in docker installation. We should see `my-network-1` created above
```
docker network ls
```
* Add container to network while running. `--name` is very important while running container because all communication works with container name. Here are adding mysql container to our network
```
docker container run --network my-network-1 --name my-sql-container-1 -e MYSQL_ROOT_PASSWORD=admin -e MYSQL_DATABASE=database1 -d mysql:5
```
* Create one more container
```
docker container run --network my-network-1 --name my-sql-container-2 -e MYSQL_ROOT_PASSWORD=admin -e MYSQL_DATABASE=database1 -d mysql:5
```
* Login to `my-sql-container-1` container and ping container `my-sql-container-2`
```
docker container exec -it my-sql-container-1 bash
```
* Ping `google.com`
```
ping google.com
```
* If `ping` not found execute following command
```
apt-get update
apt-get install iputils-ping
```
* ping `my-sql-container-2`
```
ping my-sql-container-2
```
* We should see output below
```
64 bytes from my-sql-container-2.my-network-1 (172.19.0.3): icmp_seq=1 ttl=64 time=0.159 ms
64 bytes from my-sql-container-2.my-network-1 (172.19.0.3): icmp_seq=2 ttl=64 time=0.116 ms
64 bytes from my-sql-container-2.my-network-1 (172.19.0.3): icmp_seq=3 ttl=64 time=0.066 ms
64 bytes from my-sql-container-2.my-network-1 (172.19.0.3): icmp_seq=4 ttl=64 time=0.115 ms
64 bytes from my-sql-container-2.my-network-1 (172.19.0.3): icmp_seq=5 ttl=64 time=0.115 ms
64 bytes from my-sql-container-2.my-network-1 (172.19.0.3): icmp_seq=6 ttl=64 time=0.114 ms
64 bytes from my-sql-container-2.my-network-1 (172.19.0.3): icmp_seq=7 ttl=64 time=0.123 ms
```
* remove network
```
docke network rm my-network-1
```

# Fabric8 Docker maven plugin
* [Documentation](https://dmp.fabric8.io/)
	* dmp - docker maven plugin
* Refer [plugin.txt](../fabric8-maven-plugin)
	* plugin.txt
	* settings.xml
* move `Dockerfile` to `src/main/docker` folder
* Change `Dockerfile` script to below
```
COPY maven/hello-world.jar hello-world.jar
```
* Run below maven commands
```
mvn clean package docker:build
```
* If we want to integrate `docker:build` as part of `mvn package` add following section to `fabric8` plugin. Refer [fabric8-maven-plugin](../fabric8-maven-plugin)
```
<executions>
	<execution>
		<phase>package</phase>
		<goals>
			<goal>docker:build</goal>
		</goals>
	</execution>
</executions>
```
* Push docker image to docker hub. For this we need to give credentials in `fabric8` plugin in `pom.xml`
```
mvn clean package docker:push
```
* But keeping credentials in pom.xml is not preferable. so we can remove from pom.xml and keep in `settings.xml`
	* Refer [settings.xml](../fabric8-maven-plugin)
------
# How do I add myself to the docker users group on Windows
* Run this command from an administrator command window to add your user id to the docker-users group and log back into your user account for it to take effect
```
net localgroup docker-users "your-user-id" /ADD
```
* `your-user-id` is your local Windows user name. You can determine this by looking at the folder name under `C:\Users\`