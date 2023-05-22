package com.spring.integration.service;

import com.spring.integration.model.Student;
import com.spring.integration.util.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class StudentService {

    @ServiceActivator(inputChannel = Constants.GATEWAY_CHANNEL_OBJECT_TO_JSON, outputChannel = Constants.GATEWAY_CHANNEL_JSON_TO_OBJECT)
    public Message<?> receiveMessage(Message<?> message){
      log.info("Inside receiveMessage");
      log.info("message={}", message);
      return  message;
    }

    @ServiceActivator(inputChannel = Constants.GATEWAY_CHANNEL_JSON_TO_OBJECT_TO_RESPONSE)
    public void processJsonToObject(Message<?> message){
        log.info("Inside processJsonToObject");
        MessageChannel replyChannel = (MessageChannel) message.getHeaders().getReplyChannel();
        MessageBuilder.fromMessage(message);
        log.info("json to object. student={}", message.getPayload());
        Student student = (Student) message.getPayload();
        student.setCourse(student.getCourse().toUpperCase());
        student.setName(student.getName().toUpperCase());
        Message<String> responseMessage = MessageBuilder.withPayload(student.toString()).build();
        replyChannel.send(responseMessage);
    }

}