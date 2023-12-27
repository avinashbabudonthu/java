package com.java.threads;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JoinThread implements Runnable {

    @Override
    public void run() {
        log.info("Executing JoinThread");
        for (int i = 0; i < 10; i++) {
            log.info("thread={}, i={}", Thread.currentThread().getName(), i);
        }
        log.info("Exiting JoinThread");
    }
}
