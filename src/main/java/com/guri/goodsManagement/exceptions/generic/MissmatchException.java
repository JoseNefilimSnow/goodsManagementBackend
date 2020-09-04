package com.guri.goodsManagement.exceptions.generic;

import java.util.NoSuchElementException;

public class MissmatchException extends NoSuchElementException{

	private static final long serialVersionUID = 1L;
	private static final String DESCRIPTION = "Missmatch Exception";
	
	public MissmatchException(String details) {
		super(DESCRIPTION + ". " + details);
	}
}
