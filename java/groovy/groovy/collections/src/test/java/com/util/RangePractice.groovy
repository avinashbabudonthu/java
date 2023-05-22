package com.util

import org.junit.Test

class RangePractice {

    @Test
    void rangeOfNumbers(){
        def numbers = 1..10
        println "$numbers" // [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
        println "from = $numbers.from" // from = 1
        println "to = $numbers.to" // to = 10

        // print each number
        for(number in numbers){
            println "$number"
        }
    }

    @Test
    void rangeOfLetters(){
        def letters = 'a'..'z'
        for(letter in letters){
            println "$letter"
        }
    }

    @Test
    void rangeOfEnums(){
        def weekdays = Days.MON..Days.FRI
        for(day in weekdays){
            println "$day"
        }
    }

    /**
     * 1. To print the first value of range
     * 2. These from/to are called Extents
     */
    @Test
    void from(){
        def weekdays = Days.MON..Days.FRI
        println "${weekdays.from}"
    }

    /**
     * 1. To print the last value of range
     * 2. These from/to are called Extents
     */
    @Test
    void to(){
        def weekdays = Days.MON..Days.FRI
        println "${weekdays.to}"
    }

    @Test
    void usingRangeInForLoop(){
        for(i in 1..5){
            println "number: $i"
        }
    }

    @Test
    void rangeForEachWithClosure(){
        (1..5).forEach({
            println "number: $it"
        })
    }

    @Test
    void rangeEachWithClosure(){
        (1..5).each {
            println "number: $it"
            println new Date()
            sleep(1000 * 1)
        }
    }

    @Test
    void rangeEachWithCloseWithCustomVariable(){
        (1..5).each {i ->
            println "number: $i"
        }
    }


}
