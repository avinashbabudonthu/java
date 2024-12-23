package com.practice.java.util;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Queue;

@Slf4j
public class ArrayDeQueueTest {

    @Test
    public void createQueue(){
        Queue<String> queue = new ArrayDeque<>();
        log.info("queue={}", queue);

        Queue<String> queue2 = new ArrayDeque<>(10);
        log.info("queue2={}", queue2);

    }

    /**
     * if queue has place then add element and return true
     * if queue is full throws exception
     */
    @Test
    public void add(){

    }

    /**
     * if queue has place for new element add element and return true
     * if queue is full then do not add new element and return false
     */
    @Test
    public void offer(){

    }

    /**
     * If queue is empty remove will throw an exception
     */
    @Test
    public void remove(){

    }

    /**
     * If queue is empty returns null
     */
    @Test
    public void poll(){

    }

    /**
     * throws exception if queue is empty
     */
    @Test
    public void element(){

    }

    /**
     * returns null if queue is empty
     */
    @Test
    public void peek(){

    }
}
