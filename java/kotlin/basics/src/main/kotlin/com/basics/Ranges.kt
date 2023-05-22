package com.basics

fun main() {
    var rangesPractice = RangerPractice()
//    rangesPractice.range1()
//    rangesPractice.range2()
//    rangesPractice.rangeTo()
//    rangesPractice.downTo()
//    rangesPractice.step()
//    rangesPractice.reversed()
//    rangesPractice.until()
//    rangesPractice.firstLastStep()
//    rangesPractice.filter()
    rangesPractice.utilFunctions()
}

class RangerPractice {

    fun utilFunctions() {
        val numbers = 1..10
        println(numbers.sum()) // 55
        println(numbers.average()) // 5.5
        println(numbers.count()) // 10
    }

    fun filter() {
        var numbers = 1..10
        numbers.forEach { num -> print(num) } // 12345678910
        println()
        var filtered: List<Int> = numbers.filter { num -> num % 2 == 0 }
        println(filtered) // [2, 4, 6, 8, 10]
    }

    fun firstLastStep(){
        var numbers = 1..10 step 2
        println(numbers.first) // 1
        println(numbers.last) // 9
        println(numbers.step) // 2
    }

    // until() can be used to create a range but it will skip the last element given
    fun until() {
        var numbers = 1 until 5;
        numbers.forEach{num -> print(num)} // 1234
    }

    fun reversed() {
        var numbers = (1..9).reversed()
        // 987654321
        numbers.forEach { num -> print(num) }
    }

    fun step() {
        var numbers = 1.. 9 step 2
        // 13579
        for(num in numbers){
            print(num)
        }
    }

    fun downTo() {
        var numbers = 9.downTo(1)
        // 987654321
        for(num in numbers){
            print(num)
        }
    }

    fun rangeTo() {
        var numbers = 1.rangeTo(9)
        println(numbers.toString()) // 1..9
        println(numbers) // 1..9

        // 123456789
        for(num in numbers){
            print(num)
        }
    }

    fun range1() {
        var chars = 'a'..'z'
        for (c in chars) {
            println("$c")
        }
    }

    fun range2() {
        var numbers = 1..10
        for (num in numbers) {
            println("$num")
        }
    }

}