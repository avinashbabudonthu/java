### [<<Back](../README.md) | [Java V2 All Examples](https://github.com/avinashbabudonthu/java/blob/master/java-v2/README.md) | [Java All Examples](https://github.com/avinashbabudonthu/java/blob/master/README.md)
------
# Kafka producer code
* Refer [Properties for Kafka Producer to connect to kafka](../../kafka-streams/files/kafka-producer-properties.md)
* Send message to kafka without key
```
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.Future;

public void sendMessageWithoutKey() {
	final String topicName = "word-count-input";
	final Random random = new Random();

	// add properties from above link
	Properties properties = new Properties();

	try (Producer<String, String> producer = new KafkaProducer<String, String>(properties)) {
		ProducerRecord<String, String> record1 = new ProducerRecord<>(topicName, "record1=" + random.nextLong());

		Future<RecordMetadata> record1ResultFuture = producer.send(record1);
		RecordMetadata record1RecordMetadata = record1ResultFuture.get();

		log.info("offset={}, ", record1RecordMetadata.offset());
		log.info("partition={}, serializedKeySize={}, serializedValueSize={}", record1RecordMetadata.partition(),
				record1RecordMetadata.serializedKeySize(), record1RecordMetadata.serializedValueSize());
		log.info("timestamp={}, topic={}", record1RecordMetadata.timestamp(), record1RecordMetadata.topic());
	}
}
```
* Send message to kafka with key
```
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.Future;

public void sendMessageWithKey() {
	final String topicName = "word-count-input";
	final Random random = new Random();

	// add properties from above link
	Properties properties = new Properties();

	try (Producer<String, String> producer = new KafkaProducer<String, String>(properties)) {
		ProducerRecord<String, String> record1 = new ProducerRecord<>(topicName, "key", "record1=" + random.nextLong());

		Future<RecordMetadata> record1ResultFuture = producer.send(record1);
		RecordMetadata record1RecordMetadata = record1ResultFuture.get();

		log.info("offset={}, ", record1RecordMetadata.offset());
		log.info("partition={}, serializedKeySize={}, serializedValueSize={}", record1RecordMetadata.partition(),
				record1RecordMetadata.serializedKeySize(), record1RecordMetadata.serializedValueSize());
		log.info("timestamp={}, topic={}", record1RecordMetadata.timestamp(), record1RecordMetadata.topic());
	}
}
```
* [Source code](../kafka-example-001)
------
### [<<Back](../README.md) | [Java V2 All Examples](https://github.com/avinashbabudonthu/java/blob/master/java-v2/README.md) | [Java All Examples](https://github.com/avinashbabudonthu/java/blob/master/README.md)
