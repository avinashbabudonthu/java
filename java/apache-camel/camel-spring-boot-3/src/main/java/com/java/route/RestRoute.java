package com.java.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RestRoute extends RouteBuilder {

    @Value("${app.route1:false}")
    private Boolean route1;

    @Override
    public void configure() throws Exception {
        if(route1) {
            restConfiguration().host("localhost").port("8080");

            from("timer:route1?period={{route1.timer.period}}")
                    .setHeader("id", simple("${random(6,9)}"))
                    .to("rest:get:example/{id}")
                    .log("${body}")
                    .end();
        }
    }

}