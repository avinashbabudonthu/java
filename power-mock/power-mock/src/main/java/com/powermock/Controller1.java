package com.powermock;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Controller1 {

    private ServiceImpl1 serviceImpl1;

    public Controller1(ServiceImpl1 serviceImpl1){
        this.serviceImpl1 = serviceImpl1;
    }

    public User getUser(){
        log.info("Getting user");
        return serviceImpl1.getUser();
    }
}
