package com.java.exceptions;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class RuntimeException1 extends RuntimeException{

    public RuntimeException1(String message){
        super(message);
    }

    public RuntimeException1(Throwable throwable){
        super(throwable);
    }

    public RuntimeException1(String message, Throwable throwable){
        super(message, throwable);
    }

}