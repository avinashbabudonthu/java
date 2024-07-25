package com.java;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Code without synchronization & with synchronization
 */
public class SynchronizationExample {

    public static void main(String[] args) throws InterruptedException {
        new SynchronizationExample().execute();
    }

    private void execute() throws InterruptedException {
//        synchronizedIssue();
//        synchronizedSolution();
//        synchronizedMethodIssue();
//        synchronizedMethodSolution();
        atomicInteger();
    }

    private static class Calculate {

        private int i = 0;

        public void increment() {
            i++;
        }

        public void decrement() {
            i--;
        }

        public int getI() {
            return i;
        }

    }

    private static class Calculate2 {

        private int i = 0;

        public synchronized void increment() {
            i++;
        }

        public synchronized void decrement() {
            i--;
        }

        public int getI() {
            return i;
        }

    }


    // synchronized issue
    private void synchronizedIssue() throws InterruptedException {
        Calculate calculate = new Calculate();

        for (int j = 0; j < 20; j++) {
            Thread incrementThread = new Thread(
                    () -> {
                        for (int i = 0; i < 10000; i++) {
                            calculate.increment();
                        }
                    }
            );

            Thread decrementThread = new Thread(
                    () -> {
                        for (int i = 0; i < 10000; i++) {
                            calculate.decrement();
                        }
                    }
            );


            incrementThread.start();
            decrementThread.start();

            incrementThread.join();
            decrementThread.join();

            System.out.println("i=" + calculate.getI());
        }

    }


    // synchronized method
    private void synchronizedSolution() throws InterruptedException {
        Calculate2 calculate = new Calculate2();

        for (int j = 0; j < 20; j++) {
            Thread incrementThread = new Thread(
                    () -> {
                        for (int i = 0; i < 10000; i++) {
                            calculate.increment();
                        }
                    }
            );

            Thread decrementThread = new Thread(
                    () -> {
                        for (int i = 0; i < 10000; i++) {
                            calculate.decrement();
                        }
                    }
            );


            incrementThread.start();
            decrementThread.start();

            incrementThread.join();
            decrementThread.join();

            System.out.println("i=" + calculate.getI());
        }

    }

    private static class Calculate3 {

        private int i = 0;
        private int j = 0;

        public synchronized void increment() {
            System.out.println("increment i by thread: " + Thread.currentThread().getName());
            i++;
        }

        public synchronized void decrement() {
            System.out.println("decrement i by thread: " + Thread.currentThread().getName());
            i--;
        }

        public synchronized void incrementJ() {
            System.out.println("increment j by thread: " + Thread.currentThread().getName());
            j++;
        }

        public int getI() {
            return i;
        }

        public int getJ() {
            return j;
        }
    }

    // synchronized method issue
    private void synchronizedMethodIssue() throws InterruptedException {
        Calculate3 calculate = new Calculate3();

        Thread incrementThread = new Thread(
                () -> {
                    for (int i = 0; i < 50; i++) {
                        calculate.increment();
                    }
                }
        );

        Thread decrementThread = new Thread(
                () -> {
                    for (int i = 0; i < 50; i++) {
                        calculate.decrement();
                    }
                }
        );

        Thread incrementJThread = new Thread(
                () -> {
                    for (int i = 0; i < 50; i++) {
                        calculate.incrementJ();
                    }
                }
        );


        incrementThread.start();
        decrementThread.start();
        incrementJThread.start();

        incrementThread.join();
        decrementThread.join();
        incrementJThread.join();

        System.out.println("i=" + calculate.getI());
        System.out.println("j=" + calculate.getJ());
    }


    // synchronized block

    private static class Calculate4 {

        private int i = 0;
        private int j = 0;

        private final Object lock1 = new Object();
        private final Object lock2 = new Object();

        public void increment() {
            synchronized (lock1) {
                System.out.println("increment i by thread: " + Thread.currentThread().getName());

                i++;
            }
        }

        public synchronized void decrement() {
            synchronized (lock1) {
                System.out.println("decrement i by thread: " + Thread.currentThread().getName());
                i--;
            }
        }

        public void incrementJ() {
            synchronized (lock2) {
                System.out.println("increment j by thread: " + Thread.currentThread().getName());
                j++;
            }
        }

        public int getI() {
            return i;
        }

        public int getJ() {
            return j;
        }

    }

    private void synchronizedMethodSolution() throws InterruptedException {
        Calculate4 calculate = new Calculate4();

        Thread incrementThread = new Thread(
                () -> {
                    for (int i = 0; i < 50; i++) {
                        calculate.increment();
                    }
                }
        );

        Thread decrementThread = new Thread(
                () -> {
                    for (int i = 0; i < 50; i++) {
                        calculate.decrement();
                    }
                }
        );

        Thread incrementJThread = new Thread(
                () -> {
                    for (int i = 0; i < 50; i++) {
                        calculate.incrementJ();
                    }
                }
        );

        incrementThread.start();
        decrementThread.start();
        incrementJThread.start();

        incrementThread.join();
        decrementThread.join();
        incrementJThread.join();

        System.out.println("i=" + calculate.getI());
        System.out.println("j=" + calculate.getJ());
    }

    private static class Calculate5 {

        private AtomicInteger i = new AtomicInteger(0);
        public void increment() {
            i.incrementAndGet();
        }

        public synchronized void decrement() {
            i.decrementAndGet();
        }

        public AtomicInteger getI() {
            return i;
        }

    }

    private void atomicInteger() throws InterruptedException {
        Calculate5 calculate = new Calculate5();

        Thread incrementThread = new Thread(
                () -> {
                    for (int i = 0; i < 50; i++) {
                        calculate.increment();
                    }
                }
        );

        Thread decrementThread = new Thread(
                () -> {
                    for (int i = 0; i < 50; i++) {
                        calculate.decrement();
                    }
                }
        );


        incrementThread.start();
        decrementThread.start();

        incrementThread.join();
        decrementThread.join();

        System.out.println("i=" + calculate.getI());
    }



}