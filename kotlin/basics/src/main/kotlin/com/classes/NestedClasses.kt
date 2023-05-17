package com.classes

class OuterClass {
    var name1:String = "Jack"

    class InnerClass1 {
        var name2:String = "Jill"
    }

    class InnerClass2 {
        var name3: String = "John"
    }
}

fun main() {
    var object1 = OuterClass()
    println("object1.name1: ${object1.name1}")

    var object2 = OuterClass.InnerClass1()
    println("object2.name1: ${object2.name2}")

    var object3 = OuterClass.InnerClass2()
    println("object3.name3: ${object3.name3}")
}