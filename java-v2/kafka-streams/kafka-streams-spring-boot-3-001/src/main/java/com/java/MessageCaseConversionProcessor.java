package com.java;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Produced;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MessageCaseConversionProcessor {

    private static final Serde<String> STRING_SERDE = Serdes.String();
    private static final Serde<Long> LONG_SERDE = Serdes.Long();

    @Autowired
    public void process(StreamsBuilder streamsBuilder) {
        // build kafka stream
        KStream<String, String> inputStream = streamsBuilder.stream(Topics.INPUT_TOPIC_001, Consumed.with(STRING_SERDE, STRING_SERDE));

        // print each message key and value
        // convert to lower case
        KStream<String, String> resultStream = inputStream
                .peek((key, value) -> log.info("key={}, value={}", key, value))
                .mapValues(value -> {
                    String result = "unknown";
                    if(StringUtils.isNotBlank(value)) {
                        result = value.toLowerCase();
                    }
                    return result;
                });

        // send to output topic
        resultStream.to(Topics.OUTPUT_TOPIC_002, Produced.with(STRING_SERDE, STRING_SERDE));
    }
}
