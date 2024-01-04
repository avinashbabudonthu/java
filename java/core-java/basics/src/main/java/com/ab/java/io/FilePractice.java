package com.ab.java.io;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.File;

@Slf4j
public class FilePractice {

    /**
     * Output: abc\def
     */
    @Test
    public void fileSeparator(){
        String fileSeparator = File.separator;
        log.info("abc{}def", fileSeparator);
    }

}