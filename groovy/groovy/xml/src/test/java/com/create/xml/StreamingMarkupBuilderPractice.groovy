package com.create.xml

import groovy.xml.StreamingMarkupBuilder
import org.junit.Test

/**
 * 1. Have advanced features like processing instructions and name spacing along with MarkupBuilder features
 * 2. Used for large document creation
 */
class StreamingMarkupBuilderPractice {

    @Test
    void createXmlFile(){
        def filePath = "C:\\Java-Prep\\groovy\\projects\\groovy\\xml\\src\\main\\resources\\employees.xml"
        def markupBuilder = new StreamingMarkupBuilder()
        def xml = markupBuilder.bind{
            employees{
                (1..5).each {number ->
                    mkp.comment("employee node") // mkp is implicit markup builder variable
                    employee(timestamp: new Date()){
                        serialNumber("$number")
                        name("name-$number")
                    }
                }
            }
        }

        def outputFile = new File(filePath)
        outputFile.write(xml.toString())
    }
}
