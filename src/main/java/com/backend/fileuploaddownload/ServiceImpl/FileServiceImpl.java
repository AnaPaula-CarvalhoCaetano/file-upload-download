package com.backend.fileuploaddownload.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.backend.fileuploaddownload.Entities.FileEntity;
import com.backend.fileuploaddownload.Enum.FileType;
import com.backend.fileuploaddownload.Repository.FileRepository;
import com.backend.fileuploaddownload.Service.FileService;
import com.backend.fileuploaddownload.Exception.InvalidFileTypeException;
import com.backend.fileuploaddownload.Exception.FileNotFoundException;

@Service
public class FileServiceImpl implements FileService {

	private final FileRepository fileRepository;

	@Autowired
	public FileServiceImpl(FileRepository fileRepository) {
		this.fileRepository = fileRepository;
	}

	@Override
	public void uploadFile(String fileName, byte[] fileData, FileType fileType) {
		if (isFileTypeAllowed(fileType)) {
			FileEntity fileEntity = new FileEntity();
			fileEntity.setFileName(fileName);
			fileEntity.setFileType(fileType);
			fileEntity.setData(fileData);

			fileRepository.save(fileEntity);
		} else {
			throw new InvalidFileTypeException("Tipo de arquivo não é permitido.");
		}
	}

	@Override
	public byte[] downloadFile(String fileName) {
		FileEntity fileEntity = fileRepository.findByFileName(fileName);

		if (fileEntity != null) {
			return fileEntity.getData();
		} else {
			throw new FileNotFoundException("Arquivo não encontrado.");
		}
	}

	private boolean isFileTypeAllowed(FileType fileType) {
		if (fileType == FileType.IMAGE || fileType == FileType.DOCUMENT) {
			return true;
		} else {
			throw new InvalidFileTypeException("Tipo de arquivo não é permitido.");
		}
	}
}
