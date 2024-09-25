package jpa.board.service;

import jpa.board.dto.Member2Dto;
import jpa.board.entity.Member2;
import jpa.board.repository.Member2Repository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
@Slf4j
public class Member2Service {
	
	private final Member2Repository memberRepository;
	private final PasswordEncoder passwordEncoder;
	
	// 회원가입
	public Member2 saveMember(Member2Dto member2Dto) throws Exception {
		
		member2Dto.setPassword(passwordEncoder.encode(member2Dto.getPassword()));
		
		Member2 member2 = member2Dto.toEntity();
		
		return memberRepository.save(member2);
		
	}
	
	// 회원정보 수정
	public Member2 updateMember(Member2Dto member2Dto) throws Exception {
		
		Member2 member2 = member2Dto.toEntity();
		
		return memberRepository.save(member2);
	}
	
	// Test
	public String Test() {
		return "test";
	}
	
	// Test
	public String Test2() {
		return "test2";
	}

}
