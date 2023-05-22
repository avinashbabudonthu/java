package com.basics

fun main() {
    /*
    The difference between var and val is that
    variables declared with the var keyword can be changed/modified.
    val variables cannot changed/modified
    */

    var name = "Jack"
    val number1 = 100
    println("name: $name") // name: Jack
    println("number1: $number1") // number1: 100

    var name2: String = "John"
    val number2: Int = 101
    println("name2: $name2") // name2: John
    println("number2: $number2") // number2: 101

    // You can also declare a variable without assigning the value,
    // and assign the value later. However, this is only possible when you specify the type
    var name3: String
    name3 = "Jim"
    println("name3: $name3")

    // below code gives compilation error
//    var number3
//    number3 = 102
//    println("number3: $number3")

}