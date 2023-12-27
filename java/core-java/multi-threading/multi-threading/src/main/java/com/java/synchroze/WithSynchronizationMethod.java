package com.java.synchroze;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class WithSynchronizationMethod {

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

        public synchronized void increment() {
            count++;
        }

        public synchronized void decrement() {
            count--;
        }

        public int getCount() {
            return count;
        }
    }
}
