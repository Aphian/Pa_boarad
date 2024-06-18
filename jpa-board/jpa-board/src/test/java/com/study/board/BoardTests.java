package com.study.board;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.study.board.entity.Board;
import com.study.board.entity.BoardRespository;

@SpringBootTest
public class BoardTests {
	
	@Autowired
	BoardRespository boardRepository;
	
	void save() {
		Board params = Board.builder()
				.title("1번 게시글 제목")
				.content("1번 게시글 내용")
				.writer("홍길동")
				.hits(0)
				.deleteYn('N')
				.build();
		
		boardRepository.save(params);
		
	}

}
