package com.java;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@Slf4j
public class ThreadPools {

    public static void main(String[] args) {
        Executor executor = Executors.newFixedThreadPool(4);
        executor.execute(new Thread1());
        executor.execute(new Thread1());
        executor.execute(new Thread1());
        executor.execute(new Thread1());
        executor.execute(new Thread1());
        executor.execute(new Thread1());
        executor.execute(new Thread1());
    }

    private static final class Thread1 implements Runnable {
        @Override
        public void run() {
            log.info("name={}, Executing Thread1", Thread.currentThread().getName());
        }
    }

}
