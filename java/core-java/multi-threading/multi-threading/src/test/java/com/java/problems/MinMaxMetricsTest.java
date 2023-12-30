package com.java.problems;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;

@Slf4j
public class MinMaxMetricsTest {

    public static void main(String[] args) {
        MinMaxMetrics minMaxMetrics = new MinMaxMetrics();
        Thread minThread = new Thread(new MinThread(minMaxMetrics));
        Thread maxThread = new Thread(new MaxThread(minMaxMetrics));
        Thread addSampleThread = new Thread(new AddSampleThread(minMaxMetrics));

        minThread.start();
        maxThread.start();
        addSampleThread.start();
    }

    private static class AddSampleThread implements Runnable {
        private final MinMaxMetrics minMaxMetrics;
        private final Random random = new Random();

        public AddSampleThread(MinMaxMetrics minMaxMetrics) {
            this.minMaxMetrics = minMaxMetrics;
        }

        @Override
        public void run() {
            while(true) {
                int newSample = random.nextInt(999);
                minMaxMetrics.addSample(newSample);
                try {
                    Thread.sleep(1000 * 2);
                } catch (InterruptedException e) {
                    log.info("Interrupted AddSampleThread");
                }
            }
        }
    }

    private static class MinThread implements Runnable {

        private final MinMaxMetrics minMaxMetrics;

        public MinThread(MinMaxMetrics minMaxMetrics) {
            this.minMaxMetrics = minMaxMetrics;
        }

        @Override
        public void run() {

            while(true) {
                log.info("min={}", minMaxMetrics.getMin());
                try {
                    Thread.sleep(1000 * 3);
                } catch (InterruptedException e) {
                    log.info("Interrupted AddSampleThread");
                }
            }
        }

    }

    private static class MaxThread implements Runnable {

        private final MinMaxMetrics minMaxMetrics;

        public MaxThread(MinMaxMetrics minMaxMetrics) {
            this.minMaxMetrics = minMaxMetrics;
        }

        @Override
        public void run() {
            while(true) {
                log.info("max={}", minMaxMetrics.getMax());
                try {
                    Thread.sleep(1000 * 4);
                } catch (InterruptedException e) {
                    log.info("Interrupted AddSampleThread");
                }
            }
        }
    }

}
