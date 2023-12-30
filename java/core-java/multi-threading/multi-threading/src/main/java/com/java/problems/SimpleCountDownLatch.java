package com.java.problems;

/**
 * Simple CountDownLatch
 * As part of the java.util.concurrent package, the JDK contains many classes that help us coordinate between threads.
 *
 * A few of those include the CountDownLatch, CyclicBarrier, Phaser, Exchanger, and others that may be added in future versions of the JDK.
 *
 * However, all those classes are no more than higher-level wrappers built upon the same building blocks we learned and already know very well. As such, if we never knew those classes existed, we wouldn't even need them because we can implement their functionality with the tools we already have.
 *
 * However, getting somewhat familiar with at least some of them is still recommended as they represent useful patterns.
 *
 * In this exercise, we are going to learn about the CountDownLatch , by implementing a subset of its functionality.
 *
 *
 *
 * The SimpleCountDownLatch
 *
 * To get familiar with CountDownLatch as well as gain confidence in our ability to implement it and other higher-level classes we are going to implement a simple version of the CountDownLatch and implement the majority of the CountDownLatch's functionality.
 *
 * The CountDownLatch and its simple version the SimpleCountDownLatch are initialized with a non-negative count.
 *
 * The SimpleCountDownLatch allows one or more threads to wait until a set of operations being performed in other threads completes.
 *
 * The SimpleCountDownLatch has the following main operations:
 *
 * countDown() - Decrements the count of the latch, releasing all waiting threads when the count reaches zero. If the current count already equals zero, then nothing happens.
 *
 * await() - Causes the current thread to wait until the latch has counted down to zero. If the current count is already zero, then this method returns immediately.
 *
 * The await method blocks until the current count reaches zero due to invocations of the countDown() method, after which all waiting threads are released, and any subsequent invocations of await return immediately.
 *
 * For more information and examples, see CountDownLatch.
 *
 * Hint: Consider using either version of the condition variables (Lock's condition variables or Object's wait/notify). For practice purposes, you can try both.
 *
 * Notes:
 *
 * The SimpleCountDownLatch instance is single-use. In other words, once the count goes to zero, the SimpleCountDownLatch has no additional use.
 *
 * The class has to be thread-safe
 */
public class SimpleCountDownLatch {
    private int count;

    public SimpleCountDownLatch(int count) {
        this.count = count;
        if (count < 0) {
            throw new IllegalArgumentException("count cannot be negative");
        }
    }

    /**
     * Causes the current thread to wait until the latch has counted down to zero.
     * If the current count is already zero then this method returns immediately.
     */
    public void await() throws InterruptedException {
        /**
         * Fill in your code
         */
    }

    /**
     *  Decrements the count of the latch, releasing all waiting threads when the count reaches zero.
     *  If the current count already equals zero then nothing happens.
     */
    public void countDown() {
        /**
         * Fill in your code
         */
    }

    /**
     * Returns the current count.
     */
    public int getCount() {
        /**
         * Fill in your code
         */
        return -1; // TODO
    }
}

