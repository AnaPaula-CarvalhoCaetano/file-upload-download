package com.backend.fileuploaddownload.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.fileuploaddownload.Entities.FileEntity;

@Repository
public interface FileRepository extends JpaRepository<FileEntity, Long>{
	FileEntity findByFileName(String fileName);

}
