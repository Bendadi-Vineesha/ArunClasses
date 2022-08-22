package com.demo.exceptions;

public class MovieException extends Exception {

	public MovieException() {
	}

	public MovieException(String m) {
		super(m);
	}

	public MovieException(Exception e) {
		super(e);
	}

	public MovieException(String m, Exception e) {
		super(m, e);
	}

}
