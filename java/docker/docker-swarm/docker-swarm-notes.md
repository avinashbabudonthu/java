# Docker swarm notes
* Container Orchestration tool
* Used to monitor the health of the container. If any container goes down because of some reason,then docker swarm automatically repairs it by stopping the container and launching new container in the place of it. This automation is called container orchestration
* Docker swarm comes with package of docker
* Docker swarm is clustering and scheduling tool for Docker containers
* With docker swarm, we can establish and manage cluster of docker nodes as single virtual machine

# setup docker swarm with single node
```
docker swarm init
```

# Start mysql container using docker swarm
* Run container
```
docker service create -d --network my-network-1 --name my-sql-container-2 -e MYSQL_ROOT_PASSWORD=admin -e MYSQL_DATABASE=database1 -d mysql:5
```
* we might have got an error like below or similar to below. Because docker swarm works only with `overlay`. Does not work if we give `bridge` network. Above network `my-network-1` is `bridge` network
```
Error: No such network: my-network-1
```
* Create `overlay` network
```
docker network create --driver overlay my-overlay-network-1
```
* Execute above command again with `my-overlay-network-1` network
```
docker service create -d --network my-overlay-network-1 --name my-sql-container-2 -e MYSQL_ROOT_PASSWORD=admin -e MYSQL_DATABASE=database1 -d mysql:5
```
* See the services
```
docker service ls
```

# Create Add instances to docker swarm
* Open website
```
https://labs.play-with-docker.com/
```
* If `Login` does not respond then disable adblocker
* Create 2 instances
* initalize
```
docker swarm init --advertise-addr [address-suggested]
```