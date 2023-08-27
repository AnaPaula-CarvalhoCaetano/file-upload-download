package com.backend.fileuploaddownload.Mapper;

import org.springframework.stereotype.Component;

import com.backend.fileuploaddownload.DTO.FileDTO;
import com.backend.fileuploaddownload.Entities.FileEntity;

@Component
public class FileMapper {

    public FileDTO toDTO(FileEntity entity) {
        return mapEntityToDTO(entity);
    }

    public FileEntity toEntity(FileDTO dto) {
        return mapDTOToEntity(dto);
    }

    private FileDTO mapEntityToDTO(FileEntity entity) {
        return new FileDTO(entity.getId(), entity.getFileName(), entity.getFileType(), entity.getData());
    }

    private FileEntity mapDTOToEntity(FileDTO dto) {
        return new FileEntity(dto.getId(), dto.getFileName(), dto.getFileType(), dto.getData());
    }
}
