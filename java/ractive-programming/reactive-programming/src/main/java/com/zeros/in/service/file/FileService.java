package com.zeros.in.service.file;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.function.Consumer;

@Slf4j
public class FileService {

    private static final Path PATH = Paths.get("src/main/resources/files");
    private static final Consumer<Object> ON_NEXT = (str) -> log.info("content={}", str);
    private static final Consumer<Throwable> ON_ERROR = (e) -> log.info("Error={}", e.getMessage());
    private static final Runnable ON_COMPLETE = () -> log.info("Completed");

    public static void main(String[] args) {
        new FileService().execute();
    }

    private void execute() {
        read("file01.txt").subscribe(ON_NEXT, ON_ERROR, ON_COMPLETE);
        read("file02.txt").subscribe(ON_NEXT, ON_ERROR, ON_COMPLETE);
        read("file03.txt").subscribe(ON_NEXT, ON_ERROR, ON_COMPLETE);
        write("file04.txt", "This is file4").subscribe(ON_NEXT, ON_ERROR, ON_COMPLETE);
        delete("file04.txt").subscribe(ON_NEXT, ON_ERROR, ON_COMPLETE);
    }

    private Mono<String> read(String fileName) {
        return Mono.fromSupplier(() -> readFile(fileName));
                // .subscribe(ON_NEXT, ON_ERROR, ON_COMPLETE);
    }

    private Mono<Void> write(String fileName, String content) {
        return Mono.fromRunnable(() -> writeFile(fileName, content));
    }

    private Mono<Void> delete(String fileName) {
        return Mono.fromRunnable(() -> deleteFile(fileName));
    }

    private String readFile(String fileName) {
        String content = "";
        try {
            content = Files.readString(PATH.resolve(fileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return content;
    }

    private void writeFile(String fileName, String content) {
        try {
            Files.writeString(PATH.resolve(fileName), content);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void deleteFile(String fileName) {
        try {
            Files.delete(PATH.resolve(fileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}