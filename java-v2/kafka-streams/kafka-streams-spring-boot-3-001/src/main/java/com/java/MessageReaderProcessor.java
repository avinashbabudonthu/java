package com.java;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MessageReaderProcessor {

    private static final Serde<String> STRING_SERDE = Serdes.String();

    @Autowired
    public void process(StreamsBuilder streamsBuilder) {
        // build Kafka stream
        KStream<String, String> inputStream = streamsBuilder.stream(Topics.INPUT_TOPIC_001, Consumed.with(STRING_SERDE, STRING_SERDE));

        // print message key nd value
        inputStream.peek((key, value) -> log.info("key={}, value={}", key, value));

        // send to output topi
        inputStream.to(Topics.OUTPUT_TOPIC_001);
    }

}