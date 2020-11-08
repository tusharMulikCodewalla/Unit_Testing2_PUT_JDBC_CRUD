package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Book;
import com.example.demo.service.BookService;

@RestController
public class BookController {

	@Autowired
	private BookService bookService;
	
	@PutMapping("/book/{bookId}")
	public ResponseEntity<Book> updateBookById(@PathVariable int bookId, @RequestBody Book book){
		Book b1 = bookService.updateBook(bookId, book);
		return new ResponseEntity<Book>(b1, HttpStatus.CREATED);
	}
}
