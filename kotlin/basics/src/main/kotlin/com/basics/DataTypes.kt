package com.basics

fun main() {
    var byteNum: Byte = 100
    var shortNum: Short = 101
    var intNum: Int = 102

    // A whole number is an Int as long as it is up to 2147483647.
    // If it goes beyond that, it is defined as Long
    var longNum: Long = 103

    var floatNum: Float = 104.56F

    var doubleNum: Double = 105.67

    val booleanVal1: Boolean = true
    val booleanVal2: Boolean = false

    var charVal1: Char = 'A'

    var strVal: String = "Kotlin"

    // In Kotlin, numeric type conversion is different from Java.
    // For example, it is not possible to convert an Int type to a Long type with the following code
//    val x: Int = 5
//    val y: Long = x
//    println(y) // Error: Type mismatch

    // To convert a numeric data type to another type, we must use one of the following functions:
    // toByte(), toShort(), toInt(), toLong(), toFloat(), toDouble() or toChar()
    var n1: Int = 100
    var n2: Long = n1.toLong()


}