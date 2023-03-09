package com.spring.integration.config;

import com.spring.integration.utils.Constants;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.Transformer;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.transformer.HeaderEnricher;
import org.springframework.integration.transformer.support.HeaderValueMessageProcessor;
import org.springframework.integration.transformer.support.StaticHeaderValueMessageProcessor;
import org.springframework.messaging.MessageChannel;

import java.util.HashMap;
import java.util.Map;

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

    @Bean
    @Transformer(inputChannel = Constants.GATEWAY_CHANNEL_STUDENT_INPUT, outputChannel = Constants.GATEWAY_CHANNEL_STUDENT_SAVE_RESPONSE)
    public HeaderEnricher headerEnricher(){
        Map<String, HeaderValueMessageProcessor<String>> headers = new HashMap<>();
        headers.put("middleName", new StaticHeaderValueMessageProcessor<>("UNKNOWN"));
        headers.put("lastName", new StaticHeaderValueMessageProcessor<>("UNKNOWN"));
        HeaderEnricher headerEnricher = new HeaderEnricher(headers);
        return headerEnricher;
    }

}