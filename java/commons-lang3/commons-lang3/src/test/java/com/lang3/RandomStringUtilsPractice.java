package com.lang3;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;

import java.util.Random;

public class RandomStringUtilsPractice {

    @Test
    public void random(){
        String str1 = RandomStringUtils.random(10);
        System.out.println(str1);
    }

    @Test
    public void randomAlphabetic(){
        String str1 = RandomStringUtils.randomAlphabetic(5);
        System.out.println(str1);

        String str2 = RandomStringUtils.randomAlphabetic(3, 10);
        System.out.println(str2);
    }

    @Test
    public void randomAlphanumeric(){
        String str1 = RandomStringUtils.randomAlphanumeric(10);
        System.out.println(str1);

        String str2 = RandomStringUtils.randomAlphanumeric(5, 10);
        System.out.println(str2);
    }

    @Test
    public void randomNumeric(){
        String str1 = RandomStringUtils.randomNumeric(10);
        System.out.println(str1);

        String str2 = RandomStringUtils.randomNumeric(5, 10);
        System.out.println(str2);
    }

    @Test
    public void randomPrint(){
        String str1 = RandomStringUtils.randomPrint(10);
        System.out.println(str1);
    }
}
