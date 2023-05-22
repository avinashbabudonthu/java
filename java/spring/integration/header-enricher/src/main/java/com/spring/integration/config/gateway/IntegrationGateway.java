package com.spring.integration.config.gateway;

import com.spring.integration.model.Student;
import com.spring.integration.utils.Constants;
import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;

@MessagingGateway
public interface IntegrationGateway {

    @Gateway(requestChannel = Constants.GATEWAY_CHANNEL_STUDENT_INPUT)
    Student saveStudent(Student student);

}