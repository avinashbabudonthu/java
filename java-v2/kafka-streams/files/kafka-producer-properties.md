### [<<Back](../README.md) | [Java V2 All Examples](https://github.com/avinashbabudonthu/java/blob/master/java-v2/README.md) | [Java All Examples](https://github.com/avinashbabudonthu/java/blob/master/README.md)
------
# Kafka producer properties
* Write below properties to connect Producer to kafka
```
import java.util.Properties;
import org.apache.kafka.clients.producer.ProducerConfig;

private Properties kafkaProducerProperties() {
	Properties properties = new Properties();

	properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:29092");
	properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
	properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
	properties.put(ProducerConfig.ACKS_CONFIG, "all");
	properties.put(ProducerConfig.RETRIES_CONFIG, "3");
	properties.put(ProducerConfig.LINGER_MS_CONFIG, "1");
	// ensure we don't push duplicates
	properties.put(ProducerConfig.ENABLE_IDEMPOTENCE_CONFIG, "true");

	return properties;
}
```
------
### [<<Back](../README.md) | [Java V2 All Examples](https://github.com/avinashbabudonthu/java/blob/master/java-v2/README.md) | [Java All Examples](https://github.com/avinashbabudonthu/java/blob/master/README.md)