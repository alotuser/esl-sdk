package com.esl.open.sdk.exception;

public class EslOpenException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EslOpenException(String message) {
		super(message);
	}

	public EslOpenException(String message, Throwable cause) {
		super(message, cause);
	}

	public EslOpenException(Throwable cause) {
		super(cause);
	}
}
