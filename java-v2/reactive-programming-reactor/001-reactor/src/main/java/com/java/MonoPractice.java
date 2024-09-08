package com.java;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

@Slf4j
public class MonoPractice {

    public static void main(String[] args) {

    }

    private void run() {

    }

    /**
     * [MonoPractice.lambda$just$0] - name=a
     */
    @Test
    public void just() {
        Mono<String> nameMono = Mono.just("a");
        nameMono.subscribe(name -> log.info("name={}", name));
    }


}
