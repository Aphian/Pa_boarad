package jpa.board.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jpa.board.entity.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;
import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long>{
	
	void deleteAllById(List<Long> boardIds);

}
