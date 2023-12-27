package com.java.threads;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SleepingThread implements Runnable{

    /**
     * we are calling Thread
     */
    @Override
    public void run() {
        while (true) {
            try {
                log.info("Executing sleeping thread");
                Thread.sleep(1000 * 50000);
                log.info("Exiting sleeping thread");
            }catch(InterruptedException e) {
                log.info("Exiting sleeping thread");
                return;
            }
        }
    }
}
