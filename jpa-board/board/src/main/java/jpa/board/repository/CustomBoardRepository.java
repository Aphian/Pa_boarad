package jpa.board.repository;

import jpa.board.dto.BoardDto;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CustomBoardRepository {
	
	Page<BoardDto> seleteBoardList(String searchVal, Pageable pageable);
	
}
