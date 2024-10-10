package com.java.entity;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;
import java.util.Random;
import java.util.UUID;

@Slf4j
public class PrimaryKeyGenerator implements IdentifierGenerator {

    @Override
    public Serializable generate(SharedSessionContractImplementor arg0, Object arg1) throws HibernateException {
        return method2();
    }

    private static String method1() {
        try {
            return String.valueOf(Math.abs(System.nanoTime() + new Random().nextLong()));
        } catch (Exception e) {
            // Implement ErrorsEnum and update below messages
            log.error("Exception while generating primary key", e);
            return String.valueOf(UUID.randomUUID().timestamp());
        }
    }

    private static String method2() {
        return UUID.randomUUID().toString();
    }

}