package com.basics

fun main() {
    createArray()
    accessElements()
    setElement()
    size()
    elementExists()
    loop()
}

private fun createArray() {
    var names: Array<String> = arrayOf("Jack", "John", "Jim", "Jill")
    println("names: $names") // names: [Ljava.lang.String;@610455d6
}

private fun accessElements() {
    var names: Array<String> = arrayOf("Jack", "John", "Jim", "Jill")
    println("name1: " + names[0]) // name1: Jack
    println("name2: " + names[1]) // name2: John
    println("name3: " + names[2]) // name3: Jim
    println("name4: " + names[3]) // name4: Jill
}

private fun setElement() {
    var names: Array<String> = arrayOf("Jack", "John", "Jim", "Jill")
    println("name1: " + names[0]) // name1: Jack
    names[0] = "Jane"
    println("name1: " + names[0]) // name1: Jane
}

private fun size() {
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