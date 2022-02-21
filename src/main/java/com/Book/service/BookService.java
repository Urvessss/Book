package com.Book.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.Book.entity.Book;
import com.Book.exception.BookAlreadyAdd;
import com.Book.exception.BookNotFound;
import com.Book.exception.BookNotInDatabase;
import com.Book.exception.BookNotUpdate;
import com.Book.repository.BookRepository;

@Service
public class BookService implements IBookService {

	@Autowired
	private BookRepository bookRepository;

	public Book getBook(Long id) throws BookNotFound {

		Optional<Book> bankOpt = bookRepository.findById(id);
		if (bankOpt.isPresent()) {

			return bankOpt.get();
		} else {

			throw new BookNotFound("Bank does not exists");
			
		}
	}

	public Book addBook(Book book) throws BookAlreadyAdd {

		if (!bookRepository.existsById(book.getId())) {

			return bookRepository.save(book);
		} else {

			throw new BookAlreadyAdd("This bank already exists in the database");
//		
		}
	}

	public Book updateBook(Book book) throws BookNotUpdate {

		if (bookRepository.existsById(book.getId())) {

			return bookRepository.save(book);
		} else {

			throw new BookNotUpdate("This bank already exists in the database");
			
		}
	}

	public void deleteBook(Long id) throws BookNotInDatabase {

		if (bookRepository.findById(id) != null) {

			bookRepository.deleteById(id);
		} else {

			throw new BookNotInDatabase("This bank already exists in the database");

		}
	}
	
	public List<Book> getAllBook() {
		System.out.println("Service getAllEmployees");
		return bookRepository.findAll();
	}
}