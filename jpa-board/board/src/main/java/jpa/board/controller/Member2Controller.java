package jpa.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;
import jpa.board.dto.Member2Dto;
import jpa.board.entity.Member2;
import jpa.board.service.Member2Service;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class Member2Controller {
	
	private final Member2Service member2Service;
	
	// 회원가입 빈 Form
	@GetMapping("/join")
	public String registerForm(Model model) {
		model.addAttribute("member2Dto", new Member2Dto(null, null, null, null, 0));
		return "members/resiter";
	}
	
	// 회원가입
	@PostMapping("/join")
	public String registerForm(@Valid @ModelAttribute("member2Dto") Member2Dto member2Dto, BindingResult bindingResult, Model model) {
		
		// 유효성
		if (bindingResult.hasErrors()) {
			return "register";
		}
		
		try {
			member2Service.saveMember(member2Dto);
		} catch (Exception e) {
			model.addAttribute("Error", "회원가입 오류");
			return "join";
		}
		
		return "join";
		
	}
	
	// 로그인
	@GetMapping("/login")
	public String login() {
		
		return "members/login";
		
	}

}
