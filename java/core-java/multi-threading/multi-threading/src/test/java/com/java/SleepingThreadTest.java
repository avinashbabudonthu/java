package com.java;

import com.java.threads.SleepingThread;

public class SleepingThreadTest {

    public static void main(String[] args) {
        Thread t1 = new Thread(new SleepingThread());
        t1.start();
        t1.interrupt();
    }
}
