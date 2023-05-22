package com.spring.integration.service;

import com.spring.integration.util.Constants;
import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;

@MessagingGateway
public interface IntegrationGateway {

    @Gateway(requestChannel = Constants.GATEWAY_CHANNEL_SEND_MESSAGE)
    String sendMessage(String message);

}