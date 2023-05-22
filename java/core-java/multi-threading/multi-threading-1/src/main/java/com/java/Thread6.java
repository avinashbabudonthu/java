package com.java;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Thread6 extends Thread{

    @Override
    public void run() {
        log.info("inside Thread1.run method, name={}, id={}", this.getName(), this.getId());
    }

}