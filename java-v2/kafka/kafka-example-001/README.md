### [<<Back](../README.md) | [Java V2 All Examples](https://github.com/avinashbabudonthu/java/blob/master/java-v2/README.md) | [Java All Examples](https://github.com/avinashbabudonthu/java/blob/master/README.md)
------
* Check running containers
```
docker ps -a
```
* Run kafka using docker compose
```
docker-compose up -d
```
* Check running containers again. Should see containers - `zookeeper1`, `kafka1`, `kafkaUi1`
```
docker ps -a
```
* Wait 2 minutes. Login to kafka UI - http://localhost:8080
* Create topic `input-topic-1`
```
kafka-topics.bat --zookeeper localhost:22181 --create --topic [topic-name] --partitions 1 --replication-factor 1
```
* line
```
docker-compose down
```
* Check running containers
```
docker ps -a
```
------
### [<<Back](../README.md) | [Java V2 All Examples](https://github.com/avinashbabudonthu/java/blob/master/java-v2/README.md) | [Java All Examples](https://github.com/avinashbabudonthu/java/blob/master/README.md)