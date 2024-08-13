package com.java;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.kstream.KStream;

import java.util.Properties;

@SuppressWarnings("all")
@Slf4j
public class Example0002 {

    public static final String APP_ID = "word-count-001";
    public static final String BOOTSTRAP_SERVERS = "localhost:29092";
    public static final String STATE_DIR = "C:\\one-place\\kafka-streams\\data";
    public static final String INPUT_TOPIC_001 = "input-topic-001";
    public static final String OUTPUT_TOPIC_001 = "output-topic-001";

    public static void main(String[] args) {
        new Example0002().run();
    }

    private void run() {
        log.info("Kafka streams word count example");
        example2(kafkaProperties());
    }

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

        // processing.guarantee - exactly once
        // properties.put(StreamsConfig.PROCESSING_GUARANTEE_CONFIG, StreamsConfig.EXACTLY_ONCE);
        // properties.put(StreamsConfig.PROCESSING_GUARANTEE_CONFIG, StreamsConfig.EXACTLY_ONCE_V2);

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

    /**
     * Take from input topic - convert to lower case - send to output topic
     */
    private void example2(Properties properties) {
        StreamsBuilder builder = new StreamsBuilder();
        KStream<String, String> inputStream = builder.stream(INPUT_TOPIC_001);
        inputStream
                .peek(((key, value) -> log.info("key={}, value={}", key, value)))
                .mapValues(value -> {
                    String result = "unknown";
                    if (StringUtils.isNotBlank(value)) {
                        result = value.toLowerCase();
                    }
                    return result;
                }).to(OUTPUT_TOPIC_001);

        // never call this in try-with-source. If called then application will stop immediately without waiting
        KafkaStreams kafkaStreams = new KafkaStreams(builder.build(), properties);
        kafkaStreams.start();
    }

}