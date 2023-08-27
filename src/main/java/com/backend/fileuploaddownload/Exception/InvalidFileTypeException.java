package com.backend.fileuploaddownload.Exception;

public class InvalidFileTypeException  extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public InvalidFileTypeException(String message) {
        super(message);
    }
	
}
