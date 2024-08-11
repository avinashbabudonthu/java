package com.java.producers;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;
import java.util.Random;
import java.util.concurrent.Future;

public class ProducersTest {

    public static void main(String[] args) {
        new ProducersTest().run();
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

    private void run() {
        Properties kafkaProperties = kafkaProducerProperties();
        final String topicName = "word-count-input";
        sendMessageWithoutKey(kafkaProperties, topicName);
    }

    private void sendMessageWithoutKey(Properties kafkaProperties, final String topicName) {
        final Random random = new Random();

        try (Producer<String, String> producer = new KafkaProducer<String, String>(kafkaProperties)) {
            ProducerRecord<String, String> record1 = new ProducerRecord<>(topicName, "record1=" + random.nextLong());

            Future<RecordMetadata> record1ResultFuture = producer.send(record1);
            RecordMetadata record1RecordMetadata = record1ResultFuture.get();

            log.info("offset={}, ", record1RecordMetadata.offset());
            log.info("partition={}, serializedKeySize={}, serializedValueSize={}", record1RecordMetadata.partition(),
                    record1RecordMetadata.serializedKeySize(), record1RecordMetadata.serializedValueSize());
            log.info("timestamp={}, topic={}", record1RecordMetadata.timestamp(), record1RecordMetadata.topic());
        }
    }


}
