package com.example.bootapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.bootapi.helper.FileUploadHelper;

@RestController
public class FileUploadController
{
	@Autowired
	FileUploadHelper fileUploadHelper;

	@PostMapping("/upload")
	public ResponseEntity<String> uploadFile(@RequestParam MultipartFile file)
	{
		System.out.println(file.getOriginalFilename());
		System.out.println(file.getSize());
		System.out.println(file.getContentType());

		if (file.isEmpty()
				|| file == null)
		{
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("file is empty");
		}

		if (!file.getContentType().equals("image/jpeg"))
		{
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("only  JPEG content allowed");
		}

		boolean ans = fileUploadHelper.uploadData(file);
		if (ans)
		{
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("File Successfully uploaded");
		}

		return ResponseEntity.ok("working");
	}

}
