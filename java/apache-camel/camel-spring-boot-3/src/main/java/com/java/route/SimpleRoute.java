package com.java.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class SimpleRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("timer:route2?period=1000")
                .routeId("route2")
                .log("running route2")
                .end();
    }

}