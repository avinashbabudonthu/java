package org.apache.commons.lang3;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Slf4j
public class SystemUtilsTest {

    @Test
    void getHomeName() {
        log.info("host-name={}", SystemUtils.getHostName());
    }

    @Test
    void getJavaHome() {
        log.info("java-home={}", SystemUtils.getJavaHome());
    }

    @Test
    @DisplayName("Get PATH environment variable value")
    void pathEnvironmentVariable() {
        log.info("{}", SystemUtils.getEnvironmentVariable("PATH", "UNKNOWN"));
    }

    @Test
    @DisplayName("Get temporary directory path")
    void tempDirectory() {
        log.info("{}", SystemUtils.getJavaIoTmpDir());
    }

    @Test
    @DisplayName("Get current project directory")
    void getUserDir() {
        log.info("{}", SystemUtils.getUserDir());
    }

    /**
     * C:\Users\[username]
     */
    @Test
    @DisplayName("Get user home directory")
    void getUserHome() {
        log.info("{}", SystemUtils.getUserHome());
    }

    @Test
    @DisplayName("Get username")
    void getUserName() {
        log.info("{}", SystemUtils.getUserName("UNKNOWN"));
    }


}