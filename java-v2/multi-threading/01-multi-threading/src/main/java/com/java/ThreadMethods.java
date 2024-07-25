package com.java;

public class ThreadMethods {

    public static void main(String[] args) {
        new ThreadMethods().execute();
    }

    private void execute() {
//        setName();
//        setPriority();
//        setUncaughtExceptionHandler();
        interrupt();
    }

    /**
     * Output:
     * Inside thread: main, before starting new thread
     * Inside thread: main, after starting new thread
     * Inside thread: My thread
     */
    private void setName() {
        Thread t1 = new Thread(() -> System.out.println("Inside thread: " + Thread.currentThread().getName()));
        t1.setName("My thread");
        System.out.println("Inside thread: " + Thread.currentThread().getName() + ", before starting new thread");
        t1.start();
        System.out.println("Inside thread: " + Thread.currentThread().getName() + ", after starting new thread");
    }

    /**
     * Output:
     * Inside thread: main, before starting new thread
     * Inside thread: main, after starting new thread
     * Inside thread: My thread with priority: 10
     */
    private void setPriority() {
        Thread t1 = new Thread(() -> System.out.println("Inside thread: " + Thread.currentThread().getName() + " with priority: " + Thread.currentThread().getPriority()));
        t1.setName("My thread");
        t1.setPriority(Thread.MAX_PRIORITY);
        System.out.println("Inside thread: " + Thread.currentThread().getName() + ", before starting new thread");
        t1.start();
        System.out.println("Inside thread: " + Thread.currentThread().getName() + ", after starting new thread");
    }

    /**
     * Output:
     * Inside thread: Problem thread, Exception thrown from thread: Problem thread, exception message: Dummy exception
     */
    private void setUncaughtExceptionHandler() {
        Thread t1 = new Thread(
                () -> {
                    throw new RuntimeException("Dummy exception");
                }
        );
        t1.setName("Problem thread");
        t1.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("Inside thread: " + Thread.currentThread().getName() + ", Exception thrown from thread: " + t.getName() + ", exception message: " + e.getMessage());
            }
        });
        t1.start();
    }

    private static class BlockingThread extends Thread {
        @Override
        public void run() {
            try {
                Thread.sleep(1000 * 60 * 60);
            } catch (Exception e) {
                // below 2 lines are same. Since we extend Thread, isInterrupted() is inherited. So we can directly call
                // System.out.println("Exiting blocking thread: " + Thread.currentThread().getName() + ", isInterrupted: " + Thread.currentThread().isInterrupted());

                System.out.println("Exiting blocking thread: " + Thread.currentThread().getName() + ", isInterrupted: " + isInterrupted());
            }
        }
    }

    /**
     * Output
     * Exiting blocking thread: Blocking thread, isInterrupted: false
     */
    private void interrupt() {
        Thread t1 = new BlockingThread();
        t1.setName("Blocking thread");
        t1.start();
        t1.interrupt();
    }

}