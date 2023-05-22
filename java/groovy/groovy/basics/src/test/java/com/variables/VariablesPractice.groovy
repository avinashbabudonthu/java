package com.variables

import org.junit.Test

class VariablesPractice {

    // by default method is public
    @Test
    void declareVariable(){
        def sum = 3 + 5
        println "sum=$sum"
    }

    @Test
    void stringVariable(){
        def name = "john"
        println "name=$name"
    }

    @Test
    void printClassOfVariable(){
        def score = 10
        def name = "jill"

        println "score=$score from class=${score.getClass()}"
        println "name=$name from class=${name.getClass()}"
    }
}
