package com.gcp.practice.publish;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gcp.practice.model.MessageModel;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gcp.pubsub.core.PubSubTemplate;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class PublisherController {

    @Autowired
    private PubSubTemplate pubSubTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    @Value("${app.topic.name}")
    private String topicName;

    @SneakyThrows
    @PostMapping(value = "/api/v1/messages", produces = MediaType.TEXT_PLAIN_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String publishMessage(@RequestBody MessageModel messageModel){
        log.info("message-model={}", messageModel);
        String jsonString = objectMapper.writeValueAsString(messageModel);
        log.info("publishing message json={}", jsonString);
        pubSubTemplate.publish(topicName, jsonString);
        return "success";
    }
}