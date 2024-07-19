package jpa.board.repository;

import jpa.board.entity.Member2;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Member2Repository extends JpaRepository<Member2, Long>{
	
	Optional<Member2> findByUsername(String username);
	
}
