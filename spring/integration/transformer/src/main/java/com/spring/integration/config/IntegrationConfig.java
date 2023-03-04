package com.spring.integration.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.integration.model.Student;
import com.spring.integration.util.Constants;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.Transformer;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.json.JsonToObjectTransformer;
import org.springframework.integration.json.ObjectToJsonTransformer;
import org.springframework.integration.support.json.Jackson2JsonObjectMapper;
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

    @Bean
    @Transformer(inputChannel = Constants.GATEWAY_CHANNEL_STUDENT_INPUT, outputChannel = Constants.GATEWAY_CHANNEL_OBJECT_TO_JSON)
    public ObjectToJsonTransformer objectToJsonTransformer(){
        return new ObjectToJsonTransformer(getMapper());
    }

    @Bean
    public Jackson2JsonObjectMapper getMapper(){
        ObjectMapper objectMapper = new ObjectMapper();
        return new Jackson2JsonObjectMapper(objectMapper);
    }

    @Bean
    @Transformer(inputChannel = Constants.GATEWAY_CHANNEL_JSON_TO_OBJECT, outputChannel = Constants.GATEWAY_CHANNEL_JSON_TO_OBJECT_TO_RESPONSE)
    public JsonToObjectTransformer jsonToObjectTransformer(){
        return new JsonToObjectTransformer(Student.class);
    }

}