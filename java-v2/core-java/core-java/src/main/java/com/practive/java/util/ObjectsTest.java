package com.practive.java.util;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Objects;

@Slf4j
@SuppressWarnings("all")
public class ObjectsTest {

    @Test
    void requireNonNull() {
        try {
            // if value is null then exception will be thrown
            Objects.requireNonNull(null);
        } catch (Exception e){
            // null
            log.info("{}", e.getMessage());
        }

        try {
            // if value is null then exception will be thrown
            Objects.requireNonNull(null, "Object cannot be null");
        } catch (Exception e){
            // Object cannot be null
            log.info("{}", e.getMessage());
        }
    }

    @Test
    void requireNonNullElse() {
        try {
            String value1 = Objects.requireNonNullElse("test", "default value");
            String value2 = Objects.requireNonNullElse(null, "default value");

            // value1=test, value2=default value
            log.info("value1={}, value2={}", value1, value2);
        } catch (Exception e){
            log.info("{}", e.getMessage());
        }
    }
}