package com.backend.fileuploaddownload.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.backend.fileuploaddownload.Service.FileService;
import com.backend.fileuploaddownload.Exception.InvalidFileTypeException;
import com.backend.fileuploaddownload.Enum.FileType;
import com.backend.fileuploaddownload.Exception.FileNotFoundException;

@RestController
@RequestMapping("/files")
public class FileController {

	@Autowired
	private FileService fileService;

	@PostMapping("/upload")
	public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
		if (file != null && !file.isEmpty()) {
			try {
				String fileName = file.getOriginalFilename();
				byte[] fileData = file.getBytes();
				fileService.uploadFile(fileName, fileData, FileType.IMAGE); 
				return ResponseEntity.ok("Arquivo enviado com sucesso.");
			} catch (InvalidFileTypeException e) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Tipo de arquivo não é permitido.");
			} catch (Exception e) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Falha ao enviar o arquivo.");
			}
		} else {
			return ResponseEntity.badRequest().body("Nenhum arquivo enviado.");
		}
	}

	@GetMapping("/download/{fileName}")
	public ResponseEntity<byte[]> downloadFile(@PathVariable String fileName) {
		try {
			byte[] fileData = fileService.downloadFile(fileName);
			HttpHeaders headers = new HttpHeaders();
			headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + fileName);
			return ResponseEntity.ok().headers(headers).body(fileData);
		} catch (FileNotFoundException e) {
			return ResponseEntity.notFound().build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Falha ao baixar o arquivo.".getBytes());
		}
	}
}
