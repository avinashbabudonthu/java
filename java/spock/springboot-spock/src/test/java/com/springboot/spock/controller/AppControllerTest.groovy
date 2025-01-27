package com.springboot.spock.controller

import com.springboot.spock.service.AppService
import spock.lang.Specification

class AppControllerTest extends Specification {

    AppService appService = Stub(){
        findNumbers() >> [7, 8, 9, 10]
    }

    AppController appController = new AppController(appService: appService)

    def "find number unit testing"(){
        when:
            println appController
            println appService
            List<Integer> result = appController.findNumbers()
        then:
            result == [7, 8, 9, 10]
    }

}