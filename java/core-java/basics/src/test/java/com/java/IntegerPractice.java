package com.java;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class IntegerPractice {

    /**
     * int -> Integer
     * auto boxing can do this but valueOf will cache the value for better space & time performance
      */
    @Test
    public void valueOf(){
        int i = 10;
        Integer j = Integer.valueOf(i);
        log.info("i={}", i);
    }

    /**
     * String to signed int
     */
    @Test
    public void parseInt(){
        int i1 = Integer.parseInt("100");
        log.info("i1={}", i1);
        int i2 = Integer.parseInt("-101");
        log.info("i2={}", i2);
    }

    /**
     * String to unsigned int
     */
    @Test
    public void parseUnsignedInt(){
        int i1 = Integer.parseUnsignedInt("100");
        log.info("i1={}", i1); // 100
        int i2 = Integer.parseUnsignedInt("-101"); // java.lang.NumberFormatException: Illegal leading minus sign on unsigned string -101.
    }
}
