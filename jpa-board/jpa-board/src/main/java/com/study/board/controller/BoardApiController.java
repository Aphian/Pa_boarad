package com.study.board.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// API Ã³¸®¿ë BoardApiController
@RestController
@RequestMapping("/api")
public class BoardApiController {
	
	@GetMapping("/test")
	public String test() {
		throw new RuntimeException("Exception...");
	}

}
