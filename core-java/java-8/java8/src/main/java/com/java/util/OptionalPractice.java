package com.java.util;

import org.junit.Test;

import java.util.Optional;

public class OptionalPractice {

    /**
     * Output:
     * Optional.empty
     */
    @Test
    public void empty() {
        Optional<String> emptyOptional = Optional.empty();
        System.out.println(emptyOptional);
    }

    /**
     * Output:
     * Optional[ana]
     */
    @Test
    public void ofV1() {
        Optional<String> nonNullOptional = Optional.of("ana");
        System.out.println(nonNullOptional);
    }

    /**
     * java.lang.NullPointerException
     * at java.util.Objects.requireNonNull(Objects.java:203)
     */
    @Test
    public void ofV2() {
        String name = null;
        Optional.of(name);
    }

    /**
     * Output:
     * Optional[ana]
     */
    @Test
    public void ofNullable() {
        Optional<String> nonNullOptional = Optional.ofNullable("ana");
        System.out.println(nonNullOptional);
    }

    /**
     * Output:
     * Optional.empty
     */
    @Test
    public void ofNullablefV2() {
        String name = null;
        Optional<String> nonNullOptional = Optional.ofNullable(name);
        System.out.println(nonNullOptional);
    }

    /**
     * Output:
     * true
     */
    @SuppressWarnings("all")
    @Test
    public void isPresent() {
        Optional<String> nonNullOptional = Optional.ofNullable("ana");
        System.out.println(nonNullOptional.isPresent());
    }

    /**
     * The orElse() method is used to retrieve the value wrapped inside an Optional instance. 
     * It takes one parameter, which acts as a default value. 
     * The orElse() method returns the wrapped value if it's present, and its argument otherwise
     * <p>
     * Output:
     * ana
     */
    @Test
    public void orElse() {
        String nullName = null;
        String name = Optional.ofNullable(nullName).orElse("ana");
        System.out.println(name);
    }

    /**
     * The orElseGet() method is similar to orElse(). 
     * However, instead of taking a value to return if the Optional value is not present, it takes a supplier functional interface, 
     * which is invoked and returns the value of the invocation
     * <p>
     * Output:
     * ana
     */
    @Test
    public void orElseGet() {
        String nullName = null;
        String name = Optional.ofNullable(nullName).orElseGet(() -> "ana");
        System.out.println(name);
    }
}
