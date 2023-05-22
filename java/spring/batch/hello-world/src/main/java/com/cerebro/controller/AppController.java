package com.cerebro.controller;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;

import java.util.HashMap;
import java.util.Map;

@lombok.extern.slf4j.Slf4j
@org.springframework.web.bind.annotation.RestController
public class AppController {

    @org.springframework.beans.factory.annotation.Autowired
    private org.springframework.batch.core.launch.JobLauncher jobLauncher;

    @org.springframework.beans.factory.annotation.Autowired
    private Job job;

    @lombok.SneakyThrows
    @org.springframework.web.bind.annotation.GetMapping
    public BatchStatus load(){
        Map<String, org.springframework.batch.core.JobParameter> map = new HashMap<>();
        map.put("time", new org.springframework.batch.core.JobParameter(System.currentTimeMillis()));
        JobParameters parameters = new JobParameters(map);

       JobExecution jobExecution = jobLauncher.run(job, parameters);

        log.info("Job execution status={}", jobExecution.getStatus());

        while(jobExecution.isRunning()){
            log.info(".....");
            Thread.sleep(1000);
        }

        return jobExecution.getStatus();
    }
}
