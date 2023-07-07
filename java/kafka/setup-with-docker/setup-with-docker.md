# Kafka setup with Docker
* Docker compose file [docker-compose.yml](docker-compose.yml)
* In this setup, our Zookeeper server is listening on port=2181 for the kafka service, which is defined within the same container setup. However, for any client running on the host, it'll be exposed on port 22181.
* Similarly, the kafka service is exposed to the host applications through port 29092, but it is actually advertised on port 9092 within the container environment configured by the KAFKA_ADVERTISED_LISTENERS property.
* Start Kafka Server. Open `cmd` where `docker-compose.yml` file is there. Start the Kafka server by spinning up the containers using the docker-compose command
```
$ docker-compose up -d
Creating network "kafka_default" with the default driver
Creating kafka_zookeeper_1 ... done
Creating kafka_kafka_1     ... done
```
* To connect to kafka ui tool like `Offset Explorer`
* Zookeeper url - `http://localhost:22181`
* Kafka broker url - `http://localhost:29092`
* Stop containers
```
docker-compose down
```
------
# Reference
* https://www.baeldung.com/ops/kafka-docker-setup