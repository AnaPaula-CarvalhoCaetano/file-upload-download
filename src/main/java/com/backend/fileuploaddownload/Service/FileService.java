package com.backend.fileuploaddownload.Service;

import com.backend.fileuploaddownload.Enum.FileType;

public interface FileService {
	
    void uploadFile(String fileName, byte[] fileData, FileType fileType);
    
    byte[] downloadFile(String fileName);
}

