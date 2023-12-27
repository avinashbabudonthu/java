package com.java;

import com.java.threads.NewThread;

public class NewThreadTest {

    public static void main(String[] args) {
        Thread t1 = new Thread(new NewThread());
        t1.start();
    }
}
