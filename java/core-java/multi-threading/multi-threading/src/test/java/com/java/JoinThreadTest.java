package com.java;

import com.java.threads.JoinThread;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JoinThreadTest {

    /**
     * Executing JoinThreadTest
     * Executing JoinThread
     * thread=Thread-0, i=0
     * thread=Thread-0, i=1
     * thread=Thread-0, i=2
     * thread=Thread-0, i=3
     * thread=Thread-0, i=4
     * thread=Thread-0, i=5
     * thread=Thread-0, i=6
     * thread=Thread-0, i=7
     * thread=Thread-0, i=8
     * thread=Thread-0, i=9
     * Exiting JoinThread
     * thread=main, i=20
     * thread=main, i=21
     * thread=main, i=22
     * thread=main, i=23
     * thread=main, i=24
     * thread=main, i=25
     * thread=main, i=26
     * thread=main, i=27
     * thread=main, i=28
     * thread=main, i=29
     * Exiting JoinThreadTest
     */
    public static void main(String[] args) throws InterruptedException {
        log.info("Executing JoinThreadTest");

        Thread t1 = new Thread(new JoinThread());
        t1.start();
        t1.join();

        for (int i = 20; i < 30; i++) {
            log.info("thread={}, i={}", Thread.currentThread().getName(), i);
        }

        log.info("Exiting JoinThreadTest");
    }
}
