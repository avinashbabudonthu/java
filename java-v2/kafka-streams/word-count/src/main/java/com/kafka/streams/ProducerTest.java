package com.kafka.streams;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;
import org.junit.jupiter.api.Test;

import java.util.Properties;
import java.util.Random;
import java.util.concurrent.Future;

@Slf4j
public class ProducerTest {

    @SneakyThrows
    @Test
    public void sendMessageWithoutKey() {
        final String topicName = "word-count-input";
        final Random random = new Random();

        Properties properties = new Properties();
        properties.put("bootstrap.servers", "localhost:29092");
        properties.put("key.serializer", StringSerializer.class.getName());
        properties.put("value.serializer", StringSerializer.class.getName());

        try (Producer<String, String> producer = new KafkaProducer<String, String>(properties)) {
            ProducerRecord<String, String> record1 = new ProducerRecord<>(topicName, "record1=" + random.nextLong());

            Future<RecordMetadata> record1ResultFuture = producer.send(record1);
            RecordMetadata record1RecordMetadata = record1ResultFuture.get();

            log.info("offset={}, ", record1RecordMetadata.offset());
            log.info("partition={}, serializedKeySize={}, serializedValueSize={}", record1RecordMetadata.partition(),
                    record1RecordMetadata.serializedKeySize(), record1RecordMetadata.serializedValueSize());
            log.info("timestamp={}, topic={}", record1RecordMetadata.timestamp(), record1RecordMetadata.topic());
        }
    }

    @SneakyThrows
    @Test
    public void sendMessageWithKey() {
        final String topicName = "word-count-input";
        final Random random = new Random();

        Properties properties = new Properties();
        properties.put("bootstrap.servers", "localhost:29092");
        properties.put("key.serializer", StringSerializer.class.getName());
        properties.put("value.serializer", StringSerializer.class.getName());

        try (Producer<String, String> producer = new KafkaProducer<String, String>(properties)) {
            ProducerRecord<String, String> record1 = new ProducerRecord<>(topicName, "key", "record1=" + random.nextLong());

            Future<RecordMetadata> record1ResultFuture = producer.send(record1);
            RecordMetadata record1RecordMetadata = record1ResultFuture.get();

            log.info("offset={}, ", record1RecordMetadata.offset());
            log.info("partition={}, serializedKeySize={}, serializedValueSize={}", record1RecordMetadata.partition(),
                    record1RecordMetadata.serializedKeySize(), record1RecordMetadata.serializedValueSize());
            log.info("timestamp={}, topic={}", record1RecordMetadata.timestamp(), record1RecordMetadata.topic());
        }
    }

}
