package com.infogain.gcp.poc.component;

import com.infogain.gcp.poc.poller.service.PnrService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

@Slf4j
@Component
public class PollerExecutor {

    @Autowired
    private PnrService pnrService;

    // @Scheduled(cron = "*/10 * * * * *")
    @Scheduled(cron = "0 * * * * *")
    public void process() {
        log.info("poller started at {}", LocalTime.now());
        pnrService.execute();
        log.info("poller completed at {}", LocalTime.now());
    }

}
