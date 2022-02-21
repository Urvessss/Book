package com.Book.exception;

public class BookNotUpdate extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BookNotUpdate() {
		super();
	}
	
	public BookNotUpdate(String Message) {
		super(Message);
	}

}
