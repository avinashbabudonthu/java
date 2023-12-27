package com.java;

import com.java.threads.DaemonThread;
import lombok.extern.slf4j.Slf4j;

/**
 * Daemon thread used to run background logic
 * Does not prevent main thread or application stop though daemon thread is executing
 */
@Slf4j
public class DaemonThreadTest {

    public static void main(String[] args) throws InterruptedException {
        // executing main
        log.info("Executing daemon thread test, name={}", Thread.currentThread().getName());

        // starting new thread. This thread goes to sleep very long time
        Thread t1 = new Thread(new DaemonThread());
        t1.setDaemon(true); // setting this thread as daemon thread
        t1.start();

        // after execution main thread exits and then application exits without waiting for daemon thread to finish
        for (int i = 0; i < 10; i++) {
            log.info("i={}", i);
            Thread.sleep(1000);
        }

        log.info("Exiting daemon thread test, name={}", Thread.currentThread().getName());
    }
}
