### [<<Back](../README.md) | [Java V2 All Examples](https://github.com/avinashbabudonthu/java/blob/master/java-v2/README.md) | [Java All Examples](https://github.com/avinashbabudonthu/java/blob/master/README.md)
------
# Docker Compose
* [Start Zookeeper and 1 Kafka broker and Kafka UI](files/docker-compose-kafka-1-broker.yml)
	* Run `docker-compose up -d` to start containers
	* Open Kafka UI - http://localhost:8080/
	* Run `docker-compose down` to stop and remove containers
* [Start Zookeeper and 2 Kafka brokers and Kafka UI](files/docker-compose-kafka-2-brokers.yml)
	* Run `docker-compose up -d` to start containers
	* Open Kafka UI - http://localhost:8080/
	* Run `docker-compose down` to stop and remove containers
* [Start Zookeeper and 2 Kafka brokers and Kafka UI with custom network](files/docker-compose-kafka-1-broker-with-network.yml)
	* Run `docker-compose up -d` to start containers
	* Open Kafka UI - http://localhost:8080/
	* Run `docker-compose down` to stop and remove containers
* [Run docker compose file passing file path and name using -f flag](files/custom-file-path-name.md)
* [Start containers connecting to existing external network](files/connect-to-existing-external-network.md)
------
# Reference and Materials
* https://docs.docker.com/compose/
* https://docs.docker.com/reference/cli/docker/compose/
------
### [<<Back](../README.md) | [Java V2 All Examples](https://github.com/avinashbabudonthu/java/blob/master/java-v2/README.md) | [Java All Examples](https://github.com/avinashbabudonthu/java/blob/master/README.md)