package com.kafka.streams;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.Deserializer;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.common.serialization.Serializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.apache.kafka.connect.json.JsonDeserializer;
import org.apache.kafka.connect.json.JsonSerializer;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.kstream.KGroupedStream;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.KTable;
import org.apache.kafka.streams.kstream.KeyValueMapper;
import org.apache.kafka.streams.kstream.Named;
import org.apache.kafka.streams.kstream.Produced;
import org.apache.kafka.streams.kstream.ValueMapper;

import java.util.List;
import java.util.Properties;

@Slf4j
public class WordCount {
    public static void main(String[] args) {
        new WordCount().execute();
    }

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



    private Properties kafkaProperties() {
        Properties properties = new Properties();
        // application.id
        properties.put(StreamsConfig.APPLICATION_ID_CONFIG, "word-count");

        // bootstrap.servers
        // properties.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        properties.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "kafka:9092");
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

        // json serde
        final Serializer<JsonNode> jsonNodeSerializer = new JsonSerializer();
        final Deserializer<JsonNode> jsonNodeDeserializer = new JsonDeserializer();
        final Serde<JsonNode> jsonNodeSerde = Serdes.serdeFrom(jsonNodeSerializer, jsonNodeDeserializer);

        StreamsBuilder streamsBuilder = new StreamsBuilder();
        KStream<String, JsonNode> stream = streamsBuilder.stream("bank-transactions");
        // KStream<String, JsonNode> stream = streamsBuilder.stream("bank-transactions", Consumed.with(Serdes.String(), jsonNodeSerde));

        return properties;
    }

    private void execute() {
        Properties properties = kafkaProperties();
        // log.info("{}", properties);

        StreamsBuilder streamsBuilder = new StreamsBuilder();

        // stream from kafka
        KStream<String, String> stream = streamsBuilder.stream("word-count-input");

        // map values to lower case
        KStream<String, String> valueToLowerCaseStream = stream.mapValues(new ValueMapper<String, String>() {
            @Override
            public String apply(String value) {
                return value.toLowerCase();
            }
        });

        // split each input by space
        KStream<String, String> separateBySpace = valueToLowerCaseStream.flatMapValues(new ValueMapper<String, Iterable<String>>() {
            @Override
            public Iterable<String> apply(String value) {
                return List.of(value.split(" "));
            }
        });

        // set each word as key
        KStream<String, String> selectKeyStream = separateBySpace.selectKey(new KeyValueMapper<String, String, String>() {

            @Override
            public String apply(String key, String value) {
                return value;
            }
        });

        // group streams by key
        KGroupedStream<String, String> groupByKeyStream = selectKeyStream.groupByKey();

        // convert KTable to KStream
        KTable<String, Long> wordCounts = groupByKeyStream.count(Named.as("Counts"));

        // write kafka streams to output topic
        wordCounts.toStream().to("word-count-output", Produced.with(Serdes.String(), Serdes.Long()));

        // Start kafka streams application
        KafkaStreams kafkaStreams = new KafkaStreams(streamsBuilder.build(), properties);
        kafkaStreams.cleanUp(); // not recommended for PROD
        kafkaStreams.start();

        // print the topology
        System.out.println(kafkaStreams);

        // graceful shutdown of kafka streams application
//        Runtime.getRuntime().addShutdownHook(new Thread(kafkaStreams::close));

    }
    private void execute2() {
        Properties properties = kafkaProperties();
        // log.info("{}", properties);

        StreamsBuilder streamsBuilder = new StreamsBuilder();

        // stream from kafka
        KStream<String, String> stream = streamsBuilder.stream("word-count-input");

        // map values to lower case
        KTable<String, Long> wordCounts = stream.mapValues(new ValueMapper<String, String>() {
            @Override
            public String apply(String value) {
                return value.toLowerCase();
            }
        }).flatMapValues(new ValueMapper<String, Iterable<String>>() {
            @Override
            public Iterable<String> apply(String value) {
                return List.of(value.split(" "));
            }
        }).selectKey(new KeyValueMapper<String, String, String>() {

            @Override
            public String apply(String key, String value) {
                return value;
            }
        }).groupByKey()
                .count();

        // write kafka streams to output topic
        wordCounts.toStream().to("word-count-output", Produced.with(Serdes.String(), Serdes.Long()));

        // Start kafka streams application
        KafkaStreams kafkaStreams = new KafkaStreams(streamsBuilder.build(), properties);
        kafkaStreams.start();

        // print the topology
        System.out.println(kafkaStreams);

        // graceful shutdown of kafka streams application
//        Runtime.getRuntime().addShutdownHook(new Thread(kafkaStreams::close));

    }

}
