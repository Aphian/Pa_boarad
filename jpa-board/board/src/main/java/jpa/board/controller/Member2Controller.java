package jpa.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jpa.board.dto.Member2Dto;
import jpa.board.entity.Member2;
import jpa.board.service.Member2Service;

import lombok.RequiredArgsConstructor;


@Controller
@RequiredArgsConstructor
public class Member2Controller {
	
	private final Member2Service member2Service;
	
	@GetMapping("/")
	public String login() {
		
		
		return "members/login";
		
	}

}
