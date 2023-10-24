package com.java.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class TimerRoute extends RouteBuilder {

    @Value("${app.route2}")
    private Boolean route2;

    @Value("${app.route3}")
    private Boolean route3;

    @Override
    public void configure() throws Exception {

        if(route2) {
            // timer route with frequency hard coded
            from("timer:route2?period=2000")
                    .routeId("route2")
                    .log("running route2")
                    .end();
        }


        if(route3) {
            // timer route - frequency value from application.yml
            from("timer:route3?period={{route3.timer.period}}")
                    .routeId("route3")
                    .log("running route3")
                    .end();
        }

    }

}