package com.java.threads;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NewThread extends Thread{

    @Override
    public void run() {
        log.info("Thread={}", this.getName());
    }

    @Override
    public synchronized void start() {
        log.info("Starting Thread1");
        super.start();
    }
}