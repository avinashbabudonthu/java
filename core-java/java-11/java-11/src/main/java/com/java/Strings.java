package com.java;

import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

public class Strings {

    /**
     * lines - split string by new line character
     *
     * Output:
     * -welcome to -
     * - Java 11 -
     * - tutorial-
     *
     */
    @Test
    public void lines(){
        String multilineString = "welcome to \n Java 11 \n tutorial";
        List<String> lines = multilineString.lines().collect(Collectors.toList());
        lines.forEach(line -> System.out.println("-"+line+"-"));
    }

    /**
     * lines - split string by new line character
     * isBlank - Returns true if the string is empty or contains only white space codepoints, otherwise false
     * strip - provide similar functionality to the more familiar trim method; however, with finer control and Unicode support
     *
     * Output:
     * -welcome to-
     * -Java 11-
     * -tutorial-
     */
    @Test
    public void linesAndIsBlankAndStrip(){
        String multilineString = "welcome to \n Java 11 \n tutorial";
        List<String> lines = multilineString.lines()
                .filter(line -> !line.isBlank())
                .map(String::strip)
                .collect(Collectors.toList());
        lines.forEach(line -> System.out.println("-"+line+"-"));
    }
}