package jpa.board.repository;

import jpa.board.entity.Member2;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member2, Long>{

}
