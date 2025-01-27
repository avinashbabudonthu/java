package com.springboot.spock.controller

import com.springboot.spock.repository.AppRepository
import org.mockito.Mock
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class AppControllerIntegrationTest extends Specification {

    AppRepository appRepository = Stub() {
        findIntegerList() >> Arrays.asList(7, 8, 9, 10)
    }

    @Autowired
    AppController appController

    void "find numbers test"() {
        when:
            println appController
            List<Integer> list = appController.findNumbers()
            println list
        then:
        [7, 8, 9, 10] == list
    }
}
