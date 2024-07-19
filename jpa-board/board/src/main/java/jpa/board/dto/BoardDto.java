package jpa.board.dto;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.querydsl.core.annotations.QueryProjection;

import jpa.board.entity.Board;
import jpa.board.entity.Member2;
import lombok.Builder;
import lombok.Data;

import jakarta.validation.constraints.NotEmpty;

@Data
public class BoardDto {
	
	// 시퀀스
	private Long id;
	
	@NotEmpty(message = "제목은 필수입니다.")
	private String title;
	private String content;
	private Long memberId;
	private LocalDateTime regDate;
	private LocalDateTime uptDate;
	private Long viewCount;
	private String username;
	
	private List<MultipartFile> multipartFile;
	
	public BoardDto() {
		
	}
	
	@Builder
	public BoardDto(Long id, String title, String content) {
		this.id = id;
		this.title = title;
		this.content = content;
	}
	
	@QueryProjection
    public BoardDto(Long id, String title, String content, LocalDateTime regDate , LocalDateTime uptDate, Long viewCount, String username){
        this.id = id;
        this.title = title;
        this.content = content;
        this.regDate = regDate;
        this.uptDate = uptDate;
        this.viewCount = viewCount;
        this.username = username;
    }
	
	public Board toEntity(Member2 member2) {
		return Board.builder()
				.title(title)
				.content(content)
				.member2(member2)
				.build();
	}
	
}
