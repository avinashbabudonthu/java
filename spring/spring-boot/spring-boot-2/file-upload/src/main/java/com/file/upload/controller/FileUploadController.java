package com.file.upload.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.file.upload.model.StatusModel;

@RestController
public class FileUploadController {

	@PostMapping(value = "/api/v1/files", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public StatusModel uploadFiles(@RequestParam("files") MultipartFile file) {
		String name = file.getOriginalFilename();
		StatusModel statusModel = StatusModel.builder().name(name).statusCode(200).statusDescription("success").build();

		return statusModel;
	}

}