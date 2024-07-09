package jpa.board.service;

import jpa.board.entity.Board;
import jpa.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class BoardService {
	
	private final BoardRepository boardRepository;
	
	@Transactional
	public Board deleteBoard(Long id) {
		
		Board board = boardRepository.findById(id).get();
		
		board.delete("Y");
		
		return board;
		
	}

}
