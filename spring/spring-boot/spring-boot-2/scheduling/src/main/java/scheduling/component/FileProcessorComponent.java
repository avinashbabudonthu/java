package scheduling.component;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import lombok.SneakyThrows;

@Component
public class FileProcessorComponent {

	private static final Logger log = LoggerFactory.getLogger(FileProcessorComponent.class);

	@Value("${app.input.files.path}")
	private String filePath;

	@Value("${app.inprogress.files.path}")
	private String inProgress;

	@Value("${app.success.files.path}")
	private String success;

	@Value("${app.error.files.path}")
	private String error;

	@Scheduled(fixedDelay = 5000, initialDelay = 2000)
	public void read() {
		// read files in directory
		File filesDirectory = new File(filePath);
		File[] filesList = filesDirectory.listFiles();

		if (null != filesList && filesList.length == 0) {
			log.info("no new files");
		}

		for (File file : filesList) {
			if (!file.isDirectory()) {
				process(file);
			}
		}
	}

	private void process(File inputFile) {
		String name = inputFile.getName();
		String extension = name.substring(name.lastIndexOf(".") + 1);
		File inProgressFile = new File(
				filePath + File.separator + ".." + File.separator + inProgress + File.separator + name);

		log.info("processing started, file={}", name);

		if (!"xlsx".equalsIgnoreCase(extension)) {
			log.info("wrong file extension, copying to error folder, name={}, extension={}", name, extension);
			copyToFolder(inputFile, error);
			deleteFile(inputFile);
		} else {
			try {
				copyToFolder(inputFile, inProgress); // copy file to in progress folder
				deleteFile(inputFile); // delete file from files folder

				callAPI(inProgressFile); // call API with file from in progress folder

				copyToFolder(inProgressFile, success); // copy file to completed folder
				deleteFile(inProgressFile); // delete file from in progress folder
			} catch (Exception e) {
				log.error("Exception while processing file={}", inProgressFile.getName());
				copyToFolder(inProgressFile, error);
				deleteFile(inProgressFile); // delete file from in progress folder
			}

			log.info("processing completed, file={}", name);
		}
	}

	@SneakyThrows
	private void copyToFolder(File file, String destinationDirectory) {
		String name = file.getName();
		File destination = new File(
				filePath + File.separator + ".." + File.separator + destinationDirectory + File.separator + name);
		log.info("copying file={} to folder={} ", name, destination.getAbsolutePath());

		try (FileInputStream sourceFileInputStream = new FileInputStream(file);
				FileOutputStream destinationFileInputStream = new FileOutputStream(destination);) {
			FileChannel sourceFileChannel = sourceFileInputStream.getChannel();
			FileChannel destinationFileChannel = destinationFileInputStream.getChannel();
			sourceFileChannel.transferTo(0, file.length(), destinationFileChannel);
		}

		// log.info("copied to {} folder: {}", destinationDirectory, name);
		log.info("copied file={} to folder={} ", name, destination.getAbsolutePath());
	}

	private void deleteFile(File file) {
		String name = file.getAbsolutePath();
		log.info("deleting file={}", name);
		boolean fileDeleteStatus = file.delete();
		log.info("delted file={}, status={}", name, fileDeleteStatus);
	}

	private void callAPI(File file) {
		String name = file.getName();
		if (name.contains("file-4")) {
			throw new RuntimeException("error processing file=" + name);
		}

		log.info("Calling an API with file={}", name);
	}
}
