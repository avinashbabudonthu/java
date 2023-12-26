package com.java;

import com.java.threads.Thread1;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class ThreadsPractice {

    @Test
    void createThread1() {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                log.info("t1");
            }
        });

        t1.start();
    }

    @Test
    void createThread2() {
        Thread t1 = new Thread(() -> {
            log.info("t1");
        });

        t1.start();
    }

    /**
     * class extends Thread
     * {@link com.java.threads.Thread1}
     */
    @Test
    void createThread3() {
        Thread t1 = new Thread1();
        t1.setName("New Employee thread");
        t1.start();
    }

    @Test
    void getName() {
        Thread t1 = new Thread(() -> {
            // Thread name=Thread-0
            log.info("Thread name={}", Thread.currentThread().getName());
        });
        t1.start();
    }

    /**
     * We are in thread=main before starting new thread
     * We are in thread=main after starting new thread
     * Inside thread=Thread-0
     */
    @Test
    void beforeAfter() {
        Thread thread = new Thread(() -> {
            log.info("Inside thread={}", Thread.currentThread().getName());
        });
        log.info("We are in thread={} before starting new thread", Thread.currentThread().getName());
        thread.start();
        log.info("We are in thread={} after starting new thread", Thread.currentThread().getName());
    }

    @Test
    void sleep() throws InterruptedException {
        for (int i=0;i<10;i++) {
            Thread.sleep(1000); // 1000 milli seconds
            log.info("i={}", i);
        }
    }

    @Test
    void setName() {
        Runnable runnable = () -> {
            log.info("{}", Thread.currentThread().getName()); // New worker thread
        };
        Thread thread = new Thread(runnable);
        thread.setName("New worker thread");
        thread.start();
    }

    @Test
    void setPriority() {
        Runnable runnable = () -> {
            // name=New employee thread, priority=10
          log.info("name={}, priority={}", Thread.currentThread().getName(), Thread.currentThread().getPriority());
        };

        Thread t1 = new Thread(runnable);
        t1.setName("New employee thread");
        t1.setPriority(Thread.MAX_PRIORITY);
        t1.start();
    }

    /**
     * If any unchecked exception thrown during thread execution then thread execution will stop
     * we can handle by setUncaughtExceptionHandler and handling exception
     * Usually we can use this method to release any resource or clean up logic
     */
    @Test
    void setUncaughtExceptionHandler() {
        Runnable runnable = () -> {
            throw new RuntimeException("Testing exception");
        };

        Thread t1 = new Thread(runnable);
        t1.setName("Malfunctioning thread");
        t1.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                // Exception in thread=Malfunctioning thread, message=Testing exception
                log.info("Exception in thread={}, message={}", t.getName(), e.getMessage());
            }
        });

        t1.start();
    }


}
