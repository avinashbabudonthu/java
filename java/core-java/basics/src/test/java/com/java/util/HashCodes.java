package com.java.util;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;

@Slf4j
public class HashCodes {

    @Test
    public void hashCodeFromArray(){
//        Integer array
        Integer[] intArray = new Integer[]{1,2,3,4,5,6,7};
        int intArrayHashCode = Arrays.hashCode(intArray);
        log.info("intArrayHashCode={}", intArrayHashCode);

        //      int array
        int[] intArray2 = {1,2,3,4,5,6,7};
        int intArrayHashCode2 = Arrays.hashCode(intArray2);
        log.info("intArrayHashCode2={}", intArrayHashCode2);

//        String array
        String[] stringArray = new String[]{"1","2","3","4","5","6","7"};
        int stringArrayHashCode = Arrays.hashCode(stringArray);
        log.info("stringArrayHashCode={}", stringArrayHashCode);
    }

    @Test
    public void longHashCode(){
        long val1 = 10l;
        int hashCode = (int) (val1 ^ (val1 >>> 32 ));
        log.info("hashCode={}",hashCode);
    }

    @Test
    public void floatHashCode(){
        float f = 1.23f;
        int hashCode = Float.floatToIntBits(f);
        log.info("hashCode={}", hashCode);
    }
}
