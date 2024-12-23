package com.practice.java.util;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Slf4j
public class CollectionsTest {

    @Test
    public void synchronizedList(){
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        log.info("list={}",list);

        List<String> synchronizedList = Collections.synchronizedList(list);
        log.info("synchronizedList={}", synchronizedList);
    }
}
