package com.guri.goodsManagement.exceptions.generic;

public class NoContentException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private static final String DESCRIPTION = "Not Found Exception";
	
	public NoContentException(String details) {
		super(DESCRIPTION + ". " + details);
	}

}
