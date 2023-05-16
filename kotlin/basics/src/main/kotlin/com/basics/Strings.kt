package com.basics

fun main() {

    var name1: String = "Jack"
    println("name1: $name1") // name1: Jack

    var name2 = "John"
    println("name2: $name2") // name2: John

    var name3: String = name1 + " " + name2
    println("name3: $name3") // name3: Jack John

    var name4: String = "$name1 $name2"
    println("name4: $name4") // name4: Jack John

    accessCharacterInString("Java")
    accessCharacterInString("Kotlin")
    length("Java")
    toUpperCase("kotlin")
    toLowerCase("JAVA")
    compareTo("Java", "Kotlin") // result: -1
    compareTo("Java", "Java") // result: 0
    compareTo("Kotlin", "Java") // result: 1
    indexOf()
    concat()
}

/**
str: Kotlin
0 index: K
1 index: o
2 index: t
3 index: l

str: Java
0 index: J
1 index: a
2 index: v
3 index: a
 */
fun accessCharacterInString(str: String) {
    println("0 index: " + str[0])
    println("1 index: " + str[1])
    println("2 index: " + str[2])
    println("3 index: " + str[3])
}

/**
str: Java
length: 4
 */
fun length(str: String) {
    println("length: " + str.length)
}

fun toUpperCase(str: String) {
    println("upper-case: " + str.toUpperCase()) // deprecated
    println("upper-case: " + str.uppercase())
}

fun toLowerCase(str: String) {
    println("lower-case: " + str.toLowerCase())
    println("lower-case: " + str.lowercase())
}

fun compareTo(str1: String, str2: String) {
    var result: Int = str1.compareTo(str2)
    println("result: $result")
}

fun indexOf() {
    var input: String = "Hello World Welcome to Kotlin"
    var searchStr: String = "Kotlin"
    var indexOfKotlin: Int = input.indexOf(searchStr);
    println("indexOfKotlin: $indexOfKotlin") // indexOfKotlin: 23
}

fun concat(){
    var str1: String = "Java"
    var str2: String = "Kotlin"
    var str3: String = str1 + " " + str2
    var str4: String = str1.plus(" ").plus(str2)
    var str5: String = "$str1 $str2"

    println("str3: $str3") // str3: Java Kotlin
    println("str4: $str4") // str4: Java Kotlin
    println("str5: $str5") // str5: Java Kotlin
}