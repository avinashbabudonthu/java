package com.spring.integration.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.messaging.MessageChannel;

@Configuration
public class IntegrationConfig {

    @Bean
    public MessageChannel requestChannel(){
        return new DirectChannel();
    }

    @Bean
    public MessageChannel replyChannel(){
        return new DirectChannel();
    }

}