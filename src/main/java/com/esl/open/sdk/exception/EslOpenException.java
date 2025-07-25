package com.esl.open.sdk.exception;

/**
 * *
 * <p>
 * ESL Open SDK异常类
 * </p>
 * <p>
 * 该异常类用于在ESL Open SDK中抛出和处理各种异常情况。
 * </p>
 * 
 * @author zdview
 * @since 2025-07-03
 */
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
