package jpa.board.repositoryImpl;

import com.querydsl.jpa.impl.JPAQueryFactory;

import jpa.board.dto.Member2Dto;
import jpa.board.dto.QMember2Dto;
import jpa.board.entity.QMember2;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Repository;

import java.util.List;

public class Member2RepositoryImpl {
	
	private final JPAQueryFactory jpaQueryFactory;
	
	public Member2RepositoryImpl(JPAQueryFactory jpaQueryFactory) {
		this.jpaQueryFactory = jpaQueryFactory;
	}
	
	public List<Member2Dto> findAllMember2DTO() {
		QMember2 member = QMember2.member2;
		
		return jpaQueryFactory
				.select(new QMember2Dto(
						member.id, 
						member.username,
						member.phoneNo,
						member.age,
						member.authority))
				.from(member)
				.fetch();
	}

}
