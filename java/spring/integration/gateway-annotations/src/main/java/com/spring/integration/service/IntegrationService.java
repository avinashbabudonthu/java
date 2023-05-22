package com.spring.integration.service;

import com.spring.integration.util.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class IntegrationService {

    @ServiceActivator(inputChannel = Constants.GATEWAY_CHANNEL_SEND_MESSAGE)
    public void sendMessage(Message<String> message){
        log.info("Inside sendMessage");

        MessageHeaders messageHeaders = message.getHeaders();
        log.info("messageHeaders={}", messageHeaders);

        String payload = message.getPayload();
        log.info("payload={}", payload);

        String newMessageStr = "Hello " + payload + ", Welcome to Spring Integration";
        log.info("newMessageStr={}", newMessageStr);

        MessageChannel replyChannel = (MessageChannel) messageHeaders.getReplyChannel();
        MessageBuilder.fromMessage(message);
        Message<String> newMessage = MessageBuilder.withPayload(newMessageStr).build();
        assert replyChannel != null;
        replyChannel.send(newMessage);
    }

}