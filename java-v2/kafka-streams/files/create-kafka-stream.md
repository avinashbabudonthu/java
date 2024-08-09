### [<<Back](../README.md) | [Java V2 All Examples](https://github.com/avinashbabudonthu/java/blob/master/java-v2/README.md) | [Java All Examples](https://github.com/avinashbabudonthu/java/blob/master/README.md)
------
# Create Kafka Stream
* Create kafka stream. Write business logic in between `StreamsBuilder.stream` and `kafkaStreams.start`
* Properties - [Properties to connect to Kafka from Java application](connect-to-kafka-from-java.md)
```
import java.util.Properties;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.KafkaStreams;

private void execute() {

	// get properties from above link
	Properties properties = new Properties();

	// create streams builder
	StreamsBuilder streamsBuilder = new StreamsBuilder();

	// stream from kafka topic word-count-input
	KStream<String, String> stream = streamsBuilder.stream("word-count-input");

	// business logic
	// ...
	// ...
	// ...

	// Start kafka streams application
	KafkaStreams kafkaStreams = new KafkaStreams(streamsBuilder.build(), properties);
	kafkaStreams.cleanUp(); // not recommended for PROD
	kafkaStreams.start();

	// print the topology
	System.out.println(kafkaStreams);

	// graceful shutdown of kafka streams application
	// Runtime.getRuntime().addShutdownHook(new Thread(kafkaStreams::close));

}
```
* Set custom serdes
* For `JsonSerializer`, `JsonDeserializer` add `kafka-connect` dependency. Refer [Kafka connect dependencies](../../kafka-connect/files/dependencies.md)
```
import org.apache.kafka.common.serialization.Serializer;
import com.fasterxml.jackson.databind.JsonNode;
import org.apache.kafka.connect.json.JsonSerializer;
import org.apache.kafka.common.serialization.Deserializer;
import org.apache.kafka.connect.json.JsonDeserializer;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.KStream;

final Serializer<JsonNode> jsonNodeSerializer = new JsonSerializer();
final Deserializer<JsonNode> jsonNodeDeserializer = new JsonDeserializer();
final Serde<JsonNode> jsonNodeSerde = Serdes.serdeFrom(jsonNodeSerializer, jsonNodeDeserializer);

StreamsBuilder streamsBuilder = new StreamsBuilder();
KStream<String, JsonNode> stream = streamsBuilder.stream("word-count-input", Consumed.with(Serdes.String(), jsonNodeSerde));

// business logic
// ...
// ...
// ...

// Start kafka streams application
KafkaStreams kafkaStreams = new KafkaStreams(streamsBuilder.build(), properties);
kafkaStreams.cleanUp(); // not recommended for PROD
kafkaStreams.start();

// print the topology
System.out.println(kafkaStreams);

// graceful shutdown of kafka streams application
// Runtime.getRuntime().addShutdownHook(new Thread(kafkaStreams::close));
```
------
### [<<Back](../README.md) | [Java V2 All Examples](https://github.com/avinashbabudonthu/java/blob/master/java-v2/README.md) | [Java All Examples](https://github.com/avinashbabudonthu/java/blob/master/README.md)