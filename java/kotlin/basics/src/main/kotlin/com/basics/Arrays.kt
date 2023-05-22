package com.basics

fun main() {
    var arraysPractice: ArraysPractice = ArraysPractice()
//    arraysPractice.createArray()
//    arraysPractice.accessElements()
//    arraysPractice.setElement()
//    arraysPractice.size()
//    arraysPractice.elementExists()
//    arraysPractice.loop()
//    arraysPractice.intArrayOf()
//    arraysPractice.getElementByIndex()
//    arraysPractice.arrayToString()
//    arraysPractice.distinct()

//    arraysPractice.dropFromFirst()

//    arraysPractice.dropFromLast()

    arraysPractice.isEmpty()
}

class ArraysPractice {

    fun isEmpty() {
        var names = arrayOf<String>()
        println("names.isEmpty: ${names.isEmpty()}") // names.isEmpty: true
    }

    fun dropFromLast() {
        var names: Array<String> = arrayOf("Jack", "jill", "john", "jane", "Jack", "jim", "jane")
        println(names.contentDeepToString()) // [Jack, jill, john, jane, Jack, jim, jane]

        var names2: List<String> = names.dropLast(2)
        println(names2.toString()) // [Jack, jill, john, jane, Jack]
    }

    fun dropFromFirst() {
        var names: Array<String> = arrayOf("Jack", "jill", "john", "jane", "Jack", "jim", "jane")
        println(names.contentDeepToString()) // [Jack, jill, john, jane, Jack, jim, jane]

        var names2: List<String> = names.drop(2)
        println(names2.toString()) // [john, jane, Jack, jim, jane]
    }

    fun distinct() {
        var names: Array<String> = arrayOf("Jack", "jill", "john", "jane", "Jack", "jim", "jane")
        println(names.contentDeepToString()) // [Jack, jill, john, jane, Jack, jim, jane]
        var distinctNames: List<String> = names.distinct()
        println(distinctNames.toString()) // [Jack, jill, john, jane, jim]
    }

    fun arrayToString() {
        var names: Array<String> = arrayOf("Jack", "jill", "john", "jane", "Jack", "jim", "jane")
        println(names.contentDeepToString()) // [Jack, jill, john, jane, Jack, jim, jane]
    }

    /**
    Output
    1
    2
    3
    4
    5

    Explanation: Like intArray() we have below methods
    byteArrayOf()
    charArrayOf()
    shortArrayOf()
    longArrayOf()
     */
    fun intArrayOf(){
        var intArray = intArrayOf(1,2,3,4,5)
        for(num in intArray){
            println("$num")
        }
    }

    fun createArray() {
        var names: Array<String> = arrayOf("Jack", "John", "Jim", "Jill")
        println("names: $names") // names: [Ljava.lang.String;@610455d6

        var numbers: Array<Int> = arrayOf<Int>(1,2,3,4,5,6,7,8,9,10)
        println("numbers: $numbers") // numbers: [Ljava.lang.Integer;@383534aa
    }

    fun accessElements() {
        var names: Array<String> = arrayOf("Jack", "John", "Jim", "Jill")
        println("name1: " + names[0]) // name1: Jack
        println("name2: " + names[1]) // name2: John
        println("name3: " + names[2]) // name3: Jim
        println("name4: " + names[3]) // name4: Jill
    }

    fun setElement() {
        var names: Array<String> = arrayOf("Jack", "John", "Jim", "Jill")
        println("name1: " + names[0]) // name1: Jack
        names[0] = "Jane"
        println("name1: " + names[0]) // name1: Jane
        names.set(0, "Jini")
        println("name1: " + names[0]) // name1: Jini
    }

    fun size() {
        var names = arrayOf("Jack", "Jill", "Jim", "John")
        println("names.size: " + names.size) // names.size: 4
    }

    fun elementExists() {
        var names = arrayOf("Jack", "Jill", "Jim", "John")
        if("Jim" in names) {
            println("Exists") // Exists
        } else {
            println("Does not Exist")
        }

        if("Jane" in names) {
            println("Exists")
        } else {
            println("Does not Exist") // Does not Exist
        }
    }

    fun loop(){
        var names = arrayOf("jack", "john", "jill", "jim")
        // method 1
        for(name: String in names) {
            println("name: $name")
        }

        // method 2
        for(name in names) {
            println("name: $name")
        }

    }

    fun getElementByIndex() {
        var numbers: Array<Int> = arrayOf(10,20,30,40,50)
        println("index-3: ${numbers[2]}") // index-3: 30
        println("index-2: ${numbers.get(2)}") // index-2: 30
    }
}