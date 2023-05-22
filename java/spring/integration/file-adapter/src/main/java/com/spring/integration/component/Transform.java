package com.spring.integration.component;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Slf4j
@Component
public class Transform {

    public String transform(String filePath) throws IOException {
        log.info("transform method - started");
        String fileContent = new String(Files.readAllBytes(Paths.get(filePath)));
        log.info("transform method - completed");

        return fileContent.toUpperCase();
    }

}