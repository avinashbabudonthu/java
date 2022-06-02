package com.infogain.gcp.poc.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.cloud.gcp.pubsub.core.PubSubTemplate;
import org.springframework.cloud.gcp.pubsub.core.publisher.PubSubPublisherTemplate;
import org.springframework.cloud.gcp.pubsub.core.subscriber.PubSubSubscriberTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    @ConditionalOnMissingBean
    public PubSubTemplate pubSubTemplate(PubSubPublisherTemplate pubSubPublisherTemplate,
                                         PubSubSubscriberTemplate pubSubSubscriberTemplate) {
        return new PubSubTemplate(pubSubPublisherTemplate, pubSubSubscriberTemplate);
    }

    @Bean
    public ObjectMapper objectMapper(){
        return new ObjectMapper();
    }

}