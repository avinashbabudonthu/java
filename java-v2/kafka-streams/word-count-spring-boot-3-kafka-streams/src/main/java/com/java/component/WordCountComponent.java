package com.java.component;

import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.stereotype.Component;

@Component
public class WordCountComponent {

    public void process(StreamsBuilder streamsBuilder) {
        KStream<String, String> inputStream = streamsBuilder.stream("input-topic-1");

        inputStream
                .filter((key, value) -> )
                .mapValues(value -> )

    }

}