package com.guri.goodsManagement.exceptions.generic;

public class UnauthorizedException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	private static final String DESCRIPTION = "Unauthorized Exception";
	
	public UnauthorizedException(String details) {
		super(DESCRIPTION + ". " + details);
	}

}
