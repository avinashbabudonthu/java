package com.open.csv;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.exceptions.CsvException;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import open.csv.model.Student;
import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Slf4j
public class ReadCSV {

    @SneakyThrows
    @Test
    public void readCSVFileToListOfObjects() {
        // create mapping strategy
        ColumnPositionMappingStrategy<Student> columnPositionMappingStrategy = new ColumnPositionMappingStrategy<>();
        columnPositionMappingStrategy.setType(Student.class);
        String[] columns = {"id", "name", "course"};
        columnPositionMappingStrategy.setColumnMapping(columns);

        // create csv reader
        URL url = getClass().getClassLoader().getResource("students.csv");
        Objects.requireNonNull(url);
        File file = new File(url.getPath());
        CSVReader csvReader = new CSVReader(new FileReader(file));

        // set column mapping strategy, csv reader to parse and create objects
        CsvToBean<Student> csvToBean = new CsvToBean<>();
        csvToBean.setMappingStrategy(columnPositionMappingStrategy);
        csvToBean.setCsvReader(csvReader);

        List<Student> studentList = csvToBean.parse();
        studentList.forEach(System.out::println);
    }

    @Test
    public void readCSV() {
        String fileName = "students.csv";
        URL url = ReadCSV.class.getClassLoader().getResource(fileName);
        Objects.requireNonNull(url);
        String filePath = url.getPath();
        File file = new File(filePath);
        Path path = file.toPath();
        List<String[]> rows = new ArrayList<>();
        try (Reader reader = Files.newBufferedReader(path); CSVReader csvReader = new CSVReader(reader)) {
            rows = csvReader.readAll();
        } catch (IOException | CsvException e) {
            log.error("Exception while reading csv, fileName={}", fileName, e);
        }

        for (String[] row : rows) {
            log.info("row={}", Arrays.deepToString(row));
        }
    }

    /**
     * Using CSVReaderBuilder.
     * CSVReaderBuilder allows us to skip the column headings and set parsing rules through CSVParserBuilder.
     */
    @Test
    public void readCSV2() {
        String fileName = "students.csv";
        URL url = ReadCSV.class.getClassLoader().getResource(fileName);
        Objects.requireNonNull(url);
        String filePath = url.getPath();
        File file = new File(filePath);
        Path path = file.toPath();
        List<String[]> rows = new ArrayList<>();
        CSVParser csvParser = new CSVParserBuilder()
                .withSeparator(',')
                .withIgnoreQuotations(true)
                .build();
        try (Reader reader = Files.newBufferedReader(path);
             CSVReader csvReader = new CSVReaderBuilder(reader)
                     .withSkipLines(1) // skip 1st line. generally header
                     .withCSVParser(csvParser)
                     .build()) {
            rows = csvReader.readAll();
        } catch (IOException | CsvException e) {
            log.error("Exception while reading csv, fileName={}", fileName, e);
        }

        for (String[] row : rows) {
            log.info("row={}", Arrays.deepToString(row));
        }
    }

}