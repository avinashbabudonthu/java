package com.basics

fun main() {
    var result: String = functionWithReturnString("Hello", "World")
    println("result: $result") // result: Hello World

    println("result2: " + shortReturn(10, 20)) // result2: 30
}

// data type to arguments is must
private fun functionWithReturnString(str1: String, str2: String): String {
    return "$str1 $str2"
}

private fun shortReturn(num1: Int, num2: Int) =  num1 + num2