package com.spring.integration.service;

import com.spring.integration.model.Student;
import com.spring.integration.util.Constants;
import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;

@MessagingGateway
public interface IntegrationGateway {

    @Gateway(requestChannel = Constants.GATEWAY_CHANNEL_STUDENT_INPUT)
    String processStudent(Student student);

}