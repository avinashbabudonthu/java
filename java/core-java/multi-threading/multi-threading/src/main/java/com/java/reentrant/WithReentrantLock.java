package com.java.reentrant;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
public class WithReentrantLock {

    public static void main(String[] args) throws InterruptedException {
        int correctResult = correctImplementation();
        int wrongResult = wrongImplementation();

        log.info("correctResult={}, wrongResult={}", correctResult, wrongResult);
    }

    private static class Counter {
        private int count = 0;
        private final Lock lock = new ReentrantLock();

        public void increment() {
            try {
                lock.lock();
                count++;
            } finally {
                lock.unlock();
            }

        }

        public void decrement() {
            try {
                lock.lock();
                count--;
            } finally {
                lock.unlock();
            }
        }

        public int getCount() {
            return count;
        }
    }

    private static int correctImplementation() throws InterruptedException {
        WithReentrantLock.Counter counter = new WithReentrantLock.Counter();
        Thread incrementThread = new Thread(new WithReentrantLock.IncrementThread(counter));
        Thread decrementThread = new Thread(new WithReentrantLock.DecrementThread(counter));

        incrementThread.start();
        incrementThread.join();

        decrementThread.start();
        decrementThread.join();

        return counter.getCount();
    }

    private static int wrongImplementation() throws InterruptedException {
        WithReentrantLock.Counter counter = new WithReentrantLock.Counter();
        Thread incrementThread = new Thread(new WithReentrantLock.IncrementThread(counter));
        Thread decrementThread = new Thread(new WithReentrantLock.DecrementThread(counter));

        incrementThread.start();
        decrementThread.start();

        incrementThread.join();
        decrementThread.join();

        return counter.getCount();
    }

    private static class DecrementThread implements Runnable {

        private WithReentrantLock.Counter counter;

        public DecrementThread(WithReentrantLock.Counter counter) {
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

        private WithReentrantLock.Counter counter;

        public IncrementThread(WithReentrantLock.Counter counter) {
            this.counter = counter;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                counter.increment();
            }
        }
    }


}
