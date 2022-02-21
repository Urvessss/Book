package com.Book;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookApplication {

	public static void main(String[] args) {
		
		System.out.println("Start.......");
		SpringApplication.run(BookApplication.class, args);
		System.out.println("End........");
		
		
	}

}