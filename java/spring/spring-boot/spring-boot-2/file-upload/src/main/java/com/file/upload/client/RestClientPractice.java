package com.file.upload.client;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.Test;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.file.upload.model.StatusModel;

import lombok.SneakyThrows;

public class RestClientPractice {

	@Test
	public void uploadFiles() {
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(MediaType.MULTIPART_FORM_DATA);

		MultiValueMap<String, Object> files = new LinkedMultiValueMap<>();
		files.add("files", new FileSystemResource(new File("C:\\one-place\\files\\file-1.txt")));

		HttpEntity<MultiValueMap<String, Object>> httpEntity = new HttpEntity<MultiValueMap<String, Object>>(files,
				httpHeaders);
		String url = "http://localhost:9000/api/v1/files";

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<StatusModel> response = restTemplate.postForEntity(url, httpEntity, StatusModel.class);

		System.out.println(response.getStatusCodeValue());
	}

	@SneakyThrows
	@Test
	public void uploadFiles2() throws IOException {
		MultiValueMap<String, Object> bodyMap = new LinkedMultiValueMap<>();
		bodyMap.add("files", getUserFileResource());
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.MULTIPART_FORM_DATA);
		HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(bodyMap, headers);

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = restTemplate.exchange("http://localhost:9000/api/v1/files", HttpMethod.POST,
				requestEntity, String.class);
		System.out.println("response status: " + response.getStatusCode());
		System.out.println("response body: " + response.getBody());
	}

	public Resource getUserFileResource() throws IOException {
		//todo replace tempFile with a real file
		Path tempFile = Files.createTempFile("upload-test-file", ".txt");
		Files.write(tempFile, "some test content...\nline1\nline2".getBytes());
		System.out.println("uploading: " + tempFile);
		File file = tempFile.toFile();
		//to upload in-memory bytes use ByteArrayResource instead
		return new FileSystemResource(file);
	}
}