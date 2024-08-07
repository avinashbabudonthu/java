### [<<Back](../README.md) | [Java V2 All Examples](https://github.com/avinashbabudonthu/java/blob/master/java-v2/README.md) | [Java All Examples](https://github.com/avinashbabudonthu/java/blob/master/README.md)
------
# Kafka commands
* Pre requisite - [setup Kafka using docker](setup-with-docker.md)
* Create topic
```
kafka-topics.bat --zookeeper localhost:2181 --create --topic [topic-name] --partitions 1 --replication-factor 1
```
* Create topic with log compact
```
kafka-topics.bat --zookeeper localhost:2181 --create --topic [topic-name] --partitions 1 --replication-factor 1 --config cleanup.policy=compact --config min.cleanable.dirty.ratio=0.005 --config segment.ms=10000
```
* Describe Topic
```
kafka-topics.bat --zookeeper localhost:2181 --describe --topic [Topic-Name]
```
* List topics
```
kafka-topics.bat --zookeeper localhost:2181 --list
```
* Delete Topic
```
kafka-run-class.bat --zookeeper localhost:2181 --delete --topic [topic-name] kafka.admin.TopicCommand
```
* Kafka producer to send message
```
kafka-console-producer.bat --broker-list localhost:9092 --topic [topic-name]
```
* Kafka consumer to receive message
```
kafka-console-consumer.bat --topic [topic-name] --zookeeper localhost:2181

kafka-console-consumer.bat --zookeeper localhost:2181 --topic [topic-name] --from-beginning --property print.key=true --property key.separator=,
```
* Read messages from beginning
```
kafka-console-consumer.bat --zookeeper localhost:2181 --topic [Topic-Name] --from-beginning
```

------
### [<<Back](../README.md) | [Java V2 All Examples](https://github.com/avinashbabudonthu/java/blob/master/java-v2/README.md) | [Java All Examples](https://github.com/avinashbabudonthu/java/blob/master/README.md)