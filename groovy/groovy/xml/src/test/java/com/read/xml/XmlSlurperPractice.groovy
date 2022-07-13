package com.read.xml

import org.junit.Test

class XmlSlurperPractice {

    /**
     * 1. Similar to XMLParser
     * 2. Uses lazy evaluation. Means only portion of document will be loaded to memory just before they read
     * 3. Efficient while working with large documents. Though slight slow
     * 4. Ideal when we want to access subset of xml document
     */
    @Test
    void readNodes(){
        def filePath = "C:\\Java-Prep\\groovy\\projects\\groovy\\xml\\src\\main\\resources\\students.xml"
        def file = new File(filePath)
        println "is xml exist? = ${file.exists()}"

        def slurpur = new XmlSlurper()
        def students = slurpur.parse(filePath)

        println "all content: $students"
        println "first-names: ${students.student.firstName}"
        println "first-student-name: ${students.student[0].firstName}"

        for(student in students.student){
            println "${student.firstName} : ${student.course}: ${student.grade}"
        }
    }

    /**
     * 1. Navigate to node which attributes we want to read
     * 2. use @ (at the write) to access attributes
     */
    @Test
    void readAttribute(){
        def filePath = "C:\\Java-Prep\\groovy\\projects\\groovy\\xml\\src\\main\\resources\\students.xml"
        def file = new File(filePath)

        def slurper = new XmlSlurper()
        def students = slurper.parse(file)

        for(student in students.student){
            def otherNode = student.other
            println "firstName: ${student.firstName}, lastName=${otherNode.@lastName}, gender=${otherNode.@gender}"
        }
    }

    @Test
    void iterateEachNodeWithClosure(){
        def filePath = "C:\\Java-Prep\\groovy\\projects\\groovy\\xml\\src\\main\\resources\\students.xml"
        def file = new File(filePath)

        def slurper = new XmlSlurper()
        def students = slurper.parse(file)

        students.student.each{
            println "${it.firstName}, ${it.other.@lastName}, ${it.other.@gender}, ${it.course}, ${it.grade}"
        }
    }
}
