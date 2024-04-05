package com.app.userservice.exception;


import org.springframework.http.HttpStatus;


public class ErrorData {
    private final String message;
    private final Throwable throwable ;
    private final HttpStatus httpStatus;
    
	public ErrorData(String message, Throwable throwable, HttpStatus httpStatus) {
		super();
		this.message = message;
		this.throwable = throwable;
		this.httpStatus = httpStatus;
	}

}
