package jpa.board.dto;

import jpa.board.entity.File;
import lombok.Builder;
import lombok.Data;

@Data
public class FileDto {
	
	private Long id;
	private String originFileName;	// 원본 파일명
	private String savedFileName;   // 저장된 파일명
	private String uploadDir;	    // 저장 경로
	private String extensions;      // 파일 확장자
	private Long size;
	private String contentType;
	
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
