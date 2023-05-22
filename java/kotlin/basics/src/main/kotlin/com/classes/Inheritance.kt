package com.classes

/**
Explanation:

Use the open keyword in front of the superclass/parent,
to make this the class other classes should inherit properties and functions from.

To inherit from a class, specify the name of the subclass,
followed by a colon :, and then the name of the superclass
*/

open class SuperClass {
    val year: Int = 2023
}

class Subclass: SuperClass() {
    fun method1() {
        println("year: $year") // year: 2023
    }
}

fun main() {
    var subclass = Subclass()
    subclass.method1()
}