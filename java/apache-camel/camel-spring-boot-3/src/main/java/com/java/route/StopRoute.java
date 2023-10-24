package com.java.route;

import com.java.processor.StopRouteProcessor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class StopRoute extends RouteBuilder {

    @Autowired
    private StopRouteProcessor stopRouteProcessor;

    @Value("${app.route4}")
    private Boolean route4;

    @Override
    public void configure() throws Exception {

        if(route4) {
            from("timer:route4?period={{route4.timer.period}}")
                    .routeId("route4")
                    .log("route4 started")
                    .process(stopRouteProcessor)
                    .log("route4 completed")
                    .end();
        }
    }
}
