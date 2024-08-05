### [<<Back](../README.md) | [Java V2 All Examples](https://github.com/avinashbabudonthu/java/blob/master/java-v2/README.md) | [Java All Examples](https://github.com/avinashbabudonthu/java/blob/master/README.md)
------
# Connect to kafka from java application
* Set these properties to connect to kafka from java application
```
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsConfig;
import java.util.Properties;

private Properties kafkaProperties() {
	Properties properties = new Properties();
	// application.id
	properties.put(StreamsConfig.APPLICATION_ID_CONFIG, "word-count");
	// bootstrap.servers
	properties.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:29092");
	// default.key.serde
	properties.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass());
	// default.value.serde
	properties.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass());
	properties.put(StreamsConfig.STATE_DIR_CONFIG, "C:\\one-place\\practice\\kafka-streams");
	// auto.offset.reset
	properties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
	return properties;
}
```
------
### [<<Back](../README.md) | [Java V2 All Examples](https://github.com/avinashbabudonthu/java/blob/master/java-v2/README.md) | [Java All Examples](https://github.com/avinashbabudonthu/java/blob/master/README.md)