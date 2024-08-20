package jpa.board.dto;

import com.querydsl.core.annotations.QueryProjection;

import jpa.board.entity.Board;
import jpa.board.entity.Member2;
import jpa.board.entity.Authority;
import lombok.Builder;
import lombok.Data;

import jakarta.validation.constraints.NotEmpty;

@Data
public class Member2Dto {
	
	private Long id;
	private String username;
	private String phoneNo;
	private int age;
	private Authority authority;
	
	@Builder
	public Member2Dto(Long id, String username, String phoneNo, int age) {
		this.id = id;
		this.username = username;
		this.phoneNo = phoneNo;
		this.age = age;
	}
	
	@QueryProjection
	public Member2Dto(Long id, String username, String phoneNo, int age, Authority autoryity) {
		this.id = id;
		this.username = username;
		this.phoneNo = phoneNo;
		this.age = age;
		this.authority = autoryity;
	}
	
	public Member2 toEntity() {
		return Member2.builder()
				.username(username)
				.phoneNo(phoneNo)
				.age(age)
				.authority(authority)
				.build();
	}
}
