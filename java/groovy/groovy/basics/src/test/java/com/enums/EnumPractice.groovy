package com.enums

import org.junit.Test

class EnumPractice {

    @Test
    void printEnum(){
        Days[] days = Days.values()
        for(day in days){
            println "$day"
        }
    }
}
