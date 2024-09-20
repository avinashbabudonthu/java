package com.java;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.function.Consumer;

@Slf4j
public class MonoPractice {

    /**
     * name=a
     */
    @Test
    public void just() {
        Mono<String> nameMono = Mono.just("a");
        nameMono.subscribe(name -> log.info("name={}", name));
    }

    /**
     * a
     * b
     */
    @Test
    void concatWith() {
        Mono<String> mono1 = Mono.just("a");
        Mono<String> mono2 = Mono.just("b");
        Flux<String> output1 = mono1.concatWith(mono2);
        output1.subscribe(value -> log.info("{}", value));
    }

    @Test
    void subscribe() {
        //a
        Mono<String> mono1 = Mono.just("a");
        Consumer<String> consumer = value -> log.info("{}", value);
        mono1.subscribe(consumer);

        /*
        b
        completed
         */
        Mono<String> mono2 = Mono.just("b");
        Consumer<String> consumer2 = value -> log.info("{}", value);
        Consumer<Throwable> throwableConsumer = error -> log.info("{}", error.getMessage());
        Runnable completeConsumer = () -> log.info("completed");
        mono2.subscribe(consumer2, throwableConsumer, completeConsumer);

        /*
         * error=/ by zero
         */
        Mono<Integer> mono3 = Mono.just("a").map(String::length).map(l -> l/0);
        Consumer<Integer> consumer3 = i -> log.info("{}", i);
        Consumer<Throwable> throwableConsumer3 = error -> log.info("error={}", error.getMessage());
        Runnable completeConsumer3 = () -> log.info("Completed");
        mono3.subscribe(consumer3, throwableConsumer3, completeConsumer3);
    }

}
