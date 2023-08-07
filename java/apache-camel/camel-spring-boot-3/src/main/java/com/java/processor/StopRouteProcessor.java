package com.java.processor;

import lombok.extern.slf4j.Slf4j;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class StopRouteProcessor implements Processor {

    private static int i = 0;
    private static final String routeId = "route4";

    @Override
    public void process(Exchange exchange) throws Exception {
        log.info("stop route processor");
        i++;
        if (i > 5) {
            new Thread(
                    () -> {
                        try {
                            log.info("stopping route={}", routeId);
                            exchange.getContext().getRouteController().stopRoute(routeId);
                        } catch (Exception e) {
                            log.error("Exception while stopping route={}", routeId);
                        }
                    }
            ).start();
        }
    }

}