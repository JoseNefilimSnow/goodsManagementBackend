package com.guri.goodsManagement.exceptions.generic;

public class InternalServerErrorException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private static final String DESCRIPTION = "Internal Server Error (500)";
	
	public InternalServerErrorException(String details) {
		super(DESCRIPTION + ". " + details);
	}
}
