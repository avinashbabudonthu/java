package com.infogain.gcp.poc.component;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MessageConverter {

    @Autowired
    private ObjectMapper objectMapper;

    public String convertToJsonString(Object object) {
        String result = StringUtils.EMPTY;

        try{
            log.info("converting object into json {}", object);
            result = objectMapper.writeValueAsString(object);
            log.info("converted json {}", result);
        }catch (Exception e){
            log.error("Exception while converting record to json", e);
        }

        return result;
    }

}