### [<<Back](../README.md) | [Java V2 All Examples](https://github.com/avinashbabudonthu/java/blob/master/java-v2/README.md) | [Java All Examples](https://github.com/avinashbabudonthu/java/blob/master/README.md)
------
# Run application from IDE
* Pre-requisite - Docker should be installed
* Open `cmd` in project directory
* Start kafka
```
docker compose up -d
or
docker-compose up -d
```
* Check running containers
```
docker ps -a
```
* Should see containers `zookeeper1`, `kafka1`, `kafkaUi1`
* Wait 2 min. Open Kafka UI - http://localhost:8080
* Create topics - `input-topic-001`, `output-topic-001`, `output-topic-002`
  * Partitions - 3
  * Sync replicas - 3
* Run application main class - [Main](src/main/java/com/java/Main.java)
* Send message to topic `input-topic-001`
* Same message will be pushed to `output-topic-001`
  * Refer class - [MessageReaderProcessor](src/main/java/com/java/MessageReaderProcessor.java)
* Same message will be converted to lower case and pushed to `output-topic-002`
  * Refer class - [MessageCaseConversionProcessor](src/main/java/com/java/MessageCaseConversionProcessor.java)
* If you want to continuously send messages to input topic then run application - [kafka-example-001](../../kafka/kafka-example-001)
------
# Explanation
* Refer Kafka configuration - [KafkaConfig](src/main/java/com/java/KafkaConfig.java)
  * Properties injected in this class are in [application.properties](src/main/resources/application.properties)
* Take message from input topic `input-topic-001` and send same message to output topic `output-topic-001`
  * Refer class [MessageReaderProcessor](src/main/java/com/java/MessageReaderProcessor.java)
* Take message from input topic `input-topic-001` and send same message to output topic `output-topic-002`
  * Refer class - [MessageCaseConversionProcessor](src/main/java/com/java/MessageCaseConversionProcessor.java)
------
# Run application as docker image
* Pre-requisite - Docker should be installed
* Download docker compose yaml file to start kafka - [docker-compose.yml](docker-compose.yml)
* Open `cmd` in `docker-compose.yml` file location
* Start kafka
```
docker compose up -d
or
docker-compose up -d
```
* Check running containers
```
docker ps -a
```
* Should see containers `zookeeper1`, `kafka1`, `kafkaUi1`
* Wait 2 min. Open Kafka UI - http://localhost:8080
* Create topics - `input-topic-001`, `output-topic-001`, `output-topic-002`
  * Partitions - 3
  * Sync replicas - 3
* Pull this application docker image
```
docker pull donthuavinashbabu/kafka-streams-spring-boot-3-001
```
* Start kafka streams container
```
docker run -it -p 9001:9000 --network my_network_1 donthuavinashbabu/kafka-streams-spring-boot-3-001
```
* Pull kafka producer docker image
```
docker pull donthuavinashbabu/kafka-example-001
```
* Start kafka producer container
```
docker run -it --network my_network_1 donthuavinashbabu/kafka-example-001
```
* Producer sends messages to - `input-topic-001`
* Generates output to topics - `output-topic-001`, `output-topic-002`
------
### [<<Back](../README.md) | [Java V2 All Examples](https://github.com/avinashbabudonthu/java/blob/master/java-v2/README.md) | [Java All Examples](https://github.com/avinashbabudonthu/java/blob/master/README.md)