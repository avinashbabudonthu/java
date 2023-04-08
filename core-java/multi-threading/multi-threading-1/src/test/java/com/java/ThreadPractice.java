package com.java;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Slf4j
public class ThreadPractice {

    /**
     * inside thread1 run method
     * inside thread3 run method
     * inside thread2 run method
     * inside thread4 run method
     * inside thread5 run method
     * inside thread7 run method, name=worker thread 7
     * inside Thread1.run method, name=Thread-6, id=19
     */
    @DisplayName("Create thread")
    @Test
    void createThread() {
        // with Runnable
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                log.info("inside thread1 run method");
            }
        });
        thread1.start();

        // with lambda
        Thread thread2 = new Thread(() -> {
            log.info("inside thread2 run method");
        });
        thread2.start();

        // anonymous inner class
        Thread thread3 = new Thread() {
            @Override
            public void run() {
                log.info("inside thread3 run method");
            }
        };
        thread3.start();

        // thread4 start thread immediately after creation
        new Thread(() -> {
            log.info("inside thread4 run method");
        }).start();

        // thread5
        new Thread(() -> log.info("inside thread5 run method")).start();

        // By extends java.lang.Thread
        Thread thread6 = new Thread6();
        thread6.start();

        // Thread create with Runnable and name
        Runnable runnable = () -> log.info("inside thread7 run method, name={}", Thread.currentThread().getName());
        Thread thread7 = new Thread(runnable, "worker thread 7");
        thread7.start();
    }

    /**
     * Before executing thread. id=1, name=main
     * After executing thread. id=1, name=main
     * inside thread. id=14, name=Thread-1
     */
    @DisplayName("Print thread id name")
    @Test
    void threadIdAndName() {
        log.info("Before executing thread. id={}, name={}", Thread.currentThread().getId(), Thread.currentThread().getName());
        Thread thread = new Thread(() -> {
            log.info("inside thread. id={}, name={}", Thread.currentThread().getId(), Thread.currentThread().getName());
        });
        log.info("After executing thread. id={}, name={}", Thread.currentThread().getId(), Thread.currentThread().getName());
        thread.start();
    }

    /**
     * output -
     * Before execution
     * inside thread run method, name=Thread-1
     * After execution. Time-taken=5007
     */
    @DisplayName("Thread sleep method")
    @Test
    void sleep() throws InterruptedException {
        log.info("Before execution");
        long startTime = System.currentTimeMillis();
        // sleep method takes milli seconds
        new Thread(() -> {
            log.info("inside thread run method, name={}", Thread.currentThread().getName());
        }).start();

        Thread.sleep(1000 * 5);

        long endTime = System.currentTimeMillis();
        log.info("After execution. Time-taken={}", (endTime - startTime));
    }

    /**
     * output:
     * inside thread run method. name=worker thread 1
     */
    @DisplayName("Set name to thread")
    @Test
    void setThreadName() {
        Thread thread = new Thread(() -> {
            log.info("inside thread run method. name={}", Thread.currentThread().getName());
        });
        thread.setName("worker thread 1");
        thread.start();
    }

    /**
     * output:
     * thread name=worker thread 1, priority=10
     */
    @Test
    void setPriority() {
        Thread thread = new Thread(() -> {
            log.info("thread name={}, priority={}", Thread.currentThread().getName(), Thread.currentThread().getPriority());
        });
        thread.setName("worker thread 1");
        thread.setPriority(Thread.MAX_PRIORITY);
        thread.start();
    }

    /**
     * output:
     * Critical exception occurred in Misbehave worker thread 1. Error is Intentional exception
     */
    @Test
    void exceptionHandling(){
        Thread thread = new Thread(() -> {
            throw new RuntimeException("Intentional exception");
        });

        // set exception handling
        thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                log.info("Critical exception occurred in {}. Error is {}", t.getName(), e.getMessage());
            }
        });

        thread.setName("Misbehave worker thread 1");

        thread.start();
    }

    /**
     * If we call start() method 2 times then IllegalStateException will be thrown
     *
     * output:
     * inside thread run method
     *
     * java.lang.IllegalThreadStateException
     * 	at java.lang.Thread.start(Thread.java:708)
     * 	at com.java.ThreadPractice.illegalStateException(ThreadPractice.java:157)
     *
     */
    @DisplayName("Illegal state exception")
    @Test
    void illegalStateException(){
        Thread thread = new Thread(() -> log.info("inside thread run method"));
        thread.start();
        thread.start();
    }
}
