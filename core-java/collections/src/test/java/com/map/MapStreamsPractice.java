package com.map;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class MapStreamsPractice {

    @Test
    public void iterate(){
        Map<String, String> map = new HashMap<>();
        map.put("1", "one");
        map.put("2", "two");
        map.put("3", "three");
        map.put("4", "four");

        map.forEach((key, value) -> log.info("key={}, value={}", key, value));
    }
}
