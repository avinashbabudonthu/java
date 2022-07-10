package com.delete;

import com.create.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;
import java.util.UUID;

@Slf4j
public class Delete {

    private static final String CONFIG_FILE_NAME = "spring-config.xml";

    @Test
    public void remove() {
        try (AbstractApplicationContext applicationContext = new ClassPathXmlApplicationContext(CONFIG_FILE_NAME)) {
            MongoTemplate mongoTemplate = (MongoTemplate) applicationContext.getBean("mongoTemplate");

            // save user document
            String id = UUID.randomUUID().toString();
            User user = User.builder().id(id).username("uname"+id)
                    .password("password" + id).build();
            mongoTemplate.save(user);

            // get user document
            Criteria criteria = Criteria.where("id").is(id);
            Query query = new Query();
            query.addCriteria(criteria);
            List<User> users = mongoTemplate.find(query, User.class);
            log.info("user={}", users);

            // delete user document
            mongoTemplate.remove(users.get(0));
        }
    }

}
