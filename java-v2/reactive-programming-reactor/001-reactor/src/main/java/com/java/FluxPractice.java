package com.java;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;
import java.util.function.Function;

@Slf4j
public class FluxPractice {

    /**
     * Create flux using - just
     * a
     * b
     * c
     * d
     * e
     */
    @Test
    public void just() {
        Flux<String> inputFlux = Flux.just("a", "b", "c", "d", "e");
        inputFlux.subscribe(value -> log.info("{}", value));
    }

    /**
     * Create flux from list using - fromIterable
     * name=a
     * name=b
     * name=c
     * name=d
     * name=e
     */
    @Test
    public void fromIterable() {
        List<String> namesList = List.of("a", "b", "c", "d", "e");
        Flux<String> namesFlux = Flux.fromIterable(namesList);
        namesFlux.subscribe(name -> log.info("name={}", name));
    }

    /**
     * Create flux using - fromArray
     *  a
     *  b
     *  c
     *  d
     *  e
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
     * value=A
     * value=B
     * value=C
     * value=D
     * value=E
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
        bbb
        bbbb
        bbbbb*/
        Flux<String> outputFlux = inputFlux.filter(value -> value.length() >= 3);
        outputFlux.subscribe(value -> log.info("{}", value));
    }

    /**
     * a
     * b
     * c
     * d
     * e
     * f
     * g
     * h
     * i
     * j
     * k
     * l
     * m
     * n
     * o
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
     * BBBB
     *
     * BBBBB
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
     * a
     * b
     * c
     * d
     * e
     * f
     */
    @Test
    void concat() {
        Flux<String> flux1 = Flux.just("a", "b", "c");
        Flux<String> flux2 = Flux.just("d", "e", "f");
        Flux<String> output1 = Flux.concat(flux1, flux2);
        output1.subscribe(value -> log.info("{}", value));
    }

    @Test
    void merge(){
        Flux<String> flux1 = Flux.just("a", "b", "c");
//                .delayElements(Duration.ofMillis(100));
        Flux<String> flux2 = Flux.just("d", "e", "f");
//                .delayElements(Duration.ofMillis(125));
        Flux<String> output1 = Flux.merge(flux1, flux2);
        output1.subscribe(value -> log.info("{}", value));
    }

    @Test
    void zip() {

    }

    @Test
    void zipWith() {

    }

}