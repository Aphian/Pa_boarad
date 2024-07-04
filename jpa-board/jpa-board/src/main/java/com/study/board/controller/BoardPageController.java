package com.study.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/board")
public class BoardPageController {
	
	// �Խñ� ����Ʈ ȭ��
	@GetMapping("/list")
	public String openBoardList() {
		return "board/list";
	}
	
	// �Խñ� ��� ȭ��
	@GetMapping("/write")
	public String openBoardWrite(@RequestParam(value = "id", required = false) final Long id, Model model) {
		return "board/write";
	}
	
	// �Խñ� �󼼺��� ȭ��
	@GetMapping("/view/{id}") 
	public String openBoardView(@PathVariable(value = "id", required = false) final Long id, Model model) {
		model.addAttribute("id", id);
		return "board/view";
	}

}
