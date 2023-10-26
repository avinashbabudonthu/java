package com.java.processor;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

@Component
public class KafkaRouteComponent {

    public String kafkaMessage() {
        return "Hello World - " + UUID.randomUUID();
    }

    public List<String> kafkaMessageList() {
        return List.of("Hello World - " + UUID.randomUUID(),
                "Hello World - " + UUID.randomUUID(),
                "Hello World - " + UUID.randomUUID(),
                "Hello World - " + UUID.randomUUID(),
                "Hello World - " + UUID.randomUUID());
    }

}