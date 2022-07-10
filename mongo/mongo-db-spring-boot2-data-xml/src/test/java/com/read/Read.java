package com.read;

import com.create.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import java.util.Random;
import java.util.UUID;

@Slf4j
public class Read {

    private static final String CONFIG_FILE_NAME = "spring-config.xml";

    /**
     * This operation works like updateMulti, but it returns the object before it was modified.
     */
    @Test
    public void findAndModify() {
        try (AbstractApplicationContext applicationContext = new ClassPathXmlApplicationContext(CONFIG_FILE_NAME)) {
            MongoTemplate mongoTemplate = (MongoTemplate) applicationContext.getBean("mongoTemplate");

            String id = UUID.randomUUID().toString();
            User user = User.builder().id(id).username("uname"+id)
                    .password("password" + id).build();
            mongoTemplate.save(user);

            Criteria criteria = Criteria.where("username").is("uname" + id);
            Query query = new Query();
            query.addCriteria(criteria);
            Update update = new Update();
            update.set("username", "username-updated");
            User user2 = mongoTemplate.findAndModify(query, update, User.class);
            log.info("user2: {} ", user2);
        }
    }

}
