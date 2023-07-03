package com.protobuf;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

@Slf4j
public class TheaterTest {

    @Test
    void create() {
        Theater theater = Theater.newBuilder()
                .setName("name1")
                .setAddress("address1")
                .build();
        log.info("theater={}", theater);
    }

    @Test
    void write() {
        Theater theater = Theater.newBuilder()
                .setName("name1")
                .setAddress("address1")
                .build();

        String filePath = "files/output/theater-" + UUID.randomUUID() + ".txt";

        write(theater, filePath);
    }

    private void write(Theater theater, String filePath) {
        try(FileOutputStream fileOutputStream = new FileOutputStream(filePath)){
            theater.writeTo(fileOutputStream);
        }catch (Exception e){
            log.error("Exception", e);
        }
    }

    // name=name1, id=100, email=name1@gmail.com, numbers=[100]
    @Test
    void read() throws IOException {
        Theater theater = Theater.newBuilder()
                .setName("name1")
                .setAddress("address1")
                .build();
        String filePath = "files/output/theater-" + UUID.randomUUID() + ".txt";
        write(theater, filePath);

        Theater theater2 = Theater.newBuilder().mergeFrom(new FileInputStream(filePath)).build();
        log.info("name={}, address={}",theater2.getName(), theater2.getAddress());
    }
}