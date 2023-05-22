package com.cerebro.controller;

@lombok.extern.slf4j.Slf4j
@org.springframework.web.bind.annotation.RestController
public class AppController {

    @org.springframework.beans.factory.annotation.Autowired
    private org.springframework.batch.core.launch.JobLauncher jobLauncher;

    @org.springframework.beans.factory.annotation.Autowired
    private org.springframework.batch.core.Job job;

    @lombok.SneakyThrows
    @org.springframework.web.bind.annotation.GetMapping
    public org.springframework.batch.core.BatchStatus load(){
        java.util.Map<String, org.springframework.batch.core.JobParameter> map = new java.util.HashMap<>();
        map.put("time", new org.springframework.batch.core.JobParameter(System.currentTimeMillis()));
        org.springframework.batch.core.JobParameters parameters = new org.springframework.batch.core.JobParameters(map);

       org.springframework.batch.core.JobExecution jobExecution = jobLauncher.run(job, parameters);

        log.info("Job execution status={}", jobExecution.getStatus());

        while(jobExecution.isRunning()){
            log.info(".....");
            Thread.sleep(1000);
        }

        return jobExecution.getStatus();
    }
}
