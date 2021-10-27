package com.dia.eauction.exceptions;

public class SellerNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public SellerNotFoundException() {
		super();
	}

	public SellerNotFoundException(String message) {
		super(message);
	}

}
