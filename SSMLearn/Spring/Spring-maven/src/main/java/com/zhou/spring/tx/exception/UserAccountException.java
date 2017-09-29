package com.zhou.spring.tx.exception;

public class UserAccountException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserAccountException() {
	}

	public UserAccountException(String message) {
		super(message);
	}

	public UserAccountException(Throwable cause) {
		super(cause);
	}

	public UserAccountException(String message, Throwable cause) {
		super(message, cause);
	}

	public UserAccountException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
