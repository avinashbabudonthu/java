package com.java;

import lombok.Getter;

import java.math.BigInteger;

public class FactorialThread extends Thread{

    private final long inputNumber;

    @Getter
    private Boolean isFinished = false;

    @Getter
    private BigInteger result = BigInteger.ZERO;

    public FactorialThread(long inputNumber){
        this.inputNumber = inputNumber;
    }

    @Override
    public void run() {
        this.result = factorial(inputNumber);
        this.isFinished = true;
    }

    private BigInteger factorial(long inputNumber){
        BigInteger tempResult  = BigInteger.ONE;

        for(long i = inputNumber; inputNumber > 0; i--){
            tempResult = tempResult.multiply(new BigInteger(Long.toString(i)));
        }

        return tempResult;
    }
}
