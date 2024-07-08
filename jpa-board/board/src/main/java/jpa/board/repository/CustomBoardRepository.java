package jpa.board.repository;

import jpa.board.dto.BoardReponseDto;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CustomBoardRepository {
	
	Page<BoardReponseDto> seleteBoardList(String searchVal, Pageable pageable);
	
}
