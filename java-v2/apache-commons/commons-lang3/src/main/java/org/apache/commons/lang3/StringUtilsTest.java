package org.apache.commons.lang3;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class StringUtilsTest {

    @Test
    public void isNoneBlank() {
        String name1 = "john";
        String name2 = "jim";
        String name3 = "jane";
        String name4 = "";

        boolean result1 = StringUtils.isNoneBlank(name1, name2, name3);
        log.info("result1={}", result1); // true

        boolean result2 = StringUtils.isNoneBlank(name2, name3, name4);
        log.info("result2={}", result2); // false
    }

    @Test
    public void equalsAny(){
        String name1 = "john";
        String name2 = "jim";
        String name3 = "jane";

        String input1 = "jack";
        boolean result1 = StringUtils.equalsAny(input1, name1, name2, name3);
        System.out.println(result1);

        String input2 = "jim";
        boolean result2 = StringUtils.equalsAny(input2, name1, name2, name3);
        System.out.println(result2);
    }

    @Test
    public void equalsAnyIgnoreCase(){
        String name1 = "john";
        String name2 = "jim";
        String name3 = "jane";

        String input1 = "jack";
        boolean result1 = StringUtils.equalsAnyIgnoreCase(input1, name1, name2, name3);
        System.out.println(result1);

        String input2 = "JIM";
        boolean result2 = StringUtils.equalsAnyIgnoreCase(input2, name1, name2, name3);
        System.out.println(result2);
    }

    @Test
    public void subString() {
        String str1 = "abcd";
        log.info("{}", StringUtils.substring(str1, 1)); // bcd
        log.info("{}", StringUtils.substring(str1, 0, 10)); // abcd

        String str2 = "";
        log.info("{}", StringUtils.substring(str2, 1)); // ""
        log.info("{}", StringUtils.substring(str2, 0, 10)); // ""

        String str3 = null;
        log.info("{}", StringUtils.substring(str3, 1)); // null
        log.info("{}", StringUtils.substring(str3, 0, 10)); // null
    }

}