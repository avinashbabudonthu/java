package com.create;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.UUID;

@Slf4j
public class Create {

    private static final String CONFIG_FILE_NAME = "spring-config.xml";

    @Test
    public void save(){
        User user = User.builder().id("1").username("a").password("a").build();
        log.info("before, user={}", user);
        try(AbstractApplicationContext context = new ClassPathXmlApplicationContext(CONFIG_FILE_NAME)){
            MongoTemplate mongoTemplate = (MongoTemplate) context.getBean(MongoTemplate.class);

            user = mongoTemplate.save(user);
            log.info("after, user={}", user);
        }
    }

    @Test
    public void insert(){
        User user = User.builder().id(UUID.randomUUID().toString()).username("b").password("b").build();
        log.info("before, user={}", user);
        try(AbstractApplicationContext context = new ClassPathXmlApplicationContext(CONFIG_FILE_NAME)){
            MongoTemplate mongoTemplate = (MongoTemplate) context.getBean(MongoTemplate.class);

            user = mongoTemplate.insert(user);
            log.info("after, user={}", user);
        }
    }


}
