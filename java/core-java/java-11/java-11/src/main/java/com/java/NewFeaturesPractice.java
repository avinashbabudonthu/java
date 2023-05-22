package com.java;

import com.sun.source.doctree.SeeTree;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class NewFeaturesPractice {

    @Test
    public void toArray(){
        List<String> list = Arrays.asList("jim", "john", "jill", "adam", "ana");
        System.out.println(list); // [jim, john, jill, adam, ana]

        String[] strArray = list.toArray(String[]::new);
        /**
         * jim
         * john
         * jill
         * adam
         * ana
         */
        Arrays.stream(strArray).forEach(System.out::println);

        String[] array2 = list.toArray(new String[1]);
        System.out.println(array2[0]); // jim
        System.out.println(array2[1]); // john
    }

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

    /**
     * local variables in lambda
     *
     * Output:
     * JIM->JOHN->JILL->ADAM->ANA
     *
     */
    @Test
    public void localVariable(){
        List<String> list = Arrays.asList("jim", "john", "jill", "adam", "ana");
        String resultString = list.stream()
                .map((var str) -> str.toUpperCase())
                .collect(Collectors.joining("->"));
        System.out.println(resultString);
    }

    /**
     * Predicate.not
     *
     * Output: [jim, john, jill]
     */
    @Test
    public void not(){
        List<String> list = Arrays.asList("jim", "john", "jill", "", " ");
        List<String> withoutBlanks = list.stream()
                // .filter(Predicate.not(str -> str.isBlank()))
                .filter(Predicate.not(String::isBlank))
                .collect(Collectors.toList());
        System.out.println(withoutBlanks);
    }

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

    @Test
    public void httpClient() throws Exception{
        int port = 8080;
        HttpClient httpClient = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .connectTimeout(Duration.ofSeconds(20))
                .build();
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("http://localhost:" + port))
                .build();
        HttpResponse httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        Object object = httpResponse.body();
        System.out.println(object);
    }

    /**
     * JVM access rules allow access to private members between nestmates; however, in previous Java versions,
     * the reflection API denied the same access.
     *
     * Java 11 fixes this issue and provides means to query the new class file attributes using the reflection API
     */
    @Test
    public void nestBasedAccess(){
        Set<String> nestedMembers = Arrays.stream(Employee.class.getNestMembers())
                .map(Class::getName)
                .collect(Collectors.toSet());
        System.out.println(nestedMembers);
    }

    /**
     * Output:
     * hello-hello-hello-hello-hello-
     */
    @Test
    public void stringRepeat(){
        String str = "hello-";
        String result = str.repeat(5);
        System.out.println(result);
    }

}
