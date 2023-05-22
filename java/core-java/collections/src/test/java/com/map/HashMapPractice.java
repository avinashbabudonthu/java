package com.map;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class HashMapPractice {

    @Test
    public void create(){
        Map<Integer, String> map = new HashMap<>();
        log.info("map={}", map);
    }

    @Test
    public void put(){
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "1");
        map.put(2, "2");
        map.put(3, "3");
        map.put(4, "4");

        log.info("map={}", map);
    }

    @Test
    public void get(){
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        map.put(4, "four");

        String fourValue = map.get(4);
        log.info("four-value={}", fourValue);
    }

    @Test
    public void getOrDefault(){
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        map.put(4, "four");

        String fourValue = map.getOrDefault(4, "unknown");
        log.info("four-value={}", fourValue);

        String fiveValue = map.getOrDefault(5, "unknown");
        log.info("five-value={}", fiveValue);
    }


    @Test
    public void putAll(){
        Map<Integer, String> map1 = new HashMap<>();
        map1.put(1, "1");
        map1.put(2, "2");
        map1.put(3, "3");
        log.info("map1={}", map1);

        Map<Integer, String> map2 = new HashMap<>();
        map2.put(4, "4");
        map2.put(5, "5");
        log.info("map2={}", map2);

        map1.putAll(map2);
        log.info("map1={}", map1);
    }

    @Test
    public void iterate(){
        Map<Integer, String> names = new HashMap<>();
        names.put(1, "jim");
        names.put(2, "jack");
        names.put(3, "jill");
        names.put(4, "john");

        log.info("-- iterate using for each loop --");
        for(Map.Entry<Integer, String> entry : names.entrySet()){
            log.info("key={}, value={}", entry.getKey(), entry.getValue());
        }

        log.info("-- iterate using stream --");
        names.forEach((key, value) -> log.info("key={}, value={}", key, value));
    }

    @Test
    public void remove(){
        Map<Integer, String> names = new HashMap<>();
        names.put(1, "jim");
        names.put(2, "jack");
        names.put(3, "jill");
        names.put(4, "john");

        log.info("before - names={}", names);

        names.remove(1);
        log.info("after - names={}", names);
    }

    @Test
    public void putIfAbsent(){
        Map<Integer, String> names = new HashMap<>();
        names.put(1, "jim");
        names.put(2, "jack");
        names.put(3, "jill");
        names.put(4, "john");
        log.info("1 - names={}", names); // 1 - names={1=jim, 2=jack, 3=jill, 4=john}

        names.putIfAbsent(5, "ana");
        log.info("2 - names={}", names); // 2 - names={1=jim, 2=jack, 3=jill, 4=john, 5=ana}

        names.putIfAbsent(5, "jane");
        log.info("3 - names={}", names); // 3 - names={1=jim, 2=jack, 3=jill, 4=john, 5=ana}

        names.put(null, "jim");
        log.info("4 - names={}", names); // 4 - names={null=jim, 1=jim, 2=jack, 3=jill, 4=john, 5=ana}

        names.put(5, null);
        log.info("5 - names={}", names); // 5 - names={null=jim, 1=jim, 2=jack, 3=jill, 4=john, 5=null}

        names.put(null, null);
        log.info("6 - names={}", names); // 6 - names={null=null, 1=jim, 2=jack, 3=jill, 4=john, 5=null}
    }

}