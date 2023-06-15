package com.example.bootapi.helper;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper
{

	public final String filepath = "/home/shubhambhardwaj/git/com-springboot-restapi/bootapi/src/main/resources/static/images";

	public boolean uploadData(MultipartFile f)
	{
		boolean flag = false;

		try
		{

			Files.copy(f.getInputStream(), Paths.get(filepath + '/' + f.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return flag;
	}
}
