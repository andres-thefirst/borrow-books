package com.andres.thefirst.books.service;

import java.io.IOException;

public interface ISystemFileBo {
	public void saveFile(byte [] data, String name) throws IOException;
	public byte [] getBytes(String name) throws IOException;
}
