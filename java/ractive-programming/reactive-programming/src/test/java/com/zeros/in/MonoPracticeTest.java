package com.zeros.in;

import com.github.javafaker.Faker;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * Mono creation - just, fromSupplier, fromCallable, fromRunnable, fromFuture
 */
@Slf4j
public class MonoPracticeTest {

    public static final Consumer<Object> ON_NEXT = (str) -> log.info("Received={}", str);
    public static final Consumer<Throwable> ON_ERROR = (err) -> log.info("ERROR={}", err.getMessage());
    public static final Runnable ON_COMPLETED = () -> log.info("Completed");
    private static final Faker FAKER = Faker.instance();

    @Test
    void just() {
        Mono<String> mono = Mono.just("1");
        log.info("mono={}", mono);
    }

    @Test
    void subscribe() {
        Mono<String> mono = Mono.just("Hello Mono");
        log.info("mono={}", mono);

        // below both consumers are valid
        // Consumer<Object> consumer = i -> log.info("received={}", i);
        Consumer<String> consumer = i -> log.info("received={}", i);
        mono.subscribe(consumer);
    }

    @Test
    void subscribe2() {
        Mono<String> mono = Mono.just("Hello World");
        log.info("mono={}", mono);

        // consumer
        Consumer<String> consumer = i -> log.info("{}", i);
        // errorConsumer
        Consumer<Throwable> errorConsumer = error -> log.info("error={}", error.getMessage());
        // completeConsumer
        Runnable completeConsumer = () -> log.info("Completed");

        mono.subscribe(consumer, errorConsumer, completeConsumer);
    }


    @Test
    void subscribeError() {
        Mono<Integer> mono = Mono.just("Hello World").map(String::length).map(l -> l/0);
        log.info("mono={}", mono);

        // consumer
        Consumer<Integer> consumer = i -> log.info("{}", i);
        // errorConsumer
        Consumer<Throwable> errorConsumer = error -> log.info("error={}", error.getMessage());
        // completed
        Runnable completeConsumer = () -> log.info("Completed");

        mono.subscribe(consumer, errorConsumer, completeConsumer);
    }

    @Test
    void emptyOrError() {
        getUser(1).subscribe(ON_NEXT, ON_ERROR, ON_COMPLETED);
        getUser(2).subscribe(ON_NEXT, ON_ERROR, ON_COMPLETED);
        getUser(3).subscribe(ON_NEXT, ON_ERROR, ON_COMPLETED);
    }

    private Mono<String> getUser(int userId) {
        log.info("userId={}", userId);
        if(userId == 1) {
            return Mono.just(FAKER.name().fullName());
        } else if(userId == 2) {
            return Mono.empty();
        } else {
            return Mono.error(new RuntimeException("Not in range"));
        }
    }

    private String getName() {
        log.info("Generating name");
        return FAKER.name().fullName();
    }

    private void sleep(long seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            log.info("Interrupted exception, message={}", e.getMessage());
        }
    }

    private Mono<String> getNameMonoWithSleep() {
        log.info("Inside getNameMonoWithSleep");
        return Mono.fromSupplier(() -> {
            sleep(3);
            return getName();
        }).map(String::toUpperCase);
    }

    @Test
    void fromSupplier() {
        // getName gets invoked if we create mono with method - just
        log.info("Using just");
        Mono<String> monoJust = Mono.just(getName());

        log.info("Using fromSupplier");
        Supplier<String> supplier = this::getName;
        Mono<String> monoSupplier = Mono.fromSupplier(supplier);
        // method will be called only on adding subscriber
        log.info("Using fromSupplier. Adding subscriber");
        monoSupplier.subscribe(ON_NEXT);
    }

    @Test
    void fromCallable() {
        log.info("Using callable");
        Callable<String> callable = this::getName;
        Mono<String> monoCallable = Mono.fromCallable(callable);
        log.info("Adding subscriber");
        monoCallable.subscribe(ON_NEXT);
    }

    @Test
    void block() {
        // below method calls does not execute supplier unless we subscribe
        /*
        Inside getNameMonoWithSleep
        Inside getNameMonoWithSleep
        Inside getNameMonoWithSleep
         */
        // getNameMonoWithSleep();
        // getNameMonoWithSleep();
        // getNameMonoWithSleep();

        // 2nd method executes supplier but does not execute async means blocks 3rd call
        /*
        Inside getNameMonoWithSleep
        Inside getNameMonoWithSleep
        Generating name
        Received=ORALEE MANN
        Inside getNameMonoWithSleep
         */
        // getNameMonoWithSleep();
        // getNameMonoWithSleep().subscribe(ON_NEXT);
        // getNameMonoWithSleep();

        // 2nd method executes supplier & executes async means do not block 3rd call
        // but 2nd method call does not print output because main thread is completed & call executed in different thread
        /*
        Inside getNameMonoWithSleep
        Inside getNameMonoWithSleep
        Inside getNameMonoWithSleep
         */
        // getNameMonoWithSleep();
        // getNameMonoWithSleep().subscribeOn(Schedulers.boundedElastic()).subscribe(ON_NEXT);
        // getNameMonoWithSleep();

        // 2nd method executes supplier & executes async means do not block 3rd call
        // block() makes main thread to wait until execution completes
        // returns value - we need to handle it
        /*
        Inside getNameMonoWithSleep
        Inside getNameMonoWithSleep
        Generating name
        name=SELMA MORAR
        Inside getNameMonoWithSleep
        main
         */
        getNameMonoWithSleep();
        String name = getNameMonoWithSleep().subscribeOn(Schedulers.boundedElastic()).block();
        log.info("name={}", name);
        getNameMonoWithSleep();
        log.info("main");
    }

    private CompletableFuture<String> getNameCompletableFuture() {
        return CompletableFuture.supplyAsync(() -> FAKER.name().fullName());
    }
    @Test
    void fromFuture() {
        // only calling this does not print return because this is not in main. Executing in different thread
        // so blocking main thread with "sleep(2)" for completable future to finish execution
        Mono.fromFuture(getNameCompletableFuture()).subscribe(ON_NEXT);
        sleep(2);
    }

    /**
     * Inside runnable
     * Completed
     */
    @Test
    void fromRunnable() {
        Runnable runnable = () -> log.info("Inside runnable");
        Mono.fromRunnable(runnable).subscribe(ON_NEXT, ON_ERROR, ON_COMPLETED);
    }

}