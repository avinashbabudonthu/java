# Docker compose notes
* [Reference Documentation](https://docs.docker.com/compose/compose-file/)
* Want to deploy multiple containers then we use docker compose
* Docker compose is tool for defining and running multi-container Docker applications
* With Compose, we use `YAML` file to configure application services. Then with single command, we create and start all the services from YAML configuration
* composer starts and run entire app
```
docker-compose up -d
```
* Docker compose file name should be
	* docker-compose.yml (or) docker-compose.yaml
* We call each container as `services`. That's why we use `services` key work docker-compose yml file
* [Control startup and shutdown order in Compose](https://docs.docker.com/compose/startup-order/)
