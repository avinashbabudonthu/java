package com.list;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Slf4j
public class CopyOnWriteArrayListPractice {

    @Test
    public void add(){
        List<String> list = new CopyOnWriteArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        log.info("list={}", list);
    }

    /**
     * 1. The "snapshot" style iterator method uses a reference to the state of the array at the point that the iterator was created.
     * 2. This array never changes during the lifetime of the iterator, so interference is impossible and the iterator is guaranteed not to throw ConcurrentModificationException.
     * 3. The iterator will not reflect additions, removals, or changes to the list since the iterator was created.
     * 4. Element-changing operations on iterators themselves (remove, set, and add) are not supported. These methods throw UnsupportedOperationException
     */
    @Test
    public void addWhileIteration(){
        List<Integer> numbers = new CopyOnWriteArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);

        log.info("before numbers={}",numbers);

        log.info("--- create iterator --");
        Iterator<Integer> iterator = numbers.iterator();
        numbers.add(5);

        while(iterator.hasNext()){
            log.info("element={}",iterator.next());
        }

        log.info("-- new iterator --");
        iterator = numbers.iterator();
        while(iterator.hasNext()){
            log.info("element={}",iterator.next());
        }
    }
}
