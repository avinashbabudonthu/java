package com.kafka.streams;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.Serdes;
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

    private Properties kafkaProperties() {
        Properties properties = new Properties();
        // application.id
        properties.put(StreamsConfig.APPLICATION_ID_CONFIG, "word-count");
        // bootstrap.servers
//        properties.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        properties.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "kafka:9092");
        // default.key.serde
        properties.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass());
        // default.value.serde
        properties.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass());
        properties.put(StreamsConfig.STATE_DIR_CONFIG, "C:\\one-place\\practice\\kafka-streams");
        // auto.offset.reset
        properties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
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
