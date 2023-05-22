package com.basics

fun main() {
    whileLoop()
    doWhile()
}

private fun whileLoop() {
    println("While loop")
    var i: Int = 0
    while (i < 5) {
        println("i: $i")
        i++
    }
}

private fun doWhile() {
    println("doWhile loop")
    var i: Int = 0
    do {
        println("i: $i")
        i++
    }while (i < 5)
}