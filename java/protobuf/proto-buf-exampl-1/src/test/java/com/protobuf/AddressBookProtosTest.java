package com.protobuf;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

@Slf4j
public class AddressBookProtosTest {

    @Test
    void createAddressBook() {
        AddressBookProtos.Person person =
                AddressBookProtos.Person.newBuilder()
                        .setName("name1")
                        .setId(100)
                        .setEmail("name1@gmail.com")
                        .addNumbers("100")
                        .build();
        log.info("name={}, id={}, email={}, numbers={}",person.getName(), person.getId(),
                person.getEmail(), person.getNumbersList());
    }

    @Test
    void write() {
        AddressBookProtos.Person person =
                AddressBookProtos.Person.newBuilder()
                        .setName("name1")
                        .setId(100)
                        .setEmail("name1@gmail.com")
                        .addNumbers("100")
                        .build();

        String filePath = "files/output/addressBook-" + UUID.randomUUID() + ".txt";

        write(person, filePath);
    }

    private void write(AddressBookProtos.Person person, String filePath) {
        try(FileOutputStream fileOutputStream = new FileOutputStream(filePath)){
            person.writeTo(fileOutputStream);
        }catch (Exception e){
            log.error("Exception", e);
        }
    }

    // name=name1, id=100, email=name1@gmail.com, numbers=[100]
    @Test
    void read() throws IOException {
        AddressBookProtos.Person person =
                AddressBookProtos.Person.newBuilder()
                        .setName("name1")
                        .setId(100)
                        .setEmail("name1@gmail.com")
                        .addNumbers("100")
                        .build();
        String filePath = "files/output/addressBook-" + UUID.randomUUID() + ".txt";
        write(person, filePath);

        AddressBookProtos.Person person2 = AddressBookProtos.Person.newBuilder().mergeFrom(new FileInputStream(filePath)).build();
        log.info("name={}, id={}, email={}, numbers={}",person2.getName(), person2.getId(),
                person2.getEmail(), person2.getNumbersList());
    }
}