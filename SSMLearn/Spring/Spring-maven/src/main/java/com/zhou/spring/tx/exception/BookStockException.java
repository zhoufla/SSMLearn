package com.zhou.spring.tx.exception;

public class BookStockException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BookStockException() {
	}

	public BookStockException(String message) {
		super(message);
	}

	public BookStockException(Throwable cause) {
		super(cause);
	}

	public BookStockException(String message, Throwable cause) {
		super(message, cause);
	}

	public BookStockException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
