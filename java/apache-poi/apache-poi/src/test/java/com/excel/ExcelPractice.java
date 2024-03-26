package com.excel;


import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

@Slf4j
class ExcelPractice {

    @Test
    void readExcel() {

        // Reading file from local directory
        try (FileInputStream file = new FileInputStream(new File("file-1.xlsx"))) {
            // Create Workbook instance holding reference to .xlsx file
            XSSFWorkbook workbook = new XSSFWorkbook(file);

            int numberOfSheets = workbook.getNumberOfSheets();
            log.info("number of sheets = {}", numberOfSheets);

            for (int i = 0; i < numberOfSheets; i++) {
                // read each sheet from the workbook
                XSSFSheet sheet = workbook.getSheetAt(i);

                log.info("reading sheet number={}, name={}", i, sheet.getSheetName());

                // Iterate through each rows one by one
                Iterator<Row> rowIterator = sheet.iterator();

                // Till there is an element condition holds true
                while (rowIterator.hasNext()) {
                    Row row = rowIterator.next();

                    // For each row, iterate through all the columns
                    Iterator<Cell> cellIterator = row.cellIterator();

                    while (cellIterator.hasNext()) {
                        Cell cell = cellIterator.next();
                        Object value = null;

                        // Checking the cell type and format accordingly
                        switch (cell.getCellType()) {
                            case NUMERIC:
                                value = cell.getNumericCellValue();
                                break;
                            case STRING:
                                value = cell.getStringCellValue();
                                break;
                        }
                        log.info("{}", value);
                    }

                    System.out.println("-------------");
                }

            }

            System.out.println("######## Completed ########");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Procedure: Writing a file using POI is very simple and involve the following steps:
     * <p>
     * Create a workbook
     * Create a sheet in the workbook
     * Create a row in the sheet
     * Add cells in the sheet
     * Repeat steps 3 and 4 to write more data.
     * Close the output stream.
     */
    @Test
    void writeExcel() {
        // Blank worksheet
        try (XSSFWorkbook workbook = new XSSFWorkbook();
             FileOutputStream out = new FileOutputStream("file-1.xlsx")) {
            // Creating blank Excel sheet
            XSSFSheet sheet = workbook.createSheet("students");

            // create data
            Map<String, Object[]> data = new TreeMap<>();
            data.put("1", new Object[]{"id", "name", "course"});
            data.put("2", new Object[]{"1", "Jim", "Java"});
            data.put("3", new Object[]{"2", "Jill", "J2EE"});
            data.put("4", new Object[]{"3", "Jack", "Spring"});
            data.put("5", new Object[]{"4", "John", "SQL"});

            // Iterating over data and writing it to sheet
            Set<String> keyset = data.keySet();
            int rownum = 0;
            for (String key : keyset) {
                // Creating a new row in the sheet
                Row row = sheet.createRow(rownum++);

                Object[] objArr = data.get(key);

                int cellnum = 0;
                for (Object obj : objArr) {
                    // This line creates a cell in the next column of that row
                    Cell cell = row.createCell(cellnum++);

                    if (obj instanceof String) {
                        cell.setCellValue((String) obj);
                    } else if (obj instanceof Integer) {
                        cell.setCellValue((Integer) obj);
                    }

                }
            }

            workbook.write(out);
            log.info("file-1.xlsx created successfully in path");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
