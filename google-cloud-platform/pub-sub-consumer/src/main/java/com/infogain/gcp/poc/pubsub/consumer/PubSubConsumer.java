package com.infogain.gcp.poc.pubsub.consumer;

import com.google.pubsub.v1.PubsubMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.cloud.gcp.pubsub.core.PubSubTemplate;
import org.springframework.cloud.gcp.pubsub.support.BasicAcknowledgeablePubsubMessage;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Slf4j
@Component
public class PubSubConsumer {

    @Autowired
    private PubSubTemplate pubSubTemplate;

    @Value("${pub.sub.subscription}")
    private String subscription;

    private Consumer<BasicAcknowledgeablePubsubMessage> consumer = this::consume;

    @EventListener(ApplicationReadyEvent.class)
    public void subscribe() {
        log.info("subscribing {} to {}", this.getClass().getSimpleName(), this.subscription);
        pubSubTemplate.subscribe(subscription, consumer);
    }

    public void consume(BasicAcknowledgeablePubsubMessage basicAcknowledgeablePubsubMessage) {
        PubsubMessage message = basicAcknowledgeablePubsubMessage.getPubsubMessage();

        try {
            log.info("message={},", message.getData().toStringUtf8());
            log.info("message-attribute-map={}", message.getAttributesMap());
        } catch (Exception ex) {
            log.error("Error while receiving pub sub message:::::", ex);
        }

        basicAcknowledgeablePubsubMessage.ack();
    }

}