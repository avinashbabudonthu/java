package com.java.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class TimerRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        // timer route with frequency hard coded
        from("timer:route2?period=2000")
                .routeId("route2")
                .log("running route2")
                .end();

        // timer route - frequency value from application.yml
        from("timer:route3?period={{route3.timer.period}}")
                .routeId("route3")
                .log("running route3")
                .end();
    }

}