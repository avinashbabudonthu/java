package com.practive.java.lang;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Slf4j
public class SystemTest {

    /**
     * Get Java version <br />
     * Output:
     * java.specification.version=17
     */
    @Test
    @DisplayName("Get current running java version")
    void getJavaVersion() {
        log.info("java.specification.version={}", System.getProperty("java.specification.version"));
    }

    /**
     * Output:
     * current-time-in-milli-seconds=1723705107563
     */
    @Test
    @DisplayName(value = "Get current time in milli seconds")
    void currentTimeMillis() {
        log.info("current-time-in-milli-seconds={}", System.currentTimeMillis());
    }

    /**
     * Output:
     * Direct execution: temp-directory=C:\Users\[username]\AppData\Local\Temp\
     * <br />
     * With VM argument -Djava.io.tmpdir=C:\Temp: temp-directory=C:\Temp
     */
    @Test
    @DisplayName("Get temp directory path")
    void getTempDirectoryPath() {
        log.info("temp-directory={}", System.getProperty("java.io.tmpdir"));
    }

}