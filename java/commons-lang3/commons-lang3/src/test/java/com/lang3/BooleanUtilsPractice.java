package com.lang3;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.BooleanUtils;
import org.junit.Test;

@Slf4j
public class BooleanUtilsPractice {

    @Test
    public void toBoolean() {
        String str1 = "true";
        Boolean result1 = BooleanUtils.toBoolean(str1);
        log.info("{}", result1); // true

        String str2 = "false";
        Boolean result2 = BooleanUtils.toBoolean(str2);
        log.info("{}", result2); // false

        int num1 = 0;
        Boolean result3 = BooleanUtils.toBoolean(num1);
        log.info("{}", result3); // false

        int num2 = 1;
        Boolean result4 = BooleanUtils.toBoolean(num2);
        log.info("{}", result4); // true

        int num3 = 2;
        Boolean result5 = BooleanUtils.toBoolean(num3);
        log.info("{}", result5); // true

        int num4 = -1;
        Boolean result6 = BooleanUtils.toBoolean(num4);
        log.info("{}", result6); // true
    }

}