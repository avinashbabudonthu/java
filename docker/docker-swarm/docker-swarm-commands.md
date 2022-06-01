# Docker Swarm Commands
* Start docker swarm and act as leader. This generates command for worker to join
```
docker swarm init --advertise-addr=[ip-address-of-master]
```
* List of docker nodes in docker swarm cluster
```
docker node ls
```
* Create service in docker swarm
```
docker service create --name [name-of-service] --replicas [number-of-replicas] -p 8083:8080 [image-name]
```
* Docker swarm services list
```
docker service ls
```
* Change number of replicas in docker swarm
```
docker service scale [service-name]=[new-number-of-replicas]
```
* Remove service from docker swarm
```
docker service rm [service-name]
```