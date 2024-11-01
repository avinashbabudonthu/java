package com.practice.java.util.stream;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.PrimitiveIterator;
import java.util.stream.IntStream;

@Slf4j
public class IntStreamTest {

    /**
     * 1
     * 2
     * 3
     * 4
     */
    @Test
    void range() {
        IntStream intStream = IntStream.range(1, 5);
        intStream.forEach(System.out::println);
    }

    /**
     * 1
     * 2
     * 3
     * 4
     * 5
     */
    @Test
    void rangeClosed() {
        IntStream intStream = IntStream.rangeClosed(1, 5);
        intStream.forEach(System.out::println);
    }

    /**
     * 1
     * 2
     * 3
     * 4
     * 5
     */
    @Test
    void of() {
        IntStream intStream = IntStream.of(1, 2, 3, 4, 5);
        intStream.forEach(System.out::println);
    }

    /**
     * 1
     * 2
     * 3
     * 4
     */
    @Test
    void iterator() {
        IntStream intStream = IntStream.range(1, 5);
        PrimitiveIterator.OfInt primitiveIterator = intStream.iterator();
        while (primitiveIterator.hasNext()) {
            log.info("{}", primitiveIterator.next());
        }
    }

    /**
     * 2
     * 4
     * 6
     * 8
     */
    @Test
    void map() {
        IntStream intStream = IntStream.range(1, 5);
        IntStream intStream2 = intStream.map(num -> num * 2);
        intStream2.forEach(System.out::println);
    }

    /**
     * 6
     * 7
     * 8
     * 9
     *
     * 6
     * 7
     * 8
     * 9
     *
     * 6
     * 7
     * 8
     * 9
     *
     * 6
     * 7
     * 8
     * 9
     */
    @Test
    void flatMap() {
        IntStream intStream = IntStream.range(1, 5);
        intStream.flatMap(num -> IntStream.of(6,7,8,9)).forEach(System.out::println);
    }

    /**
     * 4
     */
    @Test
    void count() {
        IntStream intStream = IntStream.range(1, 5);
        log.info("{}", intStream.count());
    }

    /**
     * 0
     */
    @Test
    void empty() {
        IntStream intStream = IntStream.empty();
        log.info("{}", intStream.count());
    }

}