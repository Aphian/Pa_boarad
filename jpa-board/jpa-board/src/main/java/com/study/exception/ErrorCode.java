package com.study.exception;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;


// ��ȸ�� ������ Enum
@Getter
@AllArgsConstructor
public enum ErrorCode {
	
	BAD_REQUEST(HttpStatus.BAD_REQUEST, "�߸��� ��û"),
	
	POST_NOT_FOUND(HttpStatus.NOT_FOUND, "�Խñ� ������ ã�� �� �����ϴ�."),
	
	METHOD_NOT_ALLOWED(HttpStatus.METHOD_NOT_ALLOWED, "������ ���� �޼����Դϴ�"), 
	
	INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "���� ���� �����Դϴ�");
	
	private final HttpStatus status;
	private final String message;

}
