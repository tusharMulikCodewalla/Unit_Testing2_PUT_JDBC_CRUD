package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.models.Book;

@Component
public class BookService {
	
	private static List<Book> books = new ArrayList<>();

	
	static {
		Book book1 = new Book(1, "Java", 12.5);
		
		books.add(book1);
	}
	
	public Book updateBook(int bookId, Book book) {
		
		Book b1 = books.get(bookId);
		
		b1.setName(book.getName());
		
		return books.get(bookId);
	}

}
