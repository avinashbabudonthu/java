package com.spock

import org.junit.Test

class MathTest {

    @Test
    void sum(){
      Math math = new Math()
      int sum = math.sum(10, 20)
      println "sum=$sum"
    }
}
