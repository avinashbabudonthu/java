package com.basics

fun main() {
    forLoop1()
}

private fun forLoop1() {
    var names = arrayOf("jack", "jill", "john", "john")
    for(name in names) {
        println("name: $name")
    }
}