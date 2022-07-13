package com.strings

import org.junit.Test

class StringsPractice {

    @Test
    void declareString(){
        def name1 = "jack"
        println "name1="+name1

        String name2 = "john"
        println "name2="+name2
    }

    /**
     * 1. gString evaluates to actual value only in double quotes
     * 2. prints as plain text if used in single quotes
     * 3. If gString variable is simple variable then can use without {} braces
     * 4. if gString is method call or any expression then use with {} braces
     */
    @Test
    void gString(){
        def name1 = "jack"
        println "name1=$name1"

        def name2 = "jill"
        println 'name2=$name2' // o/p: name2=$name2

        def names = ["jack", "jill", "jim", "tim", "tony"]
        for(def i=0;i<names.size;i++){
            println "hello, ${names[i]}"
        }
    }
}
