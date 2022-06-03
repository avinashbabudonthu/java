package com.tar.gz;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Objects;

import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarArchiveInputStream;
import org.apache.commons.compress.compressors.CompressorInputStream;
import org.apache.commons.compress.compressors.gzip.GzipCompressorInputStream;
import org.apache.commons.compress.utils.IOUtils;
import org.junit.Test;

import com.tar.Compress;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UnCompress {

	/**
	 * Decompress tar file and display files Create tar file using
	 * method @see{{@link Compress#compressToTar()}}
	 */
	@Test
	public void decompress() {
		String inputTarFilePath = "C:\\Java-Prep\\practice-projects\\third-party-libraries\\commons-compress\\files\\tar-1.tar.gz";
		String outputDirectoryPath = "C:\\Java-Prep\\practice-projects\\third-party-libraries\\commons-compress\\files\\tar-1-decompress";
		File outputDirectory = new File(outputDirectoryPath);

		try (CompressorInputStream compressorInputStream = new GzipCompressorInputStream(
				new FileInputStream(inputTarFilePath), true);
				OutputStream outputStream = new FileOutputStream("tar-1.tar")) {
			IOUtils.copy(compressorInputStream, outputStream);

			TarArchiveInputStream tarArchiveInputStream = new TarArchiveInputStream(compressorInputStream);

			TarArchiveEntry tarArchiveEntry;
			while (Objects.nonNull(tarArchiveEntry = tarArchiveInputStream.getNextTarEntry())) {
				if (tarArchiveEntry.isDirectory()) {
					continue;
				}

				File currentFile = new File(outputDirectory, tarArchiveEntry.getName());
				File parent = currentFile.getParentFile();
				if (!parent.exists()) {
					parent.mkdir();
				}
				IOUtils.copy(tarArchiveInputStream, new FileOutputStream(currentFile));
			}
		} catch (IOException e) {
			log.error("Exception while unzipping", e);
		}
	}

}
