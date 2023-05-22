package com.infogain.gcp.poc.controller;

import com.infogain.gcp.poc.model.PNRModel;
import com.infogain.gcp.poc.service.PublishService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
public class PublishController {

    @Autowired
    private PublishService publishService;

    @PostMapping(value = "/api/v1/publish", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.TEXT_PLAIN_VALUE)
    public Mono<String> publishMessage(@RequestBody PNRModel pnrModel){
        String result = publishService.publish(pnrModel); // this should be different Mono
        return Mono.just(result);
    }

    @GetMapping(value = "/api/v1/scheduler/job/publish", produces = MediaType.TEXT_PLAIN_VALUE)
    public Mono<String> publishFailedRecords(){
        log.info("started processing failed records");
        String result = publishService.publishFailedRecords();
        log.info("completed processing failed records");
        return Mono.just(result);
    }

}