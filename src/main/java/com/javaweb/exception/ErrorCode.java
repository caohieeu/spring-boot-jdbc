package com.javaweb.exception;

public enum ErrorCode {
	BUILDING_NOT_FOUND(1001, "Building not found"),
	BUILDING_CONFLICT(1002, "The building already exists");
	
	ErrorCode(int code, String message) {
		this.code = code;
		this.message = message;
	}
	
	int code;
	String message;
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
