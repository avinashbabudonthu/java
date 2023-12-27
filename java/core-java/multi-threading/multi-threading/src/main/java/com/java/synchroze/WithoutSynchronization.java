package com.java.synchroze;

import lombok.extern.slf4j.Slf4j;

/**
 * In correctImplementation method we are starting thread one after another with join
 * In wrongImplementation method we are stating both threads at a time. main thread is waiting for completion of both threads
 *
 * Better approach is to use synchronized on Counter - increment, decrement methods.
 * Both methods - correctImplementation, wrongImplementation - work properly on using synchronization method or block
 * Refer - {@link WithSynchronizationMethod} , {@link WithSynchronizationBlock}
 */
@Slf4j
public class WithoutSynchronization {

    public static void main(String[] args) throws InterruptedException {
        int correctResult = correctImplementation();
        int wrongResult = wrongImplementation();

        log.info("correctResult={}, wrongResult={}", correctResult, wrongResult);
    }

    private static int correctImplementation() throws InterruptedException {
        Counter counter = new Counter();
        Thread incrementThread = new Thread(new IncrementThread(counter));
        Thread decrementThread = new Thread(new DecrementThread(counter));

        incrementThread.start();
        incrementThread.join();

        decrementThread.start();
        decrementThread.join();

        return counter.getCount();
    }

    private static int wrongImplementation() throws InterruptedException {
        Counter counter = new Counter();
        Thread incrementThread = new Thread(new IncrementThread(counter));
        Thread decrementThread = new Thread(new DecrementThread(counter));

        incrementThread.start();
        decrementThread.start();

        incrementThread.join();
        decrementThread.join();

        return counter.getCount();
    }

    private static class DecrementThread implements Runnable {

        private Counter counter;

        public DecrementThread(Counter counter) {
            this.counter = counter;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                counter.decrement();
            }
        }
    }

    private static class IncrementThread implements Runnable {

        private Counter counter;

        public IncrementThread(Counter counter) {
            this.counter = counter;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                counter.increment();
            }
        }
    }

    private static class Counter {
        private int count = 0;

        public void increment() {
            count++;
        }

        public void decrement() {
            count--;
        }

        public int getCount() {
            return count;
        }
    }
}
