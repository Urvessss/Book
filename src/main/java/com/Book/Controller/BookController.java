package com.Book.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Book.entity.Book;
import com.Book.exception.BookAlreadyAdd;
import com.Book.exception.BookNotFound;
import com.Book.exception.BookNotInDatabase;
import com.Book.exception.BookNotUpdate;
import com.Book.service.BookService;
import com.google.common.net.HttpHeaders;

@RestController
public class BookController {

	@Autowired
	private BookService bookService;

	@GetMapping("/getBookByid/{id}")
	public ResponseEntity<Book> getBankById(@PathVariable(name = "id") Long id) throws BookNotFound {

		Book ban = bookService.getBook(id);
		ResponseEntity<Book> response = new ResponseEntity<Book>(ban, HttpStatus.OK);
		return response;
	}

	
	@PostMapping("/addbook")
	public ResponseEntity<Book> addBook(@RequestBody Book book) throws BookAlreadyAdd {

		Book ban = bookService.addBook(book);

		ResponseEntity<Book> response = new ResponseEntity<Book>(ban, HttpStatus.CREATED);
		return response;
	}

	
	@PutMapping("/updatebook")
	public ResponseEntity<Book> updateBook(@RequestBody Book book) throws BookNotUpdate {

		Book ban = bookService.updateBook(book);

		ResponseEntity<Book> response = new ResponseEntity<Book>(ban, HttpStatus.OK);
		return response;
	}

	
	@DeleteMapping("/deletebookkbyid/{id}")
	public ResponseEntity<Book> deleteBook(@PathVariable Long id) throws BookNotInDatabase {

		bookService.deleteBook(id);

		ResponseEntity<Book> response = new ResponseEntity<Book>(HttpStatus.OK);
		return response;
	}
	
	@GetMapping("/getAllBook")
	public ResponseEntity<List<Book>> getAllBooks() {
		List<Book> list =bookService.getAllBook();

		return new ResponseEntity<List<Book>>(list, HttpStatus.OK);
	}

}