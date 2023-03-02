package com.spring.integration.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.file.FileReadingMessageSource;

import java.io.File;

@Configuration
public class AppConfig {

    @Bean
    public IntegrationFlow integrationFlow(){
        // TODO
        return IntegrationFlows.from(fileReader()).logAndReply();
    }

    @Bean
    public FileReadingMessageSource fileReader(){
        FileReadingMessageSource fileReadingMessageSource = new FileReadingMessageSource();
        fileReadingMessageSource.setDirectory(new File("files"));
        return fileReadingMessageSource;
    }
}