package com.ab.java.lang;

public class ShutdownHook1 {

    /**
     * program started
     * waiting 3 seconds
     * program completed
     * shutdown hook 1
     * shutdown hook 2
     */
    public static void main(String[] args) throws Exception {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("shutdown hook 1");
        }));

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("shutdown hook 2");
        }));

        System.out.println("program started");
        System.out.println("waiting 3 seconds");
        Thread.sleep(1000 * 3);
        System.out.println("program completed");
    }
}
