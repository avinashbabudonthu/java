package com.zeros.in.util;

import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

@Slf4j
public class DefaultCustomSubscriber implements Subscriber<Object> {

    private String name = "";

    public DefaultCustomSubscriber(){}

    public DefaultCustomSubscriber(String name){
        this.name = name;
    }

    @Override
    public void onSubscribe(Subscription subscription) {
        subscription.request(Long.MAX_VALUE);
    }

    @Override
    public void onNext(Object o) {
        log.info("{} received : {}", name, o);
    }

    @Override
    public void onError(Throwable throwable) {
        log.info("{} error = {}", name, throwable.getMessage());
    }

    @Override
    public void onComplete() {
        log.info("{} completed", name);
    }
}
