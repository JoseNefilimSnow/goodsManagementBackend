package com.guri.goodsManagement.exceptions.generic;

public class NotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private static final String DESCRIPTION = "Not Found Exception";
	
	public NotFoundException(String details) {
		super(DESCRIPTION + ". " + details);
	}

}