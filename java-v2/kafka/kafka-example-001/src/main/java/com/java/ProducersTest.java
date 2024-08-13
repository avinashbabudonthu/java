package com.java;

import com.github.javafaker.Faker;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.List;
import java.util.Properties;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@Slf4j
public class ProducersTest {

    public static final Faker FAKER = Faker.instance();
    public static final String INPUT_TOPIC_001 = "input-topic-001";
    public static final String BOOTSTRAP_SERVERS = "localhost:29092";
    public static final String ACKNOWLEDGE_ALL = "all";
    public static final String RETRY_COUNT = "3";

    public static void main(String[] args) {
        new ProducersTest().run();
    }

    private void run() {
        // sendMessageWithoutKey(kafkaProducerProperties(), INPUT_TOPIC_001);
        sendMessageWithKey(kafkaProducerProperties(), INPUT_TOPIC_001);
    }

    private Properties kafkaProducerProperties() {
        Properties properties = new Properties();

        // if you start kafka using docker-compose.yml in this repo than
        // kafka is running in localhost:29092 else update correct broker details
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVERS);
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.put(ProducerConfig.ACKS_CONFIG, ACKNOWLEDGE_ALL);
        properties.put(ProducerConfig.RETRIES_CONFIG, RETRY_COUNT);

        // The producer groups together any records that arrive in between request transmissions into a single batched request.
        // Normally this occurs only under load when records arrive faster than they can be sent out.
        // However in some circumstances the client may want to reduce the number of requests even under moderate load
        properties.put(ProducerConfig.LINGER_MS_CONFIG, "1");

        // ensure we don't push duplicates
        properties.put(ProducerConfig.ENABLE_IDEMPOTENCE_CONFIG, "true");

        return properties;
    }

    private void sendMessageWithoutKey(Properties kafkaProperties, final String topicName) {
        for (int i = 1; i <= 100; i++) {
            log.info("loop {} started", i);
            String message = FAKER.harryPotter().character();
            log.info("Sending message={}", message);

            // send String message every 10 seconds
            try (Producer<String, String> producer = new KafkaProducer<String, String>(kafkaProperties)) {
                // create ProducerRecord to send message
                ProducerRecord<String, String> producerRecord = new ProducerRecord<>(topicName, message);
                // send message
                Future<RecordMetadata> future = producer.send(producerRecord);

                log.info("Sent message={}", message);

                log.info("Getting response");
                // wait for result. Not recommended in PROD
                RecordMetadata recordMetadata = future.get();

                // print log
                String topic = recordMetadata.topic();
                long offset = recordMetadata.offset();
                int partition = recordMetadata.partition();
                int serializedKeySize = recordMetadata.serializedKeySize();
                int serializedValueSize = recordMetadata.serializedValueSize();
                long timestamp = recordMetadata.timestamp();

                log.info("topic={}, offset={}, partition={}, serializedKeySize={}, serializedValueSize={}, timestamp={}",
                        topic, offset, partition, serializedKeySize, serializedValueSize, timestamp);
                log.info("loop {} completed", i);
            } catch (ExecutionException | InterruptedException e) {
                log.info("Exception in sending message", e);
            } finally {
                try {
                    log.info("Sleeping 10 seconds");
                    Thread.sleep(1000 * 10);
                } catch (InterruptedException e) {
                    log.info("Exception in thread sleep", e);
                }
            }
        }
    }

    private void sendMessageWithKey(Properties kafkaProperties, final String topicName) {
        List<String> keys = List.of("key1", "key2", "key3", "key4", "key5");
        int j = 0;

        for (int i = 1; i <= 100; i++) {
            log.info("loop {} started", i);
            String message = FAKER.harryPotter().character();
            log.info("Sending message={}", message);

            // send String message every 10 seconds
            try (Producer<String, String> producer = new KafkaProducer<String, String>(kafkaProperties)) {
                // create ProducerRecord to send message
                ProducerRecord<String, String> producerRecord = new ProducerRecord<>(topicName, keys.get(j++), message);
                // reset j to 0 if j is 2
                if (j == 5) {
                    j = 0;
                }
                // send message
                Future<RecordMetadata> future = producer.send(producerRecord);

                log.info("Sent message={}", message);

                log.info("Getting response");
                // wait for result. Not recommended in PROD
                RecordMetadata recordMetadata = future.get();

                // print log
                String topic = recordMetadata.topic();
                long offset = recordMetadata.offset();
                int partition = recordMetadata.partition();
                int serializedKeySize = recordMetadata.serializedKeySize();
                int serializedValueSize = recordMetadata.serializedValueSize();
                long timestamp = recordMetadata.timestamp();

                log.info("topic={}, offset={}, partition={}, serializedKeySize={}, serializedValueSize={}, timestamp={}",
                        topic, offset, partition, serializedKeySize, serializedValueSize, timestamp);
                log.info("loop {} completed", i);
            } catch (ExecutionException | InterruptedException e) {
                log.info("Exception in sending message", e);
            } finally {
                try {
                    log.info("Sleeping 10 seconds");
                    Thread.sleep(1000 * 10);
                } catch (InterruptedException e) {
                    log.info("Exception in thread sleep", e);
                }
            }
        }
    }

}
