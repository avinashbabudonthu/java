package com.java.component;

import org.apache.commons.lang3.StringUtils;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.KTable;
import org.apache.kafka.streams.kstream.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class WordCountComponent {

    private static final Serde<String> STRING_SERDE = Serdes.String();

    @Autowired
    public void process(StreamsBuilder streamsBuilder) {
        KStream<String, String> inputStream = streamsBuilder.stream("input-topic-1", Consumed.with(STRING_SERDE, STRING_SERDE));

        KTable<String, Long> wordCounts = inputStream
                .filter((key, value) -> StringUtils.isNotBlank(value))
                .mapValues(value -> value.toLowerCase())
                .flatMapValues(value -> List.of(value.split("\\s+")))
                .groupBy((key, value) -> value)
                .count(Named.as("word-count-store"));
        wordCounts.toStream().to("output-topic-1");
    }

}