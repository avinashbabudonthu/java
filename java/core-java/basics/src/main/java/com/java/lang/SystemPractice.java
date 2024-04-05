package com.java.lang;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class SystemPractice {

    /**
     * method to get line separator based on underlying operating system instead of hard coding
     */
    @Test
    public void lineSeparator() {
        String lineSeparator = System.getProperty("line.separator");
        log.info("abc{}def", lineSeparator);
    }

    /**
     * variable system environment variables
     */
    @Test
    public void getPathEnvironmentVariable() {
        String path = System.getenv("PATH");
        log.info("path={}", path);
    }

    /**
     * passed as
     * -Dsys.prop.name=jack
     */
    @Test
    public void systemPropertyOrVMArgument() {
        String systemPropertyOrVMArgument = System.getProperty("sys.prop.name");
        log.info("value={}", systemPropertyOrVMArgument);
    }
}
