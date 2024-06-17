package com.study.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.extern.slf4j.Slf4j;

// 전역 예외 핸들링용 
@RestControllerAdvice
@Slf4j
public class GlobalExcetionHandler {
	
	@ExceptionHandler(RuntimeException.class)
	public String handleRuntimeException(final RuntimeException e) {
		log.error("handleRuntimeExcetion : {}", e.getMessage());
		return e.getMessage();
	}

}
