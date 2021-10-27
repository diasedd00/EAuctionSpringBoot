package com.dia.eauction.exceptions;

public class DuplicateBidException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DuplicateBidException() {
		super();
	}

	public DuplicateBidException(String message) {
		super(message);
	}

}
