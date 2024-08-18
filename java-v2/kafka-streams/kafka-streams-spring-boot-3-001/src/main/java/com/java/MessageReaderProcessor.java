package com.java;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.Grouped;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.KTable;
import org.apache.kafka.streams.kstream.ValueMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Slf4j
@Component
public class MessageReaderProcessor {

    private static final Serde<String> STRING_SERDE = Serdes.String();
    public static final String INPUT_TOPIC_001 = "input-topic-001";
    public static final String OUTPUT_TOPIC_001 = "output-topic-001";

    @Autowired
    public void process(StreamsBuilder streamsBuilder) {
        /*KStream<String, String> messageStream = streamsBuilder
                .stream(INPUT_TOPIC_001, Consumed.with(STRING_SERDE, STRING_SERDE));

        KTable<String, Long> wordCounts = messageStream
                .mapValues((ValueMapper<String, String>) String::toLowerCase)
                .flatMapValues(value -> Arrays.asList(value.split("\\W+")))
                .groupBy((key, word) -> word, Grouped.with(STRING_SERDE, STRING_SERDE))
                .count();

        wordCounts.toStream().to(OUTPUT_TOPIC_001);*/

        // build Kafka stream
        KStream<String, String> inputStream = streamsBuilder.stream(INPUT_TOPIC_001, Consumed.with(STRING_SERDE, STRING_SERDE));

        // print message key nd value
        inputStream.peek((key, value) -> log.info("key={}, value={}", key, value));

        // send to output topi
        inputStream.to(OUTPUT_TOPIC_001);
    }

}