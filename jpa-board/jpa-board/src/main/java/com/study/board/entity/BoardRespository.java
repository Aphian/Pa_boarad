package com.study.board.entity;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRespository extends JpaRepository<Board, Long> {
	
	// Board Repository
	List<Board> findAllByDeleteYn(final char deleteYn, final Sort sort);
	
}
