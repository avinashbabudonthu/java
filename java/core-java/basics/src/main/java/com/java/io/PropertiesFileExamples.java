package com.java.io;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.Set;

@Slf4j
public class PropertiesFileExamples {

    @Test
    public void create() {
        // URL url = getClass().getClassLoader().getResource("file1.properties");
        Path path = Paths.get("src/main/resources/file1.properties");
        try (OutputStream outputStream = Files.newOutputStream(path)) {
            Properties properties = new Properties();
            properties.setProperty("name", "jim");
            properties.setProperty("course", "java");

            // properties={name=jim, course=java}
            log.info("properties={}", properties);

            properties.store(outputStream, null);

            // src\main\resources\file1.properties file created
            log.info("{} file created", Paths.get(path.toString()));
        } catch (Exception e) {
            log.error("Exception, url={}", path, e);
        }
    }

    @Test
    public void read() {
        Path path = Paths.get("src/main/resources/config.properties");
        try(InputStream inputStream = Files.newInputStream(path)) {
            Properties properties = new Properties();
            properties.load(inputStream);

            // config.properties={db.user=user1, db.port=8126, db.pwd=pass1, db.url=localhost}
            log.info("config.properties={}", properties);
        }catch (Exception e) {
            log.error("Exception while reading properties file", e);
        }
    }

    @Test
    public void readFromClasspath() {
        try(InputStream inputStream = getClass().getClassLoader().getResourceAsStream("config.properties")) {
            Properties properties = new Properties();
            properties.load(inputStream);

            // config.properties={db.user=user1, db.port=8126, db.pwd=pass1, db.url=localhost}
            log.info("config.properties={}", properties);
        }catch (Exception e) {
            log.error("Exception while reading properties file", e);
        }
    }

    /**
     * key=db.user, value=user1
     * key=db.port, value=8126
     * key=db.pwd, value=pass1
     * key=db.url, value=localhost
     * key=db.user
     * key=db.port
     * key=db.pwd
     * key=db.url
     *
     */
    @Test
    public void print() {
        try(InputStream inputStream = getClass().getClassLoader().getResourceAsStream("config.properties")) {
            Properties properties = new Properties();
            properties.load(inputStream);

            // java 8
            properties.forEach((key, value) -> log.info("key={}, value={}", key, value));

            // get all keys
            Set<Object> keys = properties.keySet();
            keys.forEach(key -> log.info("key={}", key));
        }catch (Exception e) {
            log.error("Exception while reading properties file", e);
        }
    }
}