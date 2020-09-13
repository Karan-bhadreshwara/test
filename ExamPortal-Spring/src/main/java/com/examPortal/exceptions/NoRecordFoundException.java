package com.examPortal.exceptions;

public class NoRecordFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public NoRecordFoundException(String msg) {
		super(msg);
	}
}