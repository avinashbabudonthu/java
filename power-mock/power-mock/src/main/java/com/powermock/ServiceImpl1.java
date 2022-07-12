package com.powermock;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ServiceImpl1 implements Service1{

    @Override
    public User getUser(){
        log.info("Getting user");
        return User.builder().firstName("jack").lastName("a").address("there").build();
    }
}