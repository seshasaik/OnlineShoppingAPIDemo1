package com.onlineShoping.demo.exceptions;

public class CustomerAlreadyExistedException extends Exception {

	private String message = "";

	/**
	 * 
	 */
	private static final long serialVersionUID = 7227800802281998871L;

	public CustomerAlreadyExistedException(String message) {
		super(message);
		this.message = message;
	}

	public CustomerAlreadyExistedException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CustomerAlreadyExistedException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public CustomerAlreadyExistedException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
