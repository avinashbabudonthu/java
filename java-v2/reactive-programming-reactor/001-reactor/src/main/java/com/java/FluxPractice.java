package com.java;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;

import java.util.List;

@Slf4j
public class FluxPractice {

    public static void main(String[] args) {
        new FluxPractice().run();
    }

    public void run() {
    }

    /**
     * [FluxPractice.lambda$fromIterable$0] - name=a
     * [FluxPractice.lambda$fromIterable$0] - name=b
     * [FluxPractice.lambda$fromIterable$0] - name=c
     * [FluxPractice.lambda$fromIterable$0] - name=d
     * [FluxPractice.lambda$fromIterable$0] - name=e
     */
    @Test
    public void fromIterable() {
        List<String> namesList = List.of("a", "b", "c", "d", "e");
        Flux<String> namesFlux = Flux.fromIterable(namesList);
        namesFlux.subscribe(name -> log.info("name={}", name));
    }

    public Flux<String> namesFlux() {
        List<String> namesList = List.of("a", "b", "c", "d", "e");
        return Flux.fromIterable(namesList);
    }

}