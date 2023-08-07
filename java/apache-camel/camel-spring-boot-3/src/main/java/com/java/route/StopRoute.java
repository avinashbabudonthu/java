package com.java.route;

import com.java.processor.StopRouteProcessor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StopRoute extends RouteBuilder {

    @Autowired
    private StopRouteProcessor stopRouteProcessor;

    @Override
    public void configure() throws Exception {
        from("timer:route4?period={{route4.timer.period}}")
                .routeId("route4")
                .log("route4 started")
                .process(stopRouteProcessor)
                .log("route4 completed")
                .end();
    }
}
