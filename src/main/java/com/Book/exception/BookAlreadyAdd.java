package com.Book.exception;

public class BookAlreadyAdd extends Exception{
	private static final long serialVersionUID = 1L;

	public BookAlreadyAdd() {
		super();
	}
	
	public BookAlreadyAdd(String Message) {
		super(Message);
	}


}
