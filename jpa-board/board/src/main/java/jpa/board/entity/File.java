package jpa.board.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import jakarta.persistence.*;
import java.time.LocalDateTime;


@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@EntityListeners(AuditingEntityListener.class)
public class File {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "file_id")
	private Long id;
	
	@Column(nullable = false)
	private String originFIleName;
	
	@Column(nullable = false)
	private String savedFileName;
	
	private String uploadDir;
	
	private String extenstion;
	
	private Long size;
	
	private String contentType;
	
	@CreatedDate
	private LocalDateTime regDate;
	
	@OneToOne(mappedBy = "file")
	private BoardFile boardFile;
	
	@Builder
	public File(Long id, String originFileName, String savedFileName, String uploadDir, String extenstion, Long size, String contentType) {
		this.id = id;
		this.originFIleName = originFileName;
		this.savedFileName = savedFileName;
		this.uploadDir = uploadDir;
		this.extenstion = extenstion;
		this.size = size;
		this.contentType = contentType;
	}
	

}
