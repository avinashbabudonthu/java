package com.java;

import com.java.threads.BlockingThread;

public class BlockingThreadTest {

    public static void main(String[] args) {
        Thread t1 = new Thread(new BlockingThread());
        t1.start();
        t1.interrupt();
    }

}
