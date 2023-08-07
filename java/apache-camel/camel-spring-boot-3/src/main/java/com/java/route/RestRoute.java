package com.java.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class RestRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        restConfiguration().host("localhost").port("8080");

        from("timer:route1?period={{route1.timer.period}}")
            .setHeader("id", simple("${random(6,9)}"))
            .to("rest:get:example/{id}")
            .log("${body}")
        .end();
    }

}