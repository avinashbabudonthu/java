package com.spring.integration.service;

import com.spring.integration.model.Student;
import com.spring.integration.utils.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class StudentService {

    @ServiceActivator(inputChannel = Constants.GATEWAY_CHANNEL_STUDENT_SAVE_RESPONSE)
    public void saveStudent(Message<Student> message){
        MessageHeaders messageHeaders = message.getHeaders();
        MessageChannel replyChannel = (MessageChannel) messageHeaders.getReplyChannel();
        Student student = message.getPayload();
        student.setMiddleName(messageHeaders.get("middleName").toString());
        student.setLastName(messageHeaders.get("lastName").toString());
        Message<Student> responseMessage = MessageBuilder.withPayload(student).build();
        replyChannel.send(responseMessage);
    }

}