package com.backend.fileuploaddownload.DTO;

import com.backend.fileuploaddownload.Enum.FileType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FileDTO {
	
	private Long id;
	private String fileName;
	private FileType fileType; 
	private byte[] data;
	
	
	public FileDTO() {
	}


	public FileDTO(Long id, String fileName, FileType fileType, byte[] data) {
		super();
		this.id = id;
		this.fileName = fileName;
		this.fileType = fileType;
		this.data = data;
	}

	

	
}
