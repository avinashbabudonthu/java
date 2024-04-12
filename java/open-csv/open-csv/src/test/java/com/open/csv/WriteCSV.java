package com.open.csv;

import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import lombok.extern.slf4j.Slf4j;
import open.csv.model.Student;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Path;
import java.util.List;
import java.util.UUID;

@Slf4j
public class WriteCSV {

    /**
     * Data
     */
    private static List<String[]> getLines() {
        String[] line1 = {"id", "name", "course"};
        String[] line2 = {"1", "jim", "java"};
        String[] line3 = {"2", "jill", "csv"};
        String[] line4 = {"3", "john", "cloud"};
        return List.of(line1, line2, line3, line4);
    }

    /**
     * Write line by line
     */
    @Test
    public void writeLineByLine() {
        // file path to create
        String fileName = "csv/students-" + UUID.randomUUID() + ".csv";
        File file = new File(fileName);
        String fileAbsolutePath = file.getAbsolutePath();
        try {
            boolean isNewFileCreated = file.createNewFile();
            log.info("File created status={}, path={}", isNewFileCreated, fileAbsolutePath);
        } catch (IOException e) {
            log.error("Exception while creating file={}", fileAbsolutePath, e);
        }

        // get data
        List<String[]> lines = getLines();

        log.info("Started writing lines to csv");
        Path path = file.toPath();
        try (CSVWriter csvWriter = new CSVWriter(new FileWriter(path.toString()))) {
            for (String[] line : lines) {
                csvWriter.writeNext(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        log.info("Completed writing lines to csv");
    }

    /**
     * Write all lines at once
     */
    @Test
    public void writeAllLines() {
        // file path to create
        String fileName = "csv/students-" + UUID.randomUUID() + ".csv";
        File file = new File(fileName);
        String fileAbsolutePath = file.getAbsolutePath();
        try {
            boolean isNewFileCreated = file.createNewFile();
            log.info("File created status={}, path={}", isNewFileCreated, fileAbsolutePath);
        } catch (IOException e) {
            log.error("Exception while creating file={}", fileAbsolutePath, e);
        }
        // get data
        List<String[]> lines = getLines();

        log.info("Started writing lines to csv");
        Path path = file.toPath();
        try (CSVWriter csvWriter = new CSVWriter(new FileWriter(path.toString()))) {
            csvWriter.writeAll(lines);
        } catch (IOException e) {
            log.error("Exception while writing to csv", e);
        }
        log.info("Completed writing lines to csv");
    }

    /**
     * Write list of objects to csv
     */
    @Test
    public void beanToCSV() {
        // file path to create
        String fileName = "csv/students-" + UUID.randomUUID() + ".csv";
        File file = new File(fileName);
        String fileAbsolutePath = file.getAbsolutePath();
        try {
            boolean isNewFileCreated = file.createNewFile();
            log.info("File created status={}, path={}", isNewFileCreated, fileAbsolutePath);
        } catch (IOException e) {
            log.error("Exception while creating file={}", fileAbsolutePath, e);
        }

        // data
        Student student1 = Student.builder().id(1).name("jill").course("java").build();
        Student student2 = Student.builder().id(2).name("jim").course("csv").build();
        Student student3 = Student.builder().id(3).name("john").course("cloud").build();
        List<Student> studentList = List.of(student1, student2, student3);

        log.info("Started writing lines to csv");
        Path path = file.toPath();
        try(Writer writer = new FileWriter(path.toString())) {
            StatefulBeanToCsv<Student> studentStatefulBeanToCsv = new StatefulBeanToCsvBuilder<Student>(writer)
                    .withQuotechar('\'')
                    .withSeparator(CSVWriter.DEFAULT_SEPARATOR)
                    .build();
            studentStatefulBeanToCsv.write(studentList);
        }catch (IOException | CsvDataTypeMismatchException | CsvRequiredFieldEmptyException e){
            log.error("Exception while writing to csv", e);
        }
        log.info("Completed writing lines to csv");
    }


}