package com.java.config;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.EnableKafkaStreams;
import org.springframework.kafka.annotation.KafkaStreamsDefaultConfiguration;
import org.springframework.kafka.config.KafkaStreamsConfiguration;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@Configuration
@EnableKafka
@EnableKafkaStreams
public class AppConfig {

//    @Value(value = "${spring.kafka.bootstrap-servers}")
//    private String bootstrapAddress;

    @Bean(name = KafkaStreamsDefaultConfiguration.DEFAULT_STREAMS_CONFIG_BEAN_NAME)
    public KafkaStreamsConfiguration kStreamsConfig() {
        /*Map<String, Object> props = new HashMap<>();
        props.put(StreamsConfig.APPLICATION_ID_CONFIG, "streams-app");
        props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
        props.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());
        props.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());*/

        // Properties properties = new Properties();
        Map<String, Object> properties = new HashMap<>();
        // application.id
        properties.put(StreamsConfig.APPLICATION_ID_CONFIG, "word-count");

        // bootstrap.servers
         properties.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:29092");
//        properties.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "kafka:9092");
        // default.key.serde
        properties.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass());
        // default.value.serde
        properties.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass());
        properties.put(StreamsConfig.STATE_DIR_CONFIG, "C:\\one-place\\practice\\kafka-streams");

        // processing.guarantee - exactly once
        // properties.put(StreamsConfig.PROCESSING_GUARANTEE_CONFIG, StreamsConfig.EXACTLY_ONCE);
        properties.put(StreamsConfig.PROCESSING_GUARANTEE_CONFIG, StreamsConfig.EXACTLY_ONCE_V2);

        // auto.offset.reset
        // earliest: automatically reset the offset to the earliest offset
        // latest: automatically reset the offset to the latest offset
        // none: throw exception to the consumer if no previous offset is found for the consumer's group
        properties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");

        // disable all cache to demonstrate all steps involved in transformation. not recommended in PROD
        // properties.put(StreamsConfig.CACHE_MAX_BYTES_BUFFERING_CONFIG, "0"); // deprecated
        properties.put(StreamsConfig.STATESTORE_CACHE_MAX_BYTES_CONFIG, "0");

        return new KafkaStreamsConfiguration(properties);
    }

}