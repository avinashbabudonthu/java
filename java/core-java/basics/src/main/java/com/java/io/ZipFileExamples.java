package com.java.io;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

@Slf4j
public class ZipFileExamples {

    @Test
    public void createZipFile() throws IOException, URISyntaxException {
        Map<String, String> properties = new HashMap<>();
        properties.put("create", "true");
        URI zipURI = new URI("jar:file", Paths.get("src/main/resources/empty.zip").toUri().getPath(), null);
        try (FileSystem zipFileSystem = FileSystems.newFileSystem(zipURI, properties)) {
            log.info("zip file created");
        } catch (Exception e) {
            log.error("exception", e);
        }
    }

    @Test
    public void writeToFileInZip1() throws URISyntaxException {
        Map<String, String> properties = new HashMap<>();
        properties.put("create", "true");
        URI zipUri = new URI("jar:file", Paths.get("src/main/resources/files2.zip").toUri().getPath(), null);
        String[] data = new String[] { "abc", "def", "ghi", "jkl" };
        try (FileSystem zipFileSystem = FileSystems.newFileSystem(zipUri, properties);
             BufferedWriter bufferedWriter = Files.newBufferedWriter(zipFileSystem.getPath("/file1-copy.txt"))) {
            for (String d : data) {
                bufferedWriter.write(d);
                bufferedWriter.newLine();
            }

            log.info("-- using Files --");
            Files.write(zipFileSystem.getPath("file2-copy.txt"), Arrays.asList(data), Charset.defaultCharset(),
                    StandardOpenOption.CREATE);
        } catch (Exception e) {
            log.error("exception", e);
        }
    }

    @Test
    public void copyToZip() throws URISyntaxException {
        Map<String, String> properties = new HashMap<>();
        properties.put("create", "true");
        URI zipUri = new URI("jar:file", Paths.get("src/main/resources/files.zip").toUri().getPath(), null);
        try (FileSystem zipFileSystem = FileSystems.newFileSystem(zipUri, properties)) {
            Path file1 = Paths.get("src/main/resources/file1.txt");
            Path destinationFile = zipFileSystem.getPath("/file1-copy.txt");
            Files.copy(file1, destinationFile, StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
            log.error("exception", e);
        }
    }

    /**
     * Create Zip file with single file
     */
    @Test
    public void createZipFileWithOneFile() {
        byte[] buffer = new byte[1024];

        // we are using try-with-resource, so closing of resources will be done automatically
        try (FileOutputStream fos = new FileOutputStream(
                "E:/Backup/JavaPrep/practiceProjects/CoreJavaPractice/src/main/resources/myZip.zip");
             ZipOutputStream zos = new ZipOutputStream(fos);
             InputStream is = getClass().getClassLoader().getResourceAsStream("file1.txt");) {

            System.out.println("fos: " + fos);
            System.out.println("zos: " + zos);
            System.out.println("is: " + is);

            ZipEntry zipEntry = new ZipEntry("file1.log");
            zos.putNextEntry(zipEntry);

            int length;
            while ((length = is.read(buffer)) > 0) {
                zos.write(buffer, 0, length);
            }

            zos.closeEntry();

            System.out.println("Zip file created");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Create zip file with files present in a folder
     * @throws IOException
     */
    @Test
    public void createZipWithFilesInFolder() throws IOException {
        List<String> sourceFileNamesList = new ArrayList<>();
        String sourceFolder = "E:/Backup/JavaPrep/practiceProjects/CoreJavaPractice/src/main/resources/folder1";
        String outputZipFile = "E:/Backup/JavaPrep/practiceProjects/CoreJavaPractice/src/main/resources/myZip2.zip";

        //get all files names in a source folder
        //if this directory contains sub-directories, iterate recursively to get all file names
        //refer listFilesAndDirectories(File directory) method in this class
        File sourceDirectory = new File(sourceFolder);
        String[] sourceFileNames = sourceDirectory.list();
        for (String sourceFileName : sourceFileNames) {
            int startIndex = Integer.parseInt(String.valueOf(sourceDirectory.length()));
            int endIndex = sourceFileName.length();
            sourceFileNamesList.add(sourceFileName.substring(startIndex, endIndex));
        }

        System.out.println("sourceFileNamesList: " + sourceFileNamesList);

        // create zip file
        byte[] buffer = new byte[1024];

        try (FileOutputStream fos = new FileOutputStream(outputZipFile);
             ZipOutputStream zos = new ZipOutputStream(fos);) {
            for (String file : sourceFileNamesList) {

                // to read file using class loader that file should be in class path else we need to complete path of file and create input stream
                try (InputStream is = getClass().getClassLoader().getResourceAsStream(file);) {
                    ZipEntry zipEntry = new ZipEntry(file);
                    zos.putNextEntry(zipEntry);

                    int length;
                    while ((length = is.read(buffer)) > 0) {
                        zos.write(buffer, 0, length);
                    }

                    System.out.println("File Added: " + file);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Zip file created");
    }

    /**
     * Reading Zip file
     * @throws IOException
     */
    @Test
    public void readZipFile() throws IOException {
        URL url = getClass().getClassLoader().getResource("my-zip-file.zip");
        try (ZipFile zipFile = new ZipFile(url.getPath());) {

            // reading all files in a zip file
            Enumeration<? extends ZipEntry> zipEntries = zipFile.entries();
            while (zipEntries.hasMoreElements()) {
                ZipEntry zipEntry = zipEntries.nextElement();
                if (zipEntry.isDirectory()) {
                    System.out.println("Dir -> " + zipEntry.getName());
                } else {
                    System.out.println("File -> " + zipEntry.getName());
                }
            }

            System.out.println("-----------------------------------------");

            // getting specific file in zip file
            ZipEntry file1Entry = zipFile.getEntry("my-zip-file/file1.txt");
            InputStream file1InputStream = zipFile.getInputStream(file1Entry);
            try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(file1InputStream));) {
                StringBuffer content = new StringBuffer();
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    content.append(line).append("\n");
                }
                System.out.println("file1 content: " + content);
            }

            System.out.println("-----------------------------------------");

            // getting specific file in sub-folder in zip file
            ZipEntry file4Entry = zipFile.getEntry("my-zip-file/sub-folder/file4.txt");
            InputStream file4InputStream = zipFile.getInputStream(file4Entry);
            try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(file4InputStream));) {
                StringBuffer content = new StringBuffer();
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    content.append(line).append("\n");
                }
                System.out.println("file4 content: " + content);
            }

        }
    }

    /**
     * Extract or unzip the zip file
     */
    @Test
    public void extract() {
        try {
            URL zipFileUrl = getClass().getClassLoader().getResource("test.zip");
            assert null != zipFileUrl;
            String zipFileStr = zipFileUrl.getFile();
            String destinationDir = Files.createTempDirectory("zip_extract_test_").toFile().getAbsolutePath();
            try (net.lingala.zip4j.ZipFile zipFile = new net.lingala.zip4j.ZipFile(new File(zipFileStr))) {
                log.info("Unzipping, zipFileStr={}, isZipFileValid={}, destinationDir={}", zipFileStr, zipFile.isValidZipFile(), destinationDir);
                zipFile.extractAll(destinationDir);
                log.info("Unzipped, zipFileStr={}, destinationDir={}", zipFileStr, destinationDir);
            }
        } catch (Exception e) {
            log.error("Exception while unzipping", e);
        }
    }

}