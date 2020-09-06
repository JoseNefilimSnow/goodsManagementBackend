package com.guri.goodsManagement.dto;

public class ErrorResponse {
	private String exception;
	private String message;
	private String path;
	
	public ErrorResponse(Exception exception, String path) {
		this.exception = exception.getClass().getSimpleName();
		this.message = exception.getMessage();
		this.path = path;
	}
	
	public ErrorResponse(Exception exception, String message, String path) {
		this.exception = exception.getClass().getSimpleName();
		this.message = message;
		this.path = path;
	}

	public String getException() {
		return exception;
	}

	public void setException(String exception) {
		this.exception = exception;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
}
