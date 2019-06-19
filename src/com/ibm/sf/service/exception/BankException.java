package com.ibm.sf.service.exception;

public class BankException extends Exception{
private static final long serialVersionUID = 1L;
	
	private String message;
	
	public BankException() {
		
	}
	
	public BankException(String message) {
		this.message=message;
	}

	@Override
	public String getMessage() {		
		return this.message;
	}
	
	
	
}



