package com.demo.advice;

import java.util.logging.ErrorManager;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.demo.exceptions.MovieException;
import com.demo.models.ErrorMessage;

@ControllerAdvice
public class ExceptionAdvice {

//	@ExceptionHandler(Exception.class)
//	public ResponseEntity<?> handleEx(Exception e) {
//		System.out.println(e.getMessage());
//		return new ResponseEntity<String>(e.getMessage(), HttpStatus.OK);
//	}
	
//	@ExceptionHandler(Exception.class)
//	public ResponseEntity<?> handleEx(Exception e) {
//		System.out.println(e.getMessage());
//		return new ResponseEntity<ErrorMessage>(
//			new ErrorMessage(e.getMessage(), e.getClass().toString()), 
//			HttpStatus.OK
//		);
//	}
	
	@ExceptionHandler(MovieException.class)
	public ResponseEntity<?> handleEx(MovieException e) {
		System.out.println(e.getMessage());
		return new ResponseEntity<ErrorMessage>(
			new ErrorMessage(e.getMessage(), e.getClass().toString()), 
			HttpStatus.OK
		);
	}
	
}
