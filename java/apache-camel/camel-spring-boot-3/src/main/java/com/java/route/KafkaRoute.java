package com.java.route;

import com.java.processor.KafkaRouteComponent;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.kafka.KafkaConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class KafkaRoute extends RouteBuilder {

    @Autowired
    private KafkaRouteComponent kafkaRouteComponent;

    @Value("${app.kafka.route}")
    private Boolean kafkaRoute;

    @Override
    public void configure() throws Exception {
        if (kafkaRoute) {
            from("timer:kafkaRoute?period=10000")
                    .routeId("kafkaRoute")
                    .log("kafkaRoute started")

                    .bean(kafkaRouteComponent, "kafkaMessage")
//                    .bean(kafkaRouteComponent, "kafkaMessageList")

                    .setHeader(KafkaConstants.KEY, constant("100"))
//                    .setHeader("kafka.KEY", constant("100")) // this or above

                    .log("Sending message, key=${headers[kafka.Key]}")
                    .to("kafka:topic-1")
                    .log("Message sent, key=${headers[kafka.Key]}")

                    .log("kafkaRoute completed")
                    .end();
        }
    }
}