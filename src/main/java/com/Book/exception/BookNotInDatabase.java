package com.Book.exception;

public class BookNotInDatabase extends Exception{
	private static final long serialVersionUID = 1L;

	public BookNotInDatabase(){
		super();
	}
	
	public BookNotInDatabase(String Message) {
		super(Message);
	}

}


