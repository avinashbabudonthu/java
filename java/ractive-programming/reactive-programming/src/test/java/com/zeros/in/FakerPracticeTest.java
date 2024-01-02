package com.zeros.in;

import com.github.javafaker.Faker;
import com.github.javafaker.Name;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class FakerPracticeTest {

    @Test
    void fakerUsage() {
        Faker faker = Faker.instance();
        Name name = faker.name();

        for (int i = 0; i < 10; i++) {
            String fullName = name.fullName();
            log.info("{}",fullName);
        }
    }

}