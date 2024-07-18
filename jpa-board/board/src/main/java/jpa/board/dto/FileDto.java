package jpa.board.dto;

import jpa.board.entity.Board;
import jpa.board.entity.File;
import jpa.board.entity.Member2;

import lombok.Builder;
import lombok.Data;

import jakarta.persistence.Column;

@Data
public class FileDto {
	
	private Long id;
	private String originFileName;
	private String savedFileName;
	private String uploadDir;
	private String extensions;
	private Long size;
	private String contentType;
	
	private FileDto() {
		
	}
	
	@Builder
	public FileDto(Long id, String originFileName, String savedFileName, String uploadDir, String extension, Long size, String contentType) {
		this.id = id;
		this.originFileName = originFileName;
		this.savedFileName = savedFileName;
		this.uploadDir = uploadDir;
		this.extensions = extension;
		this.size = size;
		this.contentType = contentType;
	}
	
	public File toEntity() {
		return File.builder()
				.originFileName(originFileName)
				.savedFileName(savedFileName)
				.uploadDir(uploadDir)
				.extenstion(extensions)
				.size(size)
				.contentType(contentType)
				.build();
	}
	

}
