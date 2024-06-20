package com.study.board.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.study.board.dto.BoardRequestDto;
import com.study.board.dto.BoardResponseDto;
import com.study.board.model.BoardService;

import com.study.exception.CustomException;
import com.study.exception.ErrorCode;

import lombok.RequiredArgsConstructor;

// API 처리용 BoardApiController
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class BoardApiController {
	
//	@GetMapping("/test")
//	public String test() {
//		throw new RuntimeException("Exception...");
//		throw new CustomException(ErrorCode.POST_NOT_FOUND);
//	}
	
	private final BoardService boardService;
	
	// 게시글 생성
	@PostMapping("/boards")
	public Long save(@RequestBody final BoardRequestDto params) {
		return boardService.save(params);
	}
	
	// 게시글 리스트 조회
	@GetMapping("/boards")
	public List<BoardResponseDto> findAll() {
		return boardService.findAll();
	}
	
	// 게시글 수정
	@PatchMapping("/boards/{id}")
	public Long save(@PathVariable(value = "id", required = false) final Long id, @RequestBody final BoardRequestDto parans) {
		return boardService.update(id, parans);
	}
	
	// 게시글 삭제
	@DeleteMapping("/boards/{id}") 
	public Long delete(@PathVariable(value = "id", required = false) final Long id) {
		return boardService.delete(id);
	}
	
	// 게시글 상세정보
	@GetMapping("/boards/{id}")
	public BoardResponseDto findById(@PathVariable(value = "id", required = false) final Long id) {
		return boardService.findById(id);
	}
	
	

}
