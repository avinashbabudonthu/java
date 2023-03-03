package com.spring.integration.config;

import com.spring.integration.component.Transform;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.dsl.*;
import org.springframework.integration.file.FileReadingMessageSource;
import org.springframework.integration.file.FileWritingMessageHandler;

import java.io.File;
import java.util.function.Consumer;

@Configuration
public class AppConfig {

    @Autowired
    private Transform transform;

    @Bean
    public IntegrationFlow integrationFlow(){
        // Consumer object
        /*Consumer<SourcePollingChannelAdapterSpec> consumer = new Consumer<SourcePollingChannelAdapterSpec>() {
            @Override
            public void accept(SourcePollingChannelAdapterSpec sourcePollingChannelAdapterSpec) {
                sourcePollingChannelAdapterSpec.poller(Pollers.fixedDelay(500)  *//*500 ms*//*)
            }
        };*/

        // Consumer object using lambda
        Consumer<SourcePollingChannelAdapterSpec> consumer =
                sourcePollingChannelAdapterSpec ->  sourcePollingChannelAdapterSpec.poller(Pollers.fixedDelay(500)  /*500 ms*/);

        return IntegrationFlows
                .from(fileReader(), consumer)
                .transform(transform, "transform") // object, methodName
                .handle(fileWriter())
                // .get();
        .nullChannel();
    }

    @Bean
    public FileReadingMessageSource fileReader(){
        FileReadingMessageSource fileReadingMessageSource = new FileReadingMessageSource();
        fileReadingMessageSource.setDirectory(new File("inputFiles"));
        return fileReadingMessageSource;
    }

    @Bean
    public FileWritingMessageHandler fileWriter(){
        FileWritingMessageHandler fileWritingMessageHandler = new FileWritingMessageHandler(new File("outputFiles"));
        return fileWritingMessageHandler;
    }
}