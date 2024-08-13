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
	properties.put(StreamsConfig.APPLICATION_ID_CONFIG, APP_ID);

	// bootstrap.servers
	properties.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVERS);

	// default.key.serde
	properties.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass());

	// default.value.serde
	properties.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass());

	// Directory location for state store.
	// This path must be unique for each streams instance sharing the same underlying filesystem.
	// Note that if not configured, then the default location will be different in each environment as
	// it is computed using System.getProperty("java.io.tmpdir")
	properties.put(StreamsConfig.STATE_DIR_CONFIG, STATE_DIR);

	// auto.offset.reset
	// earliest: automatically reset the offset to the earliest offset
	// latest: automatically reset the offset to the latest offset
	// none: throw exception to the consumer if no previous offset is found for the consumer's group
	properties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");

	// disable all cache to demonstrate all steps involved in transformation. not recommended in PROD
	// properties.put(StreamsConfig.CACHE_MAX_BYTES_BUFFERING_CONFIG, "0"); // deprecated
	properties.put(StreamsConfig.STATESTORE_CACHE_MAX_BYTES_CONFIG, "0");

	return properties;
}
```
------
### [<<Back](../README.md) | [Java V2 All Examples](https://github.com/avinashbabudonthu/java/blob/master/java-v2/README.md) | [Java All Examples](https://github.com/avinashbabudonthu/java/blob/master/README.md)