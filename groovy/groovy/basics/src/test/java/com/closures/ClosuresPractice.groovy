package com.closures

import org.junit.Test

class ClosuresPractice {

    @Test
    void declareClosure(){
        def closure1 = {
            println "welcome to closures"
            println new Date()
        }

        closure1()
    }

    @Test
    void forEachWithClosure(){
        def closure = {println "welcome to closures"}
        (1..5).forEach {
            closure()
        }
    }

    @Test
    void eachWithClosure(){
        def outSideClosure = {println "outside closure - welcome to closures $it"}
        (1..5).each {
            outSideClosure()
            println "inside closure - welcome to closures $it"
        }
    }

    /**
     * 1. print even numbers using findAll and closures
     */
    @Test
    void findAll(){
        (1..10).findAll({
            it % 2 == 0
        }).each {
            println "number: $it"
        }
    }

    @Test
    void closureWithVariable(){
        (1..5).each {number ->
            println "number=$number"
        }
    }
}
