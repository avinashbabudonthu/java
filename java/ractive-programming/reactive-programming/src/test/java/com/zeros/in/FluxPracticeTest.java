package com.zeros.in;


import com.github.javafaker.Faker;
import com.zeros.in.util.DefaultCustomSubscriber;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@Slf4j
public class FluxPracticeTest {

    private static final Consumer<Object> ON_NEXT = (obj) -> log.info("Received={}", obj);
    private static final Consumer<Throwable> ON_ERROR = (e) -> log.info("ERROR={}", e.getMessage());
    private static final Runnable ON_COMPLETE = () -> log.info("Completed");

    private static final Faker FAKER = Faker.instance();

    private record Student(String name, String course) {
    }

    private List<String> getNames(int count) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            list.add(FAKER.name().fullName());
        }
        return list;
    }

    private List<String> getNamesWithSleep(int count) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            sleep(1);
            list.add(FAKER.name().fullName());
        }
        return list;
    }

    private String getName() {
        sleep(1);
        return FAKER.name().fullName();
    }

    private Flux<String> getNamesWithFlux(int count) {
        return Flux.range(0, count).map(i -> getName());
    }

    private String[] getNamesArray(int count) {
        String[] names = new String[count];
        for (int i = 0; i < count; i++) {
            names[i] = FAKER.name().fullName();
        }
        return names;
    }

    private List<Integer> getNumbers(int count) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            list.add(FAKER.number().randomDigit());
        }
        return list;
    }

    private void sleep(long seconds) {
        try {
            Thread.sleep(1000 * seconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private DefaultCustomSubscriber getDefaultCustomSubscriber() {
        return new DefaultCustomSubscriber();
    }

    private DefaultCustomSubscriber getDefaultCustomSubscriber(String name) {
        return new DefaultCustomSubscriber(name);
    }

    @Test
    void just() {
        Flux<String> flux = Flux.just("1");
        log.info("flux={}", flux); // flux=FluxJust

        Flux<String> flux2 = Flux.just("1", "2", "3");
        log.info("flux2={}", flux2); // flux2=FluxArray

        Flux<Object> flux3 = Flux.just("one", 1, 'a', FAKER.name().fullName(), new Student("jack", "java"));
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
        Received=Student[name=jack, course=java]
        Completed
         */
        Flux<Object> objectFlux = Flux.just("one", 1, 'a', FAKER.name().fullName(), new Student("jack", "java"));
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

    private record CustomSubscriber(AtomicReference<Subscription> atomicReference) implements Subscriber<String> {

        @Override
        public void onSubscribe(Subscription subscription) {
            log.info("Received subscription={}", subscription);
            atomicReference.set(subscription);
        }

        @Override
        public void onNext(String s) {
            log.info("Received={}", s);
        }

        @Override
        public void onError(Throwable throwable) {
            log.info("ERROR={}", throwable.getMessage());
        }

        @Override
        public void onComplete() {
            log.info("Completed");
        }
    }

    @Test
    void customSubscriber() {
        AtomicReference<Subscription> atomicReference = new AtomicReference<>();
        Flux.fromIterable(getNames(10))
                .log()
                .subscribeWith(new CustomSubscriber(atomicReference));
        log.info("sleeping 3 seconds");
        sleep(3);
        log.info("requesting 3 items");
        atomicReference.get().request(3);
        log.info("sleeping 3 seconds");
        sleep(3);
        log.info("requesting 3 items");
        atomicReference.get().request(3);
        log.info("sleeping 3 seconds");
        sleep(3);
        log.info("Canceling subscription");
        atomicReference.get().cancel();
        log.info("subscription cancelled");
        log.info("sleeping 3 seconds");
        sleep(3);
        log.info("requesting 4 items");
        atomicReference.get().request(4);
    }

    /*
    names=[Stanley Cummings, Jame Ullrich IV, Latashia Carroll PhD, Katharina Jakubowski, Mr. Werner Heidenreich]
    Time taken=5 seconds
    Getting names with flux
    Fri Jan 05 14:38:52 IST 2024 - received=Moises Halvorson
    Fri Jan 05 14:38:53 IST 2024 - received=Franklyn Wiegand
    Fri Jan 05 14:38:54 IST 2024 - received=Maricela Thompson V
    Fri Jan 05 14:38:55 IST 2024 - received=Autumn Johnson
    Fri Jan 05 14:38:56 IST 2024 - received=Miss Mckenzie Ritchie
     */
    @Test
    void fluxVsList() {
        long startTimeMillis = System.currentTimeMillis();
        List<String> names = getNamesWithSleep(5);
        log.info("names={}", names);
        long endTimeMillis = System.currentTimeMillis();
        log.info("Time taken={} seconds", (endTimeMillis-startTimeMillis)/1000);

        log.info("Getting names with flux");
        getNamesWithFlux(5).subscribe(
                (name) -> log.info("{} - received={}", new Date(), name)
        );
    }

    /*
    Received=0
    Received=1
    Received=2
    Received=3
    Received=4
     */
    @Test
    void interval() {
        Flux.interval(Duration.ofSeconds(1)).subscribe(ON_NEXT);
        sleep(5);
    }

    /*
    Received=Cyndi Boyle
     */
    @Test
    void fluxFromMono() {
        Mono<String> stringMono = Mono.just(FAKER.name().fullName());
        Flux<String> stringFlux = Flux.from(stringMono);
        stringFlux.subscribe(ON_NEXT);
    }

    @Test
    void monoFromFlux() {
        Flux.fromIterable(getNames(5)).next().subscribe(ON_NEXT, ON_ERROR, ON_COMPLETE);
        // with filter
        Flux.fromIterable(getNumbers(10)).filter(num -> num == 0).next().subscribe(ON_NEXT, ON_ERROR, ON_COMPLETE);
    }

    @Test
    void create() {
        // manually emitting values
        Flux.create(fluxSink -> {
            fluxSink.next(1);
            fluxSink.next(2);
            fluxSink.next(3);
            fluxSink.next(4);
            fluxSink.next(5);
            fluxSink.complete();
        }).subscribe(getDefaultCustomSubscriber("subscriber-1"));

        // emitting with loop
        Flux.create(fluxSink -> {
            for(int i=0;i<20;i++){
                fluxSink.next(FAKER.funnyName().name());
            }
            fluxSink.complete();
        }).subscribe(getDefaultCustomSubscriber("subscriber-2"));
    }

    private static final class NameProducer implements Consumer<FluxSink<String>> {

        private FluxSink<String> stringFluxSink;

        @Override
        public void accept(FluxSink<String> stringFluxSink) {
            this.stringFluxSink = stringFluxSink;
        }

        public void produce() {
            this.stringFluxSink.next(FAKER.name().fullName());
        }

        public void produceWithThreadName(){
            this.stringFluxSink.next(Thread.currentThread().getName() + ": " + FAKER.name().fullName());
        }
    }

    @Test
    void createWithExternalConsumer() {
        NameProducer nameProducer = new NameProducer();
        Flux.create(nameProducer).subscribe(getDefaultCustomSubscriber());
        IntStream.range(0, 10).forEach(value -> nameProducer.produce());
    }

    @Test
    void createWithExternalConsumerAndRunnable() {
        NameProducer nameProducer = new NameProducer();
        Flux.create(nameProducer).subscribe(getDefaultCustomSubscriber());
        Runnable runnable = nameProducer::produceWithThreadName;
        for (int i = 0; i < 10; i++) {
            new Thread(runnable).start();
        }

        sleep(5);
    }

}