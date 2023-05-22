package com.basics

fun main() {
    val day: Int = 4

    val result = when (day) {
        1 -> "Monday"
        2 -> "Tuesday"
        3 -> "Wednesday"
        4 -> "Thursday"
        5 -> "Friday"
        6 -> "Saturday"
        7 -> "Sunday"
        else -> "Invalid"
    }

    println("result: $result") // result: Thursday
}