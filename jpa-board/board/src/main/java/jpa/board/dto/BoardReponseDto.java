package jpa.board.dto;

import java.time.LocalDateTime;

import jpa.board.entity.Board;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
public class BoardReponseDto {
	
	private Long id;
	private String title;
	private String content;
	private LocalDateTime regDate;
	private LocalDateTime uptDate;
	private Long viewCount;
	private String delYn;
	private String username;
	
	public BoardReponseDto(Board board) {
		this.id = board.getId();
		this.title = board.getTitle();
		this.content = board.getContent();
		this.regDate = board.getRegDate();
		this.uptDate = board.getUptDate();
		this.viewCount = board.getViewCount();
		this.delYn = board.getDelYn();
		this.username = board.getMember().getUsername();
	}

}
