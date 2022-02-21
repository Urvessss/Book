package com.Book.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;




@ControllerAdvice
public class CustomException extends ResponseEntityExceptionHandler {



	@ExceptionHandler(BookAlreadyAdd.class)
	public ResponseEntity<Object> BookAlreadyAdd() {
		return new ResponseEntity<Object>(null, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(BookNotFound.class)
	public ResponseEntity<Object>BookNotFound() {
		return new ResponseEntity<Object>(null, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(BookNotInDatabase.class)
	public ResponseEntity<Object>BookNotInDatabase() {
		return new ResponseEntity<Object>(null, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(BookNotUpdate.class)
	public ResponseEntity<Object>BookNotUpdate() {
		return new ResponseEntity<Object>(null, HttpStatus.NOT_FOUND);
	}
}
