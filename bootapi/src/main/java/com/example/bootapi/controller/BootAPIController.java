package com.example.bootapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.DeleteExchange;

import com.example.bootapi.entities.Book;
import com.example.bootapi.services.BookService;

@RestController
public class BootAPIController {
	
	@Autowired
	public BookService bookService;
	
	
	@GetMapping("/books")
	public List<Book> getBooks()
	{
//		Book book = new Book();
//		book.setId(1);
//		book.setAuthor("Mayank");
//		book.setTitle("Controller in SpringBoot");
//		return book;
		return bookService.getAllBooks();
	}
	
	@PostMapping("/books")
	public Book addBook(@RequestBody Book book)
	{
		
		Book b = this.bookService.appendBook(book);
		return b;
	}
	
	@DeleteMapping("/books/{bookId}")
	public void deleteBook(@PathVariable("bookId") int bid)
	{
		bookService.deleteBookByID(bid);
	}

}
