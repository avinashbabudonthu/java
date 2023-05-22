package com.loops

import org.junit.Test

class ForLoop {

    @Test
    void forLoop(){
        def names = ["jack", "jill", "jim", "tim", "tony"]
        for(int i=0; i<names.size(); i++){
            println "hello, " + names[i]
        }
    }

    @Test
    void forEach(){
        def names = ["jack", "jill", "jim", "tim", "tony"]

        for(name in names){
            println "hello, $name"
        }
    }

    @Test
    void forEachWithClosure(){
        def names = ["jack", "jill", "jim", "tim", "tony"]

        names.forEach({
            println "hello, $it"
        })

        println "------------------------"

        names.forEach({name ->
            println "hello, $name"
        })
    }

    @Test
    void eachWithClosure(){
        def names = ["jack", "jill", "jim", "tim", "tony"]

        names.each {
            println "hello, $it"
        }
    }

    @Test
    void eachWithCloseWithCustomVariable(){
        def names = ["jack", "jill", "jim", "tim", "tony"]

        names.each {name->
            println "hello, $name"
        }
    }
}
