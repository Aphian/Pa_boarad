package com.study.board.entity;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRespository extends JpaRepository<Board, Long> {
	
	// 게시글 리스트 조회
	List<Board> findAllByDeleteYn(final char deleteYn, final Sort sort);
	
}
