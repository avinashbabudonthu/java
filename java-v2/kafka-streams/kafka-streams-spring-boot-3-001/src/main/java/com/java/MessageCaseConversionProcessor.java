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
    public static final String INPUT_TOPIC_001 = "input-topic-001";
    public static final String OUTPUT_TOPIC_002 = "output-topic-002";

    @Autowired
    public void process(StreamsBuilder streamsBuilder) {
        KStream<String, String> inputStream = streamsBuilder.stream(INPUT_TOPIC_001, Consumed.with(STRING_SERDE, STRING_SERDE));
        KStream<String, String> resultStream = inputStream
                .peek((key, value) -> log.info("key={}, value={}", key, value))
                .mapValues(value -> {
                    String result = "unknown";
                    if(StringUtils.isNotBlank(value)) {
                        result = value.toLowerCase();
                    }
                    return result;
                });
        resultStream.to(OUTPUT_TOPIC_002, Produced.with(STRING_SERDE, STRING_SERDE));
    }
}
