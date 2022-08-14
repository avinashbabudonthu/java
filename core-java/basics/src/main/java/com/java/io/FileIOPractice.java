package com.java.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.DirectoryStream;
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
import java.util.Formatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.StringJoiner;
import java.util.stream.Stream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FileIOPractice {

	/**
	 * Prepare java.io.File object using string path
	 */
	@Test
	public void stringToFileObject() {
		String filePath1 = "file1.txt";
		File file1 = new File(filePath1);
		System.out.println("file1: " + file1);

		String filePath2 = "E:\\Backup\\JavaPrep\\practiceProjects\\CoreJavaPractice\\src\\main\\resources\\file1.txt";
		File file2 = new File(filePath2);
		System.out.println("file2: " + file2);
	}

	/**
	 * convert file to java.io.InputStream
	 * @throws IOException
	 */
	@Test
	public void convertFileToInputstream() throws IOException {
		String filePath1 = "E:\\Backup\\JavaPrep\\practiceProjects\\CoreJavaPractice\\src\\main\\resources\\file1.txt";
		File file = new File(filePath1);
		InputStream inputStream1 = new FileInputStream(file);
		System.out.println("inputStream1: " + inputStream1 + ", number of bytes:" + inputStream1.available());
		inputStream1.close();

		InputStream inputStream2 = getClass().getClassLoader().getResourceAsStream("file1.txt");
		System.out.println("inputStream2: " + inputStream2 + ", number of bytes:" + inputStream2.available());
		inputStream2.close();

		// from java 7 
		try (InputStream inputStream3 = getClass().getClassLoader().getResourceAsStream("file1.txt")) {
			System.out.println("inputStream3: " + inputStream3 + ", number of bytes:" + inputStream3.available());
		}
	}

	/**
	 * Method to get current project directory
	 */
	@Test
	public void getCurrentProjectDirectory() {
		// method 1
		String projectDirectory1 = System.getProperty("user.dir");
		System.out.println("FileIOPractice -> getCurrentDirectory() -> projectDirectory1: " + projectDirectory1);

		// method 2
		String projectDirectory2 = Paths.get("").toAbsolutePath().toString();
		System.out.println("FileIOPractice -> getCurrentDirectory() -> projectDirectory2: " + projectDirectory2);

		// method 3
		String projectDirectory3 = Paths.get(".").toAbsolutePath().normalize().toString();
		System.out.println("FileIOPractice -> getCurrentDirectory() -> projectDirectory3: " + projectDirectory3);

		// method 4
		URL projectDirectory4 = getClass().getProtectionDomain().getCodeSource().getLocation();
		System.out.println("FileIOPractice -> getCurrentDirectory() -> projectDirectory4: " + projectDirectory4);

		// method 5
		String myCurrentDir = System.getProperty("user.dir") + File.separator + System.getProperty("sun.java.command")
				.substring(0, System.getProperty("sun.java.command").lastIndexOf(".")).replace(".", File.separator);
		System.out.println("FileIOPractice -> getCurrentDirectory() -> myCurrentDir: " + myCurrentDir);
	}

	/**
	 * method to get line separator based on underlying operating system instead of hard coding
	 */
	@Test
	public void lineSeparator() {
		String lineSeparator = System.getProperty("line.separator").toString();
		System.out.println("abc" + lineSeparator + "def");

		String lineSeparator2 = File.separator;
		System.out.println("lineSeperator2: " + lineSeparator2);
	}

	/**
	 * Create a directory
	 */
	@Test
	public void createDirectory() {
		boolean isTestFolderCreated = new File("E:\\Backup\\testFolder").mkdir();
		System.out.println("isTestFolderCreated: " + isTestFolderCreated);

		boolean isFolderStructureCreated = new File("E:\\Backup\\folder1\\folder2").mkdirs();
		System.out.println("isFolderStructureCreated: " + isFolderStructureCreated);

		// from JDK 7 - using java.nio.file package
		try {
			Path path = Paths.get("E:\\Backup\\folder3\\folder4");
			System.out.println("Files.exists(path) : " + Files.exists(path));
			Files.createDirectories(path);
			System.out.println("Files.exists(path) : " + Files.exists(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void convertPathToFile() {
		final Path path = new File(getClass().getClassLoader().getResource("file1.txt").getPath()).toPath();
		log.info("path={}", path);

		File file = path.toFile();
		log.info("file={}", file.getAbsolutePath());
	}

	@Test
	public void writeToFile() throws IOException {
		try (BufferedWriter bufferedWriter = Files.newBufferedWriter(Paths.get("src/main/resources/file4.txt"));
				Formatter formatter = new Formatter(bufferedWriter)) {
			formatter.format("core java %s", "file io");
			bufferedWriter.newLine();
			formatter.format("core java %s %s", "file io", "practice");
		}

		File file2 = new File(
				"E:\\Backup\\JavaPrep\\practiceProjects\\CoreJavaPractice\\src\\main\\resources\\new-file2.txt");
		boolean isFile2Created = file2.createNewFile();
		System.out.println("isFile2Created: " + isFile2Created);
		System.out.println("FileIOPractice -> createFile() -> writing file2 using OutputStream");
		String fileData = "New file created. Let's write some data";
		byte[] fileDataAsByteArray = fileData.getBytes(StandardCharsets.UTF_8);
		try (OutputStream outputStream = new FileOutputStream(file2);) {
			outputStream.write(fileDataAsByteArray, 0, fileDataAsByteArray.length);
		}
	}

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
	 * java.io.OutputStream.write() method
	 * @throws IOException
	 */
	@Test
	public void writeMethod() throws IOException {
		try (OutputStream os = new FileOutputStream(new File(
				"E:\\Backup\\JavaPrep\\practiceProjects\\CoreJavaPractice\\src\\main\\resources\\file3.txt"))) {
			byte data = 100;
			os.write(data);
		}
		System.out.println("---- file file3.txt created. check the path. ---------");

		// java.io.Writer.write() method
		try (Writer writer = new FileWriter(new File(
				"E:\\Backup\\JavaPrep\\practiceProjects\\CoreJavaPractice\\src\\main\\resources\\file4.txt"))) {
			char data = 'A';
			writer.write(data);
		}
		System.out.println("---- file file4.txt created. check the path. ---------");

		// java.io.Writer.write(char[] data) method
		try (Writer writer = new FileWriter(new File(
				"E:\\Backup\\JavaPrep\\practiceProjects\\CoreJavaPractice\\src\\main\\resources\\file5.txt"))) {
			char[] data = { 'A', 'B', 'C', 'D' };
			writer.write(data);
		}
		System.out.println("---- file file5.txt created. check the path. ---------");

		// java.io.Writer.write(String data) method
		try (Writer writer = new FileWriter(new File(
				"E:\\Backup\\JavaPrep\\practiceProjects\\CoreJavaPractice\\src\\main\\resources\\file6.txt"))) {
			String data = "jack";
			writer.write(data);
		}
		System.out.println("---- file file6.txt created. check the path. ---------");
	}

	@Test
	public void readFileUsingScanner() {
		URL url2 = getClass().getClassLoader().getResource("file1.txt");
		File file2 = new File(url2.getPath());
		System.out.println("readContentsOfFile() -> file2.getAbsolutePath(): " + file2.getAbsolutePath());
		try (Scanner scanner = new Scanner(file2)) {
			while (scanner.hasNextLine()) {
				System.out.println(scanner.nextLine());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void readFileUsingBufferedReadWithAbsolutePath() {
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(
				"E:\\Backup\\JavaPrep\\practiceProjects\\CoreJavaPractice\\src\\main\\resources\\file1.txt"))) {
			String line = "";
			while ((line = bufferedReader.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@SneakyThrows
	@Test
	public void readFileUsingBufferedReaderAndRelativePath() {
		try (BufferedReader bufferedReader = Files
				.newBufferedReader(Paths.get("src/main/resources/file1.txt").toAbsolutePath())) {

			Stream<String> lines = bufferedReader.lines();
			lines.forEach(System.out::println);
		}
	}

	@Test
	public void readFileUsingFileSystemsAndRelativePath() throws IOException {
		try (BufferedReader bufferedReader = Files
				.newBufferedReader(FileSystems.getDefault().getPath("src/main/resources/file1.txt"))) {
			Stream<String> lines = bufferedReader.lines();
			lines.forEach(System.out::println);
		}
	}

	@Test
	public void readFileUsingFilesAndRelativePath() throws IOException {
		// method 1
		List<String> allLines = Files.readAllLines(Paths.get("src/main/resources/file1.txt"));
		allLines.stream().forEach(System.out::println);
	}

	@Test
	public void paths() {
		// read 1 file
		Path path = Paths.get("file1.txt");
		log.info("file-name={}, absolute-path={}", path.toString(), path.toAbsolutePath().toString());

		log.info("-- reading multiple files ---");
		Path paths = Paths.get("file1.txt", "file2.txt");
		paths.forEach(eachPath -> {
			log.info("file-name={}, absolute-path={}", eachPath.toString(), eachPath.toAbsolutePath().toString());
		});

	}

	@Test
	public void readFileByteByByteUsingFileInputStream() throws FileNotFoundException, IOException {
		// read each byte
		File file = new File(Paths.get("src/main/resources/file1.txt").toAbsolutePath().toString());
		try (InputStream insInputStream = new FileInputStream(file)) {
			int intValue = -1;
			StringBuffer fileContent = new StringBuffer();
			while ((intValue = insInputStream.read()) >= 0) {
				char charValue = (char) intValue;
				fileContent.append(charValue);
			}

			log.info("file-content={}", fileContent);
		}
	}

	@Test
	public void readFileByByteArrayUsingFileInputStream() throws FileNotFoundException, IOException {
		File file = new File(Paths.get("src/main/resources/file1.txt").toAbsolutePath().toString());
		try (InputStream insInputStream = new FileInputStream(file)) {
			int length;
			byte[] byteBuffer = new byte[20];
			StringBuffer fileContent = new StringBuffer();
			while ((length = insInputStream.read(byteBuffer)) >= 0) {
				for (int i = 0; i < length; i++) {
					char value = (char) byteBuffer[i];
					fileContent.append(value);
				}
			}

			log.info("file-content={}", fileContent);
		}
	}

	@Test
	public void readFileCharByCharUsingInputStreamReader() throws FileNotFoundException, IOException {
		File file = new File(Paths.get("src/main/resources/file1.txt").toAbsolutePath().toString());
		try (InputStream inputStream = new FileInputStream(file); Reader reader = new InputStreamReader(inputStream)) {
			int intValue;
			StringBuffer fileContent = new StringBuffer();
			while ((intValue = reader.read()) >= 0) {
				char value = (char) intValue;
				fileContent.append(value);
			}
			log.info("file-content={}", fileContent);
		}
	}

	@Test
	public void readFileByCharUsingInputStreamReader() throws FileNotFoundException, IOException {
		File file = new File(Paths.get("src/main/resources/file1.txt").toAbsolutePath().toString());
		try (InputStream inputStream = new FileInputStream(file); Reader reader = new InputStreamReader(inputStream)) {
			int length;
			char[] charBuffer = new char[10];
			StringBuffer fileContent = new StringBuffer();
			while ((length = reader.read(charBuffer)) >= 0) {
				for (int i = 0; i < length; i++) {
					fileContent.append(charBuffer[i]);
				}
			}
			log.info("file-content={}", fileContent);
		}
	}

	@Test
	public void copyFileUsingFileStreams() throws IOException {
		log.info("------- using FileStreams ----------");
		File srcFile2 = new File(Paths.get("src/main/resources/file1.txt").toAbsolutePath().toString());
		File destFile2 = new File(Paths.get("src/main/resources/file-" + System.currentTimeMillis() + ".txt")
				.toAbsolutePath().toString());
		try (FileInputStream input = new FileInputStream(srcFile2);
				FileOutputStream output = new FileOutputStream(destFile2)) {
			byte[] buf = new byte[1024];
			int bytesRead;

			while ((bytesRead = input.read(buf)) > 0) {
				output.write(buf, 0, bytesRead);
			}
		}
		log.info("------- files copied using FileStreams ----------");

	}

	@Test
	public void copyFileUsingFiles() throws IOException, FileNotFoundException {
		log.info("----- using java.nio.file.Files.copy() ---------");
		Path source = Paths.get("src/main/resources/file1.txt");
		Path out = Paths.get("src/main/resources/file-" + System.currentTimeMillis() + ".txt");
		log.info("\n source={}, \n out={}", source, out);
		Files.copy(source, out);
		log.info("------ file copied successfully using java.nio.file.Files ---------");

		log.info("------ using java.nio.channels.FileChannel.transferTo() --------");
		File sourceFile = new File(Paths.get("src/main/resources/file1.txt").toAbsolutePath().toString());
		File destinationFile = new File(Paths.get("src/main/resources/file-" + System.currentTimeMillis() + ".txt")
				.toAbsolutePath().toString());
		try (FileInputStream sourceFileInputStream = new FileInputStream(sourceFile);
				FileOutputStream destinationFileInputStream = new FileOutputStream(destinationFile);) {
			FileChannel sourceFileChannel = sourceFileInputStream.getChannel();
			FileChannel destinationFileChannel = destinationFileInputStream.getChannel();
			sourceFileChannel.transferTo(0, sourceFile.length(), destinationFileChannel);
		}
		log.info("------ files copied using java.nio.channels.FileChannel.transferTo() --------");
	}

	@Test
	public void copyFileUsingApacheCommons() throws IOException {
		log.info("-------- using apache commons ----------");
		File srcFile = new File(Paths.get("src/main/resources/file1.txt").toAbsolutePath().toString());
		File destFile = new File(Paths.get("src/main/resources/file-" + System.currentTimeMillis() + ".txt")
				.toAbsolutePath().toString());

		log.info("\n srcFile={}, \n destFile={}", srcFile, destFile);
		FileUtils.copyFile(srcFile, destFile);
		// use above or below
		//IOUtils.copy(new FileInputStream(srcFile), new FileOutputStream(destFile));
		log.info("----- file copied successfully using apache commons --------");
	}

	@Test
	public void deleteFile() {
		File file2 = new File(Paths.get("src/main/resources/file2.txt").toAbsolutePath().toString());
		if (file2.delete()) {
			log.info("{} deleted", file2.getName());
		} else {
			log.info("{} deletion failed", file2.getName());
		}

		// method 2
		URL url = getClass().getClassLoader().getResource("file2.txt");
		File file = new File(url.getPath());
		File parentDirectory = new File(file.getParent());

		// before file delete
		System.out.println("--- before delete-----");
		String[] filesList = parentDirectory.list();
		for (String fileName : filesList) {
			System.out.println("fileName: " + fileName);
		}

		file.delete();

		//after file delete
		System.out.println("--- after delete-----");
		filesList = parentDirectory.list();
		for (String fileName : filesList) {
			System.out.println("fileName: " + fileName);
		}
	}

	/**
	 * Method to iterate list of files in directories and sub directories
	 */
	@Test
	public void listFilesAndDirectories() {
		File directory = new File("E:/Backup/JavaPrep/practiceProjects/images");
		listFilesAndDirectories(directory);
	}

	private void listFilesAndDirectories(File directory) {
		File[] listOfFiles = directory.listFiles();
		for (File file : listOfFiles) {
			if (file.isDirectory())
				listFilesAndDirectories(file);
			System.out.println(file.getPath() + "\\" + file.getName());
		}
	}

	/**
	 * Read file using relative path
	 */
	@Test
	public void readFileWithRelativePath() throws IOException {
		URL url = getClass().getClassLoader().getResource("file1.txt");

		File file = new File(url.getPath());
		System.out.println("readFileWithRelativePath() -> file.getAbsolutePath(): " + file.getAbsolutePath());

		System.out.println("-----------------method 1 - reading content--------------------------");
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file));) {
			String line = "";
			while ((line = bufferedReader.readLine()) != null) {
				System.out.println(line);
			}
		}

		System.out.println("-----------------method 2 - reading content--------------------------");
		try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("file1.txt");
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))) {
			String line = "";
			while ((line = bufferedReader.readLine()) != null) {
				System.out.println(line);
			}
		}
	}

	/**
	 * Read file with relative path from static method
	 * 
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static void readFileWithRelativePathFromStaticMethod() throws FileNotFoundException, IOException {

		URL url = FileIOPractice.class.getClassLoader().getResource("file1.txt");
		File file = new File(url.getPath());
		System.out.println(
				"readFileWithRelativePathFromStaticMethod() -> file.getAbsolutePath(): " + file.getAbsolutePath());

		System.out.println("-----------------method 1 - reading content--------------------------");
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file));) {
			String line = "";
			while ((line = bufferedReader.readLine()) != null) {
				System.out.println(line);
			}
		}

		System.out.println("-----------------method 2 - reading content--------------------------");
		try (InputStream inputStream = FileIOPractice.class.getClassLoader().getResourceAsStream("file1.txt");
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))) {
			String line = "";
			while ((line = bufferedReader.readLine()) != null) {
				System.out.println(line);
			}
		}

	}

	@Test
	public void lineNumberReader() throws IOException {
		URL url = getClass().getClassLoader().getResource("file1.txt");
		File file = new File(url.getPath());

		Reader reader = new FileReader(file);
		try (LineNumberReader lineNumberReader = new LineNumberReader(reader)) {

			String line;
			while (null != (line = lineNumberReader.readLine()))
				System.out.println(lineNumberReader.getLineNumber() + ": " + line);
		}
	}

	@Test
	public void readFileUsingFilesAndStreamJDK8() {
		final Path path = new File(getClass().getClassLoader().getResource("file1.txt").getPath()).toPath();
		try (Stream<String> lines = Files.lines(path, StandardCharsets.UTF_8)) {
			lines.onClose(() -> System.out.println("Done")).forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		}
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
	 * Read file by wild card in file name
	 */
	@Test
	public void readFileByWildCard() {
		// JDK 7
		try (DirectoryStream<Path> dirStream = Files.newDirectoryStream(
				Paths.get("E:\\Backup\\JavaPrep\\practiceProjects\\CoreJavaPractice\\src\\main\\resources"),
				"file1*.txt")) {
			System.out.println(Files.exists(
					Paths.get("E:\\Backup\\JavaPrep\\practiceProjects\\CoreJavaPractice\\src\\main\\resources")));
			dirStream.forEach(path -> System.out.println(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * InputStream.read() method
	 * Reader.read()
	 * @throws IOException 
	 */
	@Test
	public void readMethod() throws IOException {
		// InputStream.read()
		System.out.println("----- reading with java.io.InputStream ---------");
		try (InputStream inputStream = new FileInputStream(new File(
				"E:\\Backup\\JavaPrep\\practiceProjects\\CoreJavaPractice\\src\\main\\resources\\file1.txt"))) {
			int byteVal;
			StringJoiner stringJoiner = new StringJoiner(",", "[", "]");
			while ((byteVal = inputStream.read()) != -1) {
				byte val = (byte) byteVal;
				stringJoiner.add(String.valueOf(val));
			}
			System.out.println(stringJoiner);
		}

		// java.io.InputStream.read(byte[] data)
		System.out.println("----- InputStream.read(byte[] data) -----");
		try (InputStream is = new FileInputStream(new File(
				"E:\\Backup\\JavaPrep\\practiceProjects\\CoreJavaPractice\\src\\main\\resources\\file1.txt"))) {
			byte[] data = new byte[10];
			int noOfBytesRead;
			while ((noOfBytesRead = is.read(data)) > 0) {
				log.info("number-of-bytes-read={}", noOfBytesRead);
				StringJoiner stringJoiner = new StringJoiner(",", "[", "]");
				for (byte byteVal : data) {
					stringJoiner.add(String.valueOf(byteVal));
				}
				System.out.println(stringJoiner);
			}
		}

		// java.io.Reader.read() method
		System.out.println("------ reading with java.io.Reader -----------");
		try (Reader reader = new FileReader(new File(
				"E:\\Backup\\JavaPrep\\practiceProjects\\CoreJavaPractice\\src\\main\\resources\\file1.txt"))) {
			int charVal;
			StringJoiner stringJoiner = new StringJoiner(",", "[", "]");
			while ((charVal = reader.read()) != -1) {
				char val = (char) charVal;
				stringJoiner.add(String.valueOf(val));
			}
			System.out.println(stringJoiner);
		}

		// java.io.Reader.read(char[] data) method
		System.out.println("----- Reader.read(byte[] data) -----");
		try (Reader is = new FileReader(new File(
				"E:\\Backup\\JavaPrep\\practiceProjects\\CoreJavaPractice\\src\\main\\resources\\file1.txt"))) {
			char[] data = new char[10];
			int noOfBytesRead;
			while ((noOfBytesRead = is.read(data)) > 0) {
				StringJoiner stringJoiner = new StringJoiner(",", "[", "]");
				for (char byteVal : data) {
					stringJoiner.add(String.valueOf(byteVal));
				}
				System.out.println(stringJoiner);
			}
		}
	}

	/**
	 * Execute directly
	 * Execute with VM argument : -Djava.io.tmpdir=C:\Temp
	 */
	@Test
	public void tempFolder() {
		String tempDirPath = System.getProperty("java.io.tmpdir");
		System.out.println("tempDirPath: " + tempDirPath);
	}
	
	@SneakyThrows
    @Test
    public void createTempDirectory(){
        log.info("creating temp directory");
        Path tempDirectory = Files.createTempDirectory("folder_prefix");
        File file = tempDirectory.toFile();
        log.info("temp directory created. path: {}", file.getAbsolutePath());
    }
	
	/**
        * Output:
        * abc
        * def
        */
    @Test
    public void lineSeparator(){
	String lineSeparator = System.getProperty("line.separator");
	System.out.println("abc" + lineSeparator + "def");
    }
    
    /**
     * Output: abc\def
     */
    @Test
    public void fileSeparator(){
        String fileSeparator = File.separator;
        System.out.println("abc" + fileSeparator + "def");
    }
	
    // Download file to temp directory
    @SneakyThrows
    @Test
    public void downloadFile(){
        // create temp directory
        File tempDirectoryFile = createTempDirectory();

        // prepare URL to download file
        String urlString = "https://abcd.com/data.zip";
        URL url = new URL(urlString);

        // destination file path with file name
        String zipFileDownloadFilePath = tempDirectoryFile.getAbsolutePath() + File.separator + "file.zip";

        // download file
        downloadFileV2(url, zipFileDownloadFilePath);
    }

    @SneakyThrows
    private void downloadFileV2(URL url, String zipFileDownloadFilePath){
        log.info("downloading file, url: {}, zip-file: {}", url.toString(), zipFileDownloadFilePath);
        FileUtils.copyURLToFile(url, new File(zipFileDownloadFilePath));
        log.info("file downloaded, url: {}, zip-file: {}", url.toString(), zipFileDownloadFilePath);
    }
	
    @SneakyThrows
    @Test
    public void deleteDirectory(File file){
        String fileAbsolutePath = file.getAbsolutePath();
        log.info("deleting directory: {}", fileAbsolutePath);
        FileUtils.deleteDirectory(file);
        log.info("deleted directory: {}", fileAbsolutePath);
    }
	
}
