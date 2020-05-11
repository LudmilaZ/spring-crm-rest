package com.luv2code.springdemo.rest;

public class BoxnotFoundExc extends RuntimeException {

	public BoxnotFoundExc() {
	
	}

	public BoxnotFoundExc(String message) {
		super(message);
	
	}

	public BoxnotFoundExc(Throwable cause) {
		super(cause);
	
	}

	public BoxnotFoundExc(String message, Throwable cause) {
		super(message, cause);
	
	}

	public BoxnotFoundExc(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	
	}

}
