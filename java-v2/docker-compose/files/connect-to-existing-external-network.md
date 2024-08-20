### [<<Back](../README.md) | [Java V2 All Examples](https://github.com/avinashbabudonthu/java/blob/master/java-v2/README.md) | [Java All Examples](https://github.com/avinashbabudonthu/java/blob/master/README.md)
------
# Start containers connecting to existing external network
* Give network name to container
```
  kafkaProducer:
    image: donthuavinashbabu/kafka-example-001
    container_name: kafkaProducer001
    depends_on:
      - kafkaStreamSpringBoot3
    networks:
      - my_network_1
```
* Define external network
```
networks:
  my_network_1:
    external: true
```
* Docker compose file to connect new containers to existing external network - [docker-compose-connect-to-existing-external-network.yml](docker-compose-connect-to-existing-external-network.yml)
------
### [<<Back](../README.md) | [Java V2 All Examples](https://github.com/avinashbabudonthu/java/blob/master/java-v2/README.md) | [Java All Examples](https://github.com/avinashbabudonthu/java/blob/master/README.md)