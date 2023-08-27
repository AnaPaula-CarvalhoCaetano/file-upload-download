package com.backend.fileuploaddownload.Entities;

import com.backend.fileuploaddownload.Enum.FileType;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Getter
@Setter
@Table(name = "files")
public class FileEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String fileName;
    
    @Enumerated(EnumType.STRING)
    private FileType fileType;
    
    private byte[] data;
    
    public FileEntity() {
        
    }

	public FileEntity(Long id, String fileName, FileType fileType, byte[] data) {
		super();
		this.id = id;
		this.fileName = fileName;
		this.fileType = fileType;
		this.data = data;
	}
    
   
}
