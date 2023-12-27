package com.java.threads;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BlockingThread implements Runnable{

    @Override
    public void run() {
        try {
            log.info("Executing blocking thread");
            Thread.sleep(5000000);
            log.info("Exiting blocking thread");
        } catch(InterruptedException e) {
            System.out.println("Interrupted exiting blocking thread");
        }
    }

}
