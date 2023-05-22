package com.java.lang;

import lombok.extern.slf4j.Slf4j;
import lombok.SneakyThrows;

@Slf4j
public class ShutdownHook2 {

    /**
     * INFO  com.java.lang.ShutdownHook2:29: i=0
     * INFO  com.java.lang.ShutdownHook2:29: i=1
     * INFO  com.java.lang.ShutdownHook2:29: i=2
     * INFO  com.java.lang.ShutdownHook2:29: i=3
     * INFO  com.java.lang.ShutdownHook2:29: i=4
     * shutdown hook 2
     * shutdown hook 3
     * shutdown hook 4
     * shutdown hook 1
     *
     */
    @SneakyThrows
    public static void main(String[] args) {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("shutdown hook 1");
        }));

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("shutdown hook 2");
        }));

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("shutdown hook 3");
        }));

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("shutdown hook 4");
        }));

        for(int i=0;i<5;i++){
            Thread.sleep(1000);
            log.info("i={}", i);
            if(i == 4)
                System.exit(1);
        }
    }
}
