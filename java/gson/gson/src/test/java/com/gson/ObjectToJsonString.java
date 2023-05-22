package com.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class ObjectToJsonString {

    @Test
    public void gsonObjectToJsonString(){
        log.info("Create {} object and set values", Gson.class.getName());
        Gson gson = new GsonBuilder().create();
        gson.toJson("hello", System.out);
        gson.toJson(100, System.out);
    }
}
