package jpa.board.dto;

import java.time.LocalDateTime;
import com.querydsl.core.annotations.QueryProjection;

import jpa.board.entity.Board;
import lombok.Builder;
import lombok.Data;

import jakarta.validation.constraints.NotEmpty;

@Data
public class Member2Dto {
	
	private Long id;

}
