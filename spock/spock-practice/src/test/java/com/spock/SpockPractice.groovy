package com.spock

import org.junit.Test
import spock.lang.Specification

class SpockPractice extends  Specification{

    @Test
    void helloWorld(){
        println "hello world"
    }

    @Test
    void "should return 2 from first element of list"(){
        given:
            List<Integer> list = new ArrayList<>()
        when:
            list.add(2)
        then:
            2 == list.get(0)
    }

    @Test
    void "stub practice"(){
        given:
            List<Integer> list = Stub()
        when:
            list.size() >> 3
        then:
            3 == list.size()
    }
}