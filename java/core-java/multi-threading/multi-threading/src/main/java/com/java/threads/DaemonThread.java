package com.java.threads;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DaemonThread implements Runnable{

    @Override
    public void run() {
        try {
            log.info("Executing daemon thread");
            Thread.sleep(1000 * 500000);
        } catch (InterruptedException e) {
            log.info("Exiting daemon thread");
        }
    }
}
