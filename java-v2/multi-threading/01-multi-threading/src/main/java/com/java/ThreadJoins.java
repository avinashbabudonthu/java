package com.java;

public class ThreadJoins {

    public static void main(String[] args) throws InterruptedException {
        new ThreadJoins().execute();
    }

    private void execute() throws InterruptedException {
//        test1();
        test2();
//        test3();
    }

    private static class PrintNumbersThread extends Thread {

        @Override
        public void run() {
            for (int i = 0; i < Integer.MAX_VALUE; i++) {
                System.out.println("thread: " + getName() + ", i = " + i);
                try {
                    Thread.sleep(1000 * 5);
                } catch (InterruptedException e) {
                    System.out.println("exception: " + e.getMessage());
                }
            }
        }

    }

    /**
     * Main thread will wait until t1 & t2 are completed
     */
    private void test1() throws InterruptedException {
        Thread t1 = new PrintNumbersThread();
        t1.setName("Worker thread 1");
        Thread t2 = new PrintNumbersThread();
        t2.setName("Worker thread 2");

        System.out.println("Starting threads");
        t1.start();
        t2.start();
        System.out.println("Started threads");

        t1.join();
        t2.join();

        System.out.println("Completed thread: " + Thread.currentThread().getName());
    }

    /**
     * Main thread will wait for 20 seconds for t1 & t2 to execute. After 20 sec main thread will continue execution.
     * But t1 & t2 keep running after main thread completion
     */
    private void test2() throws InterruptedException {
        Thread t1 = new PrintNumbersThread();
        t1.setName("Worker thread 1");
        Thread t2 = new PrintNumbersThread();
        t2.setName("Worker thread 2");

        System.out.println("Starting threads");
        t1.start();
        t2.start();
        System.out.println("Started threads");

        t1.join(1000 * 20);
        t2.join(1000 * 20);

        System.out.println("Completed thread: " + Thread.currentThread().getName());
    }

    /**
     * Main thread will wait for 20 seconds for t1 & t2 to execute. After 20 sec main thread will continue execution.
     * t1 & t2 will terminate after main thread completion because they are set as daemon threads
     */
    private void test3() throws InterruptedException {
        Thread t1 = new PrintNumbersThread();
        t1.setName("Worker thread 1");
        Thread t2 = new PrintNumbersThread();
        t2.setName("Worker thread 2");

        t1.setDaemon(true);
        t2.setDaemon(true);

        System.out.println("Starting threads");
        t1.start();
        t2.start();
        System.out.println("Started threads");

        t1.join(1000 * 20);
        t2.join(1000 * 20);

        System.out.println("Completed thread: " + Thread.currentThread().getName());
    }


}