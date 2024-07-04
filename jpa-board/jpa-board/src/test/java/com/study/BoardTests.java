package com.study;

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
				.title("1�� �Խñ� ����")
				.content("1�� �Խñ� ����")
				.writer("ȫ�浿")
				.hits(0)
				.deleteYn('N')
				.build();
		
		boardRepository.save(params);
		
	}

}
