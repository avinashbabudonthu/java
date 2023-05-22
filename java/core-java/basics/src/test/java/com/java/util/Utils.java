package com.java.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomUtils;
import org.junit.*;

import javax.xml.bind.DatatypeConverter;
import java.io.UnsupportedEncodingException;
import java.util.Random;

@Slf4j
public class Utils {

    @Test
    public void generate10DigitRandomNumber() {
        long number = (long) Math.floor(Math.random() * 9_000_000_000L) + 1_000_000_000L;
        log.info("number={}", number);
    }

    @Test
    public void createBasicAuthHeader() throws UnsupportedEncodingException {
        final String credentials = "admin:admin123";
        String basicAuthorizationHeader = "Basic "
                + DatatypeConverter.printBase64Binary(credentials.getBytes("UTF-8"));
        log.info("basic authorization header={}", basicAuthorizationHeader);
    }

    private void generateNDigitRandomNumber(int numberOfDigits) {
        double number = Math.floor(Math.random() * (9 * (Math.pow(10, numberOfDigits - 1)))) + Math.pow(10, numberOfDigits - 1);
        log.info("number={}", (long) number);
    }

    @Test
    public void generateNDigitRandomNumber() {
        for (int i = 0; i < 10; i++) {
            generateNDigitRandomNumber(5);
        }
        for (int i = 0; i < 10; i++) {
            generateNDigitRandomNumber(6);
        }

    }

    private void generateRandomNumberInRange(int start, int end) {
        int number = start + new Random().nextInt(end - start + 1);
        System.out.println(number);
    }

    @Test
    public void generateRandomNumberInRange() {
        for (int i = 0; i < 10; i++) {
            generateRandomNumberInRange(10, 100);
        }

        for (int i = 0; i < 10; i++) {
            generateRandomNumberInRange(100, 1000);
        }
    }

    private void generateNDigitRandomNumberInRange(int startInclusive, int endExclusive) {
        int number = RandomUtils.nextInt(startInclusive, endExclusive);
        log.info("number={}", number);
    }

    @Test
    public void generateNDigitRandomNumberInRange() {
        for (int i = 0; i < 10; i++) {
            generateNDigitRandomNumberInRange(1000000000, 2000999999);
        }
    }

}