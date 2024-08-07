package com.kafka.streams;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.KTable;
import org.apache.kafka.streams.kstream.Named;
import org.apache.kafka.streams.kstream.Produced;

import java.util.Arrays;
import java.util.Properties;

/**
 * Input Data:
 * ana,blue
 * john,red
 * jim,yellow
 * ana, red
 * <p>
 * Topology and operations
 * <p>
 * 1. Read on topic from kafka
 * 2. Filter bad values
 * 3. SelectKey that will be user id
 * 4. MapValue to extract color as value (as lowercase)
 * 5. Filter to remove bad colors
 * 6. Write to kafka intermediary topic
 * 7. Read from kafka as KTable
 * 8. GroupBy colour
 * 9. Count to count color occurrences
 * 10. Write to kafka final topic
 */
public class FavouriteColour {

    public static void main(String[] args) {
        new FavouriteColour().execute();
    }

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
        // state.dir
        properties.put(StreamsConfig.STATE_DIR_CONFIG, "C:\\one-place\\practice\\kafka-streams");
        // auto.offset.reset
        properties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        return properties;
    }

    private void execute() {
        Properties properties = kafkaProperties();
        StreamsBuilder streamsBuilder = new StreamsBuilder();

        // 1. Read on topic from kafka
        KStream<String, String> stream = streamsBuilder.stream("favourite-color-input");

        // operations
        KStream<String, String> userIdAndColor = stream
                // 2. Filter bad values
                .filter((key, value) -> value.contains(","))
                // 3. SelectKey that will be user id
                .selectKey((key, value) -> value.split(",")[0].toLowerCase())
                // 4. MapValue to extract color as value (as lowercase)
                .mapValues(value -> value.split(",")[1].toLowerCase())
                // 5. Filter to remove bad colors
                .filter((user, color) -> Arrays.asList("green", "blue", "red").contains(color));

        // 6. Write to kafka intermediary topic
        userIdAndColor.to("user-keys-and-color");

        // 7. Read from kafka as KTable
        KTable<String, String> userIdAndColorTable = streamsBuilder.table("user-keys-and-color");

        KTable<String, Long> favoriteColor = userIdAndColorTable
                // 8. GroupBy colour
                .groupBy((user, color) -> new KeyValue<>(color, color))
                // 9. Count to count color occurrences
                .count(Named.as("CountByColor"));

        // 10. Write to kafka final topic
        favoriteColor.toStream().to("favourite-color-output", Produced.with(Serdes.String(), Serdes.Long()));

        // start kafka
        try (KafkaStreams kafkaStreams = new KafkaStreams(streamsBuilder.build(), properties)) {
            // only do this in dev. not in prod
            kafkaStreams.cleanUp();
            kafkaStreams.start();
        }
    }
}
