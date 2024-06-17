package com.study.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.extern.slf4j.Slf4j;

// ���� ���� �ڵ鸵�� 
@RestControllerAdvice
@Slf4j
public class GlobalExcetionHandler {
	
	@ExceptionHandler(RuntimeException.class)
	public String handleRuntimeException(final RuntimeException e) {
		log.error("handleRuntimeExcetion : {}", e.getMessage());
		return e.getMessage();
	}

}
