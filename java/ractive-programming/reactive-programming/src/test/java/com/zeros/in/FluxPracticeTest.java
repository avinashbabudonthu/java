package com.zeros.in;


import com.github.javafaker.Faker;
import com.github.javafaker.Internet;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@Slf4j
public class FluxPracticeTest {

    private static final Consumer<Object> ON_NEXT = (obj) -> log.info("Received={}", obj);
    private static final Consumer<Throwable> ON_ERROR = (e) -> log.info("ERROR={}", e.getMessage());
    private static final Runnable ON_COMPLETE = () -> log.info("Completed");

    private static final Faker FAKER = Faker.instance();

    private List<String> getNames(int count) {
        List<String> list = new ArrayList<>();
        for(int i=0;i<count;i++) {
            list.add(FAKER.name().fullName());
        }
        return list;
    }

    private String[] getNamesArray(int count) {
        String[] names = new String[count];
        for(int i=0;i<count;i++) {
            names[i] = FAKER.name().fullName();
        }
        return names;
    }

    private List<Integer> getNumbers(int count) {
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<count;i++) {
            list.add(FAKER.number().randomDigitNotZero());
        }
        return list;
    }

    @Test
    void just() {
        Flux<String> flux = Flux.just("1");
        log.info("flux={}", flux); // flux=FluxJust

        Flux<String> flux2 = Flux.just("1", "2", "3");
        log.info("flux2={}", flux2); // flux2=FluxArray

        Flux<Object> flux3 = Flux.just("one", 1, 'a', FAKER.name().fullName());
        log.info("flux3={}", flux3); // flux3=FluxArray
    }

    @Test
    void subscribe() {
        /*
        Received=1
        Received=2
        Received=3
        Received=4
        Received=5
        Completed
         */
        Flux<Integer> numbers = Flux.just(1, 2, 3, 4, 5);
        numbers.subscribe(ON_NEXT, ON_ERROR, ON_COMPLETE);

        /*
        Received=one
        Received=1
        Received=a
        Received=Tabitha Baumbach
        Completed
         */
        Flux<Object> objectFlux = Flux.just("one", 1, 'a', FAKER.name().fullName());
        objectFlux.subscribe(ON_NEXT, ON_ERROR, ON_COMPLETE);
    }

    @Test
    void filter() {
        /*
        Received=2
        Received=4
        Received=6
        Received=8
        Received=10
        Completed
         */
        Flux<Integer> integerFlux = Flux.just(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Flux<Integer> evenIntegerFlux = integerFlux.filter(num -> num % 2 == 0);
        evenIntegerFlux.subscribe(ON_NEXT, ON_ERROR, ON_COMPLETE);
    }

    @Test
    void fluxFromList() {
        List<Integer> numbers = getNumbers(10);
        Flux.fromIterable(numbers).subscribe(ON_NEXT);
    }

    @Test
    void fromArray() {
        String[] names = getNamesArray(10);
        Flux.fromArray(names).subscribe(ON_NEXT);
    }

    /*
    Received=Alise Farrell
    Received=Solomon Padberg
    Received=Willis Kemmer
    Received=German Sawayn
    Received=Boyd Bernhard
    Received=Shantay Price
    Received=Greta Bradtke
    Received=Joan Marquardt
    Received=Shannon Klein
    Received=Zackary DuBuque
    Completed
    ERROR=stream has already been operated upon or closed
     */

    /**
     * 2nd time call to subscribe on stream gives error.
     * Refer {@link #fromStreamMultipleTimesSubscribe()} for fix
     *
     */
    @Test
    void fromStream() {
        List<String> names = getNames(10);
        Stream<String> stream = names.stream();
        Flux<String> stringFlux = Flux.fromStream(stream);
        stringFlux.subscribe(ON_NEXT, ON_ERROR, ON_COMPLETE);
        stringFlux.subscribe(ON_NEXT, ON_ERROR, ON_COMPLETE);
    }

    /*
    Received=Blake Hirthe
    Received=Miss Carissa Roob
    Received=John Wiza
    Received=Miss Vi Batz
    Received=Bobbye Ebert Jr.
    Received=Macie Fadel
    Received=Randall Jenkins
    Received=June Bechtelar
    Received=Kendrick Harris
    Received=Evita Fay
    Completed
    Received=Blake Hirthe
    Received=Miss Carissa Roob
    Received=John Wiza
    Received=Miss Vi Batz
    Received=Bobbye Ebert Jr.
    Received=Macie Fadel
    Received=Randall Jenkins
    Received=June Bechtelar
    Received=Kendrick Harris
    Received=Evita Fay
    Completed
     */
    @Test
    void fromStreamMultipleTimesSubscribe() {
        List<String> names = getNames(10);
        Flux<String> stringFlux = Flux.fromStream(names::stream);
        stringFlux.subscribe(ON_NEXT, ON_ERROR, ON_COMPLETE);
        stringFlux.subscribe(ON_NEXT, ON_ERROR, ON_COMPLETE);
    }

    @Test
    void fromRange() {
        Flux<Integer> rangeFlux = Flux.range(1, 20);
        rangeFlux.subscribe(ON_NEXT);

        // print random 10 names
        // Flux.range(1, 10).subscribe((num) -> log.info(FAKER.name().fullName()));
        Flux.range(1, 10).map((num) -> FAKER.name().fullName()).subscribe(ON_NEXT);
    }

    @Test
    void log() {
        Flux<Integer> rangeFlux = Flux.range(2, 10);
        rangeFlux
                .log()
                .map(num -> FAKER.name().fullName())
                .log()
                .subscribe(ON_NEXT, ON_ERROR, ON_COMPLETE);
    }
}