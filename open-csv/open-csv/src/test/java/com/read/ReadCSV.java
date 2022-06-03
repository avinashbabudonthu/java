package com.read;

import com.opencsv.CSVReader;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import open.csv.model.Student;
import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Slf4j
public class ReadCSV {

    @SneakyThrows
    @Test
    public void readCSVFileToListOfObjects(){
        // create mapping strategy
        ColumnPositionMappingStrategy<Student> columnPositionMappingStrategy = new ColumnPositionMappingStrategy<Student>();
        columnPositionMappingStrategy.setType(Student.class);
        String[] columns = {"id", "name", "course"};
        columnPositionMappingStrategy.setColumnMapping(columns);

        // create csv reader
        URL url = getClass().getClassLoader().getResource("students.csv");
        File file = new File(url.getPath());
        CSVReader csvReader = new CSVReader(new FileReader(file));

        // set column mapping strategy, csv reader to parse and create objects
        CsvToBean<Student> csvToBean = new CsvToBean<>();
        csvToBean.setMappingStrategy(columnPositionMappingStrategy);
        csvToBean.setCsvReader(csvReader);

        List<Student> studentList = csvToBean.parse();
        studentList.forEach(System.out::println);
    }

}