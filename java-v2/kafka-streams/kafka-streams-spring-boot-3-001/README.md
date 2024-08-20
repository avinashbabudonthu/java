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
* Create topics - `input-topic-001`, `output-topic-001`, `output-topic-002`, `output-topic-003`
  * Partitions - 3
  * Sync replicas - 3
* Run application main class - [Main](src/main/java/com/java/Main.java)
* Send message to topic `input-topic-001`
* Same message will be pushed to `output-topic-001`
  * Refer class - [MessageReaderProcessor](src/main/java/com/java/MessageReaderProcessor.java)
* Same message will be converted to lower case and pushed to `output-topic-002`
  * Refer class - [MessageCaseConversionProcessor](src/main/java/com/java/MessageCaseConversionProcessor.java)
* Take message from input topic `input-topic-001`, convert to lower case, do word count, send results to output topic `output-topic-003`
  * Refer class - [WordCountProcessor](src/main/java/com/java/WordCountProcessor.java)
* If you want to continuously send messages to input topic then run application - [kafka-example-001](../../kafka/kafka-example-001)
------
# Explanation
* Refer Kafka configuration - [KafkaConfig](src/main/java/com/java/KafkaConfig.java)
  * Properties injected in this class are in [application.properties](src/main/resources/application.properties)
* Take message from input topic `input-topic-001` and send same message to output topic `output-topic-001`
  * Refer class [MessageReaderProcessor](src/main/java/com/java/MessageReaderProcessor.java)
* Take message from input topic `input-topic-001`, convert to lower case, send to output topic `output-topic-002`
  * Refer class - [MessageCaseConversionProcessor](src/main/java/com/java/MessageCaseConversionProcessor.java)
* Take message from input topic `input-topic-001`, convert to lower case, do word count, send results to output topic `output-topic-003`
  * Refer class - [WordCountProcessor](src/main/java/com/java/WordCountProcessor.java)
------
# Run application as docker image
* Pre-requisite - Docker should be installed
* Download docker compose yaml file to start kafka - [docker-compose.yml](docker-compose-kafka.yml)
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
* Create topics - `input-topic-001`, `output-topic-001`, `output-topic-002`, `output-topic-003`
  * Partitions - 3
  * Sync replicas - 3
* Pull this application docker image
```
docker pull donthuavinashbabu/kafka-stream-spring-boot-3-001
```
* Start kafka streams container
```
docker run -it -p 9001:9000 --network my_network_1 donthuavinashbabu/kafka-stream-spring-boot-3-001
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
* Generates output to topics
  * Same message to `output-topic-001`
  * Lower case message to `output-topic-002`
  * Word counts to `output-topic-003`
* Stop and remove kafka containers
```
docker compose down
or
docker-compose down
```
* Check running containers
```
docker ps -a
```
------
# Run application as docker image using docker compose
* Pre-requisite - Docker should be installed
* Download docker compose yaml file to start kafka - [docker-compose.yml](docker-compose-kafka.yml)
* Open `cmd` in `docker-compose.yml` file location
* Start kafka
```
docker compose -f C:\github\java\java-v2\kafka-streams\kafka-streams-spring-boot-3-001\docker-compose-kafka.yml up -d
or
docker-compose -f C:\github\java\java-v2\kafka-streams\kafka-streams-spring-boot-3-001\docker-compose-kafka.yml up -d
```
* Check running containers
```
docker ps -a
```
* Should see containers `zookeeper1`, `kafka1`, `kafkaUi1`
* Wait 2 min. Open Kafka UI - http://localhost:8080
* Create topics - `input-topic-001`, `output-topic-001`, `output-topic-002`, `output-topic-003`
  * Partitions - 3
  * Sync replicas - 3
* Start producer and this application containers
```
docker compose -f C:\github\java\java-v2\kafka-streams\kafka-streams-spring-boot-3-001\docker-compose-app-containers.yml up -d
or
docker-compose -f C:\github\java\java-v2\kafka-streams\kafka-streams-spring-boot-3-001\docker-compose-app-containers.yml up -d
```
------
### [<<Back](../README.md) | [Java V2 All Examples](https://github.com/avinashbabudonthu/java/blob/master/java-v2/README.md) | [Java All Examples](https://github.com/avinashbabudonthu/java/blob/master/README.md)