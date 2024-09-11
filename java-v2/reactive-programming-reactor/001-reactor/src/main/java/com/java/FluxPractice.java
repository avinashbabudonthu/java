package com.java;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.function.Function;

@Slf4j
public class FluxPractice {

    /**
     * Create flux using - just
     * [FluxPractice.lambda$just$0] - a
     * [FluxPractice.lambda$just$0] - b
     * [FluxPractice.lambda$just$0] - c
     * [FluxPractice.lambda$just$0] - d
     * [FluxPractice.lambda$just$0] - e
     */
    @Test
    public void just() {
        Flux<String> inputFlux = Flux.just("a", "b", "c", "d", "e");
        inputFlux.subscribe(value -> log.info("{}", value));
    }

    /**
     * Create flux from list using - fromIterable
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

    /**
     * [FluxPractice.lambda$fromArray$2] - a
     * [FluxPractice.lambda$fromArray$2] - b
     * [FluxPractice.lambda$fromArray$2] - c
     * [FluxPractice.lambda$fromArray$2] - d
     * [FluxPractice.lambda$fromArray$2] - e
     */
    @Test
    void fromArray() {
        Flux<String> inputFlux = Flux.fromArray(new String[]{"a", "b", "c", "d", "e"});
        inputFlux.subscribe(value -> log.info("{}", value));
    }

    /**
     * Used by test case. Refer src/test/java/com/java/FluxPracticeTest.java
     * @return
     */
    public Flux<String> namesFlux() {
        List<String> namesList = List.of("a", "b", "c", "d", "e");
        return Flux.fromIterable(namesList);
    }

    /**
     * Map method. Similar to stream map.
     * Used to transform flux data.
     * In this example converting to upper case.
     *
     * [FluxPractice.lambda$map$1] - value=A
     * [FluxPractice.lambda$map$1] - value=B
     * [FluxPractice.lambda$map$1] - value=C
     * [FluxPractice.lambda$map$1] - value=D
     * [FluxPractice.lambda$map$1] - value=E
     */
    @Test
    public void map() {
        Flux<String> inputFlux = Flux.fromIterable(List.of("a", "b", "c", "d", "e"));
        Flux<String> outputFlux = inputFlux.map(String::toUpperCase);
        outputFlux.subscribe(value -> log.info("value={}", value));
    }

    @Test
    public void filter() {
        Flux<String> inputFlux = Flux.just("b", "bb", "bbb", "bbbb", "bbbbb");

        // filter string with length < 3
        /* Output:
        [FluxPractice.lambda$filter$4] - bbb
        [FluxPractice.lambda$filter$4] - bbbb
        [FluxPractice.lambda$filter$4] - bbbbb*/
        Flux<String> outputFlux = inputFlux.filter(value -> value.length() >= 3);
        outputFlux.subscribe(value -> log.info("{}", value));
    }

    /**
     * [FluxPractice.lambda$flatMap$6] - a
     * [FluxPractice.lambda$flatMap$6] - b
     * [FluxPractice.lambda$flatMap$6] - c
     * [FluxPractice.lambda$flatMap$6] - d
     * [FluxPractice.lambda$flatMap$6] - e
     * [FluxPractice.lambda$flatMap$6] - f
     * [FluxPractice.lambda$flatMap$6] - g
     * [FluxPractice.lambda$flatMap$6] - h
     * [FluxPractice.lambda$flatMap$6] - i
     * [FluxPractice.lambda$flatMap$6] - j
     * [FluxPractice.lambda$flatMap$6] - k
     * [FluxPractice.lambda$flatMap$6] - l
     * [FluxPractice.lambda$flatMap$6] - m
     * [FluxPractice.lambda$flatMap$6] - n
     * [FluxPractice.lambda$flatMap$6] - o
     */
    @Test
    void flatMap() {
        List<String> namesList = List.of("abc", "def", "ghi", "jkl", "mno");
        Flux<String> inputFlux = Flux.fromIterable(namesList);
        Flux<String> outputFlux = inputFlux.flatMap(this::splitToCharacters);
        outputFlux.subscribe(value -> log.info("{}", value));
    }

    private Flux<String> splitToCharacters(String inputString) {
        return Flux.fromArray(inputString.split(""));
    }

    /**
     * [FluxPractice.lambda$transform$9] - BBBB
     * [FluxPractice.lambda$transform$9] - BBBBB
     */
    @Test
    void transform() {
        Flux<String> inputFlux = Flux.just("b", "bb", "bbb", "bbbb", "bbbbb");
        Function<Flux<String>, Flux<String>> filterFunction = name -> name.map(String::toUpperCase)
                .filter(name2 -> name2.length() > 3);
        Flux<String> outputFlux = inputFlux.transform(filterFunction);
        outputFlux.subscribe(value -> log.info("{}", value));
    }

    /**
     * [FluxPractice.lambda$concat$10] - a
     * [FluxPractice.lambda$concat$10] - b
     * [FluxPractice.lambda$concat$10] - c
     * [FluxPractice.lambda$concat$10] - d
     * [FluxPractice.lambda$concat$10] - e
     * [FluxPractice.lambda$concat$10] - f
     */
    @Test
    void concat() {
        Flux<String> flux1 = Flux.just("a", "b", "c");
        Flux<String> flux2 = Flux.just("d", "e", "f");
        Flux<String> output1 = Flux.concat(flux1, flux2);
        output1.subscribe(value -> log.info("{}", value));
    }

}