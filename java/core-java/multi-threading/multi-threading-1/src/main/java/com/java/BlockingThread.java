package com.java;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BlockingThread implements Runnable {

    @Override
    public void run() {
        try {
            Thread.sleep(1000 * 500);
        } catch (InterruptedException e) {
            log.info("Exiting BlockingThread, name={}, is-interrupted={}", Thread.currentThread().getName(), e);
        }
    }
}