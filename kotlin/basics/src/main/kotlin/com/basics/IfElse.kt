package com.basics

fun main() {
    ifElseExpression()
}

fun ifElseExpression() {
    val time = 20
    var greeting: String = if(time < 18) {
        "Good day"
    } else {
        "Good evening"
    }
    println("greeting: $greeting") // greeting: Good evening

    var greeting2: String = if(time > 18) "Good evening" else "Good day"
    println("greeting2: $greeting2") // greeting2: Good evening
}