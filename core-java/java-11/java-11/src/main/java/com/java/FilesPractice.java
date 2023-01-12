package com.java;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FilesPractice {

    /**
     * Output:
     * C:\github\java\...\file-1.txt
     *
     */
    @Test
    public void createFile(){
        try {
            Path resultPath = Files.createFile(Path.of("C:\\github\\java\\...\\file-1.txt"));
            System.out.println(resultPath.toAbsolutePath().toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * createFile - Creates a new and empty file, failing if the file already exists
     * writeString - Write a CharSequence to a file. Characters are encoded into bytes using the UTF-8 charset
     * readString - Reads all content from a file into a string, decoding from bytes to characters using the UTF-8 charset
     *
     * Output:
     * Hello world
     */
    @Test
    public void writeStringAndReadString(){
        try {
            Path resultPath = Files.createFile(Path.of("C:\\github\\java\\core-java\\java-11\\java-11\\src\\main\\resources\\files\\file-1.txt"));
            Path path2 = Files.writeString(resultPath, "Hello world");
            String content = Files.readString(path2);
            System.out.println(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}