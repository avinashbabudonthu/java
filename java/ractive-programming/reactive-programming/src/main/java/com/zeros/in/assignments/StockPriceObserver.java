package com.zeros.in.assignments;

import com.github.javafaker.Faker;
import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.concurrent.CountDownLatch;

@Slf4j
public class StockPriceObserver {

    public static void main(String[] args) {
        new StockPriceObserver().execute();
    }

    private void sleep(long seconds) {
        try {
            Thread.sleep(1000 * seconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void execute() {

        CountDownLatch countDownLatch = new CountDownLatch(1);
        generateStockPrice().log().subscribeWith(new Subscriber<Integer>() {
            private Subscription subscription;

            @Override
            public void onSubscribe(Subscription subscription) {
                // log.info("received subscription={}", subscription);
                this.subscription = subscription;
                subscription.request(Long.MAX_VALUE);
            }

            @Override
            public void onNext(Integer price) {
                log.info("{} - price={}", LocalDateTime.now(), price);
                if (price > 140) {
                    this.subscription.cancel();
                    countDownLatch.countDown();
                }
            }

            @Override
            public void onError(Throwable throwable) {
                log.info("ERROR={}", throwable.getMessage());
                countDownLatch.countDown();
            }

            @Override
            public void onComplete() {
                log.info("Completed");
                countDownLatch.countDown();
            }
        });

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private Flux<Integer> generateStockPrice() {
        return Flux.interval(Duration.ofSeconds(1)).map(i -> getStockPrice());
    }

    private Integer getStockPrice() {
        return Faker.instance().number().numberBetween(0, 150);
    }
}
