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

// API ó���� BoardApiController
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
	
	// �Խñ� ����
	@PostMapping("/boards")
	public Long save(@RequestBody final BoardRequestDto params) {
		return boardService.save(params);
	}
	
	// �Խñ� ����Ʈ ��ȸ
	@GetMapping("/boards")
	public List<BoardResponseDto> findAll() {
		return boardService.findAll();
	}
	
	// �Խñ� ����
	@PatchMapping("/boards/{id}")
	public Long save(@PathVariable(value = "id", required = false) final Long id, @RequestBody final BoardRequestDto parans) {
		return boardService.update(id, parans);
	}
	
	// �Խñ� ����
	@DeleteMapping("/boards/{id}") 
	public Long delete(@PathVariable(value = "id", required = false) final Long id) {
		return boardService.delete(id);
	}
	
	// �Խñ� ������
	@GetMapping("/boards/{id}")
	public BoardResponseDto findById(@PathVariable(value = "id", required = false) final Long id) {
		return boardService.findById(id);
	}
	
	

}
