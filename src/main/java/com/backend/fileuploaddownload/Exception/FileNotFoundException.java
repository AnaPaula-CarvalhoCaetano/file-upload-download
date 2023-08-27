package com.backend.fileuploaddownload.Exception;

public class FileNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public FileNotFoundException(String message) {
		super(message);
	}
}