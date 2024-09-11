package com.java;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

@Slf4j
public class FluxPracticeTest {

    @Test
    void fromIterable() {
        StepVerifier.create(new FluxPractice().namesFlux())
                .expectNext("a", "b", "c", "d", "e")
                .verifyComplete();
    }

    /**
     * java.lang.AssertionError: expectation "expectNext(b)" failed (expected value: b; actual value: a)
     */
    @Test
    @DisplayName("fromIterable failing case")
    void fromIterable2() {
        StepVerifier.create(new FluxPractice().namesFlux())
                .expectNext("b", "a", "c", "d", "e")
                .verifyComplete();
    }

}