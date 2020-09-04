package com.guri.goodsManagement.exceptions.generic;

public class SQLException extends Exception{

	private static final long serialVersionUID = 1L;
	private static final String DESCRIPTION = "SQL Exception";

	public SQLException(String details) {
		
		super(DESCRIPTION + " . " + details);
			
	}

}
