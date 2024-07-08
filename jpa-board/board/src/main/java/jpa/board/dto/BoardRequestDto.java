package jpa.board.dto;

import jpa.board.entity.Board;
import jpa.board.entity.Member2;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.validation.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor
public class BoardRequestDto {
	
	@NotEmpty(message = "제목은 필수입니다.")
	private String title;
	private String content;
	private Long memberId;
	
	public BoardRequestDto(String title, String content) {
		this.title = title;
		this.content = content;
	}
	
	public Board toEntity(Member2 member) {
		return Board.builder()
				.title(title)
				.content(content)
				.member(member)
				.build();
	}

}
