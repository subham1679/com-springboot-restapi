package com.example.bootapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bootapi.entities.Book;

@RestController
public class BootAPIController {
	
	@GetMapping("/books")
	public Book getAllBooks()
	{
		Book book = new Book();
		book.setId(1);
		book.setAuthor("Mayank");
		book.setTitle("Controller in SpringBoot");
		return book;
	}

}
