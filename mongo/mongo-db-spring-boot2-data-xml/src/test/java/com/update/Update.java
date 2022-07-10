package com.update;

import com.create.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.Random;
import java.util.UUID;

@Slf4j
public class Update {

    private static final String CONFIG_FILE_NAME = "spring-config.xml";

    @Test
    public void update(){
        User user = User.builder().id(UUID.randomUUID().toString()).username("b").password("b").build();
        try(AbstractApplicationContext context = new ClassPathXmlApplicationContext(CONFIG_FILE_NAME)){
            MongoTemplate mongoTemplate = (MongoTemplate) context.getBean(MongoTemplate.class);

            user = mongoTemplate.insert(user);
            log.info("after, user={}", user);

            User user2 = User.builder().id(user.getId()).username("c").password("c").build();
            user2 = mongoTemplate.save(user2);
        }
    }

    /**
     * Update first record
     */
    @Test
    public void updateFirst() {
        try (AbstractApplicationContext applicationContext = new ClassPathXmlApplicationContext(CONFIG_FILE_NAME)) {
            MongoTemplate mongoTemplate = (MongoTemplate) applicationContext.getBean("mongoTemplate");

            for (long i = 0; i < 2; i++) {
                User user = User.builder().id(UUID.randomUUID().toString()).username("uname"+i)
                        .password("password" + i).build();
                mongoTemplate.save(user);
            }

            // update first
            Query query = new Query();
            Criteria criteria = Criteria.where("username").is("uname");
            query.addCriteria(criteria);
            org.springframework.data.mongodb.core.query.Update update = new org.springframework.data.mongodb.core.query.Update();
            update.set("username", "uname-updated");
            mongoTemplate.updateFirst(query, update, User.class);
        }
    }

    /**
     * Update multiple records
     */
    @Test
    public void updateMulti() {
        try (AbstractApplicationContext applicationContext = new ClassPathXmlApplicationContext(CONFIG_FILE_NAME)) {
            MongoTemplate mongoTemplate = (MongoTemplate) applicationContext.getBean("mongoTemplate");

            for (long i = 0; i < 2; i++) {
                User user = User.builder().id(UUID.randomUUID().toString()).username("uname"+i)
                        .password("password" + i).build();
                mongoTemplate.save(user);
            }

            // update first
            Query query = new Query();
            Criteria criteria = Criteria.where("username").is("uname");
            query.addCriteria(criteria);
            org.springframework.data.mongodb.core.query.Update update = new org.springframework.data.mongodb.core.query.Update();
            update.set("username", "uname-updatedMulti");
            mongoTemplate.updateMulti(query, update, User.class);
        }
    }

    /**
     * The upsert works operate on the find and modify else create semantics:
     * if the document is matched, update it, else create a new document
     */
    @Test
    public void upsert() {
        try (AbstractApplicationContext applicationContext = new ClassPathXmlApplicationContext(CONFIG_FILE_NAME)) {
            MongoTemplate mongoTemplate = (MongoTemplate) applicationContext.getBean("mongoTemplate");

            Long id = new Random().nextLong();
            log.info("id: {}", id);
            User user = User.builder().id(UUID.randomUUID().toString()).username("uname"+id)
                    .password("password" + id).build();
            mongoTemplate.save(user);

            Criteria criteria = Criteria.where("username").is("username" + id);
            Query query = new Query();
            query.addCriteria(criteria);

            org.springframework.data.mongodb.core.query.Update update = new org.springframework.data.mongodb.core.query.Update();
            update.set("username", "username-updated");
            mongoTemplate.upsert(query, update, User.class);
        }
    }
}
