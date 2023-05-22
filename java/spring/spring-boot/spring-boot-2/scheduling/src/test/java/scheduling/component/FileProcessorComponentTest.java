package scheduling.component;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.util.FileSystemUtils;

@RunWith(MockitoJUnitRunner.class)
public class FileProcessorComponentTest {

	private static final Logger log = LoggerFactory.getLogger(FileProcessorComponentTest.class);

	@InjectMocks
	private FileProcessorComponent fileProcessorComponent;

	@Test
	public void read2() throws Exception {
		final String IN_PROGRESS = "Inprogress";
		final String SUCCESS = "Success";
		final String ERROR = "Error";

		File tempDirectoryFile = Files.createTempDirectory("sources").toFile();
		String tempDirAbsolutePath = tempDirectoryFile.getAbsolutePath();
		System.out.println("tempDirAbsolutePath: " + tempDirAbsolutePath);

		Path sourceDirectoryPath = Files.createDirectory(Paths.get(tempDirAbsolutePath, "Source"));
		File sourceDirectoryFile = sourceDirectoryPath.toFile();
		String sourceAbsolutePath = sourceDirectoryFile.getAbsolutePath();
		System.out.println("sourceAbsolutePath: " + sourceAbsolutePath);

		Path errorPath = Files.createDirectory(Paths.get(tempDirAbsolutePath, ERROR));
		String errorAbsolutePath = errorPath.toFile().getAbsolutePath();
		System.out.println("errorAbsolutePath: " + errorAbsolutePath);

		Path inProgressPath = Files.createDirectory(Paths.get(tempDirAbsolutePath, IN_PROGRESS));
		String inProgressAbsolutePath = inProgressPath.toFile().getAbsolutePath();
		System.out.println("inProgressPath: " + inProgressAbsolutePath);

		Path completedPath = Files.createDirectory(Paths.get(tempDirAbsolutePath, SUCCESS));
		String completedAbsolutePath = completedPath.toFile().getAbsolutePath();
		System.out.println("completedAbsolutePath: " + completedAbsolutePath);

		File file1 = File.createTempFile("file-1-", ".txt", sourceDirectoryFile);
		String file1Path = file1.getAbsolutePath();
		System.out.println("file1Path: " + file1Path);

		File file2 = File.createTempFile("file-2-", ".xlsx", sourceDirectoryFile);
		String file2Path = file2.getAbsolutePath();
		System.out.println("file2Path: " + file2Path);

		File file3 = File.createTempFile("file-3-", ".docx", sourceDirectoryFile);
		String file3Path = file3.getAbsolutePath();
		System.out.println("file3Path: " + file3Path);

		FileProcessorComponent fileProcessorComponent = new FileProcessorComponent();
		ReflectionTestUtils.setField(fileProcessorComponent, "filePath", sourceAbsolutePath);
		ReflectionTestUtils.setField(fileProcessorComponent, "inProgress", IN_PROGRESS);
		ReflectionTestUtils.setField(fileProcessorComponent, "error", ERROR);
		ReflectionTestUtils.setField(fileProcessorComponent, "success", SUCCESS);
		fileProcessorComponent.read();

		log.info("Deleting temp directory={}", tempDirAbsolutePath);
		boolean isDeleted = FileSystemUtils.deleteRecursively(tempDirectoryFile);
		log.info("Deleted temp directory={}, delete-status={}", tempDirAbsolutePath, isDeleted);
	}

}
