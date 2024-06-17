package com.study.exception;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;


// 예회를 관리할 Enum
@Getter
@AllArgsConstructor
public enum ErrorCode {
	
	BAD_REQUEST(HttpStatus.BAD_REQUEST, "잘못된 요청"),
	
	POST_NOT_FOUND(HttpStatus.NOT_FOUND, "게시글 정보를 찾을 수 없습니다."),
	
	METHOD_NOT_ALLOWED(HttpStatus.METHOD_NOT_ALLOWED, "허용되지 않은 메서드입니다"), 
	
	INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "내부 서버 오류입니다");
	
	private final HttpStatus status;
	private final String message;

}
