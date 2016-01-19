package com.andres.thefirst.books.service.impl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.andres.thefirst.books.service.ISystemFileBo;

@Service
public class SystemFileBo implements ISystemFileBo{

	@Value("${path.image}")
	private String pathImage;
	
	@Override
	public void saveFile(byte[] data, String name) throws IOException {
		// TODO Auto-generated method stub
		File file = new File(pathImage +  File.separator + name);
		file.getParentFile().mkdirs();
		Files.write(file.toPath(), data);
	}
	
	@Override
	public byte [] getBytes(String name) throws IOException {
		// TODO Auto-generated method stub
		File file = new File(pathImage +  File.separator + name);
		return Files.readAllBytes(file.toPath());
	}

}
