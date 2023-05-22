package com.classes

class Car {
    var brand: String = ""
    var model: String = ""
    var year: Int = 0

    fun drive() {
        println("Driving $brand $model") // Driving Honda Amaze
    }
}

fun main() {
    var c1: Car = Car()
    c1.brand = "Honda"
    c1.model = "Amaze"
    c1.year = 2018

    // brand: Honda, model: Amaze, year: 2018
    println("brand: ${c1.brand}, model: ${c1.model}, year: ${c1.year}")
    c1.drive()
}