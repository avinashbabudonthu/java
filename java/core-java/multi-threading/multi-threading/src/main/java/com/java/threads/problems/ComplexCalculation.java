package com.java.threads.problems;

import java.math.BigInteger;

/**
 * Multithreaded Calculation
 * In this coding exercise, you will use all the knowledge from the previous lectures.
 * Before taking the exercise, make sure you review the following topics in particular:
 * 1. Thread Creation - how to create and start a thread using the Thread class and the start() method.
 *
 * 2. Thread Join - how to wait for another thread using the Thread.join() method.
 *
 *In this exercise, we will efficiently calculate the following result = base1 ^ power1 + base2 ^ power2
 *
 * Where a^b means: a raised to the power of b.
 *
 * For example 10^2 = 100
 *
 * We know that raising a number to a power is a complex computation, so we like to execute:
 *
 * result1 = x1 ^ y1
 *
 * result2 = x2 ^ y2
 *
 * In parallel.
 *
 * and combine the result in the end : result = result1 + result2
 *
 * This way, we can speed up the entire calculation.
 * Note : base1 >= 0, base2 >= 0, power1 >= 0, power2 >= 0
 */
public class ComplexCalculation {

    public static void main(String[] args) throws InterruptedException {
        new ComplexCalculation().calculateResult(new BigInteger("10"), new BigInteger("2"), new BigInteger("10"), new BigInteger("3"));
        new ComplexCalculation().calculateResult(new BigInteger("11"), new BigInteger("2"), new BigInteger("12"), new BigInteger("2"));
        new ComplexCalculation().calculateResult(new BigInteger("13"), new BigInteger("2"), new BigInteger("14"), new BigInteger("2"));
        new ComplexCalculation().calculateResult(new BigInteger("3"), new BigInteger("10"), new BigInteger("2"), new BigInteger("6"));
    }

    public BigInteger calculateResult(BigInteger base1, BigInteger power1, BigInteger base2, BigInteger power2) throws InterruptedException{
        BigInteger result;
        /*
            Calculate result = ( base1 ^ power1 ) + (base2 ^ power2).
            Where each calculation in (..) is calculated on a different thread
        */
        PowerCalculatingThread t1 = new PowerCalculatingThread(base1, power1);
        PowerCalculatingThread t2 = new PowerCalculatingThread(base2, power2);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        BigInteger result1 = t1.getResult();
        BigInteger result2 = t2.getResult();
        result = result1.add(result2);

        System.out.println(base1 + "^" + power1 + " = " + result1 + ", " + base2 + "^" + power2 + " = " + result2 + ", (" + result1 + "+" + result2 + ") = " + result);

        return result;
    }

    private static class PowerCalculatingThread extends Thread {
        private BigInteger result = BigInteger.ONE;
        private BigInteger base;
        private BigInteger power;

        public PowerCalculatingThread(BigInteger base, BigInteger power) {
            this.base = base;
            this.power = power;
        }

        @Override
        public void run() {
           /*
           Implement the calculation of result = base ^ power
           */
            result = base.pow(power.intValueExact());
        }

        public BigInteger getResult() {
            return result;
        }
    }

}
