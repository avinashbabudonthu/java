package com.basics

fun main() {
    range1()
    range2()
}

private fun range1() {
    var chars = 'a'..'z'
    for(c in chars){
        println("$c")
    }
}

private fun range2() {
    var numbers = 1..10
    for(num in numbers){
        println("$num")
    }
}