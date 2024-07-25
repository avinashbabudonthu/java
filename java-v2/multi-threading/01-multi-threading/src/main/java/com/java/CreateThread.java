package com.java;

import java.util.ArrayList;
import java.util.List;

public class CreateThread {

    public static void main(String[] args) throws Exception {
        new CreateThread().execute();
    }

    private void execute() throws Exception {
//        method1();
//        method2();
//        method3();
        startMultipleThreads();
//        printLogBeforeStartingThread();
    }

    /**
     * Using Thread constructor, passing Runnable object
     */
    private void method1() throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Inside " + Thread.currentThread().getName());
            }
        });

        System.out.println("Inside thread: " + Thread.currentThread().getName() + ", before starting new thread");
        t1.start();
        System.out.println("Inside thread: " + Thread.currentThread().getName() + ", after starting new thread");

        Thread.sleep(1000);
    }

    /**
     * Using Thread constructor, passing Runnable object as lambda
     */
    private void method2() throws InterruptedException {
        Thread t1 = new Thread(() -> System.out.println("Inside " + Thread.currentThread().getName()));

        System.out.println("Inside thread: " + Thread.currentThread().getName() + ", before starting new thread");
        t1.start();
        System.out.println("Inside thread: " + Thread.currentThread().getName() + ", after starting new thread");

        Thread.sleep(1000);
    }

    private static class NewThread extends Thread {
        @Override
        public void run() {
            // below 2 lines are same. since we extend Thread, we get inherited methods
//            System.out.println("Inside thread: " + Thread.currentThread().getName());
            System.out.println("Inside thread: " + this.getName());
        }
    }

    /**
     * Create new class extends Thread. Refer NewThread above
     * Output:
     * Inside thread: My thread
     */
    private void method3() {
        Thread t1 = new NewThread();
        t1.setName("My thread");
        t1.start();
    }

    /**
     * Start multiple threads
     * Output: Order may vary in each execution
     * Inside: Thread-1
     * Inside: Thread-0
     * Inside: Thread-2
     */
    private void startMultipleThreads() {
        Thread t1 = new Thread(() -> System.out.println("Inside: " + Thread.currentThread().getName()));
        Thread t2 = new Thread(() -> System.out.println("Inside: " + Thread.currentThread().getName()));
        Thread t3 = new Thread(() -> System.out.println("Inside: " + Thread.currentThread().getName()));

        List<Thread> threads = new ArrayList<>();
        threads.add(t1);
        threads.add(t2);
        threads.add(t3);

        for(Thread thread : threads) {
            thread.start();
        }
    }

    private static class NewThread2 extends Thread {

        @Override
        public void run() {
            System.out.println("Inside thread: " + Thread.currentThread().getName());
        }

        @Override
        public void start() {
            System.out.println("Starting thread: " + Thread.currentThread().getName() +", this thread: " + this.getName());
            super.start();
        }
    }

    /**
     * Since we extends {@link java.lang.Thread} we can override Thread.start method
     * Output:
     * Starting thread: main, this thread: My thread
     * Inside thread: My thread
     */
    private void printLogBeforeStartingThread() {
        Thread t1 = new NewThread2();
        t1.setName("My thread");
        t1.start();
    }

}