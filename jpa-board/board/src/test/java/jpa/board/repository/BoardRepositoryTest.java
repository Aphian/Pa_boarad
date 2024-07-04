package jpa.board.repository;

//import jpa.board.dto.BoardDto;
import jpa.board.entity.Board;
import jpa.board.entity.Member2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class BoardRepositoryTest {
	
	@Autowired
	BoardRepository boardRepository;
	
	@Autowired
	Member2Repository member2Repository;
	
	@Test
	public void post_save() {
		
		boardRepository.deleteAll();
		
		String title = "제목";
		String content = "내용";
		
		List<Member2> memberList = member2Repository.findAll();
		Member2 member = memberList.get(0);
		
//		BoardDto boardDto = new BoardDto(title, content);
//        Board board = boardDto.toEntity(member);
//        boardRepository.save(board);

        //when
        List<Board> boardList = boardRepository.findAll();

        //then
        Board boards = boardList.get(0);
        assertThat(boards.getTitle()).isEqualTo(title);
        assertThat(boards.getContent()).isEqualTo(content);
        
	}
	
	@Test
	public void post_update() {
		
		List<Board> boardList = boardRepository.findAll();
        Board boards = boardList.get(0);
        String title = "변경된 타이틀";
        String content = "변경된 내용";

        boards.update(title, content);
        boardRepository.save(boards);

        List<Board> boardList2 = boardRepository.findAll();

        Board boards2 = boardList2.get(0);
        assertThat(boards2.getTitle()).isEqualTo(title);
        assertThat(boards2.getContent()).isEqualTo(content);
	}


	@Test
	void test() {
		fail("Not yet implemented");
	}

}
