package com.dia.eauction.exceptions;

public class InvalidDataException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public InvalidDataException() {
super();
	}

	public InvalidDataException(String message) {
		super(message);
	}
}
